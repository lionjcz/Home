package com.jekma.maxe.login.index_menu.announcement.Content

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jekma.baselibrary.BaseFragment
import com.jekma.maxe.R
//import com.company.maxe.Tools.URL.VolleyBridge
//import com.company.maxe.databinding.ContentAnnouncefinalBinding
import org.json.JSONArray
import org.json.JSONException

class Content : BaseFragment() {
    //
//    /**
//     * DataBinding
//     */
//    private lateinit var root: ContentAnnouncefinalBinding
//
//    /**
//     * viewModel
//     */
//    private lateinit var contentviewModel:ContentviewModel
//
//    private val TAG = "Content"
//
//    /**
//     * 必要元素
//     */
//    private lateinit var title: TextView
//    private lateinit var name: TextView
//    private lateinit var towho: TextView
//    private lateinit var date: TextView
//    private lateinit var content: TextView
//
//
//    /**
//     * 接收來自AnnouncementFragment丟過來的索引，並判斷是否為空
//     *
//     */
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        root = ContentAnnouncefinalBinding.inflate(layoutInflater)
//        val arguments = arguments
//        if (arguments == null) {
//            /**
//             * 空值
//             */
//        } else {
//            /**
//             * 不是空值
//             */
//            init()
//            val index = arguments.getInt("index")
//            CallViewModel(index)
//        }
//        return root.root
//    }
//
//    private fun init() {
//        title = root.ContentTitle
//        name = root.ContentName
//        towho = root.ContentTowho
//        date = root.ContentDate
//        content = root.ContentContent
//    }
//
//    /**
//     * Communicate with viewModel
//     */
//    private fun CallViewModel(index: Int) {
//        contentviewModel = ViewModelProvider(this).get(ContentviewModel::class.java)
//        contentviewModel.callInfo(index, VolleyBridge().Announcements()).observe(viewLifecycleOwner, androidx.lifecycle.Observer {
//            Log.i(TAG,"The response is  ${it} at observe mode in Fragment:$TAG")
//            ParsingData(it, index)
//
//        })
//    }
//
//    /**
//     * @param result 所有文章內容
//     * @param index 文章索引
//     * Parsing Result
//     */
//    private fun ParsingData(result: String, index: Int) {
//        try {
//            val Response = JSONArray(result)
//            if (Response == null) {
//                Toast.makeText(requireActivity().applicationContext, "arry1 為空", Toast.LENGTH_LONG).show()
//            } else {
//                val announcements_result = Array(Response.length()) { arrayOfNulls<String>(5) }
//                for (i in 0 until Response.length()) {
//                    announcements_result[i][0] = Response.getJSONObject(i).getString("Title")
//                    announcements_result[i][1] = Response.getJSONObject(i).getString("Name")
//                    announcements_result[i][2] = Response.getJSONObject(i).getString("toWho")
//                    announcements_result[i][3] = Response.getJSONObject(i).getString("Create_at")
//                    announcements_result[i][4] = Response.getJSONObject(i).getString("Content")
//                }
//                println("index = $index")
//
//                /**
//                 * 將資料呈現致UI
//                 */
//                FillIntoUI(
//                        announcements_result[index][0]!!,
//                        announcements_result[index][1]!!,
//                        announcements_result[index][2]!!,
//                        announcements_result[index][3]!!,
//                        announcements_result[index][4]!!.replace("<br />", "\n")
//                )
//
//
//            }
//        } catch (e: JSONException) {
//            e.printStackTrace()
//            Toast.makeText(requireActivity().applicationContext, "查無型號", Toast.LENGTH_LONG).show()
//        }
//    }
//
//    /**
//     * @param title   文章標題
//     * @param name    文章姓名
//     * @param towho   發布對象
//     * @param date    建立日期
//     * @param content 文章內容
//     * 將資料呈現致UI
//     */
//    private fun FillIntoUI(title: String, name: String, towho: String, date: String, content: String) {
//        this.title.text = title
//        this.name.text = name
//        this.towho.text = towho
//        this.date.text = date
//        this.content.text = content
//    }
    override val titleResId: Int
        get() = R.string.maxe_title_content
    override val layoutResId: Int
        get() = R.layout.content_announcefinal
}