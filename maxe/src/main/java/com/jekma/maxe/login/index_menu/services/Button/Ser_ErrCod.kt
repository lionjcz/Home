package com.company.maxe.Login.index_menu.services.Button

import android.os.Bundle
import androidx.fragment.app.Fragment
//import com.android.volley.AuthFailureError

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jekma.maxe.R

class Ser_ErrCod : Fragment()
//    , OnEditorActionListener, View.OnClickListener
{
//
//    private var mQueue: Requ
//    estQueue? = null
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
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        val imm = activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.hideSoftInputFromWindow(view!!.windowToken, 0)
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root: View = inflater.inflate(R.layout.maxe_fragment_ser_errcod, container, false)
//        editview = root.findViewById<EditText>(R.id.EditTextview)
//        ok = root.findViewById(R.id.tata1_Ok)
//        ok.setOnClickListener(this)
//        editview.setOnEditorActionListener(this)
//
//
////        ok.setOnFocusChangeListener(new View.OnFocusChangeListener(){
////
////            @Override
////            public void onFocusChange(View v, boolean hasFocus) {
////                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
////                imm.hideSoftInputFromWindow(editview.getWindowToken(), 0);
////            }
////        });
        return root
    }
//
//    fun getData(editxt: String) {
//        mQueue = Volley.newRequestQueue(activity!!.applicationContext)
//        val Services_stock = VolleyBridge()
//        val getRequest: StringRequest = object :
//            StringRequest(Request.Method.POST, Services_stock.Services_errorcode(), object :
//                Listener<String?>() {
//                fun onResponse(s: String) {
//                    println("Message_log_Services_errorcode = $s")
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
//                                val testarray5 = arrayOfNulls<String>(arry1.length())
//                                val testarray6 = arrayOfNulls<String>(arry1.length())
//                                for (i in 0 until arry1.length()) {
//                                    addTextView(i)
//                                }
//
//                                //撈資料並存到陣列
//                                for (i in 0 until arry1.length()) {
//                                    testarray[i] = arry1.getJSONObject(i).getString("定變頻")
//                                }
//                                for (i in 0 until arry1.length()) {
//                                    testarray1[i] = arry1.getJSONObject(i).getString("室內外機")
//                                }
//                                for (i in 0 until arry1.length()) {
//                                    testarray2[i] = arry1.getJSONObject(i).getString("內容")
//                                }
//                                for (i in 0 until arry1.length()) {
//                                    testarray3[i] = arry1.getJSONObject(i).getString("系列")
//                                }
//                                for (i in 0 until arry1.length()) {
//                                    testarray4[i] = arry1.getJSONObject(i).getString("顯示")
//                                }
//                                for (i in 0 until arry1.length()) {
//                                    testarray5[i] = arry1.getJSONObject(i).getString("故障名稱")
//                                }
//                                for (i in 0 until arry1.length()) {
//                                    testarray6[i] = arry1.getJSONObject(i).getString("備註")
//                                }
//                                val textViews: Array<TextView?> =
//                                    arrayOfNulls<TextView>(arry1.length())
//                                for (i in 0 until arry1.length()) {
//                                    textViews[i] = view.findViewById<TextView>(0 + i)
//                                    //                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
////                                            textViews[i].setAutoSizeTextTypeUniformWithConfiguration(8,50,3,3);
////                                            System.out.println("inSDKINT");
////                                        }
//                                    textViews[i].setTextSize(20f)
//                                    textViews[i].setText("0$i")
//                                    textViews[i].setText( //                                                "定變頻　："+testarray[i]+"\n"+
//                                        //                                                "室內外機　："+testarray1[i]+"\n"+
//                                        //                                                "內容　："+testarray2[i]+"\n" +
//                                        """
//                                        系列　：${testarray3[i]}
//                                        顯示　：${testarray4[i]}
//                                        故障名稱　：${testarray5[i]}
//                                        備註　：${testarray6[i]}
//
//                                        """.trimIndent())
//                                    TextViewCompat.setAutoSizeTextTypeWithDefaults(textViews[i], TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
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
//            @get:Throws(AuthFailureError::class)
//            protected val params: Map<String, String>
//                protected get() {
//                    val hashMap = HashMap<String, String>()
//                    hashMap["search"] = editxt
//                    return hashMap
//                }
//        }
//        mQueue.add(getRequest)
//    }
//
//    override fun onClick(v: View) {
//        val linearLayout2: LinearLayout =
//            view!!.findViewById<View>(R.id.Services_Error_Result) as LinearLayout
//        linearLayout2.removeAllViewsInLayout()
//        getData(editview.getText().toString())
//        println(editview.getText().toString())
//        println("ookk")
//    }
//
//    override fun onEditorAction(v: TextView, actionId: Int, event: KeyEvent): Boolean {
//        when (actionId) {
//            EditorInfo.IME_ACTION_SEND -> {
//                val linearLayout2: LinearLayout =
//                    view!!.findViewById<View>(R.id.Services_Error_Result) as LinearLayout
//                linearLayout2.removeAllViewsInLayout()
//                getData(editview.getText().toString())
//                println(editview.getText().toString())
//                println("ookk")
//            }
//        }
//        return false
//    }
//
//    /*
//     * hide keyboard
//     * */
//    override fun onDetach() {
//        super.onDetach()
//        hideKeyboard()
//    }
//
//    fun hideKeyboard() {
////        InputMethodManager inputManager = (InputMethodManager) activity
////                .getSystemService(Context.INPUT_METHOD_SERVICE);
////        count ++;
////        System.out.println("count = "+count);
////        View currentFocusedView = activity.getCurrentFocus();
////        inputManager.hideSoftInputFromWindow(currentFocusedView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
////
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