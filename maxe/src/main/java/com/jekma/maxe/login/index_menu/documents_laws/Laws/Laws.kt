package com.company.maxe.Login.index_menu.documents_laws.Laws

//import androidx.lifecycle.ViewModelProvider.get
//import androidx.navigation.Navigation.findNavController
//import androidx.navigation.NavController.navigate
import android.os.Bundle
import com.jekma.maxe.R
//import androidx.lifecycle.ViewModelProviders
import android.view.*
import androidx.fragment.app.Fragment

//import com.company.maxe.Login.index_menu.hr.Training.Training;
//import com.company.maxe.Tools.HRFinalContent.Content_BlockDownload;
//import com.company.maxe.Tools.URL.VolleyBridge;
class Laws : Fragment()
//    , View.OnClickListener, OnTouchListener
{
//
//    private var mViewModel: LawsViewModel? = null
//    private var context: Context? = null
//    private var folderNAME: String? = null
//    private var jsonArray: JSONArray? = null
//    private val TAG = "Laws"
//    private var view: View? = null
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        context = activity!!.applicationContext
//        folderNAME = activity!!.applicationContext.resources.getString(R.string.Documents_law_laws)
//        this.view = view
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.maxe_laws_fragment, container, false)
//        Log.wtf(TAG, "onCreateView")
//        mViewModel = ViewModelProviders.of(this).get(LawsViewModel::class.java)
//        mViewModel.Laws().observe(viewLifecycleOwner, Observer<String?> { s -> result(s, root) })
        return root
    }

//    private fun result(response: String?, root: View) {
//        Log.wtf(TAG, "result")
//        run {
//
//            //            Log.wtf(TAG,"newintroduce_result"+response);
//            var linearLayout = LinearLayout(context)
//            linearLayout = root.findViewById(R.id.layout)
//            linearLayout.setBackgroundColor(resources.getColor(R.color.blanchedalmond))
//            val list: ArrayList<*> = ArrayList<Any>()
//            try {
//                jsonArray = JSONArray(response)
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
//                                    while (keys.hasNext()) {
//                                        val dir = keys.next()
//                                        Log.wtf(TAG, "The dir name is " + dir + "and at " + ab)
//                                        val filename = JSONObject(jsonObject.toString())
//                                        val filenames = filename.getJSONArray(dir) {
//                                            /*
//                                             * 資料夾名稱
//                                             * */
//                                            val switcher = arrayOf("關閉")
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
//                                            inside.tag = "WannaKnow$ab"
//                                            Log.wtf(TAG, "Tag = exercise-$ab")
//                                            inside.orientation = LinearLayout.VERTICAL
//                                            inside.layoutParams = insidelayoutParams
//                                            inside.visibility = View.GONE
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
//                                            fileView.setOnTouchListener(this)
//                                            fileView.tag =
//                                                "" + dir + "/" + filenames.getString(fileCount)
//                                            fileView.layoutParams = textViewlayoutParams
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
//    override fun onClick(v: View) {
//        if (v is TextView) {
////            Log.wtf(TAG,"filename = "+textView.getTag());
//            val textView = v
//            textView.tag
//            val ButtonName_DIR_FILE = folderNAME + "/" + textView.tag
//            when (checkType(textView.tag as String)) {
//                "pdf" ->                     /*
//                     * @param: ButtonName
//                     * @param: dirname
//                     * @param: filename
//                     * */
////                    img(folderNAME,textView.getTag());
//                    img(ButtonName_DIR_FILE)
//                "mp4" -> vdo(ButtonName_DIR_FILE)
//                else  -> {}
//            }
//        }
//    }
//
//    override fun onTouch(v: View, event: MotionEvent): Boolean {
//        return false
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
//    private fun img(folderNAME: String) {
//        val bundle = Bundle()
//        bundle.putString("index", encode(folderNAME))
//        bundle.putString("TYPE", "IMG")
//        val navController = findNavController(view!!)
//        navController.navigate(R.id.action_laws_to_content4, bundle)
//    }
//
//    private fun vdo(s: String) {
//        println("encode = " + encode(s).replace(" ".toRegex(), "%20"))
//        val parsedFilename = encode(s).replace("%".toRegex(), "%20")
//        println("encode aaaaa= $parsedFilename")
//        nextFragment(parsedFilename, "VDO")
//    }
//
//    private fun encode(s: String): String {
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
//    private fun nextFragment(parsedFilename: String, vdo: String) {
//        val values = Content_BlockDownload()
//        val bundle = Bundle()
//        bundle.putString("index", parsedFilename)
//        bundle.putString("TYPE", vdo)
//        values.setArguments(bundle)
//        val navController = findNavController(view!!)
//        navController.navigate(R.id.action_laws_to_content4, bundle)
//    }
//
//    companion object {
//        fun newInstance(): Laws {
//            return Laws()
//        }
//    }
}