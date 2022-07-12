package com.jekma.baselibrary

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat


/**
 * @param requestPermissionResultBySDK 需要請求的權限
 * @param baseActivity 主宿主
 */
class PermissionUtils(private var baseActivity: Activity, private var requestPermissionResultBySDK: Array<String>) {
    private val TAG: String = "Develop_" + javaClass.simpleName
    /**
     *  請求權限
     *  先將陣列展開在個別檢查權限
     *
     */
    @RequiresApi(Build.VERSION_CODES.Q)
    fun requestPermission(permissionListener: BaseViewModel.PermissionInViewModel?) {
        if ( hasPermissions() ){
            permissionListener?.requestSuccess( )
        }else{
            requestPermissionResultBySDK.map {
                if (baseActivity.checkSelfPermission(it) != PackageManager.PERMISSION_GRANTED) {
                    Log.d(TAG, "$it 權限尚未通過，需要做請求")
                    when {
                        ContextCompat.checkSelfPermission(baseActivity.baseContext, it) == PackageManager.PERMISSION_GRANTED -> {
                            /* 使用者允許 */
                            Log.d(TAG, "權限請求成功{$it}")
                            permissionListener?.requestSuccess()
                        }
                        baseActivity.shouldShowRequestPermissionRationale(it)                                                -> {
                            /* 當使用者拒絕或是自己去系統設定不允許時的情況在這邊處理 */
                            permissionListener?.onSecondRequest(it)
                            return
                        }
                        else                                                                                                 -> {
                            /* 第一次要求權限會進入這裡 */
                            Log.d(TAG, "沒有權限，請求權線$it")
                            permissionListener?.onFirstRequest(it)
                        }
                    }
                }
            }
        }
    }

    /**
     * 檢查每個需要的權限是否開啟，只要有一個沒開啟就回傳false
     *
     * @return Boolean
     */
    fun hasPermissions(): Boolean {
        var result = false
        for (i in requestPermissionResultBySDK.indices) {
            if (baseActivity.checkSelfPermission(requestPermissionResultBySDK[i]) == PackageManager.PERMISSION_GRANTED) {
                result = true
            } else {
                return false
            }
        }
        return result
    }

}
