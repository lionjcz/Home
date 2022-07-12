package com.company.maxe.Login

import android.os.Environment
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
//import com.company.maxe.Tools.URL.VolleyBridge
//import com.kymjs.rxvolley.RxVolley
//import com.kymjs.rxvolley.client.HttpCallback
//import com.kymjs.rxvolley.client.HttpParams
class LoginActivityViewModel: ViewModel() {
//    private var TAG:String = "LoginActivityViewModel"
////
//    private var ResponseinVM = MutableLiveData<String>()
//    fun callInfo(Email:String,Password:String,IMEI: String,Url:String): LiveData<String> {
//        RxVolleyConnext(ResponseinVM,Email,Password,IMEI,Url)
//        return ResponseinVM
//    }
//    private fun RxVolleyConnext(ResponseinVM: MutableLiveData<String>, Email:String,Password:String,IMEI:String,Url:String) {
//
//        /**
//         * 設定Api網址
//         */
//        val url = Url
//
//
//        /**
//         * 設定參數
//         */
//        val params = HttpParams()
//        //http header, optional parameters
//        params.putHeaders("cookie", "your cookie")
//        params.putHeaders("User-Agent", "rxvolley")
//        //http header, optional parameters
//        //request parameters
//        params.put("email", Email)
//        params.put("password", Password)
//        params.put("IMEI", IMEI)
//        //request parameters
//
//
//        /**
//         * Call Back 結果 並傳到liveData裡面
//         */
//        val callBack: HttpCallback = object : HttpCallback() {
//            override fun onSuccess(Response: String) {
//                Log.e("TAG", "Suc and $Response")
//                ResponseinVM.postValue(Response)
//            }
//
//            override fun onFailure(errorNo: Int, strMsg: String) {
//                Log.e("TAG", "Fai = { $errorNo } and Msg = $strMsg")
//            }
//        }
//
//
//        /**
//         * 連線到Api
//         */
//        RxVolley.Builder()
//                .url(url)
//                .httpMethod(RxVolley.Method.POST) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
//                .cacheTime(6) //default: get 5min, post 0min
//                .contentType(RxVolley.ContentType.FORM) //default FORM or JSON
//                .params(params)
//                .shouldCache(true) //default: get true, post false
//                .callback(callBack)
//                .encoding("UTF-8") //default
//                .doTask()
//    }
////
//    private var ResponseinForgot = MutableLiveData<String>()
//    fun CallForgotInfo(forName: String, forEmail: String, Status: String,Url:String): LiveData<String> {
//        RxVolleyConnext2(ResponseinForgot,forName,forEmail,Status,Url)
//        return ResponseinForgot
//    }
//    private fun RxVolleyConnext2(responseinForgot: MutableLiveData<String>, forName: String, forEmail: String, Status: String, Url: String) {
//        /**
//         * 設定Api網址
//         */
//        val url = Url
//
//
//        /**
//         * 設定參數
//         */
//        val params = HttpParams()
//        //http header, optional parameters
//        params.putHeaders("cookie", "your cookie")
//        params.putHeaders("User-Agent", "rxvolley")
//        //http header, optional parameters
//        //request parameters
//        params.put("forgot_name", forName)
//        params.put("forgot_email", forEmail)
//        params.put("sessionCHECKER", Status)
//        //request parameters
//
//
//        /**
//         * Call Back 結果 並傳到liveData裡面
//         */
//        val callBack: HttpCallback = object : HttpCallback() {
//            override fun onSuccess(Response: String) {
//                Log.e("TAG", "Suc and $Response")
//                responseinForgot.postValue(Response)
//            }
//
//            override fun onFailure(errorNo: Int, strMsg: String) {
//                Log.e("TAG", "Fai = { $errorNo } and Msg = $strMsg")
//            }
//        }
//
//
//        /**
//         * 連線到Api
//         */
//        RxVolley.Builder()
//                .url(url)
//                .httpMethod(RxVolley.Method.POST) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
//                .cacheTime(6) //default: get 5min, post 0min
//                .contentType(RxVolley.ContentType.FORM) //default FORM or JSON
//                .params(params)
//                .shouldCache(true) //default: get true, post false
//                .callback(callBack)
//                .encoding("UTF-8") //default
//                .doTask()
//    }
//
////
//    private var ResponseinEmailContent = MutableLiveData<String>()
//    fun CallEmailContentInfo(forEmail: String, forName: String, Url: String): LiveData<String> {
//        var Environment:String = VolleyBridge().Env()
//        RxVolleyConnextCallEmailContentInfo(ResponseinEmailContent,forEmail,forName,Url,Environment)
//        return ResponseinEmailContent
//
//    }
//    private fun RxVolleyConnextCallEmailContentInfo(responseinEmailContent: MutableLiveData<String>, forEmail: String, forName: String, Url: String, Enviroment:String) {
//        /**
//         * 設定Api網址
//         */
//        val url = Url
//
//
//        /**
//         * 設定參數
//         */
//        val params = HttpParams()
//        //http header, optional parameters
//        params.putHeaders("cookie", "your cookie")
//        params.putHeaders("User-Agent", "rxvolley")
//        //http header, optional parameters
//        //request parameters
//        params.put("to", forEmail)
//        params.put("destination", forName)
//        params.put("Env",Enviroment)
//        Log.i(TAG,"Enviromemnt is $Enviroment");
//        //request parameters
//
//
//        /**
//         * Call Back 結果 並傳到liveData裡面
//         */
//        val callBack: HttpCallback = object : HttpCallback() {
//            override fun onSuccess(Response: String) {
//                Log.e("TAG", "Suc and $Response")
//                responseinEmailContent.postValue(Response)
//            }
//
//            override fun onFailure(errorNo: Int, strMsg: String) {
//                Log.e("TAG", "Fai = { $errorNo } and Msg = $strMsg")
//            }
//        }
//
//
//        /**
//         * 連線到Api
//         */
//        RxVolley.Builder()
//                .url(url)
//                .httpMethod(RxVolley.Method.POST) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
//                .cacheTime(6) //default: get 5min, post 0min
//                .contentType(RxVolley.ContentType.FORM) //default FORM or JSON
//                .params(params)
//                .shouldCache(true) //default: get true, post false
//                .callback(callBack)
//                .encoding("UTF-8") //default
//                .doTask()
//    }
//
//

}