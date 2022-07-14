package com.jekma.maxe.login

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jekma.baselibrary.BaseBindingFragment
import com.jekma.maxe.R
import com.jekma.maxe.databinding.MaxeFragmentLoginBinding
//import com.jekma.maxe.databinding.MaxeFragmentLoginBinding
import com.jekma.maxe.model.room_database.User

/**
 * 
 */
@RequiresApi(Build.VERSION_CODES.Q)
class MaxeFragmentLogin : BaseBindingFragment<MaxeFragmentLoginBinding, MaxeLoginViewModel>(){

    override var permissionOnViewListener: PermissionOnView? = null

//    var myAdapter: MyAdapter? = null
    var nowSelectedData: User? = null

    override val isShowMainBar: Boolean get() = true
    override val titleResId: Int get() = R.string.maxe_projects_maxe
    override val layoutResId: Int get() = R.layout.maxe_fragment_login

    var mActionListener = object : MaxeLoginViewModel.OnActionListener{
        /**
         * 按下登入
         */
        override fun onClickLogin() {
            gotoNextNavPage(R.id.action_loginActivity_to_nav_home)
        }

        /**
         * 按下忘記帳號密碼
         */
        override fun onClickForgot() {
            gotoNextNavPage(R.id.action_loginActivity_to_registerActivity2)
        }

        /**
         * 當使用者按下 記住我的信箱時
         * 1.將 Email輸入框先清空
         * 2.當試用者成功登入後，會記住登入成功後的信箱
         */
        override fun onClickRememberEmail() {
//            RememberEmail(binding.root)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        test(mViewBinding.root)
        mViewModel.setActionLisrenr(mActionListener)
        mViewModel.create()
        mViewBinding.vm = mViewModel

        // Recyclerview
        val adapter = ListAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // UserViewModel
        mViewModel.readAllData.observe(viewLifecycleOwner) { user ->
            adapter.setData(user)
        }


    }


    private fun test(view: View) {
        mViewBinding.addBtn.setOnClickListener {
            val user = User(0, "firstName", "lastName", 30)
            mViewModel.addUser(user)
        }

        mViewBinding.deleteBtn.setOnClickListener {

            mViewModel.deleteUser(id=mViewModel.readAllData.value!!.size)
        }




//        val btCreate = view.findViewById<Button>(R.id.button_Create)
//        val btModify = view.findViewById<Button>(R.id.button_Modify)
//        val btClear = view.findViewById<Button>(R.id.button_Clear)
//        val edName = view.findViewById<EditText>(R.id.editText_Name)
//        val edPhone = view.findViewById<EditText>(R.id.editText_Phone)
//        val edHobby = view.findViewById<EditText>(R.id.editText_Hobby)
//        val edElseInfo = view.findViewById<EditText>(R.id.editText_else)
//        val edAge = view.findViewById<EditText>(R.id.editText_age)
//        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)) //設置分隔線
////        setRecyclerFunction(recyclerView) //設置RecyclerView左滑刪除
//        /**======================================================================================= */
//        /**設置修改資料的事件 */
//        btModify.setOnClickListener { v: View? ->
////            Thread(Runnable {
////                if (nowSelectedData == null) {
////                }else{
////                    val name = edName.text.toString()
////                    val phone = edPhone.text.toString()
////                    val hobby = edHobby.text.toString()
////                    val elseInfo = edElseInfo.text.toString()
////                    val age = edAge.text.toString().toInt() /*遷移後新增*/
////
////                    val data = User(nowSelectedData!!.getId(), name, phone, hobby, elseInfo, age) /*遷移後新增*/
////                    UserDataBase.getInstance(requireContext())?.dataUao?.updateData(data)
////                    requireActivity().runOnUiThread {
////                        edName.setText("")
////                        edPhone.setText("")
////                        edHobby.setText("")
////                        edElseInfo.setText("")
////                        edAge.setText("") /*遷移後新增*/
////                        nowSelectedData = null
////                        myAdapter!!.refreshView()
////                        Toast.makeText(requireContext(), "已更新資訊！", Toast.LENGTH_LONG).show()
////                    }
////                }
////            }).start()
//        }
//        /**======================================================================================= */
//        /**清空資料 */
//        btClear.setOnClickListener { v: View? ->
//            edName.setText("")
//            edPhone.setText("")
//            edHobby.setText("")
//            edElseInfo.setText("")
//            edAge.setText("") /*遷移後新增*/
//            nowSelectedData = null
//        }
//        /**======================================================================================= */
//        /**新增資料 */
//        btCreate.setOnClickListener { v: View? ->
//            mViewModel.addUser(User(0,"firstName","LastName",30))
////            Thread(Runnable {
////                val name = edName.text.toString()
////                val phone = edPhone.text.toString()
////                val hobby = edHobby.text.toString()
////                val elseInfo = edElseInfo.text.toString()
////                val age = edAge.text.toString().toInt() /*遷移後新增*/
////                if (name.length == 0) {
////
////                }else{
////                    //如果名字欄沒填入任何東西，則不執行下面的程序
////                    val data = User(name, phone, hobby, elseInfo, age /*遷移後新增*/)
////                    UserDataBase.getInstance(requireContext())?.dataUao?.insertData(data)
////                    requireActivity().runOnUiThread {
////                        myAdapter!!.refreshView()
////                        edName.setText("")
////                        edPhone.setText("")
////                        edHobby.setText("")
////                        edElseInfo.setText("")
////                        edAge.setText("") /*遷移後新增*/
////                    }
////                }
////
////            }).start()
//        }
//        /**======================================================================================= */
//        /**初始化RecyclerView */
////        Thread {
////            val data: List<User> = UserDataBase.getInstance(requireContext())?.dataUao?.displayAll() as List<User>
////            myAdapter = MyAdapter(requireActivity(), data)
////            requireActivity().runOnUiThread {
////                recyclerView.adapter = myAdapter
////                /**=============================================================================== */
////                /**=============================================================================== */
////                myAdapter!!.setOnItemClickListener(object : MyAdapter.OnItemClickListener {
////                    //原本的樣貌
////                    override fun onItemClick(myData: User?) {
////                        nowSelectedData = myData
////                        edName.setText(myData?.getName())
////                        edPhone.setText(myData?.getPhone())
////                        edHobby.setText(myData?.getHobby())
////                        edElseInfo.setText(myData?.getElseInfo())
////                        edAge.setText(myData?.getAge().toString()) /*遷移後新增*/
////                    }
////                })
////                /**=============================================================================== */
////                /**取得被選中的資料，並顯示於畫面 */
////                /**=============================================================================== */
////                /**取得被選中的資料，並顯示於畫面 */
//////                myAdapter!!.setOnItemClickListener(MyAdapter.OnItemClickListener { myData: MyData ->  //匿名函式(原貌在上方)
//////
//////                })
////            }
////        }.start()
//        /**======================================================================================= */
    }

//    class MyAdapter(private val activity: Activity, private var myData: List<User>) :
//        RecyclerView.Adapter<MyAdapter.ViewHolder>() {
//        private var onItemClickListener: OnItemClickListener? = null
//
//        /**建立對外接口 */
//        fun setOnItemClickListener(onItemClickListener: OnItemClickListener?) {
//            this.onItemClickListener = onItemClickListener
//        }
//
//        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//            var tvTitle: TextView
//            var view: View
//
//            init {
//                tvTitle = itemView.findViewById(android.R.id.text1)
//                view = itemView
//            }
//        }
//
//        /**更新資料 */
//        fun refreshView() {
//            Thread {
//                val data: List<User> = UserDataBase.getInstance(activity)?.dataUao?.displayAll() as List<User>
//                myData = data
//                activity.runOnUiThread { notifyDataSetChanged() }
//            }.start()
//        }
//
//        /**刪除資料 */
//        fun deleteData(position: Int) {
//            Thread {
//                UserDataBase.getInstance(activity)?.dataUao?.deleteData(myData[position].getId())
//                activity.runOnUiThread {
//                    notifyItemRemoved(position)
//                    refreshView()
//                }
//            }.start()
//        }
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//            val view = LayoutInflater.from(parent.context)
//                .inflate(android.R.layout.simple_list_item_1, null)
//            return ViewHolder(view)
//        }
//
//        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//            holder.tvTitle.text = myData[position].getName()
//            holder.view.setOnClickListener { v: View? -> onItemClickListener!!.onItemClick(myData[position]) }
//        }
//
//        override fun getItemCount(): Int {
//            return myData.size
//        }
//
//        /**建立對外接口 */
//        interface OnItemClickListener {
//            fun onItemClick(myData: User?)
//        }
//    }

    /**設置RecyclerView的左滑刪除行為 */
//    private fun setRecyclerFunction(recyclerView: RecyclerView) {
//        val helper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
//            //設置RecyclerView手勢功能
//            override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
//                return makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
//            }
//
//            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
//                return false
//            }
//
//            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                val position = viewHolder.adapterPosition
//                when (direction) {
//                    ItemTouchHelper.LEFT, ItemTouchHelper.RIGHT -> myAdapter!!.deleteData(position)
//                }
//            }
//        })
//        helper.attachToRecyclerView(recyclerView)
//    }



    /**
     * 初始化元件，設定事件，設定UI
     */
    private fun init() {

//        /**
//         * 當使用者輸入帳號密碼後按下虛擬鍵盤的確認，自訂連線到API
//         */
//        binding.LoginPassword.setOnEditorActionListener { v, actionId, event ->
//            when (actionId) {
//                EditorInfo.IME_ACTION_SEND -> RxVolleyConnext(IMeI, VolleyBridge().Login_Url())
//            }
//            false
//        }

    }
//
    /**
     * 當適用者按下忘記密碼，會出現Dialog視窗並要求使用者輸入，姓名，信箱
     *
     */
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
//                LAVM.CallForgotInfo(for_name,for_email,"Opened",VolleyBridge().forgot()).observe(requireContext(), androidx.lifecycle.Observer {
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

//    fun Login(view: View?){
////        dialog!!.show()
////        RxVolleyConnext(IMeI,VolleyBridge().Login_Url())
//    }

    private fun RxVolleyConnext(iMeI: String, loginUrl: String) {

//        LAVM.callInfo(
//                binding.LoginEmail.text.toString(),
//                binding.LoginPassword.text.toString(),
//                iMeI,
//                loginUrl).observe(this, androidx.lifecycle.Observer {
//            Log.i(TAG,"The response is  ${it} at observe mode in Class:Errorcode_home")
//            Parsing(it)
//
//        })
    }
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
//                val abs = FirstTimes(e_name, e_pwd, this , IMeI)
//            } else {
//                dialog!!.hide()
//                Toast.makeText(requireContext(), Login_result, Toast.LENGTH_SHORT).show()
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
//        Toast.makeText(requireContext(), "登入成功", Toast.LENGTH_SHORT).show()
//        val thispage = Intent(this, MainActivity::class.java)
//        val bundle = Bundle()
//        bundle.putInt("ArrayCount", arrayCount)
//        bundle.putString("LoginData", s)
//        thispage.putExtras(bundle) // 記得put進去，不然資料不max會帶過去哦
//        startActivityForResult(thispage, session)
//        finish()
//    }
    /**
     * 記住信箱
     */
//    private fun RememberEmail(root: View) {
//        val userid = "fakeUserId"
//        val RememberStatusString = "fakeRememberStatusString"
//        val RememberStatus = java.lang.Boolean.parseBoolean(RememberStatusString)
//        val Reme = root.findViewById<CheckBox>(R.id.Remember)
//        if (RememberStatus) {
//            val default_email = root.findViewById<TextInputEditText>(R.id.Login_Email)
//            default_email.setText(userid)
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
//            val homeIntent = Intent(requireContext(), Welcome::class.java)
//            startActivity(homeIntent)
//            finish()
//        }
//        return super.onKeyDown(keyCode, event)
//    }
//}
//
//internal class FirstTimes(e_name: String, e_pwd: String, loginActivity: LoginActivity, IMeI: String) {
//    //    private final LoginActivity loginActivity1;
//    private val activity: LoginActivity
//    private val currentNAME: String
//    var currentPWD: String
//    private var IMei = ""
//    private fun FirstLoginChangePassword(test: String) {
//        volleyPost(test)
//    }
//
//    /**
//     * API連線 - no need
//     */
//    private fun volleyPost(currentPWD: String) {
////        val changePWD = VolleyBridge()
////        val mQueue = Volley.newRequestQueue(activity)
////        // 記得put進去，不然資料不max會帶過去哦
////        val getRequest: StringRequest = object : StringRequest(Method.POST, changePWD.changePWD(),
////                Response.Listener { s ->
////                    Log.wtf("LoginActivity", s)
////                    try {
////                        val array = JSONArray(s)
////                        val result = array.getString(0)
////                        if (result == "NeedChange") {
////                            val intent = Intent(activity, RegisterActivity::class.java)
////                            val bundle = Bundle()
////                            bundle.putString("username", currentNAME)
////                            bundle.putString("IMEI", IMei)
////                            intent.putExtras(bundle) // 記得put進去，不然資料不max會帶過去哦
////                            activity.startActivity(intent)
////                            activity.finish()
////                        } else if (result == "DontNeedChange") {
////                        }
////                    } catch (e: JSONException) {
////                        e.printStackTrace()
////                    }
////                },
////                Response.ErrorListener { }) {
////            @Throws(AuthFailureError::class)
////            override fun getParams(): Map<String, String> {
////                val hashMap = HashMap<String, String>()
////                hashMap["currentPWD"] = currentPWD
////                return hashMap
////            }
////        }
////        mQueue.add(getRequest)
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
}

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.findViewById<TextView>(R.id.id_txt).text = currentItem.id.toString()
        holder.itemView.findViewById<TextView>(R.id.firstName_txt).text = currentItem.firstName
        holder.itemView.findViewById<TextView>(R.id.lastName_txt).text = currentItem.lastName
        holder.itemView.findViewById<TextView>(R.id.age_txt).text = currentItem.age.toString()
    }

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}