package com.jekma.maxe.tools

//import com.android.volley.VolleyError

interface IResult {
    fun notifySuccess(requestType: String?, response: String?)
//    fun notifyError(requestType: String?, error: VolleyError?)
    fun customError(ConnectErrorMessage: String?)
}