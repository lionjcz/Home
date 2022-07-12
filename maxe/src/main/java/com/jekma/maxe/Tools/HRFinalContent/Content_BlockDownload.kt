package com.company.maxe.Tools.HRFinalContent

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.jekma.maxe.R

class Content_BlockDownload : Fragment() {
    private var webView: WebView? = null
    private val TAG = "content_lawsfinal"
    private var progressBar: ProgressBar? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root: View = inflater.inflate(R.layout.content_training, container, false)
//        webView = root.findViewById(R.id.WV)
//        progressBar = root.findViewById(R.id.pb)
//        progressBar.setVisibility(View.VISIBLE)
//        val arguments: Bundle? = arguments
//        if (arguments == null) {
//        }
//        else {
//            val type: String = arguments.getString("TYPE")
//            val filename: String = arguments.getString("index")
//            when (type) {
//                "IMG" -> loadIMG(filename)
//                "VDO" -> loadVideo(filename)
//                else  -> Toast.makeText(activity!!.applicationContext, "Content TYPE ERROR", Toast.LENGTH_SHORT)
//                    .show()
//            }
//        }
        return root
    }
//
//    private fun loadIMG(filename: String) {
//        val webSettings: WebSettings = webView!!.settings
//        webSettings.setJavaScriptEnabled(true)
//        webSettings.setAllowFileAccess(true)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            webSettings.setAllowFileAccessFromFileURLs(true)
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            webSettings.setAllowUniversalAccessFromFileURLs(true)
//        }
//        webView!!.setWebViewClient(object : WebViewClient() {
//            override fun onPageFinished(view: WebView, url: String) {
//                Log.wtf(TAG, "onPageFinished")
//                webView!!.loadUrl("javascript:(function() { " + "document.querySelector('[role=\"toolbar\"]').remove();})()")
//                progressBar!!.visibility = View.GONE
//            }
//        })
//        val url = VolleyBridge()
//        Log.wtf(TAG, url.DovumentsUsePDFViewer() + filename)
//        webView!!.loadUrl(url.DovumentsUsePDFViewer() + filename)
//        //        webView.loadUrl("http://"+url.URL()+"/"+url.version()+"/PDFViewer/web/viewer.html?file="+filename);
//    }
//
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//    }
//
//    private fun loadVideo(filename: String) {
//        webView!!.webViewClient = MyDownLoadListener()
//        webView!!.webChromeClient = WebChromeClient()
//        webView!!.settings.loadsImagesAutomatically = true
//        webView!!.settings.javaScriptEnabled = true
//        webView!!.settings.allowFileAccess = true
//        webView!!.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
//        webView!!.settings.javaScriptCanOpenWindowsAutomatically = true
//        webView!!.settings.pluginState = WebSettings.PluginState.ON
//        webView!!.webChromeClient = myChrome()
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
//            webView!!.settings.mediaPlaybackRequiresUserGesture = false
//        }
//        webView!!.loadUrl(filename)
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
//
//        override fun onPageFinished(view: WebView, url: String) {
//            super.onPageFinished(view, url)
//            progressBar!!.visibility = View.GONE
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
//
//    override fun onAttach(context: Context) {
//        Log.wtf(TAG, "onAttach")
//        super.onAttach(context)
//    }
//
//    override fun onPause() {
//        Log.wtf(TAG, "onPause")
//        super.onPause()
//    }
//
//    override fun onDetach() {
//        Log.wtf(TAG, "onDetach")
//        super.onDetach()
//    }
//
//    override fun onStop() {
//        Log.wtf(TAG, "onStop")
//        super.onStop()
//    }
}