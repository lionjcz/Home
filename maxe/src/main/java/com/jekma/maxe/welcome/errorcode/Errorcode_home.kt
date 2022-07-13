package com.jekma.maxe.welcome.errorcode


import com.jekma.baselibrary.BaseFragment
import com.jekma.maxe.R


class Errorcode_home : BaseFragment() {

    override val titleResId: Int
        get() = R.string.maxe_title_errorcode
    override val layoutResId: Int
        get() = R.layout.maxe_fragment_errorcode_home
//
//
//    private var TAG:String = "ErrorCode_Home"
//    /*
//    * Databinding
//    * */
//    var editview: EditText? = null
//    private lateinit var binding: ActivityErrorcodeHomeBinding
//
//    /**
//     * 建立viewModel的變數
//     */
//    private lateinit var viewModel3: ViewModel3
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        DataBinding()
//    }
//
//
//    /**
//     * 使用DataBinding 綁定 Class:Data的資料
//     */
//    private fun DataBinding() {
//        binding = DataBindingUtil.setContentView(this,R.layout.activity_errorcode_home)
//        binding.errorUI = Data("請在此輸入代碼 例:Ex1","查詢錯誤代碼","清空")
//        viewModel3 = ViewModelProvider(this).get(ViewModel3::class.java)
//        /**
//         * 按下確認按鈕後執行
//         */
//        binding.submit.setOnClickListener {
//            CallObserve()
//            CloseKeyBoard()
//        }
//
//        /**
//         * 輸入完畢後，按下鍵盤中的確認
//         */
//        binding.editInput.setOnEditorActionListener { _, actionId, _ ->
//                when (actionId) {
//                    EditorInfo.IME_ACTION_SEND -> {
//                        CallObserve()
//                    }
//                }
//                System.out.println("True...")
//                false
//        }
//    }
//
//    /**
//     * 觀察 viewModel裡面的資料，並將回傳的資料傳到 解析函式裡面
//     */
//    private fun CallObserve(){
//        binding.ServicesErrorResultHome.removeAllViewsInLayout()
//        viewModel3.callInfo(binding.editInput.text.toString()).observe(this, Observer {
//            Log.i(TAG,"The response is  ${it} at observe mode in Class:Errorcode_home")
//            ParsingData(it)
//        })
//    }
//
//    /**
//     * 關閉虛擬鍵盤
//     */
//    private fun CloseKeyBoard(){
//        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.hideSoftInputFromWindow(this@Errorcode_home.currentFocus!!.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
//    }
//
//    /**
//     * 按下實體返回鍵，回到App首頁
//     */
//    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            val repair = Intent(this@Errorcode_home, Welcome::class.java)
//            startActivity(repair)
//            finish()
//        }
//        return super.onKeyDown(keyCode, event)
//    }
//
//    /**
//     * 解析傳進來的資料，並動態新增結果
//     */
//    fun ParsingData(editxt: String) {
//        try {
//            val arry1 = JSONArray(editxt)
//            if (arry1 == null) {
//                Toast.makeText(applicationContext, "arry1 為空", Toast.LENGTH_LONG).show()
//            }
//            else {
//                val emptyNot = arry1.getJSONObject(0).getString("結果")
//                if (emptyNot == "有") {
//                    val testarray = arrayOfNulls<String>(arry1.length())
//                    val testarray1 = arrayOfNulls<String>(arry1.length())
//                    val testarray2 = arrayOfNulls<String>(arry1.length())
//                    val testarray3 = arrayOfNulls<String>(arry1.length())
//                    val testarray4 = arrayOfNulls<String>(arry1.length())
//                    val testarray5 = arrayOfNulls<String>(arry1.length())
//                    val testarray6 = arrayOfNulls<String>(arry1.length())
//                    for (i in 0 until arry1.length()) {
//                        DynamicallyAppendTextView(i)
//                    }
//
//                    //撈資料並存到陣列
//                    for (i in 0 until arry1.length()) {
//                        testarray[i] = arry1.getJSONObject(i).getString("定變頻")
//                    }
//                    for (i in 0 until arry1.length()) {
//                        testarray1[i] = arry1.getJSONObject(i).getString("室內外機")
//                    }
//                    for (i in 0 until arry1.length()) {
//                        testarray2[i] = arry1.getJSONObject(i).getString("內容")
//                    }
//                    for (i in 0 until arry1.length()) {
//                        testarray3[i] = arry1.getJSONObject(i).getString("系列")
//                    }
//                    for (i in 0 until arry1.length()) {
//                        testarray4[i] = arry1.getJSONObject(i).getString("顯示")
//                    }
//                    for (i in 0 until arry1.length()) {
//                        testarray5[i] = arry1.getJSONObject(i).getString("故障名稱")
//                    }
//                    for (i in 0 until arry1.length()) {
//                        testarray6[i] = arry1.getJSONObject(i).getString("備註")
//                    }
//                    val textViews = arrayOfNulls<TextView>(arry1.length())
//                    for (i in 0 until arry1.length()) {
//                        textViews[i] = findViewById(0 + i)
//                        textViews[i]?.setTextSize(20f)
//                        textViews[i]?.setText("0$i")
//                        textViews[i]?.setText(
//                                """
//                                                    系列　：${testarray3[i]}
//                                                    顯示　：${testarray4[i]}
//                                                    故障名稱　：${testarray5[i]}
//                                                    備註　：${testarray6[i]}
//
//                                                    """.trimIndent()
//                        )
//                        textViews[i]?.let { TextViewCompat.setAutoSizeTextTypeWithDefaults(it, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM) }
//                        textViews[i]?.setTextColor(-0x1000000)
//                    }
//                } else if (emptyNot == "資料庫沒結果") {
//                    editview!!.setText("")
//                    val linearLayout2 = findViewById<View>(R.id.Services_Error_Result) as LinearLayout
//                    linearLayout2.removeAllViewsInLayout()
//                    Toast.makeText(applicationContext, "資料庫查無資料", Toast.LENGTH_LONG).show()
//                } else {
//                    editview!!.setText("")
//                    val linearLayout2 = findViewById<View>(R.id.Services_Error_Result) as LinearLayout
//                    linearLayout2.removeAllViewsInLayout()
//                    Toast.makeText(applicationContext, "請輸入資料", Toast.LENGTH_LONG).show()
//                }
//            }
//        } catch (e: JSONException) {
//            Toast.makeText(applicationContext, "連線錯誤", Toast.LENGTH_LONG).show()
//        }
//
//    }
//
//    /**
//     * 依照解析的結果，動態新增相對應的元件
//     */
//    private fun DynamicallyAppendTextView(i: Int) {
//        val linearLayout = findViewById<View>(R.id.Services_Error_Result_home) as LinearLayout
//        val textview = TextView(applicationContext)
//        textview.id = 0 + i
//        linearLayout.addView(textview)
}


