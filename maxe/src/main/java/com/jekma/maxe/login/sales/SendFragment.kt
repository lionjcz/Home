package com.jekma.maxe.login.sales

import android.app.Application
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
import com.jekma.baselibrary.BaseBindingFragment
import com.jekma.baselibrary.BaseFragment
import com.jekma.baselibrary.BaseViewModel
import com.jekma.maxe.R
import com.jekma.maxe.databinding.FragmentSendBinding
import org.json.JSONArray
import org.json.JSONException
import java.lang.Exception
import java.lang.NumberFormatException
import java.text.DecimalFormat

/**
 * 業務專區
 */
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

@RequiresApi(Build.VERSION_CODES.Q)
class SendViewModel(application: Application) : BaseViewModel(application) {
//
//    private val mResult: MutableLiveData<String>
//    private var string1234: MutableLiveData<String>? = null
//    private val TAG = getApplication<Application>().resources.getString(R.string.menu_send)
//    private var mResultCallback: IResult? = null
//    private val thisResult = "initial"
//    private val string = "initial"
//    private fun result() {
//        string1234 = MutableLiveData()
//        string1234!!.value = "changed"
//    }
//
//    private fun Api(application: Application) {
//        initVolleyCallback(TAG)
//        val volleyBridge = VolleyBridge()
//        val passData = HashMap<String, String>()
//        passData[""] = ""
//        val mVolleyService =
//            VolleyService(mResultCallback, passData, "Warn:SalesIndex Please Contact Maxe 2213")
//        mVolleyService.postDataVolley("POSTCALL", application, volleyBridge.Announcements(), thisResult)
//    }
//
//    /*
//     * Return Result
//     * */
//    private fun initVolleyCallback(TAG: String) {
//        mResultCallback = object : IResult {
//            override fun customError(ConnectErrorMessage: String) {
//                Toast.makeText(getApplication<Application>().applicationContext, "" + ConnectErrorMessage, Toast.LENGTH_SHORT)
//                    .show()
//            }
//
//            override fun notifySuccess(requestType: String, response: String) {
//                Log.wtf(TAG, "Volley requester $requestType")
//                //                Log.wtf(TAG, "Volley JSON post" + response);
//                mResult.value = response
//                //                RESULT(TAG,response);
//            }
//
//            fun notifyError(requestType: String, error: VolleyError?) {
//                Log.wtf(TAG, "Volley requester $requestType")
//                Log.wtf(TAG, "Volley JSON post" + "That didn't work!")
//            }
//        }
//    }
//
//    val text: LiveData<String>
//        get() = mResult
//
//    init {
//        Api(application)
//        mResult = MutableLiveData()
//        //        mResult.setValue("This is sales fragment");
//    }
}


class Manager : BaseFragment()
    , View.OnClickListener
//    OnTouchListener
{
    override val isShowMainBar: Boolean
        get() = true
    override val titleResId: Int
        get() = R.string.maxe_title_manager
    override val layoutResId: Int
        get() = R.layout.maxe_manager

    //
    private var scrollView: ScrollView? = null
    //    var Bu: Array<String?>
//    var Buleader: Array<String?>
//    var Bumoney: Array<String?>
    private var secondBoard: LinearLayout? = null
    private var Dynamically: LinearLayout? = null
    private var buttonboard: LinearLayout? = null
    //    private var mainlayout: LinearLayout? = null
//    private var index: String? = null
//    private var Singleindex: String? = null
//    private var sector: String? = null
//    private var Unit: String? = null
//    private var highest: String? = null
    private var switcher = ""
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        switcher = "singleDepartment"
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        elements(view)
        All("sector")

    }
    //    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val root: View = inflater.inflate(R.layout.manager, container, false)
//        elements(root)
//        val arguments: Bundle? = arguments
//        //        String index = "nulll";
//        var Manager: Boolean? = false
//        if (arguments == null) {
//        }
//        else {
//            index = arguments.getString("index") //主管
//            Singleindex = arguments.getString("index") //主管
//            sector = arguments.getString("部門") //主管
//            Unit = arguments.getString("職務類別") //主管
//            highest = arguments.getString("最高職位") //主管
//            Manager = java.lang.Boolean.valueOf(arguments.getString("主管"))
//        }
//        when (sector) {
//            "業務銷售本部" -> All(sector)
//            else     -> {
//                switcher = "singleDepartment"
//            }
//        }
//        return root
//    }
//
    /*
    * Listen all elements Onclickevent
    * */
    override fun onClick(v: View) {
        if (v is Button) {
            ButtonType(v)
        }
        else if (v is LinearLayout) {
            LinearLayoutType(v)
        }
        else {
            Toast.makeText(requireActivity().applicationContext, "Could not get your listener type please try again or contact maxe#2213", Toast.LENGTH_SHORT)
                .show()
        }
    }
    //
//    /*
//    * index
//    * */
    private fun All(MANAGER: String?) {
        parsing(MANAGER)
    }
    //
    /*
    * Get all elements ID
    * */
    private fun elements(root: View) {
        secondBoard = root.findViewById<LinearLayout>(R.id.secondBoard)
        buttonboard = root.findViewById<LinearLayout>(R.id.buttonboard)
        Dynamically = root.findViewById<LinearLayout>(R.id.Dynamically)
        scrollView = root.findViewById<ScrollView>(R.id.scrollView)
//        mainlayout = root.findViewById<LinearLayout>(R.id.mainlayout)
    }
    //
    /*
    * Dynamically append Button and HeaderView
    * */
    private fun buttonboard(text: String?) {
        buttonboard?.addView(ButtonCustom(text))
    }
    //
    /*
    * Customize
    *   TextView
    *       Bu ,
    *       Bu turnover ,
    *       Bu leaders ,
    *       District ,
    *       Employeer ,
    *       DynamicallyEmployeer
    *   Button
    *       ButtonCustom
    * */
    private fun Bu(Bu_parameter: String?): TextView {
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1F)
        val textView = TextView(requireActivity().applicationContext)
        textView.setText(Bu_parameter)
        textView.setGravity(Gravity.CENTER)
        textView.setTextSize(30f)
        layoutParams.setMargins(0, 0, 0, 0)
        TextViewCompat.setAutoSizeTextTypeWithDefaults(textView, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
        textView.setLines(1)
        textView.setTextColor(resources.getColor(R.color.maxe_black))
        textView.setLayoutParams(layoutParams)
        return textView
    }
    //
//    private fun Bu_leaders(Bu_parameter: String?): TextView {
//        val layoutParams: LinearLayout.LayoutParams =
//            LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1)
//        val textView = TextView(activity!!.applicationContext)
//        textView.setText(Bu_parameter)
//        textView.setGravity(Gravity.CENTER)
//        textView.setTextSize(30f)
//        layoutParams.setMargins(0, 0, 0, 0)
//        TextViewCompat.setAutoSizeTextTypeWithDefaults(textView, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
//        textView.setLines(1)
//        textView.setTextColor(resources.getColor(R.color.black))
//        textView.setLayoutParams(layoutParams)
//        return textView
//    }
//
//    private fun Bu_turnover(Bu_parameter: String?): TextView {
//        val layoutParams: LinearLayout.LayoutParams =
//            LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 2)
//        val textView = TextView(activity!!.applicationContext)
//        textView.setText(Format(Bu_parameter))
//        textView.setGravity(Gravity.CENTER)
//        textView.setTextSize(30f)
//        layoutParams.setMargins(0, 0, 0, 0)
//        TextViewCompat.setAutoSizeTextTypeWithDefaults(textView, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
//        textView.setLines(1)
//        textView.setTextColor(resources.getColor(R.color.black))
//        textView.setLayoutParams(layoutParams)
//        return textView
//    }
//
    private fun District(district: String?): TextView {
        var district = district
        val District = TextView(requireActivity().applicationContext)
        District.setGravity(Gravity.CENTER)
        val layoutParams: LinearLayout.LayoutParams
        if (district == null) {
            district = "null"
        }
        District.setText(district)
        try {
            district = district
        } catch (nfe: NumberFormatException) {
            nfe.message
        }
//        if (district == "台北業務一部" || district == "台北業務二部") {
//            District.setTextSize(20f)
//            District.setTextColor(resources.getColor(R.color.orchid))
//        }
//        else if (district == null) {
//            District.setTextColor(Color.RED)
//            district = "null"
//        }
//        else {
        District.setTextColor(Color.BLUE)
        District.setTextSize(20f)
//        }
        TextViewCompat.setAutoSizeTextTypeWithDefaults(District, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
        District.setMaxLines(1)
        if (switcher == "singleDepartment") {
            layoutParams =
                LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1F)
            District.setLayoutParams(layoutParams)
        }
        else {
            layoutParams =
                LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1F)
            District.setLayoutParams(layoutParams)
        }
        return District
    }
    //
    private fun Employeer(name: String): TextView {
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1F)
        val Employeer = TextView(requireActivity().applicationContext)
        Employeer.setText(name)
        Employeer.setGravity(Gravity.CENTER)
        Employeer.setTextSize(25f)
        layoutParams.setMargins(0, 0, 0, 0)
        TextViewCompat.setAutoSizeTextTypeWithDefaults(Employeer, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
        Employeer.setLines(1)
        Employeer.setTextColor(resources.getColor(R.color.maxe_black))
        Employeer.setLayoutParams(layoutParams)
        return Employeer
    }

    private fun DynamicallyEmployeer(name: String?): TextView {
        var name = name
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1F)
        val Employeer = TextView(requireActivity().applicationContext)
        if (name == null) {
            name = "null"
        }
        try {
            val d = name.toDouble()
            name = name
        } catch (nfe: NumberFormatException) {
            nfe.message
        }
        Employeer.setText(name)
        Employeer.setGravity(Gravity.CENTER)
        Employeer.setTextSize(25f)
        TextViewCompat.setAutoSizeTextTypeWithDefaults(Employeer, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
        Employeer.setLines(1)
        Employeer.setTextColor(resources.getColor(R.color.maxe_black))
        Employeer.setLayoutParams(layoutParams)
        return Employeer
    }

    private fun ButtonCustom(text: String?): Button {
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1F)
        layoutParams.setMargins(10, 10, 10, 10)
        val button = Button(requireActivity().applicationContext)
        button.textSize = 30f
        button.layoutParams = layoutParams
        button.text = text
        button.tag = text
        button.setOnClickListener(this)
        return button
    }

    //Parsing Data
    fun parsingDepartment(department: String?, b: Int) {
        var EmployeerlayoutStyle1: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        when ("sector") {
            "業務銷售本部" -> {
//                    var j = 0
//                    while (j < jsonArray1.length()) {
//                        val Department: String = jsonArray1.getJSONObject(j).getString("區域")
//                        when (Department) {
//                            "台北總公司" -> {
//                                val Taipei_department =
//                                    JSONArray(jsonArray1.getJSONObject(j).getString(Department))
//                                insertDepartment(Department)
//                                var i = 0
//                                while (i < Taipei_department.length()) {
//                                    val Taipei_group: String =
//                                        Taipei_department.getJSONObject(i).getString("Area")
//                                    insertDepartment(Taipei_group)
//                                    val jsonArray2 =
//                                        JSONArray(jsonArray1.getJSONObject(j).getString(Department))
//                                    val ss: String =
//                                        jsonArray2.getJSONObject(i).getString(Taipei_group)
//                                    val personal = JSONArray(ss)
//                                    var q = 0
//                                    while (q < personal.length()) {
//                                        val number: String =
//                                            personal.getJSONObject(q).getString("區別")
//                                        val name: String =
//                                            personal.getJSONObject(q).getString("業務姓名")
//                                        val Employeerlayout =
//                                            LinearLayout(activity!!.applicationContext)
//                                        Employeerlayout.setOrientation(LinearLayout.VERTICAL)
//                                        Employeerlayout.setLayoutParams(EmployeerlayoutStyle1)
//                                        val Employeer_all =
//                                            LinearLayout(activity!!.applicationContext)
//                                        Employeer_all.setOrientation(LinearLayout.HORIZONTAL)
//                                        Employeer_all.setLayoutParams(EmployeerlayoutStyle1)
//                                        Employeer_all.addView(Employeer("區碼"))
//                                        Employeer_all.addView(Employeer(number))
//                                        Employeer_all.addView(Employeer("姓名"))
//                                        Employeer_all.addView(Employeer(name))
//                                        Employeerlayout.addView(Employeer_all)
//                                        secondBoard.addView(Employeerlayout)
//                                        q++
//                                    }
//                                    i++
//                                }
//                            }
//                            else    -> {
//                                val jsonArray2 =
//                                    JSONArray(jsonArray1.getJSONObject(j).getString(Department))
//                                insertDepartment(Department)
//                                var q = 0
//                                while (q < jsonArray2.length() - 1) {
//                                    EmployeerlayoutStyle1 =
//                                        LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
//                                    val number: String = jsonArray2.getJSONObject(q).getString("區別")
//                                    val name: String = jsonArray2.getJSONObject(q).getString("業務姓名")
//                                    val Employeerlayout =
//                                        LinearLayout(activity!!.applicationContext)
//                                    Employeerlayout.setOrientation(LinearLayout.VERTICAL)
//                                    Employeerlayout.setLayoutParams(EmployeerlayoutStyle1)
//                                    val Employeer_all = LinearLayout(activity!!.applicationContext)
//                                    Employeer_all.setOrientation(LinearLayout.HORIZONTAL)
//                                    Employeer_all.setLayoutParams(EmployeerlayoutStyle1)
//                                    Employeer_all.addView(Employeer("區碼"))
//                                    Employeer_all.addView(Employeer(number))
//                                    Employeer_all.addView(Employeer("姓名"))
//                                    Employeer_all.addView(Employeer(name))
//                                    Employeerlayout.addView(Employeer_all)
//                                    secondBoard.addView(Employeerlayout)
//                                    q++
//                                }
//                            }
//                        }
//                        j++
//                    }
            }
            else     -> {
                var j = 0
                while (j < 4) {
                    val number: String = "區別"
                    val name: String = "業務姓名"
                    EmployeerlayoutStyle1 =
                        LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
                    val Employeerlayout = LinearLayout(requireActivity().applicationContext)
                    Employeerlayout.setOrientation(LinearLayout.VERTICAL)
                    Employeerlayout.setLayoutParams(EmployeerlayoutStyle1)
                    val Employeer_all = LinearLayout(requireActivity().applicationContext)
                    Employeer_all.setOrientation(LinearLayout.HORIZONTAL)
                    Employeer_all.setLayoutParams(EmployeerlayoutStyle1)
                    Employeer_all.addView(Employeer("區碼"))
                    Employeer_all.addView(Employeer(number))
                    Employeer_all.addView(Employeer("姓名"))
                    Employeer_all.addView(Employeer(name))
                    Employeerlayout.addView(Employeer_all)
                    secondBoard?.addView(Employeerlayout)
                    j++
                }
            }
        }
    }
    //
//    private fun insertDepartment(department: String) {
//        val EmployeerlayoutStyle1: LinearLayout.LayoutParams =
//            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
//        val Districtlayout = LinearLayout(activity!!.applicationContext)
//        Districtlayout.setOrientation(LinearLayout.VERTICAL)
//        Districtlayout.setLayoutParams(EmployeerlayoutStyle1)
//        Districtlayout.addView(District(department))
//        secondBoard.addView(Districtlayout)
//    }
//
//    private fun parsing_and_getBU(Bu: String, Singleindex: String?) {
////        val index: Int
////        val h = 0
////        try {
////            val jsonArray = JSONArray(Singleindex)
////            index = getIndex(Bu, jsonArray)
////            val singleLeader: String = jsonArray.getJSONObject(index).getString("主管")
////            val singleTurnover: String = jsonArray.getJSONObject(index).getString("0")
//            val secondBoard_style: LinearLayout.LayoutParams =
//                LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
//            val secondBoard1 = LinearLayout(requireActivity().applicationContext)
//            secondBoard1.setOrientation(LinearLayout.HORIZONTAL)
//            secondBoard1.setLayoutParams(secondBoard_style)
//            secondBoard1.setBackgroundColor(Color.YELLOW)
//            secondBoard?.addView(secondBoard1)
////                "業務銷售本部" -> {
////                    run {
////                        secondBoard1.addView(Bu(Bu))
////                        secondBoard1.addView(Bu_leaders(singleLeader))
////                        secondBoard1.addView(Bu_turnover(singleTurnover))
////                    }
////                            Layout(SingleDepartment)
////                            var k = 0
////                            while (k < SingleDepartment_jsonArray.length()) {
////                                val area: String =
////                                    SingleDepartment_jsonArray.getJSONObject(k).getString("Area")
////                                val saasd: String =
////                                    SingleDepartment_jsonArray.getJSONObject(k).getString(area)
////                                val jsonArray1 = JSONArray(saasd)
////                                Log.wtf("Developing", "jsonArray1$jsonArray1")
////                                Layout(area)
////                                var l = 0
////                                while (l < jsonArray1.length()) {
////                                    val SglEmplyr_area: String =
////                                        jsonArray1.getJSONObject(l).getString("區別")
////                                    val SglEmplyr_name: String =
////                                        jsonArray1.getJSONObject(l).getString("業務姓名")
////                                    Log.wtf("Developing", "SglEmplyr_area$SglEmplyr_area")
////                                    Log.wtf("Developing", "SglEmplyr_name$SglEmplyr_name")
////                                    val selected: JSONObject = jsonArray1.getJSONObject(l)
////                                    val EmployeerlayoutStyle: LinearLayout.LayoutParams =
////                                        LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
////                                    val Employeerlayout =
////                                        LinearLayout(activity!!.applicationContext)
////                                    Employeerlayout.setOrientation(LinearLayout.VERTICAL)
////                                    Employeerlayout.setLayoutParams(EmployeerlayoutStyle)
////                                    val EmployeerlayoutStyle2345: LinearLayout.LayoutParams =
////                                        LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
////                                    val EmployeerlayoutFOR =
////                                        LinearLayout(activity!!.applicationContext)
////                                    EmployeerlayoutFOR.setTag(selected)
////                                    EmployeerlayoutFOR.setOnClickListener(this)
////                                    EmployeerlayoutFOR.setOrientation(LinearLayout.HORIZONTAL)
////                                    EmployeerlayoutFOR.setLayoutParams(EmployeerlayoutStyle2345)
////                                    EmployeerlayoutFOR.addView(Employeer("區碼"))
////                                    EmployeerlayoutFOR.addView(Employeer(SglEmplyr_area))
////                                    EmployeerlayoutFOR.setOnTouchListener(this)
////                                    EmployeerlayoutFOR.addView(Employeer("姓名"))
////                                    EmployeerlayoutFOR.addView(Employeer(SglEmplyr_name))
////                                    Employeerlayout.addView(EmployeerlayoutFOR)
////                                    secondBoard.addView(Employeerlayout)
////                                    l++
////                                }
////                                k++
////                            }
////                        }
////                        else {
////                            val SingleDepartment_Obj: JSONObject = tmpBu.getJSONObject(i)
////                            val SingleDepartment_jsonArray: JSONArray =
////                                SingleDepartment_Obj.getJSONArray(SingleDepartment)
////                            Layout(SingleDepartment)
////                            var j = 0
////                            while (j < SingleDepartment_jsonArray.length() - 1) {
////                                val SglEmplyr_area: String =
////                                    SingleDepartment_jsonArray.getJSONObject(j).getString("區別")
////                                val SglEmplyr_name: String =
////                                    SingleDepartment_jsonArray.getJSONObject(j).getString("業務姓名")
////                                val selected: JSONObject =
////                                    SingleDepartment_jsonArray.getJSONObject(j)
////                                val EmployeerlayoutStyle: LinearLayout.LayoutParams =
////                                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
////                                val Employeerlayout = LinearLayout(activity!!.applicationContext)
////                                Employeerlayout.setOrientation(LinearLayout.VERTICAL)
////                                Employeerlayout.setLayoutParams(EmployeerlayoutStyle)
////                                val EmployeerlayoutStyle2345: LinearLayout.LayoutParams =
////                                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
////                                val EmployeerlayoutFOR = LinearLayout(activity!!.applicationContext)
////                                EmployeerlayoutFOR.setTag(selected)
////                                EmployeerlayoutFOR.setOnClickListener(this)
////                                EmployeerlayoutFOR.setOrientation(LinearLayout.HORIZONTAL)
////                                EmployeerlayoutFOR.setLayoutParams(EmployeerlayoutStyle2345)
////                                EmployeerlayoutFOR.addView(Employeer("區碼"))
////                                EmployeerlayoutFOR.addView(Employeer(SglEmplyr_area))
////                                EmployeerlayoutFOR.setOnTouchListener(this)
////                                EmployeerlayoutFOR.addView(Employeer("姓名"))
////                                EmployeerlayoutFOR.addView(Employeer(SglEmplyr_name))
////                                Employeerlayout.addView(EmployeerlayoutFOR)
////                                secondBoard.addView(Employeerlayout)
////                                j++
////                            }
////                        }
////                        i++
////                    }
////                }
////                else     -> {
////                    run {
////                        secondBoard1.addView(District("Bu"))
////                        secondBoard1.addView(District("singleLeader"))
////                        secondBoard1.addView(District("Format(singleTurnover)"))
////                    }
////                    run {
////                        var i = 0
////                        while (i < 3) {
////                            val area: String = "區別"
////                            val name: String = "業務姓名"
////                            //member Linearlauout framework
////                            run {
////                                val EmployeerlayoutFOR = LinearLayout(requireActivity().applicationContext)
////                                val EmployeerlayoutStyle: LinearLayout.LayoutParams =
////                                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
////                                val Employeerlayout = LinearLayout(requireActivity().applicationContext)
////                                Employeerlayout.setOrientation(LinearLayout.VERTICAL)
////                                Employeerlayout.setLayoutParams(EmployeerlayoutStyle)
////                                val EmployeerlayoutStyle2345: LinearLayout.LayoutParams =
////                                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
////                                EmployeerlayoutFOR.setLayoutParams(EmployeerlayoutStyle2345)
////                                EmployeerlayoutFOR.setTag(i)
////                                EmployeerlayoutFOR.setOnClickListener(this)
////                                EmployeerlayoutFOR.setOrientation(LinearLayout.HORIZONTAL)
////                                EmployeerlayoutFOR.addView(Employeer("區碼"))
////                                EmployeerlayoutFOR.addView(Employeer(area))
//////                                EmployeerlayoutFOR.setOnTouchListener(this)
////                                EmployeerlayoutFOR.addView(Employeer("姓名"))
////                                EmployeerlayoutFOR.addView(Employeer(name))
////                                Employeerlayout.addView(EmployeerlayoutFOR)
////                                secondBoard?.addView(Employeerlayout)
////                            }
////                            Log.wtf("Debug", "區碼:$area, 姓名$name")
////                            i++
////                        }
////                    }
////                }
////            }
////        } catch (e: JSONException) {
////            e.printStackTrace()
////            Log.wtf("Developing", "" + e)
////        }
//    }
//
    private fun Layout(singleDepartment: String) {
        val EmployeerlayoutStyle1: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        val Districtlayout = LinearLayout(requireActivity().applicationContext)
        Districtlayout.setOrientation(LinearLayout.VERTICAL)
        Districtlayout.setLayoutParams(EmployeerlayoutStyle1)
        Districtlayout.addView(District(singleDepartment))
        secondBoard?.addView(Districtlayout)
    }
    //
//    fun parsingBu(BU: String?): JSONArray? {
//        var AllBu: JSONArray? = null
//        try {
//            AllBu = JSONArray(BU)
//            val length: Int = AllBu.length()
//            Bu = arrayOfNulls(length)
//            Bumoney = arrayOfNulls(length)
//            Buleader = arrayOfNulls(length)
//            for (i in Bu.indices) {
//                Bu[i] = AllBu.getJSONObject(i).getString("單位")
//                Bumoney[i] = AllBu.getJSONObject(i).getString("0")
//                Buleader[i] = AllBu.getJSONObject(i).getString("主管")
//            }
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//        return AllBu
//    }
//
    private fun parsing(MANAGER: String?) {
//        val tmpDepartment: JSONArray? = parsingBu(manager)
        when (MANAGER) {
            "業務銷售本部" -> {
//                var b = 0
//                while (b < Bu.size) {
//                    val secondBoard_style: LinearLayout.LayoutParams =
//                        LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
//                    val secondBoard1 = LinearLayout(activity!!.applicationContext)
//                    secondBoard1.setWeightSum(4f)
//                    secondBoard1.setOrientation(LinearLayout.HORIZONTAL)
//                    secondBoard1.setLayoutParams(secondBoard_style)
//                    buttonboard(Bu[b])
//                    secondBoard1.addView(Bu(Bu[b]))
//                    secondBoard1.addView(Bu_leaders(Buleader[b]))
//                    secondBoard1.addView(Bu_turnover(Bumoney[b]))
//                    secondBoard1.setBackgroundColor(Color.YELLOW)
//                    secondBoard.addView(secondBoard1)
//                    parsingDepartment(Bu[b], tmpDepartment, b)
//                    b++
//                }
//                buttonboard.addView(ButtonCustom("全部"))
            }
            else     -> {
                var b = 0
                while (b < 3) {
                    val secondBoard_style: LinearLayout.LayoutParams =
                        LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                    val secondBoard1 = LinearLayout(requireActivity().applicationContext)
                    secondBoard1.setWeightSum(4F);
                    secondBoard1.setBackgroundColor(Color.YELLOW)
                    secondBoard1.setOrientation(LinearLayout.HORIZONTAL)
                    secondBoard1.setLayoutParams(secondBoard_style)
                    buttonboard("Bu $b")
                    secondBoard1.addView(District("Bu $b"))
                    secondBoard1.addView(District("Buleader[$b]"))
                    secondBoard1.addView(District("Format(Bumoney[$b])"))
                    secondBoard?.addView(secondBoard1)
                    parsingDepartment("Bu[b]", b)
                    b++
                }
                buttonboard?.addView(ButtonCustom("全部"))
            }
        }
    }
    //
//    fun Format(wantFormat: String?): String {
//        val decimalFormat = DecimalFormat(",###")
//        return decimalFormat.format(wantFormat!!.toDouble())
//    }
//
    /*
    * The following functions execute after onClick
    *   ButtonType: get tag from v that from onClick and
    *               dynamically remove previous data and insert new data on index...
    *   LinearLayoutType: get tag from v that from onClick and
    *               dynamically remove previous append data and insert new data below index...
    *
    * */
    private fun ButtonType(v: View) {
        val button = v as Button
        val tag = button.tag
        secondBoard?.removeAllViews()
        Dynamically?.removeAllViews()
        if ("全部" == tag) {
            Toast.makeText(requireActivity().applicationContext, "資料已更新", Toast.LENGTH_SHORT).show()
            buttonboard?.removeAllViews()
            All("sector")
        }
        else {
            Toast.makeText(requireActivity().applicationContext, "資料已更新", Toast.LENGTH_SHORT).show()
//            parsing_and_getBU(tag.toString(), Singleindex)
        }
    }

    private fun LinearLayoutType(v: View) {
        Dynamically?.removeAllViews()
        val linearLayout: LinearLayout = v as LinearLayout
//        linearLayout.setOnTouchListener(this)
        val tag: Any = linearLayout.getTag()
        Log.wtf("singleBU", "linearlayout tag = $tag")
        DynamicallyInputSelected(tag.toString())
        //        scrollView.smoothScrollTo(0, mainlayout.getBottom());
        scrollView?.post(Runnable { scrollView?.fullScroll(ScrollView.FOCUS_DOWN) })
    }
    //
    private fun DynamicallyInputSelected(s: String) {
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1F)
        layoutParams.setMargins(50, 50, 50, 50)
        val linearLayout = LinearLayout(requireActivity().applicationContext)
        linearLayout.setBackgroundColor(resources.getColor(R.color.maxe_maroon))
        linearLayout.setLayoutParams(layoutParams)
        linearLayout.setOrientation(LinearLayout.VERTICAL)
        linearLayout.setPadding(0, 20, 0, 0)
        try {
//            finalperson[0] = "區別"
//            finalperson[1] = "業務姓名"
//            finalperson[2] = "總銷貨數量(日)"
//            finalperson[3] = "總銷貨金額(日)"
//            finalperson[4] = "總銷貨數量(月累積)"
//            finalperson[5] = "總銷貨金額(月累積)"
            for (i in 0 until 3) {
                val layoutParams1: LinearLayout.LayoutParams =
                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1F)
                layoutParams1.setMargins(20, 0, 20, 20)
                val linearLayout1 = LinearLayout(requireActivity().applicationContext)
                linearLayout1.setBackgroundColor(Color.WHITE)
                linearLayout1.setLayoutParams(layoutParams1)
                linearLayout1.setOrientation(LinearLayout.HORIZONTAL)
                linearLayout1.addView(DynamicallyEmployeer("finalperson[i]"))
                linearLayout1.addView(DynamicallyEmployeer("jsonObject.getString(finalperson[i])"))
                linearLayout.addView(linearLayout1)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        Dynamically?.addView(linearLayout)
    }
//
//    private fun getIndex(bu: String, jsonArray: JSONArray): Int {
//        var index = 0
//        for (i in 0 until jsonArray.length()) {
//            try {
//                val Serching: String = jsonArray.getJSONObject(i).getString("單位")
//                if (Serching == bu) {
//                    index = i
//                    break
//                }
//                else {
//                    index = -1
//                }
//            } catch (e: JSONException) {
//                e.printStackTrace()
//            }
//        }
//        return index
//    }
//
//    override fun onTouch(v: View, event: MotionEvent): Boolean {
//        val color = Color.TRANSPARENT
//        val linearLayout: LinearLayout = v as LinearLayout
//        when (event.getAction()) {
//            MotionEvent.ACTION_DOWN   -> {
//                Log.wtf("Testing", "ACTION_DOWN")
//                linearLayout.setBackgroundColor(resources.getColor(R.color.gray))
//            }
//            MotionEvent.ACTION_UP     -> {
//                Log.wtf("Testing", "ACTION_UP")
//                linearLayout.setBackgroundColor(color)
//            }
//            MotionEvent.ACTION_MOVE   -> {
//                Log.wtf("Testing", "ACTION_MOVE")
//                linearLayout.setBackgroundColor(color)
//            }
//            MotionEvent.ACTION_CANCEL -> {
//                Log.wtf("Testing", "ACTION_CANCEL")
//                linearLayout.setBackgroundColor(color)
//            }
//        }
//        return false
//    }
}