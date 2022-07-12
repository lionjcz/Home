package com.jekma.baselibrary

object Utils {

    fun getSearchKeyWords():String{
        return "Thermaltake_Dongle"
    }

    fun removedDoubleQuotes(connectedSsid: String): String {
        return connectedSsid.substring(1, connectedSsid.length - 1)
    }
}