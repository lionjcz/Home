package com.jekma.maxe.login.index_menu.announcement.Content

import androidx.lifecycle.ViewModel
//import com.company.maxe.Tools.URL.VolleyBridge
//import com.kymjs.rxvolley.RxVolley
//import com.kymjs.rxvolley.client.HttpCallback
//import com.kymjs.rxvolley.client.HttpParams

class ContentviewModel: ViewModel() {
//
//    private val Result = MutableLiveData<String>()
//    private val TAG:String = "ContentviewModel"
//    fun callInfo(index: Int,Url:String): LiveData<String> {
//        RxVolleyConnext(Result,index)
//        return Result
//    }
//    private fun RxVolleyConnext(Result: MutableLiveData<String>, index: Int) {
//
//        /**
//         * 設定Api網址
//         */
//        val url = VolleyBridge().Announcements()
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
//        params.put("search", index)
//        //request parameters
//
//
//        /**
//         * Call Back 結果 並傳到liveData裡面
//         */
//        val callBack: HttpCallback = object : HttpCallback() {
//            override fun onSuccess(Response: String) {
//                Log.e("TAG", "Suc and $Response")
//                Result.postValue(Response)
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