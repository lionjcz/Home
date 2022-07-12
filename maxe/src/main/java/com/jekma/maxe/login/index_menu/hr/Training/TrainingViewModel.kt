package com.company.maxe.Login.index_menu.hr.Training

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
//import com.android.volley.VolleyError
import java.util.HashMap

class TrainingViewModel(application: Application) : AndroidViewModel(application) {
//
//    private val TAG = "NewTrainingViewModel"
//    private val Training: MutableLiveData<String>
//    private var mResultCallback: IResult? = null
//    private val thisResult = "initial"
//    private fun Api(application: Application) {
//        initVolleyCallback(TAG)
//        val volleyBridge = VolleyBridge()
//        val passData = HashMap<String, String>()
//        passData["ApiSwitcher"] = "hr_EmployeersTraining"
//        val mVolleyService =
//            VolleyService(mResultCallback, passData, "Warn:Training Please Contact Maxe 2213")
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
//                Training.value = response
//            }
//
//            fun notifyError(requestType: String, error: VolleyError?) {
//                Log.wtf(TAG, "Volley requester $requestType")
//                Log.wtf(TAG, "Volley JSON post" + "That didn't work!")
//            }
//        }
//    }
//
//    fun getTraining(): LiveData<String> {
//        return Training
//    }
//
//    init {
//        Api(application)
//        Training = MutableLiveData()
//    }
}