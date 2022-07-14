package com.company.maxe.Tools.Device

import android.content.Context
import android.util.Log
//import com.android.volley.AuthFailureError
import com.company.maxe.Login.MainActivity
import java.util.ArrayList
import java.util.HashMap

class Device(mainActivity: MainActivity, Emp_ID: String) {
    private val TAG = "Device"
//    private val Url: String = VolleyBridge().DeviceInfo() //Api url
    private val Emp_ID = "Emp_IDatDevice"

    //    private String[] Info ={};
    private val Info: MutableList<String> = ArrayList()
//    private val context: Context
//    var board: String = Build.BOARD // 主機版名稱
//    var brand: String = Build.BRAND // 品牌名稱
//    var cpu: String = Build.CPU_ABI // CPU + ABI
//    var device: String = Build.DEVICE // 設備名稱
//    var display: String = Build.DISPLAY // 版本號碼
//    var fingerprint: String = Build.FINGERPRINT // 設備識別碼
//    var host: String = Build.HOST // HOST
//    var id: String = Build.ID // 版本號碼
//    var manufacturer: String = Build.MANUFACTURER // 製造商
//    var model: String = Build.MODEL // 模組號碼
//    var product: String = Build.PRODUCT // 產品名稱
//    var tags: String = Build.TAGS // 設備描述
//    var type: String = Build.TYPE // 設備類別
//    var user: String = Build.USER // USER
//    var SDK: Int = Build.VERSION.SDK_INT // SDK版本
//    var Version = "Android:" + Build.VERSION.RELEASE // Version
//    fun api() {
//        Log.wtf(TAG, "URl = $Url")
//        val queue: RequestQueue = Volley.newRequestQueue(context)
//        val stringRequest: StringRequest =
//            object : StringRequest(Request.Method.POST, Url, object : Listener<String?>() {
//                fun onResponse(response: String) {
//                    Log.wtf(TAG, "DeviceInfo Working")
//                    Log.wtf(TAG, "response:$response")
//                }
//            }, object : ErrorListener() {
//                fun onErrorResponse(error: VolleyError?) {
//                    Log.wtf(TAG, "DeviceInfo Api Connect Error")
//                }
//            }) {
//                @get:Throws(AuthFailureError::class)
//                protected val params: Map<String, String>
//                    protected get() {
//                        val hashMap = HashMap<String, String>()
//                        hashMap["Info"] = Info.toString()
//                        Log.wtf(TAG, "hashMap:$hashMap")
//                        return hashMap
//                    }
//            }
//        queue.add(stringRequest)
//    }
//
//    private fun LogDevices() {
//        Log.wtf(TAG, "Constructor")
//        Log.wtf(TAG, "BOARD:$board")
//        Log.wtf(TAG, "BRAND:$brand")
//        Log.wtf(TAG, "CPU_ABI:$cpu")
//        Log.wtf(TAG, "DEVICE:$device")
//        Log.wtf(TAG, "DISPLAY:$display")
//        Log.wtf(TAG, "FINGERPRINT:$fingerprint")
//        Log.wtf(TAG, "HOST:$host")
//        Log.wtf(TAG, "ID:$id")
//        Log.wtf(TAG, "MANUFACTURER:$manufacturer")
//        Log.wtf(TAG, "MODEL:$model")
//        Log.wtf(TAG, "PRODUCT:$product")
//        Log.wtf(TAG, "TAGS$tags")
//        Log.wtf(TAG, "TYPE:$type")
//        Log.wtf(TAG, "USER:$user")
//        Log.wtf(TAG, "SDK:$SDK")
//        Log.wtf(TAG, "Releade:$Version")
//        Log.wtf(TAG, "Emp_ID:" + Emp_ID)
//    }
//
//    init {
//        context = mainActivity
//        this.Emp_ID = Emp_ID
//        Info.add(manufacturer)
//        Info.add(model)
//        Info.add(SDK.toString())
//        Info.add(Version)
//        Info.add(this.Emp_ID)
//        Log.wtf(TAG, "..$Info")
//        api()
//        //        LogDevices();
//    }
}