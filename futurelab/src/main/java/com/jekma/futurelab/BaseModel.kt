package com.jekma.futurelab

import android.os.Handler
import android.os.Looper
import android.os.Message

abstract class BaseModel {
    val TAG = this.javaClass.simpleName
    protected val mainHandler =
        Handler(Looper.getMainLooper()) { msg: Message? -> onHandleMessage(msg) }

    protected fun runMainThread(runnable: Runnable?) {
        mainHandler.post(runnable!!)
    }

    protected fun runMainThread(runnable: Runnable?, delayMillis: Long) {
        mainHandler.postDelayed(runnable!!, delayMillis)
    }

    protected fun onHandleMessage(msg: Message?): Boolean {
        return false
    }
}