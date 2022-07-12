package com.jekma.maxe.login.index_menu.announcement

import android.app.Application
import android.graphics.Color
import android.os.Build
import android.text.TextUtils
import android.util.Log
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.jekma.baselibrary.BaseViewModel
import com.jekma.maxe.R
import org.json.JSONArray
import org.json.JSONObject


//import com.android.volley.VolleyError
//import com.company.maxe.Tools.Callback.IResult
//import com.company.maxe.Tools.URL.VolleyBridge
//import com.company.maxe.Tools.URL.VolleyService
//import com.kymjs.rxvolley.RxVolley
//import com.kymjs.rxvolley.client.HttpCallback
//import com.kymjs.rxvolley.client.HttpParams
//import com.kymjs.rxvolley.http.DefaultRetryPolicy
//import com.kymjs.rxvolley.http.RetryPolicy

@RequiresApi(Build.VERSION_CODES.Q)
class AnnouncementViewModel(application: Application) : BaseViewModel(application) {



    private var mActionListener:OnActionListener? = null

    interface OnActionListener{
        /**
         * 再新增子元素之前，先建置最外面的Scroll框架，再放入Layout容器
         */
        fun createElements(result: String)
    }

    fun setActionListener(listener:OnActionListener){
        mActionListener = listener
    }

    override fun create() {
        super.create()
        Log.d("Develop_","create")

        val msg = "[{title:1,Name:2,toWho:jacky,Create_at:1},{title:1,Name:2,toWho:jacky,Create_at:1}]"

        val obj = JSONObject()
        obj.put("Title","1")
        obj.put("Name","1")
        obj.put("toWho","1")
        obj.put("Create_at","1")
        val job = JSONArray()
        job.put(obj)
        mActionListener?.createElements(job.toString())
    }
//
//    /**
//     * 解析回來的資料，並動態新增元件
//     * @param result 回來的資料
//     */
//    private fun CreateElements(result: String) {
//
//
//    }
//
    /**
     * @param title 公告名稱
     * @param name 發佈人姓名
     * @param towho 發布對象
     * @param create_at 建立時間
     * @param Count 文章數量
     * @param maintable Layout容器
     *
     * 根據以上參數的數量，參數內容，動態新增相對應的元件，並放入Layout容器中
     * Layout請參考實際畫面
     */
    fun DynamicallyBuildOneSetLayout(Count: Int, title: String, name: String, towho: String, create_at: String, maintable: TableLayout) {
        Log.d("Develop_", "injectRow achieved")
        val tableRow = TableRow(getApplication())
        val tableParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
        tableRow.layoutParams = tableParams
        val Title = TextView(getApplication())
        val t1params = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT)
        Title.text = (Count + 1).toString() + "." + title
        Title.maxLines = 1
        Title.ellipsize = TextUtils.TruncateAt.END
        Title.textSize = 20f
        Title.setTextColor(Color.BLACK)
        Title.gravity = Gravity.CENTER_VERTICAL
        Title.layoutParams = t1params
        val Name = TextView(getApplication())
        val sign = TextView(getApplication())
        val toWho = TextView(getApplication())
        val Date = TextView(getApplication())
        Name.text = name
        val nameparams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.MATCH_PARENT)
        Name.layoutParams = nameparams
        Name.setTextColor(Color.BLACK)
        sign.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_arrow_forward_black_24dp, 0, 0, 0)
        sign.setTextColor(Color.BLACK)
        toWho.text = towho
        toWho.setTextColor(Color.BLACK)
        toWho.layoutParams = nameparams
        Date.text = create_at
        Date.setTextColor(Color.BLACK)
        Date.gravity = Gravity.RIGHT
        val lp123 = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT, 1F)
        Date.layoutParams = lp123
        val ll1 = LinearLayout(getApplication())
        ll1.orientation = LinearLayout.HORIZONTAL
        ll1.layoutParams = lp123
        ll1.addView(Name)
        ll1.addView(sign)
        ll1.addView(toWho)
        ll1.addView(Date)
        val ll2 = LinearLayout(getApplication())
        val t2params1 = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT, 1F)
        t2params1.setMargins(30, 15, 30, 0)
        ll2.orientation = LinearLayout.VERTICAL
        ll2.layoutParams = t2params1
        ll2.addView(Title)
        ll2.addView(ll1)
        tableRow.addView(ll2)
        tableRow.tag = Count // or entry.setTag(entry.index()), etc
        tableRow.setOnClickListener(getApplication()) //add OnClickListener Here
        maintable.addView(tableRow, TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT))
    }





//    /**
//     * 點選公告時，帶著索引值傳入到下一個Fragment裡面
//     */
//    override fun onClick(v: View) {
//        run {
//            Log.i("Develop_", "Clicked Announcement and index = ${v.tag as Int}")
//            val rowId = v.tag as Int
//            val bundle = Bundle()
//            bundle.putInt("index", rowId)
//
////            Navigation.findNavController(binding.root).navigate(R.id.action_nav_announcement_to_nav_content_announcefinal, bundle)
//        }
//    }

//    private val announcement=MutableLiveData<String>()
//
//    fun callInfo(userInput: String): LiveData<String> {
//        RxVolleyConnext(announcement,userInput)
//        return announcement
//    }
//    private fun RxVolleyConnext(announcement: MutableLiveData<String>, userInput: String) {
//
//        /**
//         * 設定Api網址
//         */
//        val url = VolleyBridge().Announcements()
//
//
//        /**
//         * 設定參數
//         */
//        val params = HttpParams()
//        //http header, optional parameters
//        params.putHeaders("cookie", "your cookie")
//        params.putHeaders("User-Agent", "rxvolley")
//        //http header, optional parameters
//        //request parameters
//        params.put("search", userInput)
//        //request parameters
//
//
//        /**
//         * Call Back 結果 並傳到liveData裡面
//         */
//        val callBack: HttpCallback = object : HttpCallback() {
//            override fun onSuccess(Response: String) {
//                Log.e(""Develop_"", "Suc and $Response")
//                announcement.postValue(Response)
//            }
//
//            override fun onFailure(errorNo: Int, strMsg: String) {
//                Log.e(""Develop_"", "Fai = { $errorNo } and Msg = $strMsg")
//            }
//        }
//
//
//        /**
//         * 連線到Api
//         */
//        RxVolley.Builder()
//                .url(url)
//                .httpMethod(RxVolley.Method.POST) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
//                .cacheTime(6) //default: get 5min, post 0min
//                .contentType(RxVolley.ContentType.FORM) //default FORM or JSON
//                .params(params)
//                .shouldCache(true) //default: get true, post false
//                .callback(callBack)
//                .encoding("UTF-8") //default
//                .retryPolicy(DefaultRetryPolicy(20 * 1000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT))
//                .doTask()
//    }

}