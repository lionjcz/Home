package com.jekma.maxe.login.index_menu.announcement

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TableLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.jekma.baselibrary.BaseBindingFragment
import com.jekma.maxe.R
import com.jekma.maxe.databinding.MaxeFragmentAnnounceBinding
import org.json.JSONArray
import org.json.JSONException

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