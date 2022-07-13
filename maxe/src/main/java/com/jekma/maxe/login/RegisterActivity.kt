package com.jekma.maxe.login
//import com.example.redeady.R;
//import com.example.redeady.ui.Others.VolleyBridge;
import com.jekma.baselibrary.BaseFragment
import com.jekma.maxe.R
//import com.android.volley.AuthFailureError

class RegisterActivity : BaseFragment() {
    //
//    private var mQueue: RequestQueue? = null
//    private var Sub: Button? = null
//    private var getRequest: StringRequest? = null
//    private var NEWPWD: String? = null
//    private var OLDPWD: String? = null
//    private var username: String? = null
//    private var IMeI: String? = null
//    private val TAG = "RegisterActivity"
//
//    //    private String[] info = { IMeI , IMSI, mRoaming , mCountry , mOperator , mOperatorName , mTelPhoneType , mICCID};
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_register)
//
////        getDevicesImei();
//        Toast.makeText(this@RegisterActivity, "First login please change your password!", Toast.LENGTH_SHORT)
//            .show()
//        val bundle: Bundle? = intent.extras
//        username = bundle.getString("username") //姓名
//        IMeI = bundle.getString("IMEI") //姓名
//        Sub = findViewById<View>(R.id.submit_b) as Button
//        Sub!!.setOnClickListener { VolleyHttp(username) }
//    }
//
//    //intent page
//    private fun intenpage() {
//        var myIntent: Intent? = Intent()
//        myIntent = Intent(this@RegisterActivity, LoginActivity::class.java)
//        startActivity(myIntent)
//        finish()
//    }
//
//    //go back last activity
//    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            var myIntent: Intent? = Intent()
//            myIntent = Intent(this@RegisterActivity, LoginActivity::class.java)
//            startActivity(myIntent)
//            finish()
//        }
//        return super.onKeyDown(keyCode, event)
//    }
//
//    /*
//    * API連線
//    * param = NEWPWD
//    * param = OLDPWD
//    * param = username
//    *  param = IMeI
//    * */
//    private fun VolleyHttp(username: String?) {
//        val Url = VolleyBridge()
//        val v_u: String = Url.Register_Url()
//        println(v_u)
//        val oldPWD: EditText = findViewById<View>(R.id.oldP_WD) as EditText
//        val newPWD: EditText = findViewById<View>(R.id.newP_WD) as EditText
//        mQueue = Volley.newRequestQueue(this)
//        getRequest = object : StringRequest(Request.Method.POST, v_u, object : Listener<String?>() {
//            fun onResponse(s: String?) {
//                println(s)
//                try {
//                    val array = JSONArray(s)
//                    val final_r: String = array.getString(0)
//                    if (final_r == "密碼修改成功") {
//                        Toast.makeText(this@RegisterActivity, final_r, Toast.LENGTH_SHORT).show()
//                        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
//                        startActivity(intent)
//                        finish()
//                    }
//                    else {
//                        Toast.makeText(this@RegisterActivity, final_r, Toast.LENGTH_SHORT).show()
//                    }
//                } catch (e: JSONException) {
//                    e.printStackTrace()
//                }
//            }
//        }, object : ErrorListener() {
//            fun onErrorResponse(volleyError: VolleyError) {
//                Toast.makeText(this@RegisterActivity, "連線失敗$volleyError", Toast.LENGTH_SHORT).show()
//            }
//        }) {
//            @get:Throws(AuthFailureError::class)
//            protected val params: Map<String, String?>
//                protected get() {
//                    OLDPWD = oldPWD.getText().toString()
//                    NEWPWD = newPWD.getText().toString()
//                    val hashMap = HashMap<String, String?>()
//                    hashMap["NEWPWD"] = NEWPWD
//                    hashMap["OLDPWD"] = OLDPWD
//                    hashMap["NAME"] = username
//                    hashMap["IMEI"] = IMeI
//                    Log.wtf(TAG, "NEWPWD = $NEWPWD")
//                    Log.wtf(TAG, "OLDPWD = $OLDPWD")
//                    Log.wtf(TAG, "NAME = $username")
//                    Log.wtf(TAG, "IMEI = $IMeI")
//                    return hashMap
//                }
//        }
//        mQueue.add(getRequest)
//    }
//
//    companion object {
//        const val REQUEST_READ_PHONE_STATE = 8
//    }
    override val titleResId: Int
        get() = R.string.maxe_title_register
    override val layoutResId: Int
        get() = R.layout.maxe_fragment_register
}