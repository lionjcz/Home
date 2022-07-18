package com.jekma.maxe

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.TextViewCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.jekma.baselibrary.BaseFragment
import com.jekma.maxe.databinding.MaxeFragmentErrorCodeHomeBinding
import com.jekma.maxe.databinding.MaxeFragmentWelcomeBinding
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class Welcome : BaseFragment() {

    override val isShowMainBar: Boolean
        get() = true

    override val titleResId: Int
        get() = R.string.maxe_title_welcome
    override val layoutResId: Int
        get() = R.layout.maxe_fragment_welcome

    private var _binding: MaxeFragmentWelcomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MaxeFragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ErrorCodeHome.setOnClickListener {
            gotoNextNavPage(R.id.action_welcome_to_errorcode_home)
        }

        binding.GoToLogin.setOnClickListener {
            gotoNextNavPage(R.id.action_welcome_to_loginActivity)
        }

        webViewInitial()
        bannerInitial()
    }

    private fun webViewInitial() {
        binding.Official.webViewClient = WebViewClient()
        binding.Official.settings.javaScriptEnabled = true
        binding.Official.loadUrl("https://www.maxe.com.tw/Web/Maxe/Newest=1")
    }

    override fun onResume() {
        super.onResume()
        binding.banner.start()
    }

    override fun onPause() {
        super.onPause()
        binding.banner.stop()
    }


    //    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//
//    }
//
    private fun bannerInitial() {
        val list: MutableList<DataBean> = ArrayList()
        list.add(
            DataBean(
                "https://www.maxe.com.tw/Web/Maxe//package/Media/Banner/220422%E8%90%AC%E5%A3%AB%E7%9B%8A%E5%AE%98%E7%B6%B2BN_%E9%98%B2%E8%A9%90%E9%A8%99_%E5%AE%98%E7%B6%B2%E9%98%B2%E8%A9%90%E9%A8%994.jpg",
                null,
                1
            )
        )
        list.add(
            DataBean(
                "https://www.maxe.com.tw/Web/Maxe//package/Media/Banner/111%E5%B9%B4.jpg",
                null,
                1
            )
        )
        list.add(
            DataBean(
                "https://www.maxe.com.tw/Web/Maxe//package/Media/Banner/%E5%B0%8F%E5%86%B7%E9%9C%B8mini.jpg",
                null,
                1
            )
        )


        binding.banner.setAdapter(object : BannerImageAdapter<DataBean>(list) {
            override fun onBindView(
                holder: BannerImageHolder,
                data: DataBean,
                position: Int,
                size: Int
            ) {
                Glide.with(holder.itemView)
                    .load(data.imageUrl)
                    .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
                    .into(holder.imageView)
            }
        }).addBannerLifecycleObserver(this).indicator = CircleIndicator(requireContext())

    }

    data class DataBean(var imageUrl: String?, var title: String?, var viewType: Int)
}

class ErrorCodeHome : BaseFragment() {

    override val isShowMainBar: Boolean
        get() = true

    override val titleResId: Int
        get() = R.string.maxe_title_errorcode
    override val layoutResId: Int
        get() = R.layout.maxe_fragment_errorcode_home


    private var _binding: MaxeFragmentErrorCodeHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MaxeFragmentErrorCodeHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        

        parsingData(data = fakeData())
    }

    private fun fakeData(): String {
        val fakeJsonArray = JSONArray()
        for (i in 0 .. 10){
            val fakeObject = JSONObject()
            fakeObject.put("結果","有")
            fakeObject.put("定變頻","定變頻$i")
            fakeObject.put("室內外機","室內外機$i")
            fakeObject.put("內容","內容$i")
            fakeObject.put("系列","系列$i")
            fakeObject.put("顯示","顯示$i")
            fakeObject.put("故障名稱","故障名稱$i")
            fakeObject.put("備註","備註$i")
            fakeJsonArray.put(fakeObject)
        }
        return fakeJsonArray.toString()
    }


    /**
     * 解析傳進來的資料，並動態新增結果
     */
    private fun parsingData(data: String) {
        try {
            val jsonArray = JSONArray(data)
            when (jsonArray.getJSONObject(0).getString("結果")) {
                "有" -> {
                    Log.d("Develop_","u有")
                    val testArray = arrayOfNulls<String>(jsonArray.length())
                    val testArray1 = arrayOfNulls<String>(jsonArray.length())
                    val testArray2 = arrayOfNulls<String>(jsonArray.length())
                    val testArray3 = arrayOfNulls<String>(jsonArray.length())
                    val testArray4 = arrayOfNulls<String>(jsonArray.length())
                    val testArray5 = arrayOfNulls<String>(jsonArray.length())
                    val testArray6 = arrayOfNulls<String>(jsonArray.length())
                    for (i in 0 until jsonArray.length()) {
                        dynamicallyAppendTextView(i)
                    }

                    //撈資料並存到陣列
                    for (i in 0 until jsonArray.length()) {
                        testArray[i] = jsonArray.getJSONObject(i).getString("定變頻")
                        Log.d("Develop_","定變頻:${testArray[i]}")
                    }
                    for (i in 0 until jsonArray.length()) {
                        testArray1[i] = jsonArray.getJSONObject(i).getString("室內外機")
                    }
                    for (i in 0 until jsonArray.length()) {
                        testArray2[i] = jsonArray.getJSONObject(i).getString("內容")
                    }
                    for (i in 0 until jsonArray.length()) {
                        testArray3[i] = jsonArray.getJSONObject(i).getString("系列")
                    }
                    for (i in 0 until jsonArray.length()) {
                        testArray4[i] = jsonArray.getJSONObject(i).getString("顯示")
                    }
                    for (i in 0 until jsonArray.length()) {
                        testArray5[i] = jsonArray.getJSONObject(i).getString("故障名稱")
                    }
                    for (i in 0 until jsonArray.length()) {
                        testArray6[i] = jsonArray.getJSONObject(i).getString("備註")
                    }
                    val textViews = arrayOfNulls<TextView>(jsonArray.length())
                    for (i in 0 until jsonArray.length()) {
                        textViews[i] = binding.root.findViewById(0 + i)
                        textViews[i]?.textSize = 20f
                        textViews[i]?.text = "0$i"
                        textViews[i]?.text = """
                                                                        系列　：${testArray3[i]}
                                                                        顯示　：${testArray4[i]}
                                                                        故障名稱　：${testArray5[i]}
                                                                        備註　：${testArray6[i]}
                        
                                                                        """.trimIndent()
                        textViews[i]?.let {
                            TextViewCompat.setAutoSizeTextTypeWithDefaults(
                                it,
                                TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM
                            )
                        }
                        textViews[i]?.setTextColor(-0x1000000)
                    }
                }
                "資料庫沒結果" -> {
                    binding.editInput.setText("")
                    val linearLayout2 = binding.ServicesErrorResultHome
                    linearLayout2.removeAllViewsInLayout()
                    Toast.makeText(requireContext(), "資料庫查無資料", Toast.LENGTH_LONG).show()
                }
                else -> {
                    binding.editInput.setText("")
                    val linearLayout2 =binding.ServicesErrorResultHome
                    linearLayout2.removeAllViewsInLayout()
                    Toast.makeText(requireContext(), "請輸入資料", Toast.LENGTH_LONG).show()
                }
            }
        } catch (e: JSONException) {
            Log.e("Develop_","${e.message}")
            Toast.makeText(requireContext(), "連線錯誤", Toast.LENGTH_LONG).show()
        }

    }

    /**
     * 依照解析的結果，動態新增相對應的元件
     */
    private fun dynamicallyAppendTextView(i: Int) {
        val linearLayout = binding.ServicesErrorResultHome
        val textview = TextView(requireContext())
        textview.id = 0 + i
        linearLayout.addView(textview)
    }
}