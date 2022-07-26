package com.jekma.futurelab.bluetooth

import android.app.Application
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.jekma.baselibrary.BaseViewModel

@RequiresApi(Build.VERSION_CODES.Q)
class ScanQrCodeViewModel(application: Application) : BaseViewModel(application) {


    var mActionListener: OnActionListener? = null
    val obHasPermission = ObservableBoolean(false)
    val onSpotLight = ObservableField("Open")

    interface OnActionListener {
        fun onPermissionResult(result: Boolean?)
        fun onChangeLoadingState(isRunning: Boolean) {}
        fun onClickedAdd()
        fun onClickedWhereQrCode()
        fun onClickedSpotLight()
        fun onClickedOpenPermission()
    }

    fun doClickedAdd(view: View?) {
        mActionListener!!.onClickedAdd()
    }

    fun doClickedWhereQrCode(view: View?) {
        mActionListener!!.onClickedWhereQrCode()
    }

    fun doClickedSpotLight(view: View?) {
        mActionListener!!.onClickedSpotLight()
    }


    fun setActionListener(mActionListener: OnActionListener?) {
        this.mActionListener = mActionListener
    }

    fun getActionListener(): OnActionListener? {
        return mActionListener
    }

    fun doClickedOpenPermission(view: View?) {
        mActionListener!!.onClickedOpenPermission()
    }
}
