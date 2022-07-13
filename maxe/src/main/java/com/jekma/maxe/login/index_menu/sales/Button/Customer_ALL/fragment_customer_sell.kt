package com.company.maxe.Login.index_menu.sales.Button.Customer_ALL

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jekma.maxe.R
//import com.android.volley.AuthFailureError

class fragment_customer_sell : Fragment() {
//
//    private var mQueue: RequestQueue? = null
//    private var getRequest: StringRequest? = null
//    var getFroms_c: String? = null
//    var Nov_106: TextView? = null
//    var Nov_107: TextView? = null
//    var Nov_108: TextView? = null
//    var Dec_106: TextView? = null
//    var Dec_107: TextView? = null
//    var Dec_108: TextView? = null
//    var Jan_106: TextView? = null
//    var Jan_107: TextView? = null
//    var Jan_108: TextView? = null
//    var Feb_106: TextView? = null
//    var Feb_107: TextView? = null
//    var Feb_108: TextView? = null
//    var Mar_106: TextView? = null
//    var Mar_107: TextView? = null
//    var Mar_108: TextView? = null
//    var Apr_106: TextView? = null
//    var Apr_107: TextView? = null
//    var Apr_108: TextView? = null
//    var May_106: TextView? = null
//    var May_107: TextView? = null
//    var May_108: TextView? = null
//    var Jun_106: TextView? = null
//    var Jun_107: TextView? = null
//    var Jun_108: TextView? = null
//    var Jul_106: TextView? = null
//    var Jul_107: TextView? = null
//    var Jul_108: TextView? = null
//    var Aug_106: TextView? = null
//    var Aug_107: TextView? = null
//    var Aug_108: TextView? = null
//    var Sep_106: TextView? = null
//    var Sep_107: TextView? = null
//    var Sep_108: TextView? = null
//    var Oct_106: TextView? = null
//    var Oct_107: TextView? = null
//    var Oct_108: TextView? = null
//    var ttl_106: TextView? = null
//    var ttl_107: TextView? = null
//    var ttl_108: TextView? = null
//    var act_108 = arrayOfNulls<String>(14)
//    var act_107 = arrayOfNulls<String>(14)
//    var act_106 = arrayOfNulls<String>(14)
//    private var getFroms_c1: String? = null
//    private val TAG = "fragment_customer_sell"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.maxe_fragment_customer_sell, container, false)
//        val arguments: Bundle? = arguments
//        setColor(root)
//        if (arguments == null) {
//            Toast.makeText(activity!!.applicationContext, "bundle withou no data", Toast.LENGTH_SHORT)
//                .show()
//        }
//        else {
//            val customer_sell = VolleyBridge()
//            getFroms_c1 = arguments.getString("GetCustomer")
//            getFroms_c = catchnumbrt(getFroms_c1)
//            println("getFroms_cgetFroms_c = $getFroms_c")
//            val aaa = getFroms_c
//            val list: ArrayList<*> = ArrayList<Any>()
//            mQueue = Volley.newRequestQueue(activity!!.applicationContext)
//            getRequest = object :
//                StringRequest(Request.Method.POST, customer_sell.customer_sell(), object :
//                    Listener<String?>() {
//                    fun onResponse(s: String) {
//                        val test_textipt: TextView = view.findViewById<TextView>(R.id.test_textipt)
//                        test_textipt.setText(getFroms_c1)
//                        println("s = $s")
//                        try {
//                            val arry = JSONArray(s)
//                            //106
//                            getData106(s)
//                            //107
//                            getData107(s)
//                            //108
//                            getData108(s)
//                        } catch (e: JSONException) {
//                            e.printStackTrace()
//                            Toast.makeText(activity!!.applicationContext, "" + e, Toast.LENGTH_SHORT)
//                                .show()
//                        }
//                    }
//                }, object : ErrorListener() {
//                    fun onErrorResponse(volleyError: VolleyError?) {
//                        Toast.makeText(activity!!.applicationContext, "Select Customer http connect wrong", Toast.LENGTH_SHORT)
//                    }
//                }) {
//                @get:Throws(AuthFailureError::class)
//                protected val params: Map<String, String>
//                    protected get() {
//                        val hashMap = HashMap<String, String?>()
//                        val function_show_all_name = "Customer_year_sell"
//                        hashMap["function_show_all_name"] = function_show_all_name
//                        hashMap["getFroms_c"] = aaa
//                        Log.wtf(TAG, " => passing to api : function_show_all_name = $function_show_all_name")
//                        Log.wtf(TAG, " => passing to api : getFroms_c = $getFroms_c")
//                        return hashMap
//                    }
//            }
//            mQueue.add(getRequest)
//        }
        return root
    }

//    //HideKeyboard
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        hideKeyboard()
//    }
//
//    private fun hideKeyboard() {
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
//
//    //HideKeyboard
//    private fun setColor(root: View) {
//        Nov_106 = root.findViewById<View>(R.id.Nov_106) as TextView
//        Nov_106.setTextColor(Color.BLACK)
//        Nov_107 = root.findViewById<View>(R.id.Nov_107) as TextView
//        Nov_107.setTextColor(Color.BLACK)
//        Nov_108 = root.findViewById<View>(R.id.Nov_108) as TextView
//        Nov_108.setTextColor(Color.BLACK)
//        Dec_106 = root.findViewById<View>(R.id.Dec_106) as TextView
//        Dec_106.setTextColor(Color.BLACK)
//        Dec_107 = root.findViewById<View>(R.id.Dec_107) as TextView
//        Dec_107.setTextColor(Color.BLACK)
//        Dec_108 = root.findViewById<View>(R.id.Dec_108) as TextView
//        Dec_108.setTextColor(Color.BLACK)
//        Jan_106 = root.findViewById<View>(R.id.Jan_106) as TextView
//        Jan_106.setTextColor(Color.BLACK)
//        Jan_107 = root.findViewById<View>(R.id.Jan_107) as TextView
//        Jan_107.setTextColor(Color.BLACK)
//        Jan_108 = root.findViewById<View>(R.id.Jan_108) as TextView
//        Jan_108.setTextColor(Color.BLACK)
//        Feb_106 = root.findViewById<View>(R.id.Feb_106) as TextView
//        Feb_106.setTextColor(Color.BLACK)
//        Feb_107 = root.findViewById<View>(R.id.Feb_107) as TextView
//        Feb_107.setTextColor(Color.BLACK)
//        Feb_108 = root.findViewById<View>(R.id.Feb_108) as TextView
//        Feb_108.setTextColor(Color.BLACK)
//        Mar_106 = root.findViewById<View>(R.id.Mar_106) as TextView
//        Mar_106.setTextColor(Color.BLACK)
//        Mar_107 = root.findViewById<View>(R.id.Mar_107) as TextView
//        Mar_107.setTextColor(Color.BLACK)
//        Mar_108 = root.findViewById<View>(R.id.Mar_108) as TextView
//        Mar_108.setTextColor(Color.BLACK)
//        Apr_106 = root.findViewById<View>(R.id.Apr_106) as TextView
//        Apr_106.setTextColor(Color.BLACK)
//        Apr_107 = root.findViewById<View>(R.id.Apr_107) as TextView
//        Apr_107.setTextColor(Color.BLACK)
//        Apr_108 = root.findViewById<View>(R.id.Apr_108) as TextView
//        Apr_108.setTextColor(Color.BLACK)
//        May_106 = root.findViewById<View>(R.id.May_106) as TextView
//        May_106.setTextColor(Color.BLACK)
//        May_107 = root.findViewById<View>(R.id.May_107) as TextView
//        May_107.setTextColor(Color.BLACK)
//        May_108 = root.findViewById<View>(R.id.May_108) as TextView
//        May_108.setTextColor(Color.BLACK)
//        Jun_106 = root.findViewById<View>(R.id.Jun_106) as TextView
//        Jun_106.setTextColor(Color.BLACK)
//        Jun_107 = root.findViewById<View>(R.id.Jun_107) as TextView
//        Jun_107.setTextColor(Color.BLACK)
//        Jun_108 = root.findViewById<View>(R.id.Jun_108) as TextView
//        Jun_108.setTextColor(Color.BLACK)
//        Jul_106 = root.findViewById<View>(R.id.Jul_106) as TextView
//        Jul_106.setTextColor(Color.BLACK)
//        Jul_107 = root.findViewById<View>(R.id.Jul_107) as TextView
//        Jul_107.setTextColor(Color.BLACK)
//        Jul_108 = root.findViewById<View>(R.id.Jul_108) as TextView
//        Jul_108.setTextColor(Color.BLACK)
//        Aug_106 = root.findViewById<View>(R.id.Aug_106) as TextView
//        Aug_106.setTextColor(Color.BLACK)
//        Aug_107 = root.findViewById<View>(R.id.Aug_107) as TextView
//        Aug_107.setTextColor(Color.BLACK)
//        Aug_108 = root.findViewById<View>(R.id.Aug_108) as TextView
//        Aug_108.setTextColor(Color.BLACK)
//        Sep_106 = root.findViewById<View>(R.id.Sep_106) as TextView
//        Sep_106.setTextColor(Color.BLACK)
//        Sep_107 = root.findViewById<View>(R.id.Sep_107) as TextView
//        Sep_107.setTextColor(Color.BLACK)
//        Sep_108 = root.findViewById<View>(R.id.Sep_108) as TextView
//        Sep_108.setTextColor(Color.BLACK)
//        Oct_106 = root.findViewById<View>(R.id.Oct_106) as TextView
//        Oct_106.setTextColor(Color.BLACK)
//        Oct_107 = root.findViewById<View>(R.id.Oct_107) as TextView
//        Oct_107.setTextColor(Color.BLACK)
//        Oct_108 = root.findViewById<View>(R.id.Oct_108) as TextView
//        Oct_108.setTextColor(Color.BLACK)
//        ttl_106 = root.findViewById<View>(R.id.ttl_106) as TextView
//        ttl_106.setTextColor(Color.BLACK)
//        ttl_107 = root.findViewById<View>(R.id.ttl_107) as TextView
//        ttl_107.setTextColor(Color.BLACK)
//        ttl_108 = root.findViewById<View>(R.id.ttl_108) as TextView
//        ttl_108.setTextColor(Color.BLACK)
//    }
//
//    private fun catchnumbrt(getFroms_c: String?): String {
//        var str = getFroms_c
//        str = str!!.replace("\\D+".toRegex(), "")
//        println(str)
//        return str
//    }
//
//    private fun getData106(s: String) {
//        try {
//            val arry = JSONArray(s)
//            for (i in 0..12) {
//                when (i) {
//                    0    -> {
//                        act_106[i] = arry.getJSONObject(0).getString("First_Customer_sell0$i")
//                        ttl_106 = view!!.findViewById<View>(R.id.ttl_106) as TextView
//                        ttl_106.setText(act_106[i])
//                    }
//                    1    -> {
//                        act_106[i] = arry.getJSONObject(0).getString("First_Customer_sell0$i")
//                        Jan_106 = view!!.findViewById<View>(R.id.Jan_106) as TextView
//                        Jan_106.setText(act_106[i])
//                    }
//                    2    -> {
//                        act_106[i] = arry.getJSONObject(0).getString("First_Customer_sell0$i")
//                        Feb_106 = view!!.findViewById<View>(R.id.Feb_106) as TextView
//                        Feb_106.setText(act_106[i])
//                    }
//                    3    -> {
//                        act_106[i] = arry.getJSONObject(0).getString("First_Customer_sell0$i")
//                        Mar_106 = view!!.findViewById<View>(R.id.Mar_106) as TextView
//                        Mar_106.setText(act_106[i])
//                    }
//                    4    -> {
//                        act_106[i] = arry.getJSONObject(0).getString("First_Customer_sell0$i")
//                        Apr_106 = view!!.findViewById<View>(R.id.Apr_106) as TextView
//                        Apr_106.setText(act_106[i])
//                    }
//                    5    -> {
//                        act_106[i] = arry.getJSONObject(0).getString("First_Customer_sell0$i")
//                        May_106 = view!!.findViewById<View>(R.id.May_106) as TextView
//                        May_106.setText(act_106[i])
//                    }
//                    6    -> {
//                        act_106[i] = arry.getJSONObject(0).getString("First_Customer_sell0$i")
//                        Jun_106 = view!!.findViewById<View>(R.id.Jun_106) as TextView
//                        Jun_106.setText(act_106[i])
//                    }
//                    7    -> {
//                        act_106[i] = arry.getJSONObject(0).getString("First_Customer_sell0$i")
//                        Jul_106 = view!!.findViewById<View>(R.id.Jul_106) as TextView
//                        Jul_106.setText(act_106[i])
//                    }
//                    8    -> {
//                        act_106[i] = arry.getJSONObject(0).getString("First_Customer_sell0$i")
//                        Aug_106 = view!!.findViewById<View>(R.id.Aug_106) as TextView
//                        Aug_106.setText(act_106[i])
//                    }
//                    9    -> {
//                        act_106[i] = arry.getJSONObject(0).getString("First_Customer_sell0$i")
//                        Sep_106 = view!!.findViewById<View>(R.id.Sep_106) as TextView
//                        Sep_106.setText(act_106[i])
//                    }
//                    10   -> {
//                        act_106[i] = arry.getJSONObject(0).getString("First_Customer_sell$i")
//                        Oct_106 = view!!.findViewById<View>(R.id.Oct_106) as TextView
//                        Oct_106.setText(act_106[i])
//                    }
//                    11   -> {
//                        act_106[i] = arry.getJSONObject(0).getString("First_Customer_sell$i")
//                        Nov_106 = view!!.findViewById<View>(R.id.Nov_106) as TextView
//                        Nov_106.setText(act_106[i])
//                    }
//                    12   -> {
//                        act_106[i] = arry.getJSONObject(0).getString("First_Customer_sell$i")
//                        Dec_106 = view!!.findViewById<View>(R.id.Dec_106) as TextView
//                        Dec_106.setText(act_106[i])
//                    }
//                    else -> {}
//                }
//            }
//        } catch (e: JSONException) {
//            e.printStackTrace()
//            Toast.makeText(activity!!.applicationContext, "" + e, Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    //                                107
//    private fun getData107(s: String) {
//        try {
//            val arry = JSONArray(s)
//            for (i in 0..12) {
//                when (i) {
//                    0    -> {
//                        act_107[i] = arry.getJSONObject(1).getString("Second_Customer_sell0$i")
//                        ttl_107 = view!!.findViewById<View>(R.id.ttl_107) as TextView
//                        ttl_107.setText(act_107[i])
//                    }
//                    1    -> {
//                        act_107[i] = arry.getJSONObject(1).getString("Second_Customer_sell0$i")
//                        Jan_107 = view!!.findViewById<View>(R.id.Jan_107) as TextView
//                        Jan_107.setText(act_107[i])
//                    }
//                    2    -> {
//                        act_107[i] = arry.getJSONObject(1).getString("Second_Customer_sell0$i")
//                        Feb_107 = view!!.findViewById<View>(R.id.Feb_107) as TextView
//                        Feb_107.setText(act_107[i])
//                    }
//                    3    -> {
//                        act_107[i] = arry.getJSONObject(1).getString("Second_Customer_sell0$i")
//                        Mar_107 = view!!.findViewById<View>(R.id.Mar_107) as TextView
//                        Mar_107.setText(act_107[i])
//                    }
//                    4    -> {
//                        act_107[i] = arry.getJSONObject(1).getString("Second_Customer_sell0$i")
//                        Apr_107 = view!!.findViewById<View>(R.id.Apr_107) as TextView
//                        Apr_107.setText(act_107[i])
//                    }
//                    5    -> {
//                        act_107[i] = arry.getJSONObject(1).getString("Second_Customer_sell0$i")
//                        May_107 = view!!.findViewById<View>(R.id.May_107) as TextView
//                        May_107.setText(act_107[i])
//                    }
//                    6    -> {
//                        act_107[i] = arry.getJSONObject(1).getString("Second_Customer_sell0$i")
//                        Jun_107 = view!!.findViewById<View>(R.id.Jun_107) as TextView
//                        Jun_107.setText(act_107[i])
//                    }
//                    7    -> {
//                        act_107[i] = arry.getJSONObject(1).getString("Second_Customer_sell0$i")
//                        Jul_107 = view!!.findViewById<View>(R.id.Jul_107) as TextView
//                        Jul_107.setText(act_107[i])
//                    }
//                    8    -> {
//                        act_107[i] = arry.getJSONObject(1).getString("Second_Customer_sell0$i")
//                        Aug_107 = view!!.findViewById<View>(R.id.Aug_107) as TextView
//                        Aug_107.setText(act_107[i])
//                    }
//                    9    -> {
//                        act_107[i] = arry.getJSONObject(1).getString("Second_Customer_sell0$i")
//                        Sep_107 = view!!.findViewById<View>(R.id.Sep_107) as TextView
//                        Sep_107.setText(act_107[i])
//                    }
//                    10   -> {
//                        act_107[i] = arry.getJSONObject(1).getString("Second_Customer_sell$i")
//                        Oct_107 = view!!.findViewById<View>(R.id.Oct_107) as TextView
//                        Oct_107.setText(act_107[i])
//                    }
//                    11   -> {
//                        act_107[i] = arry.getJSONObject(1).getString("Second_Customer_sell$i")
//                        Nov_107 = view!!.findViewById<View>(R.id.Nov_107) as TextView
//                        Nov_107.setText(act_107[i])
//                    }
//                    12   -> {
//                        act_107[i] = arry.getJSONObject(1).getString("Second_Customer_sell$i")
//                        Dec_107 = view!!.findViewById<View>(R.id.Dec_107) as TextView
//                        Dec_107.setText(act_107[i])
//                    }
//                    else -> {}
//                }
//            }
//        } catch (e: JSONException) {
//            e.printStackTrace()
//            Toast.makeText(activity!!.applicationContext, "" + e, Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    //108
//    private fun getData108(s: String) {
//        try {
//            val arry = JSONArray(s)
//            for (i in 0..12) {
//                when (i) {
//                    0    -> {
//                        act_108[i] = arry.getJSONObject(2).getString("Third_Customer_sell0$i")
//                        ttl_108 = view!!.findViewById<View>(R.id.ttl_108) as TextView
//                        ttl_108.setText(act_108[i])
//                    }
//                    1    -> {
//                        act_108[i] = arry.getJSONObject(2).getString("Third_Customer_sell0$i")
//                        Jan_108 = view!!.findViewById<View>(R.id.Jan_108) as TextView
//                        Jan_108.setText(act_108[i])
//                    }
//                    2    -> {
//                        act_108[i] = arry.getJSONObject(2).getString("Third_Customer_sell0$i")
//                        Feb_108 = view!!.findViewById<View>(R.id.Feb_108) as TextView
//                        Feb_108.setText(act_108[i])
//                    }
//                    3    -> {
//                        act_108[i] = arry.getJSONObject(2).getString("Third_Customer_sell0$i")
//                        Mar_108 = view!!.findViewById<View>(R.id.Mar_108) as TextView
//                        Mar_108.setText(act_108[i])
//                    }
//                    4    -> {
//                        act_108[i] = arry.getJSONObject(2).getString("Third_Customer_sell0$i")
//                        Apr_108 = view!!.findViewById<View>(R.id.Apr_108) as TextView
//                        Apr_108.setText(act_108[i])
//                    }
//                    5    -> {
//                        act_108[i] = arry.getJSONObject(2).getString("Third_Customer_sell0$i")
//                        May_108 = view!!.findViewById<View>(R.id.May_108) as TextView
//                        May_108.setText(act_108[i])
//                    }
//                    6    -> {
//                        act_108[i] = arry.getJSONObject(2).getString("Third_Customer_sell0$i")
//                        Jun_108 = view!!.findViewById<View>(R.id.Jun_108) as TextView
//                        Jun_108.setText(act_108[i])
//                    }
//                    7    -> {
//                        act_108[i] = arry.getJSONObject(2).getString("Third_Customer_sell0$i")
//                        Jul_108 = view!!.findViewById<View>(R.id.Jul_108) as TextView
//                        Jul_108.setText(act_108[i])
//                    }
//                    8    -> {
//                        act_108[i] = arry.getJSONObject(2).getString("Third_Customer_sell0$i")
//                        Aug_108 = view!!.findViewById<View>(R.id.Aug_108) as TextView
//                        Aug_108.setText(act_108[i])
//                    }
//                    9    -> {
//                        act_108[i] = arry.getJSONObject(2).getString("Third_Customer_sell0$i")
//                        Sep_108 = view!!.findViewById<View>(R.id.Sep_108) as TextView
//                        Sep_108.setText(act_108[i])
//                    }
//                    10   -> {
//                        act_108[i] = arry.getJSONObject(2).getString("Third_Customer_sell$i")
//                        Oct_108 = view!!.findViewById<View>(R.id.Oct_108) as TextView
//                        Oct_108.setText(act_108[i])
//                    }
//                    11   -> {
//                        act_108[i] = arry.getJSONObject(2).getString("Third_Customer_sell$i")
//                        Nov_108 = view!!.findViewById<View>(R.id.Nov_108) as TextView
//                        Nov_108.setText(act_108[i])
//                    }
//                    12   -> {
//                        act_108[i] = arry.getJSONObject(2).getString("Third_Customer_sell$i")
//                        Dec_108 = view!!.findViewById<View>(R.id.Dec_108) as TextView
//                        Dec_108.setText(act_108[i])
//                    }
//                    else -> {}
//                }
//            }
//        } catch (e: JSONException) {
//            e.printStackTrace()
//            Toast.makeText(activity!!.applicationContext, "json error $e", Toast.LENGTH_SHORT)
//                .show()
//        }
//    }
}