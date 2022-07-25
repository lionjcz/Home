package com.jekma.futurelab

import android.app.Application
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingMethod
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.jekma.baselibrary.BaseViewModel

@RequiresApi(Build.VERSION_CODES.Q)
class DeviceItemViewModel(application: Application) : BaseViewModel(application) {
    enum class TYPE {
        DEVICE_LIST, DEVICE_NOTIFY
    }
    var obType = ObservableField(TYPE.DEVICE_LIST)
    var obIsEditMode = ObservableBoolean(false)
    var obDeviceConnectStatus: ObservableField<Device.DeviceConnectStatus> =
        ObservableField<Device.DeviceConnectStatus>()
    var obDeviceType: ObservableField<Device.Type> = ObservableField<Device.Type>()
    var obMaskVisibly = ObservableField(View.INVISIBLE)
    var obDeviceIcon: ObservableField<Device.Type> = ObservableField<Device.Type>()
    var obDeviceName = ObservableField<String>()
    private var mDevice: Device? = null
    private var mActionListener: OnActionListener? = null

    interface OnActionListener {
        fun onPlay()
        fun onDelete()
        fun onSelect()
        fun onGetDeviceIcon(type: Device.Type?): Drawable?
        fun onGetDeviceItemConnectStatus(status: Device.DeviceConnectStatus?): String?
    }

    fun setActionListener(mActionListener: OnActionListener?) {
        this.mActionListener = mActionListener
    }

    override fun create() {
        super.create()
        Log.d("issue_158", "s = " + obType.get().toString())
        if (obType.get() == TYPE.DEVICE_LIST) {
            obDeviceName.set(mDevice?.name)
            obDeviceConnectStatus.set(Device.DeviceConnectStatus.CONNECTING)
            obDeviceIcon.set(Device.Type.FRAGRANCE_MACHINE)
        }
        else {
            obDeviceName.set(mDevice?.name)
            obDeviceConnectStatus.set(Device.DeviceConnectStatus.CONNECTING)
            obDeviceIcon.set(Device.Type.FRAGRANCE_MACHINE)
        }
    }

    override fun destroy() {
        super.destroy()
    }

    fun doPlay(view: View?) {
        mActionListener!!.onPlay()
    }

    fun doDelete(view: View?) {
        mActionListener!!.onDelete()
    }

    fun doSelect(view: View?) {
        mActionListener!!.onSelect()
    }

    fun setDevice(device: Device?) {
        mDevice = device
    }

    fun getDeviceIcon(type: Device.Type?): Drawable? {
        return if (mActionListener != null) {
            mActionListener!!.onGetDeviceIcon(type)
        }
        else null
    }

    fun getDeviceConnectStatusText(status: Device.DeviceConnectStatus?): String? {
        return if (mActionListener != null) {
            mActionListener!!.onGetDeviceItemConnectStatus(status)
        }
        else null
    }

//    @BindingAdapter("android:paddingLeft")
//    fun setPaddingLeft(view: View, padding: Int) {
//        view.setPadding(padding,
//            view.getPaddingTop(),
//            view.getPaddingRight(),
//            view.getPaddingBottom())
//    }




    @BindingAdapter("doScale")
    fun doScale(view: View, size: Float) {
        view.animate().scaleX(size)
        view.animate().scaleY(size)
    }

}


class Device : JsonBase {
    var deviceType: String? = null
    var deviceId: String? = null
    var name: String? = null
    var type: Type? = null
    var group = 0
    var connected: Boolean? = null

    constructor() {}
    constructor(deviceId: String?, deviceType: String?) {
        this.deviceId = deviceId
        this.deviceType = deviceType
    }

    constructor(deviceId: String?, name: String?, type: Type?, group: Int) {
        this.deviceId = deviceId
        this.name = name
        this.type = type
        this.group = group
    }

    enum class DeviceConnectStatus {
        DISCONNECT, CONNECTING, CONNECTED, CONNECTION_FAILED
    }

    enum class Type(val code: String) {
        FRAGRANCE_MACHINE("fm");

    }
}

