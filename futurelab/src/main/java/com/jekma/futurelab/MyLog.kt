package com.jekma.futurelab

import android.util.Log

object MyLog {
    const val DEBUG = true
    fun v(tag: String?, msg: String?) {
        if (DEBUG) {
            Log.v(tag, msg!!)
        }
    }

    fun d(tag: String?, msg: String?) {
        if (DEBUG) {
            Log.d(tag, msg!!)
        }
    }

    fun i(tag: String?, msg: String?) {
        if (DEBUG) {
            Log.i(tag, msg!!)
        }
    }

    fun w(tag: String?, msg: String?) {
        if (DEBUG) {
            Log.w(tag, msg!!)
        }
    }

    fun e(tag: String?, msg: String?) {
        if (DEBUG) {
            Log.e(tag, msg!!)
        }
    }
}