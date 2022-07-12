package com.jekma.baselibrary

import android.app.Application
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.AndroidViewModel
import java.io.IOException

@RequiresApi(Build.VERSION_CODES.Q)
abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {
    var permissionUtils: PermissionUtils? = null

    /**
     * 將各個階段取得權限後的結果，callback到View層
     */
    var permissionListener: PermissionInViewModel = object : PermissionInViewModel {
        override fun onFirstRequest(s: String) {
            permissionOnViewListener?.onFirstRequest(s)
        }

        override fun onSecondRequest(permission: String) {
            permissionOnViewListener?.onSecondRequest(permission)
        }

        override fun requestSuccess() {
            permissionOnViewListener?.requestSuccess()
        }

        override fun currentPermissionResult(hasPermissions: Boolean) {
            permissionOnViewListener?.currentPermissionResult(hasPermissions)
        }
    }

    private var permissionOnViewListener: BaseBindingFragment.PermissionOnView? = null
    protected val mTAG = "Develop_" + javaClass.simpleName
    protected var mWIfiUtils = WifiUtils(application.applicationContext)

    interface PermissionInViewModel {
        fun onFirstRequest(s: String)
        fun onSecondRequest(permission: String)
        fun requestSuccess()
        fun currentPermissionResult(hasPermissions: Boolean)
    }

    open fun create() {}

    /**
     * 要求權限
     */
    open fun resume(requireActivity: FragmentActivity, permissionOnViewListener: BaseBindingFragment.PermissionOnView?) {
        try {
            this.permissionOnViewListener = permissionOnViewListener
            permissionUtils = PermissionUtils(requireActivity, mWIfiUtils.wantPermissions)
            permissionUtils?.requestPermission(permissionListener)
        } catch (e: IOException) {
            Log.e(mTAG, "Exception:${e.message}")
        }
    }

    open fun pause() {}

    open fun destroy() {}

}
