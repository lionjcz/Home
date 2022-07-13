package com.jekma.maxe.login.index_menu.announcement

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.company.maxe.Tools.URL.VolleyBridge
import com.jekma.baselibrary.BaseBindingFragment
import com.jekma.maxe.R
import com.jekma.maxe.databinding.ContentAnnounceFinalBinding
import com.jekma.maxe.login.index_menu.announcement.AnnouncementViewModel.Companion.fakeData
import org.json.JSONArray
import org.json.JSONException

@RequiresApi(Build.VERSION_CODES.Q)
class Content : BaseBindingFragment<ContentAnnounceFinalBinding, ContentViewModel>() {

    override val titleResId: Int
        get() = R.string.maxe_title_announce_content
    override val layoutResId: Int
        get() = R.layout.content_announcefinal

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
            CallViewModel(index,fakeData())
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