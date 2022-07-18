package com.jekma.maxe.login.hr.newTraining

//import androidx.navigation.NavController
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.jekma.baselibrary.BaseFragment
import com.jekma.maxe.R

class NewTraining :
//    Fragment(), View.OnClickListener, OnTouchListener
    BaseFragment()
{
    //
//    private var newTrainingViewModel: NewTrainingViewModel? = null
//    private var jsonArray: JSONArray? = null
//    private var context: Context? = null
//    private var folderNAME: String? = null
//    private var view: View? = null
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        context = activity!!.applicationContext
//        folderNAME = activity!!.applicationContext.resources.getString(R.string.HR_NewTraining)
//        this.view = view
//    }
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val root: View = inflater.inflate(R.layout.newtraining, container, false)
//        newTrainingViewModel = ViewModelProviders.of(this).get(NewTrainingViewModel::class.java)
//        newTrainingViewModel.getNewTraining()
//            .observe(viewLifecycleOwner, Observer<String?> { s -> result(s, root) })
//        return root
//    }
//
//    private fun result(response: String?, root: View) {
//        run {
//
//            //            Log.wtf(TAG,"newintroduce_result"+response);
//            var linearLayout = LinearLayout(activity!!.applicationContext)
//            linearLayout = root.findViewById<LinearLayout>(R.id.layout)
//            linearLayout.setBackgroundColor(resources.getColor(R.color.blanchedalmond))
//            val list: ArrayList<*> = ArrayList<Any>()
//            try {
//                jsonArray = JSONArray(response)
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
//                        //                        Log.wtf(TAG,"response_by_TAG = "+response_by_TAG);
//                        val seperate = JSONArray(response_by_TAG)
//                        for (ab in 0 until seperate.length()) {
////                            seperate.get(ab);
////                            Log.wtf(TAG,"seperate.get(ab) = "+seperate.get(ab));
//
////                            String piano = (String) seperate.get(ab);
////
//                            val json: Any = JSONTokener(seperate.get(ab).toString()).nextValue()
//
//                            /*
//                             * Check is JSONObject or JSONArray or File
//                             * if it is not JSONObject or JSONArray that must be a file.
//                             * */if (json is JSONObject) {
////                                JSONArray dirname = new JSONArray(response_by_TAG);
////                                Log.wtf(TAG,"Total Data = "+dirname);
////                                Log.wtf(TAG,"Total Data length = "+seperate.length());
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
//                                        //                                        Log.wtf(TAG,"The dir name is "+dir+"and at "+ab);
//                                        val filename = JSONObject(jsonObject.toString())
//                                        val filenames: JSONArray = filename.getJSONArray(dir) {
//                                            /*
//                                             * 資料夾名稱
//                                             * */
//                                            val switcher = arrayOf("關閉")
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
//                                            inside.setTag("WannaKnow$ab")
//                                            //                                            Log.wtf(TAG,"Tag = "+"exercise-" + ab);
//                                            inside.setOrientation(LinearLayout.VERTICAL)
//                                            inside.setLayoutParams(insidelayoutParams)
//                                            inside.setVisibility(View.GONE)
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
//                                            fileView.setOnTouchListener(this)
//                                            fileView.setTag("" + dir + "/" + filenames.getString(fileCount))
//                                            fileView.setLayoutParams(textViewlayoutParams)
//                                            textViewlayoutParams.setMargins(0, 0, 0, 30)
//                                            inside.addView(fileView)
//                                        }
//                                            combine.addView(dirView)
//                                            combine.addView(inside)
//                                        }
//                                        //
//                                    }
//                                    linearLayout.addView(combine)
//                                    //
//                                }
//                                //                                }
//                            }
//                            else if (json is JSONArray) {
////                                Log.wtf(TAG,"This is JSONArray = "+json);
//                            }
//                            else {
////                                Log.wtf(TAG,"This is file = "+json);
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
//    override fun onClick(v: View) {
//        if (v is TextView) {
////            Log.wtf(TAG,"filename = "+textView.getTag());
//            val textView: TextView = v as TextView
//            textView.getTag()
//            val ButtonName_DIR_FILE = folderNAME + "/" + textView.getTag()
//            when (checkType(textView.getTag() as String)) {
//                "pdf" ->                     /*
//                     * @param: ButtonName
//                     * @param: dirname
//                     * @param: filename
//                     * */img(ButtonName_DIR_FILE)
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
//        val navController: NavController = findNavController(view)
//        navController.navigate(R.id.action_newTraining_to_content4, bundle)
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
//            finalfilename = "http://" + volleyBridge.URL() + "/Documents/" + s
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
//        val navController: NavController = findNavController(view)
//        navController.navigate(R.id.action_newTraining_to_content4, bundle)
//    }
    override val titleResId: Int
        get() = R.string.maxe_title_new_training
    override val layoutResId: Int
        get() = R.layout.maxe_training
}


class NewTrainingViewModel(application: Application) : AndroidViewModel(application) {
//
//    private val TAG = "NewTrainingViewModel"
//    private val NewTraining: MutableLiveData<String>
//    private var mResultCallback: IResult? = null
//    private val thisResult = "initial"
//    private fun Api(application: Application) {
//        initVolleyCallback(TAG)
//        val volleyBridge = VolleyBridge()
//        val passData = HashMap<String, String>()
//        passData["ApiSwitcher"] = "hr_NewEmployeersTraining"
//        val mVolleyService =
//            VolleyService(mResultCallback, passData, "Warn:NewTraining Please Contact Maxe 2213")
//        mVolleyService.postDataVolley("POSTCALL", application, volleyBridge.hr(), thisResult)
//    }
//
//    /*
//     * Return Result
//     * */
//    private fun initVolleyCallback(TAG: String) {
//        mResultCallback = object : IResult {
//            override fun customError(ConnectErrorMessage: String) {
//                Toast.makeText(getApplication<Application>().applicationContext, "" + ConnectErrorMessage, Toast.LENGTH_SHORT)
//                    .show()
//            }
//
//            override fun notifySuccess(requestType: String, response: String) {
//                Log.wtf(TAG, "Volley requester $requestType")
//                Log.wtf(TAG, "Volley JSON post$response")
//                NewTraining.value = response
//            }
//
//            override fun notifyError(requestType: String, error: VolleyError?) {
//                Log.wtf(TAG, "Volley requester $requestType")
//                Log.wtf(TAG, "Volley JSON post" + "That didn't work!")
//            }
//        }
//    }
//
//    fun getNewTraining(): LiveData<String> {
//        return NewTraining
//    }
//
//    init {
//        Api(application)
//        NewTraining = MutableLiveData()
//    }
}