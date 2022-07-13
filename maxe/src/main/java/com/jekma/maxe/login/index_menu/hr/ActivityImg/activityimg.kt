package com.company.maxe.Login.index_menu.hr.ActivityImg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jekma.maxe.R
//import com.bumptech.glide.Glide

class activityimg : Fragment()
//    , View.OnClickListener, OnTouchListener
{
//
//    var imageView: ImageView? = null
//    private var mViewModel: ActivityimgViewModel? = null
//    private var context: Context? = null
//    private var jsonArray: JSONArray? = null
//    private var folderNAME: String? = null
//    private val TAG = "Documents"
//    private var view: View? = null
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        this.view = view
//        context = activity!!.applicationContext
//        folderNAME = activity!!.applicationContext.resources.getString(R.string.HR_ActivityImgs)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.maxe_activityimg_fragment, container, false)
//        mViewModel = ViewModelProviders.of(this).get(ActivityimgViewModel::class.java)
//        mViewModel.Activityimg()
//            .observe(viewLifecycleOwner, Observer<String?> { s -> result(s, root) })
        return root
    }
//
//    inner class ViewPagerAdapter(private val context: Context, private val imageNames: Array<String>, private val imagePhoto: Array<String>, view: View) :
//        BaseAdapter() {
//        private val layoutInflater: LayoutInflater
//        private val view: View
//        override fun getCount(): Int {
//            return imagePhoto.size
//        }
//
//        override fun getItem(position: Int): Any {
//            return null
//        }
//
//        override fun getItemId(position: Int): Long {
//            return 0
//        }
//
//        override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
//            var convertView: View? = convertView
//            if (convertView == null) {
//                convertView = layoutInflater.inflate(R.layout.grid_single, parent, false)
//            }
//            //            TextView tvName = convertView.findViewById(R.id.grid_name);
//            val imageView = convertView.findViewById<ImageView>(R.id.grid_image)
//            //            tvName.setText(imageNames[position]);
////            Picasso.get()
////                    .load(imagePhoto[position])
////                    .resize(50, 50)
////                    .centerCrop()
////                    .into(imageView);
//            Glide.with(context).load(imagePhoto[position]).into(imageView)
//            imageView.setOnClickListener { //                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
////                    final NavController navController =  Navigation.findNavController(view);
////
////                    navController.navigate(R.id.action_activityimg_to_displayimagefragment);
//                val intent = Intent(context, displayimageactivity::class.java)
//                val bundle = Bundle()
//                bundle.putStringArray("id", imagePhoto)
//                bundle.putInt("currentPosition", position)
//                intent.putExtras(bundle)
//                startActivity(intent)
//            }
//            //            imageView.setImageURI(Uri.parse("https://cdn.pixabay.com/photo/2016/11/11/23/34/cat-1817970_960_720.jpg"));
//            return convertView
//        }
//
//        init {
//            layoutInflater =
//                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//            this.view = view
//        }
//    }
//
//    //ImageSlider
//    private fun result(s: String?, root: View) {
//        run {
//            var linearLayout = LinearLayout(context)
//            linearLayout = root.findViewById<LinearLayout>(R.id.layout)
//            linearLayout.setBackgroundColor(resources.getColor(R.color.blanchedalmond))
//            val list: ArrayList<*> = ArrayList<Any>()
//            try {
//                jsonArray = JSONArray(s)
//                var response_by_TAG: String? = null
//                for (k in 0 until jsonArray.length()) {
//                    val string: String = jsonArray.getJSONObject(k).optString(folderNAME)
//                    if (string === "" || string.length == 0) {
//                    }
//                    else {
//                        response_by_TAG = string
//                        val seperate = JSONArray(response_by_TAG)
//                        for (ab in 0 until seperate.length()) {
//                            val json: Any = JSONTokener(seperate.get(ab).toString()).nextValue()
//                            if (json is JSONObject) {
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
//                                            //                                            inside.setBackgroundColor(Color.CYAN);
//                                            inside.setOrientation(LinearLayout.VERTICAL)
//                                            inside.setLayoutParams(insidelayoutParams)
//                                            inside.setVisibility(View.GONE) {
//                                                val gv = GridView(context)
//                                                val t1: LinearLayout.LayoutParams =
//                                                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1200)
//                                                gv.setLayoutParams(t1)
//                                                gv.setNumColumns(3)
//                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                                                    gv.setNestedScrollingEnabled(true)
//                                                }
//                                                val names = arrayOfNulls<String>(filenames.length())
//                                                val imagess =
//                                                    arrayOfNulls<String>(filenames.length())
//                                                for (fileCount in 0 until filenames.length()) {
//                                                    imagess[fileCount] =
//                                                        "http://www.maxe.com.tw/Documents/%E6%B4%BB%E5%8B%95%E7%85%A7%E7%89%87/" + dir + "/" + filenames.getString(fileCount)
//                                                    names[fileCount] = ""
//                                                }
//                                                val viewPagerAdapter: ViewPagerAdapter =
//                                                    ViewPagerAdapter(getContext(), names, imagess, view)
//                                                gv.setAdapter(viewPagerAdapter)
//                                                inside.addView(gv)
//                                            }
//                                            combine.addView(dirView)
//                                            combine.addView(inside)
//                                        }
//                                    }
//                                    linearLayout.addView(combine)
//                                }
//                            }
//                            else if (json is JSONArray) {
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
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        mViewModel = ViewModelProviders.of(this).get(ActivityimgViewModel::class.java)
//        // TODO: Use the ViewModel
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
//            finalfilename = "http://" + volleyBridge.URL() + "/Documents/" + s
//        } catch (e: UnsupportedEncodingException) {
//            e.printStackTrace()
//        }
//        return finalfilename
//    }
//
//    private fun nextFragment(parsedFilename: String) {
//        val values: com.jekma.maxe.Tools.HRFinalContent.Content =
//            com.jekma.maxe.Tools.HRFinalContent.Content()
//        val bundle = Bundle()
//        bundle.putString("index", parsedFilename)
//        values.setArguments(bundle)
//        val fr = fragmentManager!!.beginTransaction()
//        fr.replace(R.id.nav_host_fragment, values)
//        fr.addToBackStack(values.javaClass.getName())
//        fr.commit()
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
//    override fun onTouch(v: View, event: MotionEvent): Boolean {
//        return false
//    }
//
//    companion object {
//        fun newInstance(): activityimg {
//            return activityimg()
//        }
//    }
}