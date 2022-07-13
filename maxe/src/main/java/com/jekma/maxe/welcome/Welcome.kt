package com.jekma.maxe.welcome

import com.jekma.baselibrary.BaseFragment
import com.jekma.maxe.R
//import com.company.maxe.R
//import com.youth.banner.Banner
//import com.youth.banner.BannerConfig
//import com.youth.banner.listener.OnBannerListener
//import com.youth.banner.loader.ImageLoader

class Welcome : BaseFragment() {

    //    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        SystemCode()
//
//    }
//
//    private fun SystemCode() {
//        setContentView(R.layout.activity_welcome)
//        supportActionBar!!.hide() //hide action bar
//        val mWebView = findViewById<WebView>(R.id.Official)
//        mWebView.webViewClient = WebViewClient()
//        mWebView.settings.javaScriptEnabled = true
//        mWebView.loadUrl("http://www.maxe.com.tw/WSE/news")
//        val banner = findViewById<Banner>(R.id.banner)
//        val images: MutableList<String?> = ArrayList()
//        images.add("http://www.maxe.com.tw/maxe_facebookQRCODE.jpg")
//        images.add("http://www.maxe.com.tw/WSE/carousel/banner4.png")
//        images.add("http://www.maxe.com.tw/WSE/carousel/banner3.png")
//        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
//        banner.setImages(images)
//                .setImageLoader(GlideImageLoader())
//                .setOnBannerListener(this)
//                .setDelayTime(3000)
//                .start()
//    }
//
//    fun GoToLogin(view: View?) {
//        val homeIntent = Intent(this@Welcome, LoginActivity::class.java)
//        startActivity(homeIntent)
//        finish()
//    }
//
//    fun ErrorCode_home(view: View?) {
//        val repair = Intent(this@Welcome, Errorcode_home::class.java)
//        startActivity(repair)
//        finish()
//    }
//
//    override fun OnBannerClick(position: Int) {
//        Toast.makeText(applicationContext, "clicked :$position", Toast.LENGTH_SHORT).show()
//    }
    override val titleResId: Int
        get() = R.string.maxe_title_welcome
    override val layoutResId: Int
        get() = R.layout.maxe_fragment_welcome
}

//internal class GlideImageLoader : ImageLoader() {
//    override fun displayImage(context: Context, path: Any, imageView: ImageView) {
//        Glide.with(context).load(path).into(imageView)
//    }
//}