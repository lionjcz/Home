package com.jekma.maxe.login.announcement

import android.app.Application
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import com.jekma.maxe.tools.url.VolleyBridge
import com.jekma.baselibrary.BaseBindingFragment
import com.jekma.baselibrary.BaseViewModel
import com.jekma.maxe.R
import com.jekma.maxe.databinding.ContentAnnounceFinalBinding
import com.jekma.maxe.databinding.MaxeFragmentAnnounceBinding
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.lang.Exception

@RequiresApi(Build.VERSION_CODES.Q)
class AnnouncementFragment : BaseBindingFragment<MaxeFragmentAnnounceBinding,AnnouncementViewModel>() {

    private lateinit var announcements_result: Array<Array<String?>>

    override val isShowMainBar: Boolean get() = true

    override val titleResId: Int get() = R.string.maxe_title_announcement

    override val layoutResId: Int get() = R.layout.maxe_fragment_announce

    override var permissionOnViewListener: PermissionOnView? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel.setActionListener(object:AnnouncementViewModel.OnActionListener{
            override fun createElements(result: String) {
                Log.d("Develop_","建立ScrollView框架")
                var framwork = mViewBinding.maintable //建立ScrollView框架
                framwork.removeAllViews() // 針對使用者點選上一頁而重複新增問題，這邊加入移除語法來排除問題
                var maintable = TableLayout(requireContext())//建立Layout容器
                framwork.addView(maintable) //放入ScrollView框架
                try {
                    val Response = JSONArray(result)
                    announcements_result = Array(Response.length()) { arrayOfNulls<String>(4) }
                    for (AnnouncementCount in 0 until Response.length()) {
                        announcements_result[AnnouncementCount][0] = Response.getJSONObject(AnnouncementCount).getString("Title")
                        announcements_result[AnnouncementCount][1] = Response.getJSONObject(AnnouncementCount).getString("Name")
                        announcements_result[AnnouncementCount][2] = Response.getJSONObject(AnnouncementCount).getString("toWho")
                        announcements_result[AnnouncementCount][3] = Response.getJSONObject(AnnouncementCount).getString("Create_at")
                        mViewModel.DynamicallyBuildOneSetLayout(
                            AnnouncementCount,
                            Response.getJSONObject(AnnouncementCount).getString("Title"),
                            Response.getJSONObject(AnnouncementCount).getString("Name"),
                            Response.getJSONObject(AnnouncementCount).getString("toWho"),
                            Response.getJSONObject(AnnouncementCount).getString("Create_at"),
                            maintable
                        )
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                    Toast.makeText(requireContext(), "發生異常，請聯絡 2901-5588 分機 2213", Toast.LENGTH_LONG).show()
                }
            }

            override fun onClick(bundle: Bundle) {
                gotoNextNavPage(R.id.action_nav_announcement_to_nav_content_announcefinal,bundle)
            }
        })
        mViewModel.create()
        mViewBinding.vm = mViewModel
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
class AnnouncementViewModel(application: Application) : BaseViewModel(application),View.OnClickListener {

    companion object{
        fun fakeData(): String {
            val job = JSONArray()
            for (i in 0 .. 9 ){
                val obj = JSONObject()
                obj.put("Title","公告標題$i")
                obj.put("Name","公告名稱$i")
                obj.put("toWho","對誰發布$i")
                obj.put("Create_at","2022/4/2$i")
                obj.put("Content","在萬事益的公告$i")
                job.put(obj)
            }
            return job.toString()
        }
    }


    private var mActionListener: OnActionListener? = null

    interface OnActionListener{
        /**
         * 再新增子元素之前，先建置最外面的Scroll框架，再放入Layout容器
         */
        fun createElements(result: String)
        fun onClick(bundle: Bundle)
    }

    fun setActionListener(listener: OnActionListener){
        mActionListener = listener
    }

    /**
     * Fake Data
     */
    override fun create() {
        super.create()
        Log.d("Develop_","create")


        mActionListener?.createElements(fakeData())
    }
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
        try {

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
            sign.setCompoundDrawablesWithIntrinsicBounds(R.drawable.maxe_ic_arrow_forward_black_24dp, 0, 0, 0)
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
            tableRow.setOnClickListener(this) //add OnClickListener Here
            maintable.addView(tableRow, TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT))
        }catch (e: Exception){
            e.printStackTrace()
            Log.e("Develop_", "${e.message}")
        }
    }


    /**
     * 點選公告時，帶著索引值傳入到下一個Fragment裡面
     */
    override fun onClick(v: View) {
        Log.i("Develop_", "Clicked Announcement and index = ${v.tag as Int}")
        val rowId = v.tag as Int
        val bundle = Bundle()
        bundle.putInt("index", rowId)
        mActionListener?.onClick(bundle)
    }

}

@RequiresApi(Build.VERSION_CODES.Q)
class Content : BaseBindingFragment<ContentAnnounceFinalBinding, ContentViewModel>() {

    override val titleResId: Int
        get() = R.string.maxe_title_announce_content
    override val layoutResId: Int
        get() = R.layout.maxe_content_announcefinal

    override val isShowMainBar: Boolean
        get() = true
    override var permissionOnViewListener: PermissionOnView? = null

    /**
     * 必要元素
     */
    private lateinit var title: TextView
    private lateinit var name: TextView
    private lateinit var towho: TextView
    private lateinit var date: TextView
    private lateinit var content: TextView


    /**
     * 接收來自AnnouncementFragment丟過來的索引，並判斷是否為空
     *
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    /**
     * 假資料
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.setActionListener(object : ContentViewModel.OnActionListener {
            override fun HttpCallback(response: String, index: Int) {
                ParsingData(response, index)
                Log.d("Develop_", "The response is  {$response} at observe mode in Fragment:${javaClass.simpleName},index:$index")
            }
        })
        mViewModel.create()
        val arguments = arguments
        if (arguments == null) {
            Log.d("Develop_arguments","0")
            /**
             * 空值
             */
        } else {
            Log.d("Develop_arguments","1")
            /**
             * 不是空值
             */
            init()
            val index = arguments.getInt("index")
            CallViewModel(index, AnnouncementViewModel.fakeData())
        }
        mViewBinding.vm = mViewModel
    }

    private fun init() {
        title = mViewBinding.ContentTitle
        name = mViewBinding.ContentName
        towho = mViewBinding.ContentTowho
        date = mViewBinding.ContentDate
        content = mViewBinding.ContentContent
    }

    /**
     * Communicate with viewModel,call api
     */
    private fun CallViewModel(index: Int, fakeData: String) {
        mViewModel.callInfo(index, VolleyBridge().Announcements(),fakeData)
    }

    /**
     * @param result 所有文章內容
     * @param index 文章索引
     * Parsing Result
     */
    private fun ParsingData(result: String, index: Int) {

        try {
            val Response = JSONArray(result)
            val announcements_result = Array(Response.length()) { arrayOfNulls<String>(5) }
            for (i in 0 until Response.length()) {
                announcements_result[i][0] = Response.getJSONObject(i).getString("Title")
                announcements_result[i][1] = Response.getJSONObject(i).getString("Name")
                announcements_result[i][2] = Response.getJSONObject(i).getString("toWho")
                announcements_result[i][3] = Response.getJSONObject(i).getString("Create_at")
                announcements_result[i][4] = Response.getJSONObject(i).getString("Content")
            }

            /**
             * 將資料呈現致UI
             */
            FillIntoUI(
                announcements_result[index][0]!!,
                announcements_result[index][1]!!,
                announcements_result[index][2]!!,
                announcements_result[index][3]!!,
                announcements_result[index][4]!!.replace("<br />", "\n")
            )
        } catch (e: JSONException) {
            e.printStackTrace()
            Toast.makeText(requireActivity().applicationContext, "查無型號", Toast.LENGTH_LONG).show()
        }
    }

    /**
     * @param title   文章標題
     * @param name    文章姓名
     * @param towho   發布對象
     * @param date    建立日期
     * @param content 文章內容
     * 將資料呈現致UI
     */
    private fun FillIntoUI(
        title: String,
        name: String,
        towho: String,
        date: String,
        content: String
    ) {
        Log.d("Develop_Fill","title:$title")
        this.title.text = title
        this.name.text = name
        this.towho.text = towho
        this.date.text = date
        this.content.text = content
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
class ContentViewModel(application: Application) : BaseViewModel(application) {

    private val Result = MutableLiveData<String>()

    fun callInfo(index: Int, announcements: String, fakeData: String) {
        RxVolleyConnext(Result,index)
        mActionListener?.HttpCallback(fakeData,index = index)
    }

    private var mActionListener: OnActionListener? = null

    interface OnActionListener{
        fun HttpCallback(response: String, index: Int)
    }

    fun setActionListener(listener: OnActionListener){
        mActionListener = listener
    }


    //    private val TAG:String = "ContentviewModel"
//    fun callInfo(index: Int,Url:String): LiveData<String> {
//        RxVolleyConnext(Result,index)
//        return Result
//    }
    private fun RxVolleyConnext(Result: MutableLiveData<String>, index: Int) {

        /**
         * 設定Api網址
         */
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
//        params.put("search", index)
//        //request parameters
//
//
//        /**
//         * Call Back 結果 並傳到liveData裡面
//         */
//        val callBack: HttpCallback = object : HttpCallback() {
//            override fun onSuccess(Response: String) {
//                Log.e("TAG", "Suc and $Response")
//                Result.postValue(Response)
//            }
//
//            override fun onFailure(errorNo: Int, strMsg: String) {
//                Log.e("TAG", "Fai = { $errorNo } and Msg = $strMsg")
//            }
//        }
//
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
//                .doTask()
    }

}