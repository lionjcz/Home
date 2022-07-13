package com.jekma.maxe.login.index_menu.sales

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.widget.TextViewCompat
import com.jekma.maxe.login.index_menu.sales.Manager.Manager
import com.jekma.baselibrary.BaseBindingFragment
import com.jekma.maxe.R
import com.jekma.maxe.databinding.FragmentSendBinding
import org.json.JSONArray
import java.lang.Exception
import java.text.DecimalFormat

@RequiresApi(Build.VERSION_CODES.Q)
class SendFragment : BaseBindingFragment<FragmentSendBinding, SendViewModel>(),
    View.OnClickListener {

    override val isShowMainBar: Boolean
        get() = true
    override val titleResId: Int
        get() = R.string.maxe_title_sales
    override val layoutResId: Int
        get() = R.layout.maxe_fragment_send
    override var permissionOnViewListener: PermissionOnView? = null
    private val TAG = "SendFragment"

    //ManagerBox
    private var ss: String? = null
    private var sector: String? = null
    private var isManager: Boolean? = null
    private var general_sales: LinearLayout? = null
    private var sales: String? = null

    //DataBox
    private var index_area: TextView? = null
    private var index_day: TextView? = null
    private var index_month: TextView? = null
    private var index_district: TextView? = null

    //ButtonBox
    private var CustomerBTN: LinearLayout? = null
    private var CatalogSerBTN: LinearLayout? = null
    private var TextSerchingBTN: LinearLayout? = null
    private var CustomerSerchingBTN: LinearLayout? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
//        ManagerBox(super.onCreateView(inflater, container, savedInstanceState))
//        ButtonBox(super.onCreateView(inflater, container, savedInstanceState))
//        val Personal = MainActivity
//        PermissionCheck(Personal.PERSONAL()[9]!!, CatalogSerBTN) //查詢庫存
//        PermissionCheck(Personal.PERSONAL()[9]!!, TextSerchingBTN) //查詢庫存
//        PermissionCheck(Personal.PERSONAL()[10]!!, CustomerSerchingBTN) //查詢經銷商
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataBox()
        ManagerBox()
        ButtonBox()
        Parsing( "s")

    }


    /*
     * Condition
     *   isManager = true and checkSales = 國內業務人員
     * */
    fun Api2(root: View) {
//        val mQueue: RequestQueue = Volley.newRequestQueue(activity!!.applicationContext)
//        val Manager = VolleyBridge()
//        val getRequest: StringRequest = object :
//            StringRequest(Request.Method.POST, Manager.Manager_URL(), object :
//                Listener<String?>() {
//                fun onResponse(s: String?) {
//                    Log.wtf(TAG, s)
//                    ss = s
//                    try {
        val arry = JSONArray("s")
//                        /*
//                             * 根據功能狀態來選擇是否顯示
//                             * 啟動 為 顯示
//                             * 關閉 為 隱藏
//                             * */
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
    }

    private fun Parsing(s: String?) {
        val Manager = mViewBinding.Manager
        val tableLayout = TableLayout(requireActivity().applicationContext)
        for (i in 0 until 3) {
            tableLayout.addView(
                tr(),
                TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT)
            )
        }
        Manager.addView(headerLinearLayout())
        Manager.addView(tableLayout)
    }

    private fun tr(): TableRow {
        val tableRow = TableRow(requireActivity().applicationContext)
        val tableParams =
            TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
        tableRow.layoutParams = tableParams
        tableRow.layoutParams = tableParams
        tableRow.addView(ll())
        tableRow.tag = "單位" // or entry.setTag(entry.index()), etc
        tableRow.setOnClickListener(tablerowOnClickListener) //add OnClickListener Here
        tableRow.isClickable = true
        tableRow.setBackgroundColor(Color.WHITE)
        return tableRow
    }

    private fun ll(): LinearLayout {
        val linearLayout = LinearLayout(requireActivity().applicationContext)
        val t2params1 =
            TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT, 1F)
        linearLayout.orientation = LinearLayout.HORIZONTAL
        linearLayout.layoutParams = t2params1
        linearLayout.addView(tv("單位"))
        linearLayout.addView(tv("主管"))
        linearLayout.addView(tv("14531"))
        return linearLayout
    }

    private fun headerLinearLayout(): LinearLayout {
        val linearLayout = LinearLayout(requireActivity().applicationContext)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT)
        linearLayout.setOrientation(LinearLayout.HORIZONTAL)
        linearLayout.setLayoutParams(layoutParams)
        linearLayout.addView(headvertv("單位名稱"))
        linearLayout.addView(headvertv("單位主管"))
        linearLayout.addView(headvertv("單位營業額"))
        return linearLayout
    }

    private fun headvertv(title: String): TextView {
        val layoutParams1: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1F)
        val textView = TextView(requireActivity().applicationContext)
        textView.textSize = 25f
        TextViewCompat.setAutoSizeTextTypeWithDefaults(textView, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
        textView.gravity = Gravity.CENTER
        textView.setBackgroundColor(Color.YELLOW)
        textView.setLines(1)
        textView.layoutParams = layoutParams1
        textView.text = title
        return textView
    }

    private fun tv(s: String): TextView {
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1F)
        //        layoutParams.gravity = Gravity.CENTER;
        val textView = TextView(requireActivity().applicationContext)
        textView.textSize = 25f

//        textView.setBackgroundColor(Color.WHITE);
        TextViewCompat.setAutoSizeTextTypeWithDefaults(textView, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
        textView.setLines(1)
        textView.gravity = Gravity.CENTER
        textView.layoutParams = layoutParams
        textView.text = s
        return textView
    }

    private val tablerowOnClickListener = View.OnClickListener { v ->
        val tableRow = v as TableRow

        //print
//            Toast.makeText(getActivity().getApplicationContext(),"Selected "+rowId,Toast.LENGTH_SHORT).show();
//            System.out.println("index a = "+rowId);
//            System.out.println("index TAG = "+v.getTag());

        //change clicked item color
        tableRow.setBackgroundColor(Color.GRAY)
//        val Personal = MainActivity


//            Log.wtf("Developing","職務類別"+Personal.PERSONAL()[3]);
//            Log.wtf("Developing","部門"+sector);
//            Log.wtf("Developing","最高職位"+Personal.PERSONAL()[4]);

        /*
                 * Go to Fragment Manager
                 * Param rowId -> 單位
                 * */
        val values = Manager()
        val bundle = Bundle()
//        bundle.putString("index", ss)
//        bundle.putString("部門", sector)
//        bundle.putString("職務類別", Personal.PERSONAL()[3])
//        bundle.putString("最高職位", Personal.PERSONAL()[4])
//        bundle.putString("主管", Personal.PERSONAL()[5])
        gotoNextNavPage(R.id.action_nav_send_to_manager, bundle)
    }


    //業績加逗號
    private fun mDecimalFormat(sale: String): String {
        var variable = "Initial"
        variable = try {
            val mDecimalFormat = DecimalFormat("#,###")
            mDecimalFormat.format(sale.toDouble())
        } catch (e: Exception) {
            Log.wtf(TAG, "it's not integer::$sales")
            sale
        }
        return variable
    }


    private fun PermissionCheck(permission: String, TargetButton: LinearLayout?) {
        if (permission == "啟動") {
            TargetButton?.isEnabled = true
        }
        else {
            TargetButton?.isEnabled = false
            val textView: TextView = TargetButton?.getChildAt(1) as TextView
            textView.setTextColor(Color.GRAY)
        }
    }

    private fun ButtonBox() {
        mViewBinding.CustomerBTN.setOnClickListener(this)
        mViewBinding.CatalogSerBTN.setOnClickListener(this)
        mViewBinding.TextSerchingBTN.setOnClickListener(this)
        mViewBinding.CustomerSerchingBTN.setOnClickListener(this)
    }


    private fun ManagerBox() {
        mViewBinding.generalSales.visibility = View.VISIBLE
    }

    private fun DataBox() {
        mViewBinding.indexArea.apply {
            text = "37"
        }

        mViewBinding.indexDay.apply {
            text = "66,168,168"
        }
        mViewBinding.indexMonth.apply {
            text = "168,168,168"
        }

        mViewBinding.indexDistrict.apply {
            text = "台北"
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.CustomerBTN         -> {
                gotoNextNavPage(R.id.action_nav_send_to_customer, null)
            }
            R.id.CatalogSerBTN       -> {
                gotoNextNavPage(R.id.action_nav_send_to_catalog, null)
            }
            R.id.TextSerchingBTN     -> {
                gotoNextNavPage(R.id.action_nav_send_to_textSerching, null)
            }
            R.id.CustomerSerchingBTN -> {
                gotoNextNavPage(R.id.action_nav_send_to_Sales_CustomerBySerching, null)
            }
            else                     -> {
                Toast.makeText(requireActivity().applicationContext, "Something was wrong !! please contact maxe 2213", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

}