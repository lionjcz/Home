package com.company.maxe.Login.index_menu.sales.Button.Customer_ALL

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
//import androidx.navigation.NavController
import com.jekma.maxe.R
//import com.android.volley.AuthFailureError
//import com.company.maxe.Login.MainActivity
import java.util.ArrayList
import java.util.HashMap

class Customer : Fragment() {
//    private var mQueue: RequestQueue? = null
//    private var getRequest: StringRequest? = null
//    private var Home_are: String? = null
//    private var view3: View? = null
//    private val TAG = "Customer"
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        view3 = view
//    }
//
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.customer, container, false)
//        val Personal = activity as MainActivity?
//        val SALES: Array<String> = Personal.SALES()
//        Log.wtf(TAG, "職務類別 = " + Personal.PERSONAL().get(3))
//        if (Personal.PERSONAL().get(3).equals("國內業務人員")) {
//            Log.wtf(TAG, "部門 = " + Personal.PERSONAL().get(2))
//            Log.wtf(TAG, "職位 = " + Personal.PERSONAL().get(4))
//            Home_are = if (Personal.PERSONAL().get(4).equals("本部總經理") && Personal.PERSONAL().get(2)
//                    .equals("業務銷售本部")) {
//                "Manager_all"
//            }
//            else if (Personal.PERSONAL().get(4).equals("副總經理") && Personal.PERSONAL().get(2)
//                    .equals("空調特販本部")) {
//                "SubManager_all"
//            }
//            else {
//                SALES[1]
//            }
//            WholeCustomer(Home_are, root)
//        }
//        else {
//            Toast.makeText(activity!!.applicationContext, "此功能限定業務人員", Toast.LENGTH_SHORT).show()
//        }
        return root
    }
//
//    //show all customer
//    private fun WholeCustomer(Home_are: String?, root: View) {
//        val Customer_sales = VolleyBridge()
//        val url1: String = Customer_sales.Customer_sales()
//        mQueue = Volley.newRequestQueue(activity!!.applicationContext)
//        getRequest =
//            object : StringRequest(Request.Method.POST, url1, object : Listener<String?>() {
//                fun onResponse(s: String) {
//                    PushData(s, root)
//                }
//            }, object : ErrorListener() {
//                fun onErrorResponse(volleyError: VolleyError?) {
//                    Toast.makeText(activity!!.applicationContext, "Select Customer http connect wrong1    1", Toast.LENGTH_SHORT)
//                }
//            }) {
//                @get:Throws(AuthFailureError::class)
//                protected val params: Map<String, String?>
//                    protected get() {
//                        val hashMap = HashMap<String, String?>()
//                        hashMap["function_show_all_name"] = Home_are
//                        Log.wtf(TAG, "HashMap = $Home_are")
//                        return hashMap
//                    }
//            }
//        mQueue.add(getRequest)
//    }
//
//    private fun PushData(s: String, root: View) {
//        val list: ArrayList<*> = ArrayList<Any>()
//        try {
//            val arry = JSONArray(s)
//            val stock_tem = arrayOfNulls<String>(arry.length())
//            val stock_tem1 = arrayOfNulls<String>(arry.length())
//            for (i in 0 until arry.length()) {
//                stock_tem[i] = arry.getJSONObject(i).getString("Customer_NAME")
//                stock_tem1[i] = arry.getJSONObject(i).getString("Customer_NAME2")
//                val combine = "(" + stock_tem1[i] + ")" + stock_tem[i]
//                list.add(combine)
//            }
//            val arrayAdapter: ArrayAdapter<*> =
//                ArrayAdapter<Any?>(context, R.layout.simple_list_item_1, list)
//            val listView = root.findViewById<View>(R.id.select_all11) as ListView
//            listView.setOnItemClickListener(object : OnItemClickListener {
//                override fun onItemClick(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
//                    val intent =
//                        Intent(activity!!.applicationContext, fragment_customer_sell::class.java)
//                    intent.putExtra("test", listView.getItemAtPosition(position).toString())
//                    val bundle = Bundle()
//                    bundle.putString("GetCustomer", listView.getItemAtPosition(position).toString())
//                    Log.wtf("atb", listView.getItemAtPosition(position).toString())
//                    val navController: NavController = findNavController(view3)
//                    navController.navigate(R.id.action_customer_to_fragment_customer_sell, bundle)
//                }
//            })
//            listView.adapter = arrayAdapter
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//    }
}