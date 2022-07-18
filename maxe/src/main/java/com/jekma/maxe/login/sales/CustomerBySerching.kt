package com.jekma.maxe.login.sales

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
//import androidx.navigation.NavController
//import com.android.volley.AuthFailureError
import com.jekma.maxe.R

/**
 * 搜尋底下全部的經銷商
 */
class CustomerBySerching : Fragment() {
//
//    var TAG = "CustomerBySerching"
//
//    //    ArrayList list;
//    private var adapter: ExampleAdapter? = null
//    private var exampleList: MutableList<ExampleItem>? = null
//    private var mQueue: RequestQueue? = null
//    private var getRequest: StringRequest? = null
//    private var Home_are = "initial"
//    private var searchView: SearchView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root: View = inflater.inflate(R.layout.maxe_fragment_customer_by_serching, container, false)
//        val Personal = activity as MainActivity?
//        val SALES: Array<String> = Personal.SALES()
//        Log.wtf(TAG, "職務類別 = " + Personal.PERSONAL().get(3))
//        if (Personal.PERSONAL().get(3).equals("國內業務人員")) {
//            Log.wtf(TAG, "部門 = " + Personal.PERSONAL().get(2))
//            Log.wtf(TAG, "職位 = " + Personal.PERSONAL().get(4))
//            Home_are = if (Personal.PERSONAL().get(4).equals("本部總經理") && Personal.PERSONAL().get(2)
//                    .equals("業務銷售本部")) {
//                "Manager_all"
//            }
//            else if (Personal.PERSONAL().get(4).equals("副總經理") && Personal.PERSONAL().get(2)
//                    .equals("空調特販本部")) {
//                "SubManager_all"
//            }
//            else {
//                SALES[1]
//            }
//            WholeCustomer(Home_are, root)
//        }
//        else {
//            Toast.makeText(activity!!.applicationContext, "此功能限定業務人員", Toast.LENGTH_SHORT).show()
//        }
        return root
    }
//
//    //HideKeyboard
//    override fun onDetach() {
//        super.onDetach()
//        Log.wtf(TAG, "onDetach")
//        val activity: Activity? = activity
//        hideKeyboard()
//    }
//
//    private fun hideKeyboard() {
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
//    //HideKeyboard
//    private fun LoadData(s: String, root: View) {
//        exampleList = ArrayList()
//        try {
//            val arry = JSONArray(s)
//            val stock_tem = arrayOfNulls<String>(arry.length())
//            val stock_tem1 = arrayOfNulls<String>(arry.length())
//            for (i in 0 until arry.length()) {
//                stock_tem[i] = arry.getJSONObject(i).getString("Customer_NAME")
//                stock_tem1[i] = arry.getJSONObject(i).getString("Customer_NAME2")
//                val combine = "(" + stock_tem1[i] + ")" + stock_tem[i]
//                exampleList.add(ExampleItem(combine))
//            }
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//        //
////        exampleList = new ArrayList<>();
////        for(int i=0 ; i < 200 ; i++){
////            exampleList.add(new ExampleItem("Demo data"+i));
////        }
//    }
//
//    private fun setRecyclerView(root: View) {
//        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerView)
//        recyclerView.setHasFixedSize(true)
//        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
//        adapter = ExampleAdapter(exampleList)
//        recyclerView.layoutManager = layoutManager
//        recyclerView.adapter = adapter
//    }
//
//    //show searched customer
//    private fun DoSearchAction(root: View) {
//        searchView = root.findViewById(R.id.searchView)
//        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE)
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String): Boolean {
//                adapter!!.filter.filter(newText)
//                return false
//            }
//        })
//    }
//
//    //show all customer
//    private fun WholeCustomer(Home_are: String, root: View) {
//        val Customer_sales = VolleyBridge()
//        val url1: String = Customer_sales.Customer_sales()
//        mQueue = Volley.newRequestQueue(activity!!.applicationContext)
//        getRequest =
//            object : StringRequest(Request.Method.POST, url1, object : Listener<String?>() {
//                fun onResponse(s: String) {
//                    println("s = $s")
//                    LoadData(s, root)
//                    setRecyclerView(root)
//                    DoSearchAction(root)
//                }
//            }, object : ErrorListener() {
//                fun onErrorResponse(volleyError: VolleyError?) {
//                    Toast.makeText(activity!!.applicationContext, "Select Customer http connect wrong1    1", Toast.LENGTH_SHORT)
//                }
//            }) {
//                @get:Throws(AuthFailureError::class)
//                protected val params: Map<String, String>
//                    protected get() {
//                        val hashMap = HashMap<String, String>()
//                        hashMap["function_show_all_name"] = Home_are
//                        Log.wtf(TAG, "HashMap = $Home_are")
//                        return hashMap
//                    }
//            }
//        mQueue.add(getRequest)
//    }
//
//    internal inner class ExampleItem(val text2: String)
//    internal inner class ExampleAdapter(exampleList: MutableList<ExampleItem>?) :
//        RecyclerView.Adapter<ExampleViewHolder>(), Filterable, View.OnClickListener,
//        OnTouchListener {
//        private val exampleList: List<ExampleItem>?
//        private val exampleListFull: List<ExampleItem>
//        override fun onClick(v: View) {
//            val textView: TextView = v as TextView
//            Log.wtf("Main", "" + textView.getText())
//            val intent = Intent(activity!!.applicationContext, fragment_customer_sell::class.java)
//            intent.putExtra("test", textView.getText())
//            val bundle = Bundle()
//            bundle.putString("GetCustomer", textView.getText() as String)
//            val navController: NavController = findNavController(view)
//            navController.navigate(R.id.action_Sales_CustomerBySerching_to_fragment_customer_sell, bundle)
//            searchView!!.setQuery("", false) // clear the text
//            searchView!!.isIconified = true // close the search editor and make search icon again
//        }
//
//        override fun onTouch(v: View, event: MotionEvent): Boolean {
//            val linearLayout: TextView = v as TextView
//            val color = Color.TRANSPARENT
//            when (event.getAction()) {
//                MotionEvent.ACTION_DOWN   -> {
//                    Log.wtf("Testing", "ACTION_DOWN")
//                    linearLayout.setBackgroundColor(resources.getColor(R.color.gray))
//                }
//                MotionEvent.ACTION_UP     -> {
//                    Log.wtf("Testing", "ACTION_UP")
//                    linearLayout.setBackgroundColor(color)
//                }
//                MotionEvent.ACTION_MOVE   -> {
//                    Log.wtf("Testing", "ACTION_MOVE")
//                    linearLayout.setBackgroundColor(color)
//                }
//                MotionEvent.ACTION_CANCEL -> {
//                    Log.wtf("Testing", "ACTION_CANCEL")
//                    linearLayout.setBackgroundColor(color)
//                }
//            }
//            return false
//        }
//
//        internal inner class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//            var imageView: ImageView? = null
//            var textView1: TextView? = null
//            var textView2: TextView
//
//            init {
//                //                imageView = itemView.findViewById(R.id.image_view);
////                textView1 = itemView.findViewById(R.id.textView1);
//                textView2 = itemView.findViewById<TextView>(R.id.textView2)
//            }
//        }
//
//        private val selectedPos = RecyclerView.NO_POSITION
//        var selected_position = 0 // You have to set this globally in the Adapter class
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
//            val v: View = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.example_item, parent, false)
//            return ExampleViewHolder(v)
//        }
//
//        override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
//            val currentItem = exampleList!![position]
//            //            holder.imageView.setImageResource(currentItem.getImageResource());
////            holder.textView1.setText(currentItem.getText1());
//            holder.textView2.setText(currentItem.text2)
//            holder.textView2.setOnClickListener(this)
//            holder.textView2.setOnTouchListener(this)
//
////            holder.textView2.setBackgroundColor(selected_position == position ? Color.GREEN : Color.TRANSPARENT);
//
////            holder.textView2.setSelected(selectedPos == position);
//        }
//
//        override fun getItemCount(): Int {
//            return exampleList!!.size
//        }
//
//        override fun getFilter(): Filter {
//            return exampleFilter
//        }
//
//        private val exampleFilter: Filter = object : Filter() {
//            override fun performFiltering(constraint: CharSequence): FilterResults {
//                val filteredList: MutableList<ExampleItem> = ArrayList()
//                if (constraint == null || constraint.length == 0) {
//                    filteredList.addAll(exampleListFull)
//                }
//                else {
//                    val filterPattern =
//                        constraint.toString().lowercase(Locale.getDefault()).trim { it <= ' ' }
//                    for (item in exampleListFull) {
//                        if (item.text2.lowercase(Locale.getDefault()).contains(filterPattern)) {
//                            filteredList.add(item)
//                        }
//                    }
//                }
//                val results = FilterResults()
//                results.values = filteredList
//                return results
//            }
//
//            override fun publishResults(constraint: CharSequence, results: FilterResults) {
//                exampleList!!.clear()
//                exampleList.addAll(results.values as List<*>)
//                notifyDataSetChanged()
//            }
//        }
//
//        init {
//            this.exampleList = exampleList
//            exampleListFull = ArrayList(exampleList)
//        }
//    }
}


class BySerchingResult : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root: View = inflater.inflate(R.layout.maxe_fragment_byserchingresult, container, false)
        val arguments: Bundle? = arguments
        if (arguments != null) {
            val data: String? = arguments.getString("DemoData")
            println("DemoData = $data")
        }
        else {
            Toast.makeText(context, "bundle without no data", Toast.LENGTH_SHORT).show()
        }
        return root
    }
}