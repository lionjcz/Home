package com.company.maxe.Login.index_menu.services

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
//import com.android.volley.VolleyError
import java.util.HashMap

class ShareViewModel(application: Application) : AndroidViewModel(application) {
//
//    private val stock: MutableLiveData<Boolean>
//    private val errorcode: MutableLiveData<Boolean>
//    private val TAG = "ShareViewModel"
//    private var mResultCallback: IResult? = null
//    private val thisResult = "initial"
//    private fun Api(application: Application) {
//        initVolleyCallback(TAG)
//        val status = VolleyBridge()
//        val passData = HashMap<String, String>()
//        passData[""] = ""
//        val mVolleyService =
//            VolleyService(mResultCallback, passData, "Warn:ServicesIndex Please Contact Maxe 2213")
//        mVolleyService.postDataVolley("POSTCALL", application, status.status(), thisResult)
//    }
//
//    /*
//     * Return Result
//     * */
//    private fun initVolleyCallback(TAG: String) {
//        mResultCallback = object : IResult {
//            override fun customError(ConnectErrorMessage: String) {
//                Toast.makeText(getApplication<Application>().applicationContext, "" + ConnectErrorMessage, Toast.LENGTH_SHORT)
//                    .show()
//            }
//
//            override fun notifySuccess(requestType: String, response: String?) {
//                Log.wtf(TAG, "Volley requester $requestType")
//                //                Log.wtf(TAG, "Volley JSON post" + response);
////                mResult.setValue(response);
////                Parsing(TAG,response);
//            }
//
//            private fun Parsing(tag: String, response: String) {
//                try {
//                    val arry = JSONObject(response)
//                    val slideshow: String = arry.getString("查詢庫存") //slideshow
//                    val galley: String = arry.getString("查詢業績") //galley
//                    val stock: String = arry.getString("查詢料號庫存") //ercde_dialog
//                    val error_code: String = arry.getString("查詢錯誤代碼") //error_code
//                    println("arry.length = " + arry.length())
//                    val function = arrayOfNulls<String>(arry.length() - 1)
//                    if (slideshow != null && galley != null && stock != null && error_code != null) {
//                        function[0] = slideshow //slideshow
//                        function[1] = galley //galley
//                        function[2] = stock //stock
//                        function[3] = error_code //error_code
//                    }
//                    else {
//                        println("==")
//                    }
//                    Status(function)
//                } catch (e: JSONException) {
//                    e.printStackTrace()
//                }
//            }
//
//            /*
//             * 根據功能開關決定是否顯示
//             * */
//            private fun Status(function: Array<String?>) {
//
//                //        function[0] = slideshow;//slideshow -> 查詢庫存
//                //        function[1] = galley;//galley -> 經銷商業績
//                //        function[2] = stock;//stock -> 查詢料號庫存
//                //        function[3] = error_code;//error_code -> 查詢錯誤代碼
//                for (i in function.indices) {
//                    println("function[i] Service" + i + " = " + function[i])
//                }
//
//                //        function[2] = stock;//stock -> 查詢料號庫存
//                //        function[3] = error_code;//error_code -> 查詢錯誤代碼
//                //服管專區
//                if (function[2] == "啟動") {
////                    stock.setEnabled(true);
//                    stock.setValue(true)
//                }
//                else if (function[2] == "關閉") {
////                    stock.setEnabled(false);
//                    stock.setValue(false)
//                }
//                if (function[3] == "啟動") {
////                    errorcode.setEnabled(true);
//                    errorcode.setValue(true)
//                }
//                else if (function[3] == "關閉") {
////                    errorcode.setEnabled(false);
//                    errorcode.setValue(true)
//                }
//                //服管專區
//            }
//
//            override fun notifyError(requestType: String, error: VolleyError?) {
//                Log.wtf(TAG, "Volley requester $requestType")
//                Log.wtf(TAG, "Volley JSON post" + "That didn't work!")
//            }
//        }
//    }
//
//    fun getStock(): LiveData<Boolean> {
//        return stock
//    }
//
//    fun getErrorcode(): LiveData<Boolean> {
//        return errorcode
//    }
//
//    init {
//        Api(application)
//        stock = MutableLiveData()
//        errorcode = MutableLiveData()
//    }
}