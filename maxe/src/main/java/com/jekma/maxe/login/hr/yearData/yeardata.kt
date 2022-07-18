package com.jekma.maxe.login.hr.yearData

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import com.jekma.maxe.R

class yeardata : Fragment()
//    , View.OnClickListener, OnTouchListener



class YeardataViewModel(application: Application) : AndroidViewModel(application) {
//
//    private val documents: MutableLiveData<String>
//    private val TAG = "NewTrainingViewModel"
//    private var mResultCallback: IResult? = null
//    private val thisResult = "initial"
//    private fun Api(application: Application) {
//        initVolleyCallback(TAG)
//        val volleyBridge = VolleyBridge()
//        val passData = HashMap<String, String>()
//        passData["ApiSwitcher"] = "L2_D_LmenuLaw"
//        val mVolleyService =
//            VolleyService(mResultCallback, passData, "Warn:Documents&Laws Please Contact Maxe 2213")
//        mVolleyService.postDataVolley("POSTCALL", application, volleyBridge.hr(), thisResult)
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
//                Log.wtf(TAG, "Volley JSON post$response")
//                documents.value = response
//            }
//
//            fun notifyError(requestType: String, error: VolleyError?) {
//                Log.wtf(TAG, "Volley requester $requestType")
//                Log.wtf(TAG, "Volley JSON post" + "That didn't work!")
//            }
//        }
//    }
//
//    fun documents(): LiveData<String> {
//        return documents
//    } // TODO: Implement the ViewModel
//
//    init {
//        Api(application)
//        documents = MutableLiveData()
//    }
}