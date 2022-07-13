package com.company.maxe.Login

//import com.company.maxe.Login.test.DialogBack
//import com.company.maxe.R
//import com.company.maxe.Tools.Device.Device
//import com.company.maxe.Tools.Tool
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.company.maxe.Tools.Device.Device
import com.company.maxe.Tools.Tool
import com.jekma.baselibrary.BaseFragment
import com.jekma.maxe.R
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : BaseFragment() {

    companion object{
        val fakeData =
            "[\n" + "{},\n" + "{\n" + "\"區別\":\"area\",\n" + "\"區域\":\"area2\"\n" + "},\n" + "{\n" + "\"總銷貨金額(月累積)\":88126643,\n" + "\"總銷貨金額(日)\":66438812\n" + "},\n" + "987654321\n" + "]"


        private var NavigationTAG = ""

        private lateinit var Employeer: Array<String?>
        private lateinit var Sales: Array<String?>

        fun PERSONAL(): Array<String?> {
            return Employeer
        }

        //
        fun sales(loginData: String?) {
            NavigationTAG = "$NavigationTAG->sales()"
            Sales = arrayOfNulls(4)
            try {
                val jsonArray = JSONArray(loginData)
                Sales[0] = Tool(jsonArray.getJSONObject(1).optString("區域")).checkNull //area
                Sales[1] = Tool(jsonArray.getJSONObject(1).optString("區別")).checkNull //district
                Sales[2] = Tool(jsonArray.getJSONObject(2).optString("總銷貨金額(月累積)")).checkNull //month
                Sales[3] = Tool(jsonArray.getJSONObject(2).optString("總銷貨金額(日)")).checkNull //day
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
        //
        private fun Basical(loginData: String?) {
            NavigationTAG = "$NavigationTAG->Basical()"
            try {
                Employeer = arrayOfNulls(14)
                val jsonArray = JSONArray(loginData)
                Employeer[0] = Tool(jsonArray.getJSONObject(0).optString("Android_NAME")).checkNull //name
                Employeer[1] = Tool(jsonArray.getJSONObject(0).optString("Android_Email")).checkNull //email
                Employeer[2] = Tool(jsonArray.getJSONObject(0).optString("部門")).checkNull
                //section
                Employeer[3] = Tool(jsonArray.getJSONObject(0).optString("職務類別")).checkNull
                //unit
                Employeer[4] = Tool(jsonArray.getJSONObject(0).optString("職位")).checkNull
                //highestUnit
                Employeer[5] = Tool(jsonArray.getJSONObject(0).optBoolean("Manager").toString()).checkNull
                //Manager
                Employeer[6] = Tool(jsonArray.getJSONObject(0).optString("萬士益(庫存)")).checkNull
                //stockMaxe
                Employeer[7] = Tool(jsonArray.getJSONObject(0).optString("副牌(庫存)")).checkNull
                //stockElse
                Employeer[8] = Tool(jsonArray.getJSONObject(0).optString("員工編號")).checkNull //WorkerNumber
                Employeer[9] = Tool(jsonArray.getJSONObject(0).optString("查詢庫存")).checkNull //Permission(sales_stock)
                Employeer[10] = Tool(jsonArray.getJSONObject(0).optString("查詢業績")).checkNull //Permission(sales_customer)
                Employeer[11] = Tool(jsonArray.getJSONObject(0).optString("查詢料號庫存")).checkNull //Permission(services_stock)
                Employeer[12] = Tool(jsonArray.getJSONObject(0).optString("查詢錯誤代碼")).checkNull //Permission(services_errorcode)
                Employeer[13] = Tool(jsonArray.getJSONObject(0).optString("部_分公司")).checkNull //Permission(services_errorcode)
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
    }
    fun SALES(loginData: String): Array<String?> {
        Sales = arrayOfNulls(4)
        val jsonArray = JSONArray(loginData)
        Log.e("SAKED",jsonArray.getJSONObject(1).optString("區域"))
        Sales[0] = Tool(jsonArray.getJSONObject(1).optString("區域")).checkNull //area
        Sales[1] = Tool(jsonArray.getJSONObject(1).optString("區別")).checkNull //district
        Sales[2] = Tool(jsonArray.getJSONObject(2).optString("總銷貨金額(月累積)")).checkNull //month
        Sales[3] = Tool(jsonArray.getJSONObject(2).optString("總銷貨金額(日)")).checkNull //day
        return Sales
    }


    private val TAG = "MainActivity"
//    private var mAppBarConfiguration: AppBarConfiguration? = null
//    private var toolbar: Toolbar? = null
//    private lateinit var navigationView: NavigationView
//    private var drawer: DrawerLayout? = null
//    var Destination: String? = null

//



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        run {
            NavigationTAG = TAG
            Log.d(NavigationTAG, "onCreate")
            ReceiveDataFromLoginActivity()
//            val User = Device(this, Employeer[8])
        }
        /*
        * default system code
        * */
//        system_code()
//
//        //header Data
//        headerData(navigationView)
//        ForDebug()
    }
//
//    private fun system_code() {
//        run {
//            toolbar = findViewById(R.id.toolbar)
//            setSupportActionBar(toolbar)
//            drawer = findViewById(R.id.drawer_layout)
//            navigationView = findViewById(R.id.nav_view)
//            mAppBarConfiguration = AppBarConfiguration.Builder(
//                    R.id.nav_home, R.id.nav_announcement, R.id.nav_slideshow,
//                    R.id.nav_tools, R.id.nav_share, R.id.nav_send)
//                    .setDrawerLayout(drawer)
//                    .build()
//            val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
//            NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration!!)
//            NavigationUI.setupWithNavController(navigationView, navController)
//            navController.addOnDestinationChangedListener { controller, destination, arguments -> Destination = destination.label as String? }
//        }
//    }
//
//    private fun ForDebug() {
////        for(int i=0;i<PERSONAL().length;i++){
////            Log.wtf(TAG,"PERSONAL["+i+"] = "+PERSONAL()[i]);
////        }
////
////        for(int i=0;i<SALES().length;i++){
////            Log.wtf(TAG,"SALES["+i+"] = "+SALES()[i]);
////        }
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.main, menu)
//        return true
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
//        return (NavigationUI.navigateUp(navController, mAppBarConfiguration!!)
//                || super.onSupportNavigateUp())
//    }
//
//    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
//        if (Destination == getString(R.string.menu_home)) {
//            if (keyCode == KeyEvent.KEYCODE_BACK) {
//                val test = DialogBack()
//                test.show(this)
//                return false
//            }
//        } else {
//        }
//        return super.onKeyDown(keyCode, event)
//    }
//
    /*
    * Reveice data from LoginActivity
    * */
    private fun ReceiveDataFromLoginActivity() {

    NavigationTAG = "$NavigationTAG->ReceiveDataFromLoginActivity()"
//        val bundle = intent.extras
//        if (bundle != null) {
//            val LoginData = bundle.getString("LoginData") //姓名
//            Log.wtf(NavigationTAG, "" + LoginData)
//            Basical(LoginData)
//            sales(fakeData)
//        } else {
//            Log.wtf(TAG, "Bundle is empty")
//        }
    }
//
//    /*
//    * set menu ( name + number ) and email
//    * */
//    private fun headerData(navigationView: NavigationView?) {
//        NavigationTAG = "$NavigationTAG->headerData()"
//        val headerview = navigationView!!.getHeaderView(0)
//        val name_number = headerview.findViewById<View>(R.id.name_number) as TextView
//        val email = headerview.findViewById<View>(R.id.email) as TextView
//        name_number.text = Employeer[0].toString() + " " + Employeer[8]
//        email.text = Employeer[1]
//    }
    override val titleResId: Int
        get() = R.string.maxe_title_main
    override val layoutResId: Int
        get() = R.layout.fragment_main
}