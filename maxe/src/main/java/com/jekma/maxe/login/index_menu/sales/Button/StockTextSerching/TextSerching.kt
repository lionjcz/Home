package com.company.maxe.Login.index_menu.sales.Button.StockTextSerching

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
//import com.android.volley.AuthFailureError
import com.jekma.maxe.R

class TextSerching : Fragment()
//    , View.OnClickListener, OnEditorActionListener
{
//
//    private val TAG = "TextSerching"
//    private var mQueue: RequestQueue? = null
//    var editview: EditText? = null
//    var zoot: View? = null
//    private var TextSerching_Cancel: Button? = null
//    private var ok: Button? = null
//    private val stockMaxe: String? = null
//    private val stockElse: String? = null
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        Log.wtf(TAG, "onAttach")
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        Log.wtf(TAG, "onCreateView")
        val root: View = inflater.inflate(R.layout.maxe_textserching, container, false)
//        zoot = root
//        editview = root.findViewById<EditText>(R.id.TextSerchingContent)
//        editview.setOnEditorActionListener(this)
//        TextSerching_Cancel = root.findViewById(R.id.TextSerching_Cancel)
//        TextSerching_Cancel.setOnClickListener(this)
//        ok = root.findViewById(R.id.TextSerching_Ok)
//        ok.setOnClickListener(this)
        return root
    }

    //    @Override
    //    public void onActivityCreated(Bundle savedInstanceState) {
    //        Log.wtf(TAG,"onActivityCreated");
    //        super.onActivityCreated(savedInstanceState);
    //        final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
    //        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
//    //    }//not working
//    override fun onStart() {
//        Log.wtf(TAG, "onStart")
//        super.onStart()
//    }
//
//    override fun onResume() {
//        Log.wtf(TAG, "onResume")
//        super.onResume()
//    }
//
//    /*
//     * Listen Click event
//     * */
//    override fun onClick(v: View) {
//        when (v.id) {
//            R.id.TextSerching_Cancel -> Cancel_event()
//            R.id.TextSerching_Ok     -> ok_event()
//        }
//    }
//
//    /*
//    * Remove all TextView
//    * */
//    private fun Cancel_event() {
//        removeAllTextView()
//        editview.setText("")
//    }
//
//    /*
//    * OK event
//    * */
//    private fun ok_event() {
//        removeAllTextView() // remove previous result
//        Api(editview.getText().toString()) //get data according User Input
//        closeKeyboard() //close virtual keyboard
//        hideKeyboard(activity)
//    }
//
//    /*
//    * Close virtual keyboard*/
//    private fun closeKeyboard() {
//        if (zoot != null) {
//            try {
//                val imm =
//                    activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//                imm.hideSoftInputFromWindow(zoot!!.windowToken, 0)
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//    }
//
//    /**
//     * Remove all data
//     */
//    private fun removeAllTextView() {
//        val linearLayout2: LinearLayout =
//            zoot!!.findViewById<View>(R.id.TextSerching_ResultContainer) as LinearLayout
//        linearLayout2.removeAllViewsInLayout()
//    }
//
//    /*
//    * Connect to API and that will return result
//    * */
//    fun Api(editxt: String) {
//        mQueue = Volley.newRequestQueue(activity!!.applicationContext)
//        val Services_stock = VolleyBridge()
//        val getRequest: StringRequest = object :
//            StringRequest(Request.Method.POST, Services_stock.Sales_textSerching(), object :
//                Listener<String?>() {
//                fun onResponse(s: String) {
//                    Parsing(s)
//                }
//            }, object : ErrorListener() {
//                fun onErrorResponse(error: VolleyError?) {
//                    Toast.makeText(context, "Warn: Please Contact Maxe 2213", Toast.LENGTH_SHORT)
//                        .show()
//                }
//            }) {
//            //stockMaxe
//            //stockElse
//            @get:Throws(AuthFailureError::class)
//            protected val params: Map<String, String>
//                protected get() {
//                    val personal = activity as MainActivity?
//                    val hashMap = HashMap<String, String>()
//                    hashMap["type"] = editxt
//                    hashMap["stockMaxe"] = personal.PERSONAL().get(6) //stockMaxe
//                    hashMap["stockElse"] = personal.PERSONAL().get(7) //stockElse
//                    Log.wtf("$TAG=>Passing To Api", "type-> $editxt")
//                    Log.wtf("$TAG=>Passing To Api", "stockMaxe -> " + personal.PERSONAL().get(6))
//                    Log.wtf("$TAG=>Passing To Api", "stockElse -> " + personal.PERSONAL().get(7))
//                    return hashMap
//                }
//        }
//        mQueue.add(getRequest)
//    }
//
//    /*
//     * Dynamically add TexeView into LinearLayout
//     * Param: i
//     * */
//    private fun addTextView(i: Int) {
//        val linearLayout: LinearLayout =
//            view!!.findViewById<View>(R.id.TextSerching_ResultContainer) as LinearLayout
//        val textview = TextView(activity!!.applicationContext)
//        textview.setId(0 + i)
//        linearLayout.addView(textview)
//    }
//
//    /*
//     * Parsing JSON response from Api
//     * */
//    private fun Parsing(s: String) {
//        try {
//            val arry1 = JSONArray(s)
//            if (arry1 == null) {
//                Toast.makeText(activity!!.applicationContext, "arry1 為空", Toast.LENGTH_LONG).show()
//            }
//            else {
//                val result: Boolean = arry1.getJSONObject(0).optBoolean("result")
//                if (result) {
//                    val testarray = arrayOfNulls<String>(arry1.length())
//                    val testarray1 = arrayOfNulls<String>(arry1.length())
//                    val testarray2 = arrayOfNulls<String>(arry1.length())
//                    //撈資料並存到陣列
//                    val textViews: Array<TextView?> = arrayOfNulls<TextView>(arry1.length())
//                    for (i in 0 until arry1.length()) {
//                        addTextView(i)
//                        testarray[i] = arry1.getJSONObject(i).getString("type")
//                        testarray1[i] = arry1.getJSONObject(i).getString("number")
//                        testarray2[i] = arry1.getJSONObject(i).getString("place")
//                        textViews[i] = view.findViewById<TextView>(0 + i)
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                            textViews[i].setAutoSizeTextTypeUniformWithConfiguration(8, 17, 3, 3)
//                        }
//                        textViews[i].setText("0$i")
//                        textViews[i].setText("""
//                                型號　：${testarray[i]}
//                                數量　：${testarray1[i]}
//                                倉別　：${testarray2[i]}
//
//
//                                """.trimIndent())
//                        textViews[i].setTextColor(-0x1000000)
//                    }
//                }
//                else {
//                    Toast.makeText(context, arry1.getJSONObject(0)
//                        .optString("response"), Toast.LENGTH_SHORT).show()
//                }
//            }
//        } catch (e: JSONException) {
//            e.printStackTrace()
//            Toast.makeText(activity!!.applicationContext, "查無型號", Toast.LENGTH_LONG).show()
//        }
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        Log.wtf(TAG, "onDetach")
//        println("abcddddddddddddddddd")
//        val activity: Activity? = activity
//        println("activity = $activity")
//        hideKeyboard()
//    }
//
//    fun hideKeyboard() {
////        InputMethodManager inputManager = (InputMethodManager) activity
////                .getSystemService(Context.INPUT_METHOD_SERVICE);
////        count ++;
////        System.out.println("count = "+count);
////        View currentFocusedView = activity.getCurrentFocus();
////        inputManager.hideSoftInputFromWindow(currentFocusedView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
////
//        val inputManager =
//            activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        val focusedView = activity!!.currentFocus
//        /*
//         * If no view is focused, an NPE will be thrown
//         *
//         * Maxim Dmitriev
//         */if (focusedView != null) {
//            inputManager.hideSoftInputFromWindow(focusedView.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
//        }
//    }
//
//    override fun onEditorAction(v: TextView, actionId: Int, event: KeyEvent): Boolean {
//        when (actionId) {
//            EditorInfo.IME_ACTION_SEND -> ok_event()
//        }
//        return false
//    }
//
//    companion object {
//        /*
//    * Hide keyboard
//    * */
//        fun hideKeyboard(activity: Activity?) {
//            val inputManager =
//                activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//
//            // check if no view has focus:
//            val currentFocusedView: View = activity.getCurrentFocus()
//            if (currentFocusedView != null) {
//                inputManager.hideSoftInputFromWindow(currentFocusedView.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
//            }
//        }
//    }
}