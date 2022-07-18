package com.jekma.maxe.tools.url

//import com.android.volley.AuthFailureError
//import com.android.volley.Response
//import com.android.volley.toolbox.StringRequest
//import com.android.volley.toolbox.Volley
//import com.jekma.maxe.tools.IResult

class VolleySingleTon() {
//
//    private val TAG:String = "VolleySingleTon"
//    var mResultCallback: IResult? = null
//    var mContext: Context? = null
//    var mhashMap: HashMap<String, String>? = null
//    var ErrorResponse1 = "initial1"
//    init {
//        mResultCallback = resultCallback;
//        mhashMap = HashMap<String, String>();
//        mhashMap = HashMap;
//        ErrorResponse1 = ErrorResponse;
//    }
//
//
//    fun postDataVolley(requestType:String, context: Context, url: String, variable:String ){
//        mContext = context
//        try {
//            Log.i(TAG,"$variable");
//            Log.i(TAG,"$url");
//            Log.i(TAG,"$context");
//            val queue = Volley.newRequestQueue(mContext)
//            val getRequest: StringRequest = object : StringRequest(Method.POST, url,
//                Response.Listener { s ->
//                    //                        res=s;
//                    if (mResultCallback != null) mResultCallback!!.notifySuccess(requestType, s)
//                },
//                Response.ErrorListener { error ->
//                    if (mResultCallback != null) mResultCallback!!.notifyError(requestType, error)
//                     mResultCallback!!.customError(ErrorResponse1)
//                }){
//                    @Throws(AuthFailureError::class)
//                    override fun getParams(): Map<String, String> {
//                        return mhashMap!!
//                    }
//                }
//            queue.add(getRequest)
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }
}