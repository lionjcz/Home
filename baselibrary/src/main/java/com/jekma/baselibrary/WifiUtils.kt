package com.jekma.baselibrary


import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.wifi.ScanResult
import android.net.wifi.WifiConfiguration
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.jekma.baselibrary.Utils.getSearchKeyWords
import com.jekma.baselibrary.Utils.removedDoubleQuotes
import kotlinx.coroutines.*
import java.util.ArrayList
import java.util.concurrent.ExecutorService

class WifiUtils(private val context: Context) {
    //    init {
//        setCurrentSsid()
//    }
    private val mTAG = "Develop_WifiUtils"
    var wifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
    val wantPermissions =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_WIFI_STATE
            )
        } else {
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_WIFI_STATE)
        }
    val targetWifiName = "null"
    val targetWifiPassword = "null"
    private lateinit var currentConnectedSsid: String
    private var scanedWifiInfo: MutableList<ScanResult>? = null
    private var isFindTargetWifi: Boolean = false
    private var mOnScannAllWifiListener: OnScanAllWifiListener? = null
    private var mOnWifiStatusListener: OnWifiStatusListener? = null
    private var mSearchTargetWifiListener: OnSearchTargetWifiListener? = null
    private var mScanCurrentConnectedWifiListener: OnScanCurrentConnectedWifiListener? = null
    var mOnActionListener: OnActionListener? = null

    fun getWifiList(): MutableList<ScanResult>? {
        return wifiManager.scanResults
    }

    interface OnActionListener{
        fun getCurrentSsid(ssid: String)
    }

    interface OnSearchTargetWifiListener {
        fun onResult(result: Boolean)
    }

    interface OnScanCurrentConnectedWifiListener {
        fun onResult(ssid: String?)
    }

    interface OnScanAllWifiListener {
        fun onResult(scanedWifiInfo: MutableList<ScanResult>?, threadName: String)
    }

    interface OnWifiStatusListener {
        fun onResult(state: Int)
    }
    fun setActionListener(param: OnActionListener) {
        this.mOnActionListener = param
    }
    fun setScanAllWifiListener(param: OnScanAllWifiListener) {
        this.mOnScannAllWifiListener = param
    }

    fun setWifiStatusListener(param: OnWifiStatusListener) {
        this.mOnWifiStatusListener = param
    }

    fun restart() {
        wifiManager.isWifiEnabled = false
        wifiManager.isWifiEnabled = true
    }

    @SuppressLint("MissingPermission")
    fun bindNetworkToSpecialWifi(targetWifiName: String?) {
        Log.d(mTAG, "bindNetworkToSpecialWifi ssid{$targetWifiName}")
        val conf = WifiConfiguration()
        conf.SSID =
            "\"" + targetWifiName + "\"";   // Please note the quotes. String should contain ssid in quotes

        conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE)
        conf.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.OPEN)
        conf.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP)
        conf.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP)
        conf.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP40)
        conf.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP104)
        conf.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP)
        conf.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP)
        conf.allowedProtocols.set(WifiConfiguration.Protocol.WPA)
        conf.allowedProtocols.set(WifiConfiguration.Protocol.RSN)

        wifiManager.addNetwork(conf);
        val list = wifiManager.configuredNetworks
        for (i in list) {
            if (i.SSID != null && i.SSID == "\"" + targetWifiName + "\"") {
                wifiManager.disconnect()
                wifiManager.enableNetwork(i.networkId, true)
                wifiManager.reconnect()
                Log.d(mTAG, "networkId:{${i.networkId ?: -1}}")
                break
            }
        }
    }

    /**
     * 檢查wifi是否打開
     */
    fun status(): Boolean {
        return wifiManager.isWifiEnabled
    }

    /**
     *  檢查WIFI有沒有連線AP
     */
    fun isConnectedAp(): Boolean {
        if (wifiManager.connectionInfo.networkId == -1) {
            return false
        }
        return true
    }

    fun getDongleNameList(): MutableList<String> {
        val list: MutableList<String> = ArrayList()
        wifiManager.scanResults.map {
            if (it.SSID.contains(getSearchKeyWords())){
                list.add(it.SSID)
            }
        }
        return list
    }

    fun setCurrentSsid(param: OnActionListener) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val mCm: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val callback = object: ConnectivityManager.NetworkCallback(FLAG_INCLUDE_LOCATION_INFO) {
                override fun onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities) {
                    param.getCurrentSsid((networkCapabilities.transportInfo as? WifiInfo)?.ssid?.trim('"')!!)
                }
            }
            mCm.registerDefaultNetworkCallback(callback)
        }else{
            wifiManager.connectionInfo.ssid
            param.getCurrentSsid(removedDoubleQuotes(wifiManager.connectionInfo.ssid))
        }
    }

    inner class JobThread(var className: String) {
        private lateinit var jobWifiState: Job
        private lateinit var jobDetectCurrentConnectedWifi: Job
        private lateinit var jobScanAllWifi: Job
        private lateinit var jobFindTargetWifi: Job
        private lateinit var jobConnectToTargetWifi: Job


        /**
         * 開始偵測 Wifi 狀態 並帶入秒數
         * @param detectTime 多少秒偵測一次
         */
        fun startDetectWifiState(detectTime: Long) {
            jobWifiState = GlobalScope.launch(Dispatchers.Main) {
                while (true) {
                    mOnWifiStatusListener?.onResult(wifiManager.wifiState)
                    delay(detectTime * 1000)
                }
            }
        }

        /**
         * 停止偵測 Wifi 狀態
         */
        fun stopDetectWifiState() {
            this.jobWifiState.cancel()
        }

        /**
         * 掃描所有Wifi
         * @return 已掃描到的所有WIFI資訊
         */
        fun startScanAllWifi(detectTime: Long) {
            jobScanAllWifi = GlobalScope.launch(Dispatchers.Main) {
                while (true) {
                    scanedWifiInfo = wifiManager.scanResults
                    mOnScannAllWifiListener?.onResult(scanedWifiInfo, className)
                    delay(detectTime * 1000)
                }
            }
        }

        /**
         * 停止掃描所有Wifi
         */
        fun stopScanAllWifi() {
            Log.d(className, "Stop ScanAllWifi")
            this.jobScanAllWifi.cancel()
        }

        /**
         * 偵測當下連線的Wifi
         */
        fun startDetectCurrentConnectedWifi(detectTime: Long) {
            jobDetectCurrentConnectedWifi = GlobalScope.launch(Dispatchers.Main) {
                while (true) {
                    currentConnectedSsid = wifiManager.connectionInfo?.ssid!!
                    mScanCurrentConnectedWifiListener?.onResult(currentConnectedSsid)
                    delay(detectTime * 1000)
                }
            }
        }

        /**
         * 停止偵測當下連線的Wifi
         */
        fun stopDetectCurrentConnectedWifi() {
            this.jobDetectCurrentConnectedWifi.cancel()
        }

        /**
         * 開始尋找目標Wifi
         */
        fun startFindTargetWifi(detectTime: Long) {
            //取得 scanAllWifi的資料
            jobFindTargetWifi = GlobalScope.launch(Dispatchers.Main) {
                while (true) {
                    isFindTargetWifi = false
                    scanedWifiInfo?.forEach {

                        if (it.SSID.contains(targetWifiName)) {
                            isFindTargetWifi = true
                        }
                    }
                    if (isFindTargetWifi) {
                        mSearchTargetWifiListener?.onResult(true)
                    } else {
                        mSearchTargetWifiListener?.onResult(false)
                    }
                    delay(detectTime * 1000)
                }
            }

        }

        /**
         *  停止搜尋目標Wifi
         */
        fun stopFindTargetWifi() {
            jobFindTargetWifi.cancel()
        }

        /**
         *  開始連線目標Wifi
         */
        fun startConnectToTargetWifi(detectTime: Long) {
//            jobConnectToTargetWifi = GlobalScope.launch(Dispatchers.Main) {
//                while (true) {
//                    //                Logic part
//                    if (!currentConnectedSsid.equals("<unknown ssid>")) {
//                        if (isFindTargetWifi && !(currentConnectedSsid).equals('"' + targetWifiName + '"')) {
//                            Log.d(className, "")
//                            val conf = WifiConfiguration()
//                            conf.SSID =
//                                "\"" + targetWifiName + "\"" // Please note the quotes. String should contain ssid in quotes
//                            conf.wepKeys[0] = "\"" + targetWifiPassword + "\"";
//                            conf.wepTxKeyIndex = 0;
//                            conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
//                            conf.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP40);
//                            conf.preSharedKey = "\"" + targetWifiPassword + "\"";
//                            conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
//                            wifiManager.addNetwork(conf)
//                            val list = wifiManager.configuredNetworks
//                            for (i in list) {
//                                if (i.SSID != null && i.SSID == "\"" + targetWifiName + "\"") {
//                                    wifiManager.disconnect()
//                                    wifiManager.enableNetwork(i.networkId, true)
//                                    wifiManager.reconnect()
//                                    break
//                                }
//                            }
//                        }
//                    }
//                    //                Logic part
//                    delay(detectTime * 1000)
//                }
//            }
        }

        /**
         * 停止連線目標Wifi
         */
        fun stopConnectToTargetWifi() {
            jobConnectToTargetWifi.cancel()
        }
    }


}
