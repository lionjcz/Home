package com.company.maxe.Login.index_menu.sales.Button.StockCatalogSerching

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
//import com.android.volley.AuthFailureError
import com.jekma.maxe.R

class Catalog : Fragment()
//    , View.OnClickListener
{
//
//    private var mQueue: RequestQueue? = null
//    private var getRequest: StringRequest? = null
//    var chosen1: TextView? = null
//    var chosen2: TextView? = null
//    var chosen3: TextView? = null
//    var chosen4: TextView? = null
//    var chosen5: TextView? = null
//    private val TAG = "Catalog"
//
//    /*
//    * Build all id
//    * */
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        chosen1 = view.findViewById<TextView>(R.id.chosen1)
//        chosen1.setOnClickListener(this)
//        chosen2 = view.findViewById<TextView>(R.id.chosen2)
//        chosen2.setOnClickListener(this)
//        chosen3 = view.findViewById<TextView>(R.id.chosen3)
//        chosen3.setOnClickListener(this)
//        chosen4 = view.findViewById<TextView>(R.id.chosen4)
//        chosen4.setOnClickListener(this)
//        chosen5 = view.findViewById<TextView>(R.id.chosen5)
//        chosen5.setOnClickListener(this)
//        val stock_btn = view.findViewById<ImageView>(R.id.stock_btn)
//        stock_btn.setOnClickListener(this)
//        val reset_btn = view.findViewById<ImageView>(R.id.reset_btn)
//        reset_btn.setOnClickListener(this)
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.maxe_catalog, container, false)
    }
//
//    /*
//    * Listen Click event
//    * */
//    override fun onClick(v: View) {
//        when (v.id) {
//            R.id.chosen1   -> {
//                val dialog = DialogPicker(R.id.chosen1)
//                DialogWindow(dialog)
//            }
//            R.id.chosen2   -> {
//                val dialog = DialogPicker(R.id.chosen2)
//                DialogWindow(dialog)
//            }
//            R.id.chosen3   -> {
//                val dialog = DialogPicker(R.id.chosen3)
//                DialogWindow(dialog)
//            }
//            R.id.chosen4   -> {
//                val dialog = DialogPicker(R.id.chosen4)
//                DialogWindow(dialog)
//            }
//            R.id.chosen5   -> {
//                val dialog = DialogPicker(R.id.chosen5)
//                DialogWindow(dialog)
//            }
//            R.id.stock_btn -> stock_btn()
//            R.id.reset_btn -> reset_btn()
//        }
//    }
//
//    /*
//    * Dialog Window
//    * */
//    private fun DialogWindow(dialog: DialogPicker) {
//        dialog.show(fragmentManager!!, "DialogPicker")
//    }
//
//    /*
//    * Condition user selected or not and Connect Api;
//    * */
//    private fun stock_btn() {
//        if (chosen1.getText() == "型態" && chosen2.getText() == "定變頻" && chosen3.getText() == "級數" && chosen4.getText() == "規格" && chosen5.getText() == "K瓦數") {
//            Toast.makeText(activity!!.applicationContext, "請選擇", Toast.LENGTH_SHORT).show()
//        }
//        val linearLayout2: LinearLayout = view!!.findViewById<View>(R.id.MyTable) as LinearLayout
//        linearLayout2.removeAllViewsInLayout()
//        Api()
//    }
//
//    /*
//    *  Reset to default
//    * */
//    private fun reset_btn() {
//        val linearLayout2: LinearLayout = view!!.findViewById<View>(R.id.MyTable) as LinearLayout
//        linearLayout2.removeAllViewsInLayout()
//        chosen1.setText("型態")
//        chosen1.setTextColor(resources.getColor(R.color.green))
//        chosen2.setText("定變頻")
//        chosen2.setTextColor(resources.getColor(R.color.green))
//        chosen3.setText("級數")
//        chosen3.setTextColor(resources.getColor(R.color.green))
//        chosen4.setText("規格")
//        chosen4.setTextColor(resources.getColor(R.color.green))
//        chosen5.setText("K瓦數")
//        chosen5.setTextColor(resources.getColor(R.color.green))
//        chosen3.setVisibility(View.VISIBLE)
//        chosen4.setVisibility(View.VISIBLE)
//    }
//
//    /*
//    * Connect to Api
//    * */
//    private fun Api() {
//        val Getstock = VolleyBridge()
//        val url: String = Getstock.Sales_CatalogSerching()
//        val list: ArrayList<*> = ArrayList<Any>()
//        mQueue = Volley.newRequestQueue(activity!!.applicationContext)
//        getRequest = object : StringRequest(Request.Method.POST, url, object : Listener<String?>() {
//            fun onResponse(s: String) {
//
////                                    Toast.makeText(getActivity().getApplicationContext(),s,Toast.LENGTH_SHORT).show();
////                                    System.out.println("a="+s);
//                Parsing(s)
//            }
//
//            private fun addTextView(i: Int) {}
//        }, object : ErrorListener() {
//            fun onErrorResponse(volleyError: VolleyError?) {
//                Toast.makeText(activity!!.applicationContext, "Select Customer http connect wrong", Toast.LENGTH_SHORT)
//            }
//        }) {
//            @get:Throws(AuthFailureError::class)
//            protected val params: Map<String, String>
//                protected get() {
//                    val Personal = activity as MainActivity?
//                    val Home_are: String = Personal.PERSONAL().get(1)
//                    val hashMap = HashMap<String, String>()
//                    hashMap["distruct"] = Home_are
//                    hashMap["Condition1"] = chosen1.getText() as String
//                    hashMap["Condition2"] = chosen2.getText() as String
//                    hashMap["Condition3"] = chosen3.getText() as String
//                    hashMap["Condition4"] = chosen4.getText() as String
//                    hashMap["Condition5"] = chosen5.getText() as String
//                    Log.wtf("$TAG=>Passing to Api :", "distruct = $Home_are")
//                    Log.wtf("$TAG=>Passing to Api :", "Condition1 = " + chosen1.getText() as String)
//                    Log.wtf("$TAG=>Passing to Api :", "Condition2 = " + chosen2.getText() as String)
//                    Log.wtf("$TAG=>Passing to Api :", "Condition3 = " + chosen3.getText() as String)
//                    Log.wtf("$TAG=>Passing to Api :", "Condition4 = " + chosen4.getText() as String)
//                    Log.wtf("$TAG=>Passing to Api :", "Condition5 = " + chosen5.getText() as String)
//                    return hashMap
//                }
//        }
//        mQueue.add(getRequest)
//    }
//
//    /*
//    * Parsing JSON response from Api
//    * */
//    private fun Parsing(s: String) {
//        try {
//            val check = JSONArray(s)
//            val check_result = arrayOfNulls<String>(check.length())
//            check_result[0] = check.getJSONObject(0).getString("Customer_NAME1")
//            if (check_result[0] == "資料表未上傳") {
//                Toast.makeText(activity!!.applicationContext, "資料表未上傳", Toast.LENGTH_SHORT).show()
//            }
//            else if (check_result[0] == "請重新確認是否選擇正確") {
//                Toast.makeText(activity!!.applicationContext, "請重新確認是否選擇正確", Toast.LENGTH_SHORT)
//                    .show()
//            }
//            else {
//                do_sorting(s)
//            }
//            //設定陣列
//        } catch (e: JSONException) {
//            Toast.makeText(activity!!.applicationContext, "Select Customer http connect wrong$e", Toast.LENGTH_SHORT)
//        }
//    }
//
//    /*
//    * Dynamically create and access data into TextView
//    *  **set id , text , color , textsize
//    * Param: s
//    * */
//    @Throws(JSONException::class)
//    private fun do_sorting(s: String) {
//        val arry = JSONArray(s)
//        val testarray = arrayOfNulls<String>(arry.length())
//        val testarray1 = arrayOfNulls<String>(arry.length())
//        val testarray2 = arrayOfNulls<String>(arry.length())
//        //撈資料並存到陣列
//        for (i in 0 until arry.length()) {
//            testarray[i] = arry.getJSONObject(i).getString("Customer_NAME1")
//            testarray1[i] = arry.getJSONObject(i).getString("Customer_NAME2")
//            testarray2[i] = arry.getJSONObject(i).getString("Customer_NAME3")
//        }
//
//        //動態產生textview
//        for (i in 0 until arry.length()) {
//            addTextView(i)
//        }
//
//        //動態設定名稱
//        val textViews: Array<TextView?> = arrayOfNulls<TextView>(arry.length())
//        for (i in 0 until arry.length()) {
//            textViews[i] = view.findViewById<TextView>(0 + i)
//            textViews[i].setText("0$i")
//            textViews[i].setText("   " + testarray[i] + "   " + testarray1[i] + "   " + testarray2[i])
//            textViews[i].setTextColor(-0x1000000)
//            if (testarray1[i] == "沒庫存") {
//                textViews[i].setTextSize(21f)
//            }
//            else {
//                textViews[i].setTextSize(22f)
//            }
//        }
//    }
//
//    /*
//    * Dynamically add TexeView into LinearLayout
//    * Param: i
//    * */
//    private fun addTextView(i: Int) {
//        val linearLayout: LinearLayout = view!!.findViewById<View>(R.id.MyTable) as LinearLayout
//        val textview = TextView(activity!!.applicationContext)
//        textview.setId(0 + i)
//        linearLayout.addView(textview)
//    }
}