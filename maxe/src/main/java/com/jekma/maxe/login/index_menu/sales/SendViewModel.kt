package com.company.maxe.Login.index_menu.sales

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
//import com.android.volley.VolleyError
import java.util.HashMap

class SendViewModel(application: Application) : AndroidViewModel(application) {
//
//    private val mResult: MutableLiveData<String>
//    private var string1234: MutableLiveData<String>? = null
//    private val TAG = getApplication<Application>().resources.getString(R.string.menu_send)
//    private var mResultCallback: IResult? = null
//    private val thisResult = "initial"
//    private val string = "initial"
//    private fun result() {
//        string1234 = MutableLiveData()
//        string1234!!.value = "changed"
//    }
//
//    private fun Api(application: Application) {
//        initVolleyCallback(TAG)
//        val volleyBridge = VolleyBridge()
//        val passData = HashMap<String, String>()
//        passData[""] = ""
//        val mVolleyService =
//            VolleyService(mResultCallback, passData, "Warn:SalesIndex Please Contact Maxe 2213")
//        mVolleyService.postDataVolley("POSTCALL", application, volleyBridge.Announcements(), thisResult)
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
//            override fun notifySuccess(requestType: String, response: String) {
//                Log.wtf(TAG, "Volley requester $requestType")
//                //                Log.wtf(TAG, "Volley JSON post" + response);
//                mResult.value = response
//                //                RESULT(TAG,response);
//            }
//
//            fun notifyError(requestType: String, error: VolleyError?) {
//                Log.wtf(TAG, "Volley requester $requestType")
//                Log.wtf(TAG, "Volley JSON post" + "That didn't work!")
//            }
//        }
//    }
//
//    val text: LiveData<String>
//        get() = mResult
//
//    init {
//        Api(application)
//        mResult = MutableLiveData()
//        //        mResult.setValue("This is sales fragment");
//    }
}