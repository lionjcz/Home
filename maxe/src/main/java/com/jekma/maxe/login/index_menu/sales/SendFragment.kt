package com.company.maxe.Login.index_menu.sales

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import android.view.Viewimport
import android.widget.TableRow
import androidx.core.widget.TextViewCompat
import androidx.fragment.app.Fragment
//import androidx.navigation.NavController
import com.company.maxe.Login.MainActivity
import com.jekma.maxe.R
import java.lang.Exception
import java.text.DecimalFormat
import java.util.HashMap

//com.android.volley.AuthFailureError
class SendFragment : Fragment()
//    , View.OnClickListener
{
//
//    private var sendViewModel: SendViewModel? = null
//    private val TAG = "SendFragment"
//
//    //ManagerBox
//    private var ss: String? = null
//    private var sector: String? = null
//    private var isManager: Boolean? = null
//    private var general_sales: LinearLayout? = null
//    private var sales: String? = null
//
//    //DataBox
//    private var index_area: TextView? = null
//    private var index_day: TextView? = null
//    private var index_month: TextView? = null
//    private var index_district: TextView? = null
//
//    //ButtonBox
//    private var CustomerBTN: LinearLayout? = null
//    private var CatalogSerBTN: LinearLayout? = null
//    private var TextSerchingBTN: LinearLayout? = null
//    private var CustomerSerchingBTN: LinearLayout? = null
//    private var view: View? = null
//    private var view1: View? = null
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        this.view = view
//        view1 = view
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
//        sendViewModel = ViewModelProviders.of(this).get(SendViewModel::class.java)
        val root: View = inflater.inflate(R.layout.fragment_send, container, false)
//        DataBox(root)
//        ManagerBox(root)
//        ButtonBox(root)
//        val Personal = activity as MainActivity?
//        PermissionCheck(Personal.PERSONAL().get(9), CatalogSerBTN) //查詢庫存
//        PermissionCheck(Personal.PERSONAL().get(9), TextSerchingBTN) //查詢庫存
//        PermissionCheck(Personal.PERSONAL().get(10), CustomerSerchingBTN) //查詢經銷商
        return root
    }
//
//    private fun PermissionCheck(permission: String, TargetButton: LinearLayout?) {
//        if (permission == "啟動") {
//            TargetButton.setEnabled(true)
//        }
//        else {
//            TargetButton.setEnabled(false)
//            val textView: TextView = TargetButton.getChildAt(1) as TextView
//            textView.setTextColor(Color.GRAY)
//        }
//    }
//
//    private fun ManagerBox(root: View) {
//        val Personal = activity as MainActivity?
//        isManager = java.lang.Boolean.valueOf(Personal.PERSONAL().get(5)) //是否為主管
//        val checkSales: String = Personal.PERSONAL().get(3)
//        general_sales = root.findViewById<LinearLayout>(R.id.general_sales)
//        sales = Personal.PERSONAL().get(0) //姓名
//        sector = Personal.PERSONAL().get(2) //部門
//
//        /*
//         * 判斷是否為主管
//         * */if (isManager!! && checkSales == "國內業務人員" || isManager!!) {
//            if (isManager!! && checkSales == "國內業務人員") {
//                Api2(root)
//            }
//            else {
//            }
//            general_sales.setVisibility(View.GONE)
//        }
//        if (checkSales != "國內業務人員") {
//            general_sales.setVisibility(View.GONE)
//        }
//    }
//
//    /*
//     * Condition
//     *   isManager = true and checkSales = 國內業務人員
//     * */
//    fun Api2(root: View) {
//        val mQueue: RequestQueue = Volley.newRequestQueue(activity!!.applicationContext)
//        val Manager = VolleyBridge()
//        val getRequest: StringRequest = object :
//            StringRequest(Request.Method.POST, Manager.Manager_URL(), object : Listener<String?>() {
//                fun onResponse(s: String?) {
//                    Log.wtf(TAG, s)
//                    ss = s
//                    try {
//                        val arry = JSONArray(s)
//                        /*
//                             * 根據功能狀態來選擇是否顯示
//                             * 啟動 為 顯示
//                             * 關閉 為 隱藏
//                             * */Parsing(arry, s, root)
//                    } catch (e: JSONException) {
//                        e.printStackTrace()
//                    }
//                }
//            }, null) {
//            @get:Throws(AuthFailureError::class)
//            protected val params: Map<String, String>
//                protected get() {
//                    val hashMap = HashMap<String, String?>()
//                    hashMap["personal"] = sales
//                    println("Name = $sales")
//                    Log.wtf(TAG, "passing to api : personal = $sales")
//                    return hashMap
//                }
//        }
//        mQueue.add(getRequest)
//    }
//
//    private fun Parsing(arry: JSONArray, s: String?, root: View) {
//        val Manager: LinearLayout = root.findViewById<LinearLayout>(R.id.Manager)
//        val tableLayout = TableLayout(activity!!.applicationContext)
//        for (i in 0 until arry.length()) {
//            tableLayout.addView(tr(arry, i), TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT))
//        }
//        Manager.addView(headerLinearLayout())
//        Manager.addView(tableLayout)
//    }
//
//    private fun tr(arry: JSONArray, i: Int): TableRow {
//        val tableRow = TableRow(activity!!.applicationContext)
//        val tableParams =
//            TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
//        tableRow.layoutParams = tableParams
//        tableRow.layoutParams = tableParams
//        tableRow.addView(ll(arry, i))
//        try {
//            tableRow.tag =
//                arry.getJSONObject(i).getString("單位") // or entry.setTag(entry.index()), etc
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//        tableRow.setOnClickListener(tablerowOnClickListener) //add OnClickListener Here
//        tableRow.isClickable = true
//        tableRow.setBackgroundColor(Color.WHITE)
//        return tableRow
//    }
//
//    private fun ll(arry: JSONArray, i: Int): LinearLayout {
//        val linearLayout = LinearLayout(activity!!.applicationContext)
//        val t2params1 =
//            TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT, 1)
//        linearLayout.setOrientation(LinearLayout.HORIZONTAL)
//        linearLayout.setLayoutParams(t2params1)
//        try {
//            val decimalFormat = DecimalFormat(",###")
//            linearLayout.addView(tv(arry.getJSONObject(i).getString("單位")))
//            linearLayout.addView(tv(arry.getJSONObject(i).getString("主管")))
//            linearLayout.addView(tv(decimalFormat.format(arry.getJSONObject(i).getString("0")
//                .toDouble())))
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//        return linearLayout
//    }
//
//    private fun headerLinearLayout(): LinearLayout {
//        val linearLayout = LinearLayout(activity!!.applicationContext)
//        val layoutParams: LinearLayout.LayoutParams =
//            LinearLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT)
//        linearLayout.setOrientation(LinearLayout.HORIZONTAL)
//        linearLayout.setLayoutParams(layoutParams)
//        linearLayout.addView(headvertv("單位名稱"))
//        linearLayout.addView(headvertv("單位主管"))
//        linearLayout.addView(headvertv("單位營業額"))
//        return linearLayout
//    }
//
//    private fun headvertv(title: String): TextView {
//        val layoutParams1: LinearLayout.LayoutParams =
//            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1)
//        val textView = TextView(activity!!.applicationContext)
//        textView.setTextSize(25f)
//        TextViewCompat.setAutoSizeTextTypeWithDefaults(textView, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
//        textView.setGravity(Gravity.CENTER)
//        textView.setBackgroundColor(Color.YELLOW)
//        textView.setLines(1)
//        textView.setLayoutParams(layoutParams1)
//        textView.setText(title)
//        return textView
//    }
//
//    private fun tv(s: String): TextView {
//        val layoutParams: LinearLayout.LayoutParams =
//            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1)
//        //        layoutParams.gravity = Gravity.CENTER;
//        val textView = TextView(activity!!.applicationContext)
//        textView.setTextSize(25f)
//
////        textView.setBackgroundColor(Color.WHITE);
//        TextViewCompat.setAutoSizeTextTypeWithDefaults(textView, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
//        textView.setLines(1)
//        textView.setGravity(Gravity.CENTER)
//        textView.setLayoutParams(layoutParams)
//        textView.setText(s)
//        return textView
//    }
//
//    private val tablerowOnClickListener = View.OnClickListener { v ->
//        val tableRow = v as TableRow
//
//        //print
////            Toast.makeText(getActivity().getApplicationContext(),"Selected "+rowId,Toast.LENGTH_SHORT).show();
////            System.out.println("index a = "+rowId);
////            System.out.println("index TAG = "+v.getTag());
//
//        //change clicked item color
//        tableRow.setBackgroundColor(Color.GRAY)
//        val Personal = activity as MainActivity?
//
//
////            Log.wtf("Developing","職務類別"+Personal.PERSONAL()[3]);
////            Log.wtf("Developing","部門"+sector);
////            Log.wtf("Developing","最高職位"+Personal.PERSONAL()[4]);
//
//        /*
//                 * Go to Fragment Manager
//                 * Param rowId -> 單位
//                 * */
//        val values = Manager()
//        val bundle = Bundle()
//        bundle.putString("index", ss)
//        bundle.putString("部門", sector)
//        bundle.putString("職務類別", Personal.PERSONAL().get(3))
//        bundle.putString("最高職位", Personal.PERSONAL().get(4))
//        bundle.putString("主管", Personal.PERSONAL().get(5))
//        findNavController(view).navigate(R.id.action_nav_send_to_manager, bundle)
//    }
//
//    private fun ButtonBox(root: View) {
//        CustomerBTN = root.findViewById<LinearLayout>(R.id.CustomerBTN)
//        //        TextView tvCustomer = root.findViewById((CustomerBTN.getChildAt(1)).getId());
////        tvCustomer.setText("經銷商營業額");
//        CatalogSerBTN = root.findViewById<LinearLayout>(R.id.CatalogSerBTN)
//        //        TextView tvCatalogSer = root.findViewById((CatalogSerBTN.getChildAt(1)).getId());
////        tvCatalogSer.setText("型錄搜尋(庫存)");
//        TextSerchingBTN = root.findViewById<LinearLayout>(R.id.TextSerchingBTN)
//        //        TextView tvTextSerching = root.findViewById((TextSerchingBTN.getChildAt(1)).getId());
////        tvTextSerching.setText("型號搜尋(庫存)");
//        CustomerSerchingBTN = root.findViewById<LinearLayout>(R.id.CustomerSerchingBTN)
//        CustomerBTN.setOnClickListener(this)
//        CatalogSerBTN.setOnClickListener(this)
//        TextSerchingBTN.setOnClickListener(this)
//        CustomerSerchingBTN.setOnClickListener(this)
//    }
//
//    private fun DataBox(root: View) {
//        val Personal = activity as MainActivity?
//        Personal.SALES()
//        index_area = root.findViewById<TextView>(R.id.index_area)
//        index_day = root.findViewById<TextView>(R.id.index_day)
//        index_month = root.findViewById<TextView>(R.id.index_month)
//        index_district = root.findViewById<TextView>(R.id.index_district)
//        index_day.setText(Personal.SALES().get(2)) //month
//        index_district.setText(Personal.SALES().get(0)) //district
//        index_district.setTextSize(30f)
//        index_area.setText(Personal.SALES().get(1)) //area
//        index_day.setText(mDecimalFormat(Personal.SALES().get(2))) //month
//        index_month.setText(mDecimalFormat(Personal.SALES().get(3))) //day
//    }
//
//    //業績加逗號
//    private fun mDecimalFormat(sale: String): String {
//        var variable = "Initial"
//        variable = try {
//            val mDecimalFormat = DecimalFormat("#,###")
//            mDecimalFormat.format(sale.toDouble())
//        } catch (e: Exception) {
//            Log.wtf(TAG, "it's not integer")
//            sale
//        }
//        return variable
//    }
//
//    override fun onClick(v: View) {
//        val navController: NavController = findNavController(view)
//        when (v.id) {
//            R.id.CustomerBTN         -> navController.navigate(R.id.action_nav_send_to_customer)
//            R.id.CatalogSerBTN       -> navController.navigate(R.id.action_nav_send_to_catalog)
//            R.id.TextSerchingBTN     -> navController.navigate(R.id.action_nav_send_to_textSerching)
//            R.id.CustomerSerchingBTN -> navController.navigate(R.id.action_nav_send_to_Sales_CustomerBySerching)
//            else                     -> Toast.makeText(activity!!.applicationContext, "Something was wrong !! please contact maxe 2213", Toast.LENGTH_SHORT)
//                .show()
//        }
//    }
}