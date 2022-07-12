package com.company.maxe.Login.index_menu.hr.YearData

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.jekma.maxe.R
import com.company.maxe.Tools.HRFinalContent.Content
import java.io.UnsupportedEncodingException
import java.net.URLEncoder
import java.util.ArrayList

class yeardata : Fragment()
//    , View.OnClickListener, OnTouchListener
{
//
//    private var mViewModel: YeardataViewModel? = null
//    private var context: Context? = null
//    private var folderNAME: String? = null
//    private var jsonArray: JSONArray? = null
//    private val TAG = "Documents"
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        context = activity!!.applicationContext
//        folderNAME = activity!!.applicationContext.resources.getString(R.string.HR_YearData)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.documents_fragment, container, false)
//        mViewModel = ViewModelProviders.of(this).get(YeardataViewModel::class.java)
//        mViewModel.documents()
//            .observe(viewLifecycleOwner, Observer<String?> { s -> result(s, root) })
        return root
    }
//
//    private fun result(s: String?, root: View) {
//        run {
//
//            //            Log.wtf(TAG,"newintroduce_result"+response);
//            var linearLayout = LinearLayout(context)
//            linearLayout = root.findViewById<LinearLayout>(R.id.layout)
//            linearLayout.setBackgroundColor(resources.getColor(R.color.blanchedalmond))
//            val list: ArrayList<*> = ArrayList<Any>()
//            try {
//                jsonArray = JSONArray(s)
//                var response_by_TAG: String? = null
//                /*
//                 * Get JSONOBJECT by TAG
//                 * */for (k in 0 until jsonArray.length()) {
//                    /*
//                     * Level 1
//                     * Check it have file or not
//                     * */
//                    val string: String = jsonArray.getJSONObject(k).optString(folderNAME)
//                    if (string === "" || string.length == 0) {
////                        Log.wtf(TAG,"No file exist = ");
//                    }
//                    else {
//                        response_by_TAG = string
//                        val seperate = JSONArray(response_by_TAG)
//                        for (ab in 0 until seperate.length()) {
//                            val json: Any = JSONTokener(seperate.get(ab).toString()).nextValue()
//
//                            /*
//                             * Check is JSONObject or JSONArray or File
//                             * if it is not JSONObject or JSONArray that must be a file.
//                             * */if (json is JSONObject) {
//                                Log.wtf(TAG, "Total Data length = " + seperate.length())
//                                val abc = JSONArray(seperate.toString())
//                                if (abc.optJSONObject(ab) == null) {
//                                }
//                                else {
//                                    val jsonObject = JSONObject(abc.get(ab).toString())
//                                    val keys: Iterator<String> = jsonObject.keys()
//                                    val combinelayoutParams: LinearLayout.LayoutParams =
//                                        LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
//                                    val combine = LinearLayout(context)
//                                    combine.setOrientation(LinearLayout.VERTICAL)
//                                    combinelayoutParams.setMargins(50, 50, 50, 50)
//                                    combine.setLayoutParams(combinelayoutParams)
//                                    combine.setBackgroundColor(resources.getColor(R.color.white))
//                                    //
//                                    while (keys.hasNext()) {
//                                        val dir = keys.next()
//                                        Log.wtf(TAG, "The dir name is " + dir + "and at " + ab)
//                                        val filename = JSONObject(jsonObject.toString())
//                                        val filenames: JSONArray = filename.getJSONArray(dir) {
//                                            val switcher = arrayOf("關閉")
//
//                                            /*
//                                             * 資料夾名稱
//                                             * */
//                                            val dirViewlayoutParams: LinearLayout.LayoutParams =
//                                                LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
//                                            val dirView = TextView(context)
//                                            dirView.setText(dir)
//                                            dirView.setTextSize(30f)
//                                            dirView.setTextColor(Color.BLACK)
//                                            dirView.setGravity(Gravity.CENTER)
//                                            dirView.setOnClickListener(View.OnClickListener { v ->
//                                                val textView: TextView = v as TextView
//                                                val string: String = textView.getTag().toString()
//                                                val linearLayout1: LinearLayout =
//                                                    root.findViewWithTag<LinearLayout>("WannaKnow$string")
//                                                if (switcher[0] == "開啟") {
//                                                    linearLayout1.setVisibility(View.GONE)
//                                                    switcher[0] = "關閉"
//                                                }
//                                                else {
//                                                    linearLayout1.setVisibility(View.VISIBLE)
//                                                    switcher[0] = "開啟"
//                                                }
//                                            })
//                                            dirView.setTag(ab)
//                                            dirView.setBackgroundColor(resources.getColor(R.color.yellow))
//                                            dirViewlayoutParams.setMargins(0, 0, 0, 0)
//                                            dirView.setLayoutParams(dirViewlayoutParams)
//                                            val insidelayoutParams: LinearLayout.LayoutParams =
//                                                LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
//                                            val inside = LinearLayout(context)
//                                            inside.setTag(dir)
//                                            inside.setTag("WannaKnow$ab")
//                                            inside.setOrientation(LinearLayout.VERTICAL)
//                                            inside.setLayoutParams(insidelayoutParams)
//                                            inside.setVisibility(View.GONE)
//
//                                            /*
//                                             * 檔案名稱
//                                             * */for (fileCount in 0 until filenames.length()) {
////                                        Log.wtf(TAG,"filename = "+filenames.getString(fileCount));
//                                            val textViewlayoutParams: LinearLayout.LayoutParams =
//                                                LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
//                                            val fileView = TextView(context)
//                                            fileView.setText(filenames.getString(fileCount))
//                                            fileView.setTextSize(25f)
//                                            fileView.setTextColor(Color.BLACK)
//                                            fileView.setMaxLines(1)
//                                            fileView.setEllipsize(TextUtils.TruncateAt.END)
//                                            fileView.setOnClickListener(this)
//                                            fileView.setTag("" + dir + "/" + filenames.getString(fileCount))
//                                            fileView.setLayoutParams(textViewlayoutParams)
//                                            fileView.setOnTouchListener(this)
//                                            textViewlayoutParams.setMargins(0, 0, 0, 30)
//                                            inside.addView(fileView)
//                                        }
//                                            combine.addView(dirView)
//                                            combine.addView(inside)
//                                        }
//                                    }
//                                    linearLayout.addView(combine)
//                                }
//                            }
//                            else if (json is JSONArray) {
////                                Log.wtf(TAG,"This is JSONArray = "+json);
//                            }
//                            else {
//                                Log.wtf(TAG, "This is file = $json")
//                                val textViewlayoutParams: LinearLayout.LayoutParams =
//                                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
//                                val fileView = TextView(context)
//                                fileView.setText(json.toString())
//                                fileView.setTextSize(25f)
//                                fileView.setTextColor(Color.BLACK)
//                                fileView.setMaxLines(1)
//                                fileView.setTag(json.toString())
//                                fileView.setEllipsize(TextUtils.TruncateAt.END)
//                                fileView.setOnClickListener(this)
//                                fileView.setLayoutParams(textViewlayoutParams)
//                                fileView.setBackgroundColor(resources.getColor(R.color.white))
//                                fileView.setOnTouchListener(this)
//                                textViewlayoutParams.setMargins(50, 0, 50, 50)
//                                linearLayout.addView(fileView)
//                            }
//                        }
//                        break
//                    }
//                }
//            } catch (e: JSONException) {
//                println(e.fillInStackTrace())
//                Toast.makeText(activity!!.applicationContext, "Response was wrong please contact maxe#2213", Toast.LENGTH_SHORT)
//            }
//        }
//    }
//
//    private fun checkType(filename: String): String {
////        Log.wtf(TAG,""+filename);
//        val filenameArray = filename.split("\\.").toTypedArray()
//        return filenameArray[filenameArray.size - 1]
//    }
//
//    private fun img(s: String) {
//        val webview = WebView(context!!)
//        webview.setDownloadListener(MyDownLoadListener())
//        val webSettings: WebSettings = webview.settings
//        webSettings.setJavaScriptEnabled(true)
//        webSettings.setJavaScriptCanOpenWindowsAutomatically(true)
//        webSettings.setDomStorageEnabled(true)
//        webSettings.setPluginState(WebSettings.PluginState.ON)
//        webSettings.setAllowFileAccess(true)
//        webSettings.setLoadWithOverviewMode(true)
//        webSettings.setUseWideViewPort(true)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            webSettings.setAllowUniversalAccessFromFileURLs(true)
//        }
//        webview.loadUrl(encode(s))
//    }
//
//    private fun vdo(s: String) {
//        val parsedFilename = encode(s).replace("%".toRegex(), "%20")
//        nextFragment(parsedFilename)
//    }
//
//    private fun encode(s: String): String {
//        var finalfilename = ""
//        try {
//            val filename = URLEncoder.encode(s, "UTF-8")
//            val volleyBridge = VolleyBridge()
//            finalfilename = "http://" + volleyBridge.URL() + "/Documents/" + s
//        } catch (e: UnsupportedEncodingException) {
//            e.printStackTrace()
//        }
//        return finalfilename
//    }
//
//    override fun onClick(v: View) {
//        if (v is TextView) {
//            val textView: TextView = v as TextView
//            textView.getTag()
//            Log.wtf(TAG, "filename = " + textView.getTag())
//            val ButtonName_DIR_FILE = folderNAME + "/" + textView.getTag()
//            when (checkType(textView.getTag() as String)) {
//                "pdf" -> {
//                    /*
//                     * @param: ButtonName
//                     * @param: dirname
//                     * @param: filename
//                     * */img(ButtonName_DIR_FILE)
//                    Log.wtf(TAG, "pdf = " + textView.getTag())
//                }
//                "mp4" -> vdo(ButtonName_DIR_FILE)
//                else  -> {}
//            }
//        }
//    }
//
//    private inner class MyDownLoadListener : DownloadListener {
//        override fun onDownloadStart(url: String, userAgent: String, contentDisposition: String, mimetype: String, contentLength: Long) {
//            if (url != null) {
//                val i = Intent(Intent.ACTION_VIEW)
//                i.setData(Uri.parse(url))
//                startActivity(i)
//            }
//        }
//    }
//
//    private fun nextFragment(parsedFilename: String) {
//        val values = Content()
//        val bundle = Bundle()
//        bundle.putString("index", parsedFilename)
//        values.arguments = bundle
//        val fr = fragmentManager!!.beginTransaction()
//        fr.replace(R.id.nav_host_fragment, values)
//        fr.addToBackStack(values.javaClass.name)
//        fr.commit()
//    }
//
//    override fun onTouch(v: View, event: MotionEvent): Boolean {
//        return false
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        mViewModel = ViewModelProviders.of(this).get(YeardataViewModel::class.java)
//    }
}