package com.company.maxe.Tools.URL

import android.content.Context
import com.company.maxe.Tools.Callback.IResult
//import com.android.volley.AuthFailureError
import java.lang.Exception
import java.util.HashMap

class VolleyService(resultCallback: IResult?, HashMap: HashMap<String, String>, ErrorResponse: String) {
//
//    var mResultCallback: IResult? = null
//    var mContext: Context? = null
//    var mhashMap: HashMap<String, String>? = null
//    var ErrorResponse1 = "initial1"
//    fun postDataVolley(requestType: String?, context: Context, url: String, variable: String) {
//        mContext = context
//        try {
//            println("VolleyService = $variable")
//            println("VolleyService = $url")
//            println("VolleyService = $context")
//            val queue: RequestQueue = Volley.newRequestQueue(mContext)
//            val getRequest: StringRequest =
//                object : StringRequest(Request.Method.POST, url, object : Listener<String?>() {
//                    fun onResponse(s: String?) {
//                        //                        res=s;
//                        if (mResultCallback != null) mResultCallback.notifySuccess(requestType, s)
//                    }
//                }, object : ErrorListener() {
//                    fun onErrorResponse(error: VolleyError?) {
//                        if (mResultCallback != null) mResultCallback.notifyError(requestType, error)
//                        mResultCallback.customError(ErrorResponse1)
//                    }
//                }) {
//                    @get:Throws(AuthFailureError::class)
//                    protected val params: Map<String, String>?
//                        protected get() = mhashMap
//                }
//            queue.add(getRequest)
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }
//
//    init {
//        mResultCallback = resultCallback
//        mhashMap = HashMap
//        mhashMap = HashMap()
//        mhashMap = HashMap
//        ErrorResponse1 = ErrorResponse
//    }
}