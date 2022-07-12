package com.company.maxe.welcome.errorcode

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
//import com.company.maxe.Tools.URL.VolleyBridge
//import com.kymjs.rxvolley.RxVolley
//import com.kymjs.rxvolley.client.HttpCallback
//import com.kymjs.rxvolley.client.HttpParams
import java.util.*


class ViewModel3(application: Application) : AndroidViewModel(application){
//
//    private var userInfoLiveData = MutableLiveData<String>()
//    fun callInfo(userInput: String): LiveData<String> {
//        RxVolleyConnext(userInfoLiveData,userInput)
//        return userInfoLiveData
//    }
//    private fun RxVolleyConnext(userInfoLiveData: MutableLiveData<String>, userInput: String) {
//
//        /**
//         * 設定Api網址
//         */
//        val Services_stock = VolleyBridge()
//        val url = Services_stock.Services_errorcode()
//
//
//        /**
//         * 設定參數
//         */
//        val params = HttpParams()
//        //http header, optional parameters
//            params.putHeaders("cookie", "your cookie")
//            params.putHeaders("User-Agent", "rxvolley")
//        //http header, optional parameters
//        //request parameters
//            params.put("search", userInput)
//        //request parameters
//
//
//        /**
//         * Call Back 結果 並傳到liveData裡面
//         */
//        val callBack: HttpCallback = object : HttpCallback() {
//            override fun onSuccess(Response: String) {
//                Log.e("TAG", "Suc and $Response")
//                userInfoLiveData.postValue(Response)
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
}


