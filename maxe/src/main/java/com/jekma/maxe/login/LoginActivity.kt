package com.jekma.maxe.login

import com.jekma.baselibrary.BaseFragment
import com.jekma.maxe.R

//import android.Manifest
//import android.app.Activity
//import android.app.AlertDialog
//import android.app.ProgressDialog
//import android.content.Context
//import android.content.DialogInterface
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.os.Build
//import android.os.Bundle
//import android.provider.Settings
//import android.telephony.TelephonyManager
//import android.util.Log
//import android.view.KeyEvent
//import android.view.LayoutInflater
//import android.view.View
//import android.view.inputmethod.EditorInfo
//import android.widget.CheckBox
//import android.widget.EditText
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.app.ActivityCompat
//import androidx.core.content.ContextCompat
//import androidx.databinding.DataBindingUtil
//import androidx.lifecycle.ViewModelProvider
//import com.android.volley.*
//import com.android.volley.toolbox.StringRequest
//import com.android.volley.toolbox.Volley
//import com.company.maxe.Login.LoginActivityViewModel
//import com.company.maxe.Login.MainActivity
//import com.company.maxe.R
//import com.company.maxe.Tools.URL.VolleyBridge
//import com.company.maxe.databinding.ActivityLoginBinding
//import com.jekma.maxe.welcome.Welcome
//import com.google.android.material.textfield.TextInputEditText
//import org.json.JSONArray
//import org.json.JSONException
//import java.io.*
//import java.util.*
//import kotlin.jvm.Throws

class LoginActivity : BaseFragment(){
    //
//    /**
//     * DataBinding
//     */
//    private lateinit var binding: ActivityLoginBinding
//    private lateinit var e_eml: String
//    private lateinit var e_pwd: String
//    private lateinit var devices: Devices
//
//    /**
//     * 建立viewModel的變數
//     */
//    private lateinit var LAVM: LoginActivityViewModel
//
//
//    private val TAG = "LoginActivity"
//    private val session = 1
//    private var IMeI = "initial"
//    private val REQUEST_PERMISSION_PHONE_STATE:Int = 1
//    private var dialog: ProgressDialog? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
//        LAVM = ViewModelProvider(this).get(LoginActivityViewModel::class.java)
//
//
//        RememberEmail()
//        init()
//        val mTelManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
//        devices = Devices(TAG,this,REQUEST_PERMISSION_PHONE_STATE,mTelManager)
//        IMeI = devices.imei
//        println(devices.imei)
//        Log.wtf(TAG, "imei" + devices!!.imei)
//        dialog = ProgressDialog(this)
//    }
//
//
//    /**
//     * 初始化元件，設定事件，設定UI
//     */
//    private fun init() {
//
//        /**
//         * 當使用者輸入帳號密碼後按下虛擬鍵盤的確認，自訂連線到API
//         */
//        binding.LoginPassword.setOnEditorActionListener { v, actionId, event ->
//            when (actionId) {
//                EditorInfo.IME_ACTION_SEND -> RxVolleyConnext(IMeI,VolleyBridge().Login_Url())
//            }
//            false
//        }
//
//
//        /**
//         * 當使用者按下 記住我的信箱時
//         * 1.將 Email輸入框先清空
//         * 2.當試用者成功登入後，會記住登入成功後的信箱
//         */
//        binding.Remember.setOnClickListener {
//            RememberEmail()
//        }
//
//
//
//        /**
//         * 隱藏ActionBar
//         */
//        supportActionBar!!.hide() //hide action bar
//
//
//    }
//
//    /**
//     * 當適用者按下忘記密碼，會出現Dialog視窗並要求使用者輸入，姓名，信箱
//     *
//     */
//    private var ctx: LoginActivity? = this
//    private lateinit var mQueue: RequestQueue
//    fun forgot(view: View?) {
//        val layoutInflater = LayoutInflater.from(ctx)
//        val newPlanDialog = layoutInflater.inflate(R.layout.dialogforgot, null)
//        val ad = AlertDialog.Builder(ctx)
//        ad.setView(newPlanDialog)
//        ad.setTitle("萬士益")
//        ad.setNeutralButton("取消") { dialog, which -> }
//        ad.setPositiveButton("確定", object : DialogInterface.OnClickListener {
//            override fun onClick(dialog: DialogInterface, which: Int) {
////                volleyPorst(ctx)
//                val f_name = newPlanDialog.findViewById<View>(R.id.for_name) as EditText
//                val for_name = f_name.text.toString()
//                val f_email = newPlanDialog.findViewById<View>(R.id.for_email) as EditText
//                val for_email = f_email.text.toString()
//                LAVM.CallForgotInfo(for_name,for_email,"Opened",VolleyBridge().forgot()).observe(this@LoginActivity, androidx.lifecycle.Observer {
//                    Log.i(TAG,"The response is  ${it} at observe mode in Class:$TAG")
//                    val jsonArray = JSONArray(it)
//                    val sessionSeter = jsonArray.getString(0)
//                    msg(sessionSeter)
//                    getRes(sessionSeter, newPlanDialog)
//                })
//
//            }
//
//            fun volleyPorst(ctx: LoginActivity?) {
//                mQueue = Volley.newRequestQueue(ctx)
//                val getRequest: StringRequest = object : StringRequest(Method.POST, VolleyBridge().forgot(),
//                        Response.Listener { s ->
//                            try {
//                                val jsonArray = JSONArray(s)
//                                val sessionSeter = jsonArray.getString(0)
//                                msg(sessionSeter)
//                                getRes(sessionSeter, newPlanDialog)
//                            } catch (e: JSONException) {
//                                e.printStackTrace()
//                            }
//                        }, Response.ErrorListener { Toast.makeText(ctx, "Warn:Login , Please contace Maxe 2213", Toast.LENGTH_SHORT).show() }) {
//                    @Throws(AuthFailureError::class)
//                    override fun getParams(): Map<String, String> {
//                        val f_name = newPlanDialog.findViewById<View>(R.id.for_name) as EditText
//                        val for_name = f_name.text.toString()
//                        val f_email = newPlanDialog.findViewById<View>(R.id.for_email) as EditText
//                        val for_email = f_email.text.toString()
//                        val hashMap = HashMap<String, String>()
//                        hashMap["forgot_name"] = for_name
//                        hashMap["forgot_email"] = for_email
//                        hashMap["sessionCHECKER"] = "Opened"
//                        Log.wtf("LoginActivity", "Passing variable :forgot_name = $for_name")
//                        Log.wtf("LoginActivity", "Passing variable :forgot_email = $for_email")
//                        Log.wtf("LoginActivity", "Passing variable :" + "sessionCHECKER = " + "Opened")
//                        return hashMap
//                    }
//                }
//                mQueue.add(getRequest)
//            }
//        })
//        ad.show()
//    }
//    private fun msg(sessionSeter: String) {
//        Toast.makeText(ctx, sessionSeter, Toast.LENGTH_SHORT).show()
//    }
//    private fun getRes(sessionSeter: String, newPlanDialog: View) {
//        when (sessionSeter) {
//            "請確認您輸入的是否正確" -> msg(sessionSeter)
//            "資料驗證成功，寄信中請稍後。" -> {
//                msg(sessionSeter)
//                sender(newPlanDialog)
//            }
//            "session錯誤" -> msg(sessionSeter)
//        }
//    }
//    private fun sender(newPlanDialog: View) {
//        val f_name = newPlanDialog.findViewById<View>(R.id.for_name) as EditText
//        val for_name = f_name.text.toString()
//        val f_email = newPlanDialog.findViewById<View>(R.id.for_email) as EditText
//        val for_email = f_email.text.toString()
//        volleyPost(for_email, for_name)
//
//    }
//    private fun volleyPost(for_email: String, for_name: String) {
//        LAVM.CallEmailContentInfo(for_email, for_name , VolleyBridge().emailContent).observe(this,androidx.lifecycle.Observer<String> {
//            val array = JSONArray(it)
//            val result = array.getString(0)
//            if (result == result) {
//                msg(result)
//            }
//
//        })
////        mQueue = Volley.newRequestQueue(ctx)
////        val getRequest: StringRequest = object : StringRequest(Method.POST, VolleyBridge().emailContent,
////                Response.Listener { s ->
////                    try {
////
////                    } catch (e: JSONException) {
////                        e.printStackTrace()
////                    }
////                }, null) {
////            @Throws(AuthFailureError::class)
////            override fun getParams(): Map<String, String> {
////                val hashMap = HashMap<String, String>()
////                hashMap["to"] = for_email
////                hashMap["destination"] = for_name
////                Log.wtf("LoginActivity", "passing data : to = $for_email")
////                Log.wtf("LoginActivity", "passing data : destination = $for_name")
////                return hashMap
////            }
////        }
////        getRequest.retryPolicy = DefaultRetryPolicy(20 * 1000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
////        mQueue.add(getRequest)
//    }
//
//    /**
//     * 當使用者輸入帳號密碼後按下登入時，自動連線至Api
//     */
//    fun Login(view: View?){
//        dialog!!.show()
//        RxVolleyConnext(IMeI,VolleyBridge().Login_Url())
//    }
//
//    private fun RxVolleyConnext(iMeI: String, loginUrl: String) {
//
//        LAVM.callInfo(
//                binding.LoginEmail.text.toString(),
//                binding.LoginPassword.text.toString(),
//                iMeI,
//                loginUrl).observe(this, androidx.lifecycle.Observer {
//            Log.i(TAG,"The response is  ${it} at observe mode in Class:Errorcode_home")
//            Parsing(it)
//
//        })
//    }
//    private fun Parsing(response: String) {
//        try {
//            val arry = JSONArray(response)
//            val Login_result = arry.getJSONObject(0).getString("Login_result")
//            if (Login_result == "登入成功_IMEI比對成功") {
//                dialog!!.hide()
//                SaveData()
//                Check_e_level_unit(arry, response)
//            } //First Login
//            else if (Login_result == "First_login") {
//                val e_name = arry.getJSONObject(0).getString("Android_NAME")
//                val abs = FirstTimes(e_name, e_pwd, this@LoginActivity, IMeI)
//            } else {
//                dialog!!.hide()
//                Toast.makeText(this@LoginActivity, Login_result, Toast.LENGTH_SHORT).show()
//            }
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//    }
//    @Throws(JSONException::class)
//    private fun Check_e_level_unit(arry: JSONArray, s: String) {
//        val arrayCount = arry.length()
//        BundleData(s, arrayCount)
//    }
//    private fun BundleData(s: String, arrayCount: Int) {
//        Toast.makeText(this@LoginActivity, "登入成功", Toast.LENGTH_SHORT).show()
//        val thispage = Intent(this, MainActivity::class.java)
//        val bundle = Bundle()
//        bundle.putInt("ArrayCount", arrayCount)
//        bundle.putString("LoginData", s)
//        thispage.putExtras(bundle) // 記得put進去，不然資料不max會帶過去哦
//        startActivityForResult(thispage, session)
//        finish()
//    }
//    /**
//     * 記住信箱
//     */
//    private fun RememberEmail() {
//        val userid = getSharedPreferences("test", Context.MODE_PRIVATE)
//                .getString("USER", "")
//        val RememberStatusString = getSharedPreferences("test", Context.MODE_PRIVATE)
//                .getString("Remember", "")
//        //        System.out.println("RememberStatusString = "+RememberStatusString);
//        val RememberStatus = java.lang.Boolean.parseBoolean(RememberStatusString)
//        val Reme = findViewById<CheckBox>(R.id.Remember)
//        if (RememberStatus) {
//            val default_email = findViewById<View>(R.id.Login_Email) as TextInputEditText
//            default_email.setText(userid)
//            Reme.isChecked = true
//        } else {
//        }
//    }
//    /**
//     * 向使用者要求權限
//     */
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        Log.wtf(TAG, "onRequestPermissionsResult")
//        if (requestCode == REQUEST_PERMISSION_PHONE_STATE) {
//            devices.else29(TAG, REQUEST_PERMISSION_PHONE_STATE)
//            Log.wtf(TAG, "onRequestPermissionsResult()->@param requestCode = $requestCode")
//        } else {
//            Log.wtf(TAG, "onRequestPermissionsResult()->@param requestCode = $requestCode")
//        }
//    }
//
//    /**
//     * 當使用者登入成功後，記住信箱，以方便下次顯示
//     */
//    private fun SaveData() {
//        val user = binding.LoginEmail.text.toString()
//        val pref = getSharedPreferences("test", Context.MODE_PRIVATE)
//        pref.edit().putString("USER", user).commit()
//    }
//    /**
//     * 當使用者按下返回鍵後，回到首頁
//     */
//    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            val homeIntent = Intent(this@LoginActivity, Welcome::class.java)
//            startActivity(homeIntent)
//            finish()
//        }
//        return super.onKeyDown(keyCode, event)
//    }
//}
//
//internal class FirstTimes(e_name: String, e_pwd: String, loginActivity: LoginActivity, IMeI: String) {
//    //    private final LoginActivity loginActivity1;
//    private val activity: Activity
//    private val currentNAME: String
//    var currentPWD: String
//    private var IMei = ""
//    private fun FirstLoginChangePassword(test: String) {
//        volleyPost(test)
//    }
//
//    private fun volleyPost(currentPWD: String) {
//        val changePWD = VolleyBridge()
//        val mQueue = Volley.newRequestQueue(activity)
//        // 記得put進去，不然資料不max會帶過去哦
//        val getRequest: StringRequest = object : StringRequest(Method.POST, changePWD.changePWD(),
//                Response.Listener { s ->
//                    Log.wtf("LoginActivity", s)
//                    try {
//                        val array = JSONArray(s)
//                        val result = array.getString(0)
//                        if (result == "NeedChange") {
//                            val intent = Intent(activity, RegisterActivity::class.java)
//                            val bundle = Bundle()
//                            bundle.putString("username", currentNAME)
//                            bundle.putString("IMEI", IMei)
//                            intent.putExtras(bundle) // 記得put進去，不然資料不max會帶過去哦
//                            activity.startActivity(intent)
//                            activity.finish()
//                        } else if (result == "DontNeedChange") {
//                        }
//                    } catch (e: JSONException) {
//                        e.printStackTrace()
//                    }
//                },
//                Response.ErrorListener { }) {
//            @Throws(AuthFailureError::class)
//            override fun getParams(): Map<String, String> {
//                val hashMap = HashMap<String, String>()
//                hashMap["currentPWD"] = currentPWD
//                return hashMap
//            }
//        }
//        mQueue.add(getRequest)
//    }
//    init {
//        IMei = IMeI
//        currentNAME = e_name
//        currentPWD = e_pwd
//        activity = loginActivity
//        FirstLoginChangePassword(currentPWD)
//    }
//}
//
//internal object IMEIUtil {
//    fun getDeviceId(context: Context): String {
//        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
//        if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    Activity#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for Activity#requestPermissions for more details.
//            return ""
//        }
//        var deviceId = telephonyManager.deviceId.trim { it <= ' ' }
//        if (deviceId == null) {
//            val androidId = Settings.Secure.getString(context.contentResolver,
//                    Settings.Secure.ANDROID_ID)
//            deviceId = Build.SERIAL + "#" + androidId
//        }
//        return deviceId.trim { it <= ' ' }
//    }
//
//    private fun checkSelfPermission(readPhoneState: String): Int {
//        return 0
//    }
//}
//
//internal class Devices(tag: String, loginActivity: LoginActivity, REQUEST_PERMISSION_PHONE_STATE: Int, telephonyService: TelephonyManager) {
//    private var tm: TelephonyManager
//    private var REQUEST_PERMISSION_PHONE_STATE: Int
//    private var context:Activity
//
//    init {
//        this.context = loginActivity
//        this.REQUEST_PERMISSION_PHONE_STATE = REQUEST_PERMISSION_PHONE_STATE
//        this.tm = telephonyService
//    }
//    private var NavigationTAG = "NavigationPermissionCheckTAG" //default
//    private var APIVERSION = 0 //default
//    var imei = "initial" //default
//    private var DEVICEINFO: Array<String?>? = null //default
//
//    /** DEVICEIMEI START
//     * check target build version
//     * distinguish two parts to be 29 and else29
//     *
//     */
//    private fun DEVICEIMEI() {
//        NavigationTAG = "$NavigationTAG->DEVICEIMEI()"
//        val TargetDevice = Build.VERSION.SDK_INT // user device build version
//        val ANDROID_Q = Build.VERSION_CODES.Q // android Q  =  Api 29
//        APIVERSION = TargetDevice // access target device build version
//        if (TargetDevice == ANDROID_Q) {
//            /*
//             * Android 29 全面禁止使用要求存取手機權限(刪除後可將資料留在裝置上面)
//             * 故因此採用shareperference(刪除後資料將被刪除)
//             * 一旦使用者刪除APP，資料將不見，以此判斷是否唯一值
//             * */
//            // Do something for lollipop and above versions
//            VERSION29(NavigationTAG)
//            Log.wtf(NavigationTAG, "@param TargetDevice = $ANDROID_Q")
//        } // 29
//        else {
//            /*使用要求存取手機權限(刪除後可將資料留在裝置上面)
//             * */
//            // do something for phones running an SDK before Android Q
//            Log.wtf(NavigationTAG, "@param TargetDevice = $TargetDevice")
//            else29(NavigationTAG,REQUEST_PERMISSION_PHONE_STATE )
//        } //else29
//    }
//
//    /**
//     * 29
//     * @param navigationTAG
//     * 1.according uuid.randomUUID to make an uniqueID that would be passed to writable() to write
//     * 2.according readable() to read uniqueID
//     */
//    private fun VERSION29(navigationTAG: String) {
//        //            SDK MODEL MANUFACTURER COUNTRY
//        NavigationTAG = "$navigationTAG->VERSION29()"
//        val path = context.getExternalFilesDir(null)
//        Log.wtf(NavigationTAG, "uniqueID path = $path")
//        val uniqueID = UUID.randomUUID().toString()
//        Log.wtf(NavigationTAG, "make uniqueID = $uniqueID")
//        writeable(context, uniqueID)
//        readable(context)
//    }
//
//    private fun writeable(context: Context, uuid: String) {
//        val path = context.getExternalFilesDir(null)
//        Log.wtf("writeable", " path -> $path")
//        val setfile = File(path, "jacky1.txt")
//        if (setfile.exists()) {
//            Log.wtf("writeable", "file exised")
//        } else {
//            try {
//                val fos = FileOutputStream(setfile)
//                fos.write(uuid.toByteArray())
//                fos.close()
//                Log.wtf("writeable", "writeable successful")
//            } catch (e: FileNotFoundException) {
//                e.printStackTrace()
//            } catch (e: IOException) {
//                e.printStackTrace()
//            }
//        }
//    }
//
//    private fun readable(context: Context) {
//        var readIMEI = "readable initial"
//        val path = context.getExternalFilesDir(null)
//        Log.wtf("readable", "path = $path")
//        val getfile = File(path, "jacky1.txt")
//        if (getfile.exists()) {
//            Log.wtf("readable", "file exist  = $getfile is not null!")
//            try {
//                val fis = FileInputStream(getfile)
//                val isr = InputStreamReader(fis)
//                val buff = BufferedReader(isr)
//                readIMEI = buff.readLine()
//                Log.wtf("readable", "readable successful")
//                imei = readIMEI
//            } catch (e: FileNotFoundException) {
//                e.printStackTrace()
//            } catch (e: IOException) {
//                e.printStackTrace()
//            }
//        } else {
//            Log.wtf("readable", "file is not exist")
//            readIMEI = "null"
//            println("$getfile is null!")
//        }
//        Log.wtf("readable", "readIMEI = $readIMEI")
//    }
//
//    /** else29 showPhoneStatePermission
//     * display phonestatepermission window
//     * click yes ->next step
//     * click no -> window loop
//     */
//    fun else29(NavigationTAG: String, REQUEST_PERMISSION_PHONE_STATE: Int) {
//        var NavigationTAG = NavigationTAG
//        NavigationTAG = "$NavigationTAG->else29()"
//        val permissionCheck = ContextCompat.checkSelfPermission(
//                context, Manifest.permission.READ_PHONE_STATE)
//        Log.wtf(NavigationTAG, "" + permissionCheck)
//        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
//            requestPermission(Manifest.permission.READ_PHONE_STATE, REQUEST_PERMISSION_PHONE_STATE)
//        } else {
//            setIMEI()
//        }
//    }
//
//    // requestPermission
//    private fun requestPermission(permissionName: String, permissionRequestCode: Int) {
//        ActivityCompat.requestPermissions(context, arrayOf(permissionName), permissionRequestCode)
//    }
//
//    /**
//     * get IMEI and pass to global variables
//     */
//    private fun setIMEI() {
//        imei = IMEIUtil.getDeviceId(context)
//        Log.wtf("LoginActivity->PermissionCheck->DEVICE_BuildVersion()->showPhoneStatePermission()", "@param imei = $imei")
//    }
//
//    /** DEVICEINFO START
//     *
//     * @param navigationTAG
//     */
//    //DEVICEINFO--1
//    fun DEVICEINFO(navigationTAG: String) {
//        NavigationTAG = "$navigationTAG->getDeviceInfo(NavigationTAG)"
//        val mCountry = this.tm.networkCountryIso
//        val mOperatorName = this.tm.networkOperatorName
//        DEVICEINFO = arrayOfNulls(5)
//        Log.wtf(NavigationTAG, "Target device SDK = " + Build.VERSION.SDK)
//        Log.wtf(NavigationTAG, "Target device Country = $mCountry")
//        Log.wtf(NavigationTAG, "Target device MODEL = " + Build.MODEL)
//        Log.wtf(NavigationTAG, "Target device MANUFACTURER = " + Build.MANUFACTURER)
//        Log.wtf(NavigationTAG, "Target device OperatorName = $mOperatorName")
//        DEVICEINFO!![0] = Build.VERSION.SDK
//        DEVICEINFO!![1] = mCountry
//        DEVICEINFO!![2] = Build.MODEL
//        DEVICEINFO!![3] = Build.MANUFACTURER
//        DEVICEINFO!![4] = mOperatorName
//        Log.wtf(NavigationTAG, "Target device final = $DEVICEINFO")
//    }
//
//        companion object {
//            private const val TAG = "PermissionCheck"
//        }
//
//    //Start
//    init {
//        NavigationTAG = tag + "->" + TAG // set NavigationTAG for tracing record
//        // set context for permission record
//        Log.wtf(NavigationTAG, "Constructor")
//        DEVICEIMEI()
//        DEVICEINFO(NavigationTAG) //DEVICEINFO--1
//    }
    override val titleResId: Int
        get() = R.string.projects_maxe
    override val layoutResId: Int
        get() = R.layout.activity_login
}