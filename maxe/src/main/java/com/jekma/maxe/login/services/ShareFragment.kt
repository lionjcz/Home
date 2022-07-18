package com.jekma.maxe.login.services

import android.app.Application
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
//import androidx.navigation.NavController
import com.jekma.baselibrary.BaseFragment
import com.jekma.maxe.R
import java.lang.IllegalStateException

class ShareFragment : BaseFragment(), View.OnClickListener {
    override val isShowMainBar: Boolean
        get() = true
    override val titleResId: Int
        get() = R.string.maxe_title_services
    override val layoutResId: Int
        get() = R.layout.maxe_fragment_share

    private lateinit var errorcode: LinearLayout
    private lateinit var stock: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val root: View = inflater.inflate(R.layout.maxe_fragment_share, container, false)
        ButtonBox(root)
        PermissionCheck("啟動", stock) //查詢料號庫存 //Permission(services_stock)
        PermissionCheck("啟動", errorcode) //查詢錯誤代碼 Permission(services_errorcode)
        return root
    }
//
    private fun ButtonBox(root: View) {
        errorcode = root.findViewById<LinearLayout>(R.id.errorcode)
        stock = root.findViewById<LinearLayout>(R.id.stock)
        errorcode.setOnClickListener(this)
        stock.setOnClickListener(this)
    }

    private fun PermissionCheck(permission: String, TargetButton: LinearLayout?) {
        println("permission = $permission")
        if (permission == "啟動") {
            TargetButton?.setEnabled(true)
        }
        else if (permission == "關閉") {
            TargetButton?.setEnabled(false)
            val textView: TextView = TargetButton?.getChildAt(1) as TextView
            textView.setTextColor(Color.GRAY)
        }
        else {
            Toast.makeText(requireActivity().applicationContext, "Something was wrong !! please contace Maxe 2213", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.errorcode -> {
                gotoNextNavPage(R.id.action_nav_share_to_ser_ErrCod,null)
            }
            R.id.stock     -> {
                gotoNextNavPage(R.id.action_nav_share_to_ser_stock,null)
            }
            else           -> {
                throw IllegalStateException("Unexpected value: " + v.id)
            }
        }
    }
}

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