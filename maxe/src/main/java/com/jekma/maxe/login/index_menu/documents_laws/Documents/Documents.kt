package com.jekma.maxe.login.index_menu.documents_laws.Documents

//import androidx.lifecycle.ViewModelProvider.get
import com.jekma.maxe.R
import com.jekma.baselibrary.BaseFragment

//import com.jekma.maxe.Tools.HRFinalContent.Content;
//import com.company.maxe.Tools.URL.VolleyBridge;
class Documents : BaseFragment()
//    Fragment(), View.OnClickListener, OnTouchListener
{
    //
//    private var mViewModel: DocumentsViewModel? = null
//    private var context: Context? = null
//    private var folderNAME: String? = null
//    private var jsonArray: JSONArray? = null
//    private val TAG = "Documents"
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        context = activity!!.applicationContext
//        folderNAME =
//            activity!!.applicationContext.resources.getString(R.string.Documents_law_documents)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val root = inflater.inflate(R.layout.documents_fragment, container, false)
//        mViewModel = ViewModelProviders.of(this).get(DocumentsViewModel::class.java)
//        mViewModel.documents()
//            .observe(viewLifecycleOwner, Observer<String?> { s -> result(s, root) })
//        return root
//    }
//
//    private fun result(s: String?, root: View) {
//        run {
//
//            //            Log.wtf(TAG,"newintroduce_result"+response);
//            var linearLayout = LinearLayout(context)
//            linearLayout = root.findViewById(R.id.layout)
//            linearLayout.setBackgroundColor(resources.getColor(R.color.blanchedalmond))
//            val list: ArrayList<*> = ArrayList<Any>()
//            try {
//                jsonArray = JSONArray(s)
//                var response_by_TAG: String? = null
//                /*
//                 * Get JSONOBJECT by TAG
//                 * */for (k in 0 until jsonArray!!.length()) {
//                    /*
//                     * Level 1
//                     * Check it have file or not
//                     * */
//                    val string = jsonArray!!.getJSONObject(k).optString(folderNAME)
//                    if (string === "" || string.length == 0) {
////                        Log.wtf(TAG,"No file exist = ");
//                    }
//                    else {
//                        response_by_TAG = string
//                        //                        Log.wtf(TAG,"response_by_TAG = "+response_by_TAG);
//                        val seperate = JSONArray(response_by_TAG)
//                        for (ab in 0 until seperate.length()) {
////                            seperate.get(ab);
////                            Log.wtf(TAG,"seperate.get(ab) = "+seperate.get(ab));
//
////                            String piano = (String) seperate.get(ab);
////
//                            val json = JSONTokener(seperate[ab].toString()).nextValue()
//
//                            /*
//                             * Check is JSONObject or JSONArray or File
//                             * if it is not JSONObject or JSONArray that must be a file.
//                             * */if (json is JSONObject) {
////                                JSONArray dirname = new JSONArray(response_by_TAG);
////                                Log.wtf(TAG,"Total Data = "+dirname);
//                                Log.wtf(TAG, "Total Data length = " + seperate.length())
//                                val abc = JSONArray(seperate.toString())
//
////                                for(int dirCount =0 ; dirCount < dirname.length() ; dirCount++){
//                                if (abc.optJSONObject(ab) == null) {
//                                }
//                                else {
//                                    val jsonObject = JSONObject(abc[ab].toString())
//                                    val keys = jsonObject.keys()
//                                    val combinelayoutParams =
//                                        LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
//                                    val combine = LinearLayout(context)
//                                    combine.orientation = LinearLayout.VERTICAL
//                                    combinelayoutParams.setMargins(50, 50, 50, 50)
//                                    combine.layoutParams = combinelayoutParams
//                                    combine.setBackgroundColor(resources.getColor(R.color.white))
//                                    //
//                                    while (keys.hasNext()) {
//                                        val dir = keys.next()
//                                        Log.wtf(TAG, "The dir name is " + dir + "and at " + ab)
//                                        val filename = JSONObject(jsonObject.toString())
//                                        val filenames = filename.getJSONArray(dir) {
//                                            val switcher = arrayOf("關閉")
//
//                                            /*
//                                             * 資料夾名稱
//                                             * */
//                                            val dirViewlayoutParams =
//                                                LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
//                                            val dirView = TextView(context)
//                                            dirView.text = dir
//                                            dirView.textSize = 30f
//                                            dirView.setTextColor(Color.BLACK)
//                                            dirView.gravity = Gravity.CENTER
//                                            dirView.setOnClickListener { v ->
//                                                val textView = v as TextView
//                                                val string = textView.tag.toString()
//                                                val linearLayout1 =
//                                                    root.findViewWithTag<LinearLayout>("WannaKnow$string")
//                                                if (switcher[0] == "開啟") {
//                                                    linearLayout1.visibility = View.GONE
//                                                    switcher[0] = "關閉"
//                                                }
//                                                else {
//                                                    linearLayout1.visibility = View.VISIBLE
//                                                    switcher[0] = "開啟"
//                                                }
//                                            }
//                                            dirView.tag = ab
//                                            dirView.setBackgroundColor(resources.getColor(R.color.yellow))
//                                            dirViewlayoutParams.setMargins(0, 0, 0, 0)
//                                            dirView.layoutParams = dirViewlayoutParams
//                                            val insidelayoutParams =
//                                                LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
//                                            val inside = LinearLayout(context)
//                                            inside.tag = dir
//                                            inside.tag = "WannaKnow$ab"
//                                            inside.orientation = LinearLayout.VERTICAL
//                                            inside.layoutParams = insidelayoutParams
//                                            inside.visibility = View.GONE
//
//                                            /*
//                                             * 檔案名稱
//                                             * */for (fileCount in 0 until filenames.length()) {
////                                        Log.wtf(TAG,"filename = "+filenames.getString(fileCount));
//                                            val textViewlayoutParams =
//                                                LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
//                                            val fileView = TextView(context)
//                                            fileView.setText(filenames.getString(fileCount))
//                                            fileView.textSize = 25f
//                                            fileView.setTextColor(Color.BLACK)
//                                            fileView.maxLines = 1
//                                            fileView.ellipsize = TextUtils.TruncateAt.END
//                                            fileView.setOnClickListener(this)
//                                            fileView.tag =
//                                                "" + dir + "/" + filenames.getString(fileCount)
//                                            fileView.layoutParams = textViewlayoutParams
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
//                                val textViewlayoutParams =
//                                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
//                                val fileView = TextView(context)
//                                fileView.text = json.toString()
//                                fileView.textSize = 25f
//                                fileView.setTextColor(Color.BLACK)
//                                fileView.maxLines = 1
//                                fileView.tag = json.toString()
//                                fileView.ellipsize = TextUtils.TruncateAt.END
//                                fileView.setOnClickListener(this)
//                                fileView.layoutParams = textViewlayoutParams
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
//        val extension = filenameArray[filenameArray.size - 1]
//        println("image = $extension")
//        return extension
//    }
//
//    private fun img(s: String) {
//        val webview = WebView(context!!)
//        webview.setDownloadListener(MyDownLoadListener())
//        val webSettings = webview.settings
//        webSettings.javaScriptEnabled = true
//        webSettings.javaScriptCanOpenWindowsAutomatically = true
//        webSettings.domStorageEnabled = true
//        webSettings.pluginState = WebSettings.PluginState.ON
//        webSettings.allowFileAccess = true
//        webSettings.loadWithOverviewMode = true
//        webSettings.useWideViewPort = true
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            webSettings.allowUniversalAccessFromFileURLs = true
//        }
//        webview.loadUrl(encode(s))
//    }
//
//    private fun vdo(s: String) {
//        println("encode = " + encode(s).replace(" ".toRegex(), "%20"))
//        val parsedFilename = encode(s).replace("%".toRegex(), "%20")
//        println("encode aaaaa= $parsedFilename")
//        nextFragment(parsedFilename)
//    }
//
//    private fun encode(s: String): String {
////            Log.wtf(TAG,"encode() = "+"http://60.250.34.243:4747/Documents/"+s);
//        var finalfilename = ""
//        try {
//            val filename = URLEncoder.encode(s, "UTF-8")
//            val volleyBridge = VolleyBridge()
//            finalfilename = "http://" + volleyBridge.URL().toString() + "/Documents/" + s
//        } catch (e: UnsupportedEncodingException) {
//            e.printStackTrace()
//        }
//        return finalfilename
//    }
//
//    override fun onClick(v: View) {
//        if (v is TextView) {
//            val textView = v
//            textView.tag
//            Log.wtf(TAG, "filename = " + textView.tag)
//            val ButtonName_DIR_FILE = folderNAME + "/" + textView.tag
//            when (checkType(textView.tag as String)) {
//                "pdf" -> {
//                    /*
//                     * @param: ButtonName
//                     * @param: dirname
//                     * @param: filename
//                     * */img(ButtonName_DIR_FILE)
//                    Log.wtf(TAG, "pdf = " + textView.tag)
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
//                i.data = Uri.parse(url)
//                startActivity(i)
//            }
//        }
//    }
//
//    private fun nextFragment(parsedFilename: String) {
//        val values = Content()
//        val bundle = Bundle()
//        bundle.putString("index", parsedFilename)
//        values.setArguments(bundle)
//        val fr = fragmentManager!!.beginTransaction()
//        fr.replace(R.id.nav_host_fragment, values)
//        fr.addToBackStack(values.getClass().getName())
//        fr.commit()
//    }
//
//    override fun onTouch(v: View, event: MotionEvent): Boolean {
//        return false
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        mViewModel = ViewModelProviders.of(this).get(DocumentsViewModel::class.java)
//        // TODO: Use the ViewModel
//    }
    override val titleResId: Int
        get() = R.string.maxe_title_document
    override val layoutResId: Int
        get() = R.layout.documents_fragment
}