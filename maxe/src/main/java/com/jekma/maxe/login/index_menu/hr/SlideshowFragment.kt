package com.jekma.maxe.login.index_menu.hr

import com.jekma.baselibrary.BaseFragment
import com.jekma.maxe.R

class SlideshowFragment : BaseFragment() {
    //    var Training: LinearLayout? = null
//    var NewTraining: LinearLayout? = null
//    var Introduce: LinearLayout? = null
//    var YearData: LinearLayout? = null
//    var ActivityImg: LinearLayout? = null
//    private var view: View? = null
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        Training = view.findViewById<LinearLayout>(R.id.Training)
//        NewTraining = view.findViewById<LinearLayout>(R.id.NewTraining)
//        Introduce = view.findViewById<LinearLayout>(R.id.Introduce)
//        YearData = view.findViewById<LinearLayout>(R.id.YearData)
//        ActivityImg = view.findViewById<LinearLayout>(R.id.ActivityImg)
//        Training.setOnClickListener(this)
//        NewTraining.setOnClickListener(this)
//        Introduce.setOnClickListener(this)
//        YearData.setOnClickListener(this)
//        ActivityImg.setOnClickListener(this)
//        super.onViewCreated(view, savedInstanceState)
//        this.view = view
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?, savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_slideshow, container, false)
//    }
//
//    override fun onClick(v: View) {
//        val navController: NavController = findNavController(view)
//        val linearLayout: LinearLayout = v as LinearLayout
//        val tvCustomer: TextView = v.findViewById<TextView>(linearLayout.getChildAt(1).getId())
//        Toast.makeText(activity!!.applicationContext, tvCustomer.getText(), Toast.LENGTH_SHORT)
//            .show()
//        val changeLayout: Int = linearLayout.getId()
//        val fragment: Fragment? = null
//        when (changeLayout) {
//            R.id.Training    -> navController.navigate(R.id.action_nav_slideshow_to_training)
//            R.id.NewTraining -> navController.navigate(R.id.action_nav_slideshow_to_newTraining)
//            R.id.Introduce   -> navController.navigate(R.id.action_nav_slideshow_to_introduce)
//            R.id.YearData    -> navController.navigate(R.id.action_nav_slideshow_to_yeardata)
//            R.id.ActivityImg -> navController.navigate(R.id.action_nav_slideshow_to_activityimg)
//            else             -> throw IllegalStateException("Unexpected value: " + v.id)
//        }
//    }
    override val titleResId: Int
        get() = R.string.maxe_title_slideshow
    override val layoutResId: Int
        get() = R.layout.fragment_slideshow
}