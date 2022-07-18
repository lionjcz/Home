package com.jekma.maxe.login.hr.activityImg

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel

//import com.bumptech.glide.Glide

class activityimg : Fragment()
//    , View.OnClickListener, OnTouchListener



class ActivityimgViewModel(application: Application) : AndroidViewModel(application) {
//
//    // TODO: Implement the ViewModel
//    private val activityimg: MutableLiveData<String>
//    private val TAG = "NewTrainingViewModel"
//    private var mResultCallback: IResult? = null
//    private val thisResult = "initial"
//    fun Activityimg(): LiveData<String> {
//        return activityimg
//    }
//
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
//                activityimg.value = response
//            }
//
//            override fun notifyError(requestType: String, error: VolleyError?) {
//                Log.wtf(TAG, "Volley requester $requestType")
//                Log.wtf(TAG, "Volley JSON post" + "That didn't work!")
//            }
//        }
//    }
//
//    init {
//        Api(application)
//        activityimg = MutableLiveData()
//    }
}