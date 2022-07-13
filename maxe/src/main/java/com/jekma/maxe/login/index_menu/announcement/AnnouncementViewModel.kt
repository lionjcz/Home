package com.jekma.maxe.login.index_menu.announcement

import android.app.Application
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.jekma.baselibrary.BaseViewModel
import com.jekma.maxe.R
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception

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


    private var mActionListener:OnActionListener? = null

    interface OnActionListener{
        /**
         * 再新增子元素之前，先建置最外面的Scroll框架，再放入Layout容器
         */
        fun createElements(result: String)
        fun onClick(bundle: Bundle)
    }

    fun setActionListener(listener:OnActionListener){
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
        }catch (e:Exception){
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