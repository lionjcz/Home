package com.jekma.maxe.tools.HRFinalContent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.jekma.maxe.R

class Content : Fragment() {
    private var webview: WebView? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root: View = inflater.inflate(R.layout.maxe_newemployeerfinal, container, false)
//        webview = root.findViewById(R.id.NEwebview)
//        val arguments: Bundle? = arguments
//        if (arguments == null) {
//        }
//        else {
//            val filename: String = arguments.getString("index") //主管
//            println("index =3256 $filename")
//            loadVideo(filename)
//        }
        return root
    }
//
//    private fun loadVideo(filename: String) {
//        webview!!.webViewClient = MyDownLoadListener()
//        webview!!.webChromeClient = WebChromeClient()
//        webview!!.settings.loadsImagesAutomatically = true
//        webview!!.settings.javaScriptEnabled = true
//        webview!!.settings.allowFileAccess = true
//        webview!!.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
//        webview!!.settings.javaScriptCanOpenWindowsAutomatically = true
//        webview!!.settings.pluginState = WebSettings.PluginState.ON
//        webview!!.webChromeClient = myChrome()
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
//            webview!!.settings.mediaPlaybackRequiresUserGesture = false
//        }
//        webview!!.loadUrl(filename)
//    }
//
//    private inner class MyDownLoadListener : WebViewClient(), DownloadListener {
//        override fun onDownloadStart(url: String, userAgent: String, contentDisposition: String, mimetype: String, contentLength: Long) {
//            if (url != null) {
//                val i = Intent(Intent.ACTION_VIEW)
//                i.setData(Uri.parse(url))
//                startActivity(i)
//            }
//        }
//    }
//
//    private inner class myChrome internal constructor() : WebChromeClient() {
//        private var mCustomView: View? = null
//        private var mCustomViewCallback: CustomViewCallback? = null
//
//        //protected FrameLayout mFullscreenContainer;
//        //private int mOriginalOrientation;
//        private var mOriginalSystemUiVisibility = 0
//        val defaultVideoPoster: Bitmap?
//            get() = if (mCustomView == null) {
//                null
//            }
//            else BitmapFactory.decodeResource(activity!!.applicationContext.resources, 2130837573)
//
//        override fun onHideCustomView() {
//            (activity!!.window.decorView as FrameLayout).removeView(mCustomView)
//            mCustomView = null
//            activity!!.window.decorView.systemUiVisibility = mOriginalSystemUiVisibility
//            activity!!.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
//            mCustomViewCallback.onCustomViewHidden()
//            mCustomViewCallback = null
//        }
//
//        override fun onShowCustomView(paramView: View, paramCustomViewCallback: CustomViewCallback) {
//            if (mCustomView != null) {
//                onHideCustomView()
//                return
//            }
//            mCustomView = paramView
//            mOriginalSystemUiVisibility = activity!!.window.decorView.systemUiVisibility
//            activity!!.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
//            //this.mOriginalOrientation = getRequestedOrientation();
//            mCustomViewCallback = paramCustomViewCallback
//            (activity!!.window.decorView as FrameLayout).addView(mCustomView, FrameLayout.LayoutParams(-1, -1))
//            activity!!.window.decorView.systemUiVisibility = 3846
//        }
//    }
}