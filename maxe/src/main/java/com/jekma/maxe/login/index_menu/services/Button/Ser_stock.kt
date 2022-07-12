package com.company.maxe.Login.index_menu.services.Button

import android.content.Context
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.CheckBox
import androidx.fragment.app.Fragment
//import com.android.volley.AuthFailureError
import com.company.maxe.Login.MainActivity
import java.util.HashMap

class Ser_stock : Fragment()
//    , OnEditorActionListener, View.OnClickListener
{
//
//    private var mQueue: RequestQueue? = null
//    private val data1: Array<String>
//    private val data2: Array<String>
//    private val data3: Array<String>
//    private val data4: Array<String>
//    private val data5: Array<String>
//    var btn: Button? = null
//    var btn1: Button? = null
//    var btn2: Button? = null
//    var btn3: Button? = null
//    var ok: Button? = null
//    var editview: EditText? = null
//    private val count = 0
//    private var root: View? = null
//    private var item_number = false
//    private var description = false
//    private var specification = false
//    private var onlysearch_itemnumber_first_4_digits = false
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        val imm = activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.hideSoftInputFromWindow(view!!.windowToken, 0)
//    }
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val root: View = inflater.inflate(R.layout.fragment_ser_stock, container, false)
//        editview = root.findViewById<EditText>(R.id.EditTextview)
//        editview.setOnEditorActionListener(this)
//        ok = root.findViewById(R.id.tata_Ok)
//        ok.setOnClickListener(this)
//        val Item_Number = root.findViewById<CheckBox>(R.id.Item_number)
//        val Description = root.findViewById<CheckBox>(R.id.Decription)
//        val Specification = root.findViewById<CheckBox>(R.id.Specification)
//        val OnlySearch_ItemNumber_First_4_digits =
//            root.findViewById<CheckBox>(R.id.onlysearch_itemnumber_first_4_digits)
//        Item_Number.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
//            override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
//                if (isChecked) {
//                    item_number = true
//                    Description.isChecked = false
//                    Specification.isChecked = false
//                    OnlySearch_ItemNumber_First_4_digits.isChecked = false
//                }
//                else {
//                    item_number = false
//                }
//            }
//        })
//        Description.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
//            override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
//                if (isChecked) {
//                    description = true
//                    Item_Number.isChecked = false
//                    Specification.isChecked = false
//                    OnlySearch_ItemNumber_First_4_digits.isChecked = false
//                }
//                else {
//                    description = false
//                }
//            }
//        })
//        Specification.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
//            override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
//                if (isChecked) {
//                    specification = true
//                    Item_Number.isChecked = false
//                    Description.isChecked = false
//                    OnlySearch_ItemNumber_First_4_digits.isChecked = false
//                }
//                else {
//                    specification = false
//                }
//            }
//        })
//        OnlySearch_ItemNumber_First_4_digits.setOnCheckedChangeListener(object :
//            CompoundButton.OnCheckedChangeListener {
//            override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
//                if (isChecked) {
//                    onlysearch_itemnumber_first_4_digits = true
//                    Item_Number.isChecked = false
//                    Description.isChecked = false
//                    Specification.isChecked = false
//                }
//                else {
//                    onlysearch_itemnumber_first_4_digits = false
//                }
//            }
//        })
//
//
////        CheckBox(root , Item_Number);
//        this.root = root
//        return root
//    }
//
//    //移除所有結果
//    private fun removeAllTextView() {
//        val linearLayout2: LinearLayout =
//            view!!.findViewById<View>(R.id.Services_Error_Result) as LinearLayout
//        linearLayout2.removeAllViewsInLayout()
//    }
//
//    //連線並抓取資料
//    fun getData(editxt: String, root: View?) {
//        mQueue = Volley.newRequestQueue(activity!!.applicationContext)
//        val Services_stock = VolleyBridge()
//        val getRequest: StringRequest = object :
//            StringRequest(Request.Method.POST, Services_stock.Services_stock(), object :
//                Listener<String?>() {
//                fun onResponse(s: String?) {
////                        System.out.println(s);
////                        Toast.makeText(getActivity().getApplicationContext(),s,Toast.LENGTH_LONG).show();
//                    try {
//                        val arry1 = JSONArray(s)
//                        if (arry1 == null) {
//                            Toast.makeText(activity!!.applicationContext, "arry1 為空", Toast.LENGTH_LONG)
//                                .show()
//                        }
//                        else {
//                            val emptyNot: String = arry1.getJSONObject(0).getString("結果")
//                            if (emptyNot == "有") {
//                                val testarray = arrayOfNulls<String>(arry1.length())
//                                val testarray1 = arrayOfNulls<String>(arry1.length())
//                                val testarray2 = arrayOfNulls<String>(arry1.length())
//                                val testarray3 = arrayOfNulls<String>(arry1.length())
//                                val testarray4 = arrayOfNulls<String>(arry1.length())
//                                for (i in 0 until arry1.length()) {
//                                    addTextView(i)
//                                }
//
//                                //撈資料並存到陣列
//                                for (i in 0 until arry1.length()) {
//                                    testarray[i] = arry1.getJSONObject(i).getString("庫別名稱")
//                                    testarray1[i] = arry1.getJSONObject(i).getString("品號")
//                                    testarray2[i] = arry1.getJSONObject(i).getString("品名")
//                                    testarray3[i] = arry1.getJSONObject(i).getString("規格")
//                                    testarray4[i] = arry1.getJSONObject(i).getString("數量")
//                                }
//                                val textViews: Array<TextView?> =
//                                    arrayOfNulls<TextView>(arry1.length())
//                                for (i in 0 until arry1.length()) {
//                                    textViews[i] = view.findViewById<TextView>(0 + i)
//                                    //                                        textViews[i].setTextSize(17);
//                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                                        textViews[i].setAutoSizeTextTypeUniformWithConfiguration(8, 17, 3, 3)
//                                    }
//                                    textViews[i].setText("0$i")
//                                    textViews[i].setText("""
//    庫別名稱　：${testarray[i]}
//    品號　：${testarray1[i]}
//    品名　：${testarray2[i]}
//    規格　：${testarray3[i]}
//    庫存數量　：${testarray4[i]}
//
//    """.trimIndent())
//                                    textViews[i].setTextColor(-0x1000000)
//                                }
//                            }
//                            else if (emptyNot == "資料庫沒結果") {
//                                editview.setText("")
//                                val linearLayout2: LinearLayout =
//                                    view!!.findViewById<View>(R.id.Services_Error_Result) as LinearLayout
//                                linearLayout2.removeAllViewsInLayout()
//                                Toast.makeText(activity!!.applicationContext, "資料庫查無資料", Toast.LENGTH_LONG)
//                                    .show()
//                            }
//                            else {
//                                editview.setText("")
//                                val linearLayout2: LinearLayout =
//                                    view!!.findViewById<View>(R.id.Services_Error_Result) as LinearLayout
//                                linearLayout2.removeAllViewsInLayout()
//                                Toast.makeText(activity!!.applicationContext, "請輸入資料", Toast.LENGTH_LONG)
//                                    .show()
//                            }
//                        }
//                    } catch (e: JSONException) {
//                        Toast.makeText(activity!!.applicationContext, "連線錯誤", Toast.LENGTH_LONG)
//                            .show()
//                    }
//                }
//
//                private fun addTextView(i: Int) {
//                    val linearLayout: LinearLayout =
//                        view!!.findViewById<View>(R.id.Services_Error_Result) as LinearLayout
//                    val textview = TextView(activity!!.applicationContext)
//                    textview.setId(0 + i)
//                    linearLayout.addView(textview)
//                }
//            }, null) {
//            //品號前四碼//規格//品名//品號
//            //部_分公司
//            //使用者輸入
//            //部_分公司
//            @get:Throws(AuthFailureError::class)
//            protected val params: Map<String, String>
//                protected get() {
//                    val hashMap = HashMap<String, String>()
//                    val Personal = activity as MainActivity?
//                    val Department: String = Personal.PERSONAL().get(13) //部_分公司
//                    hashMap["search"] = editxt //使用者輸入
//                    hashMap["Department"] = Department //部_分公司
//                    Log.wtf("Ser_stock", "passing to api : search = $editxt")
//                    Log.wtf("Ser_stock", "passing to api : Department = $Department")
//                    if (item_number && !description && !specification && !onlysearch_itemnumber_first_4_digits) {
//                        hashMap["Item_Number"] = item_number.toString() //品號
//                        Log.wtf("Ser_stock", "passing to api : Item_Number = $item_number")
//                    }
//                    else if (!item_number && description && !specification && !onlysearch_itemnumber_first_4_digits) {
//                        hashMap["Description"] = description.toString() //品名
//                        Log.wtf("Ser_stock", "passing to api : Description = $description")
//                    }
//                    else if (!item_number && !description && specification && !onlysearch_itemnumber_first_4_digits) {
//                        hashMap["Specification"] = specification.toString() //規格
//                        Log.wtf("Ser_stock", "passing to api : Specification = $specification")
//                    }
//                    else if (!item_number && !description && !specification && onlysearch_itemnumber_first_4_digits) {
//                        hashMap["OnlySearch_ItemNumber_First_4_Digits"] =
//                            onlysearch_itemnumber_first_4_digits.toString() //品號前四碼
//                        Log.wtf("Ser_stock", "passing to api : OnlySearch_ItemNumber_First_4_Digits = $onlysearch_itemnumber_first_4_digits")
//                    }
//                    else {
//                    }
//                    return hashMap
//                }
//        }
//        mQueue.add(getRequest)
//    }
//
//    //    按下按鈕
//    override fun onClick(v: View) {
//        removeAllTextView()
//        getData(editview.getText().toString(), root) //get data of user input
//        hideKeyboard()
//    }
//
//    //    按下鍵盤的確認鍵即可動作
//    override fun onEditorAction(v: TextView, actionId: Int, event: KeyEvent): Boolean {
//        when (actionId) {
//            EditorInfo.IME_ACTION_SEND -> {
//                removeAllTextView()
//                getData(editview.getText().toString(), root) //get data of user input
//                hideKeyboard()
//            }
//        }
//        return false
//    }
//
//    //隱藏鍵盤
//    override fun onDetach() {
//        super.onDetach()
//        hideKeyboard()
//    }
//
//    fun hideKeyboard() {
//        val inputManager =
//            activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        val focusedView = activity!!.currentFocus
//        /*
//         * If no view is focused, an NPE will be thrown
//         *
//         * Maxim Dmitriev
//         */if (focusedView != null) {
//            inputManager.hideSoftInputFromWindow(focusedView.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
//        }
//    }
}