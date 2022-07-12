package com.company.maxe.Login.index_menu.services

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
//import androidx.navigation.NavController
import com.company.maxe.Login.MainActivity
import com.jekma.maxe.R
import java.lang.IllegalStateException

class ShareFragment : Fragment()
//    , View.OnClickListener
{
//    private var shareViewModel: ShareViewModel? = null
//    private var errorcode: LinearLayout? = null
//    private var stock: LinearLayout? = null
//    private var view: View? = null
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        this.view = view
//    }
//
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
//        shareViewModel = ViewModelProviders.of(this).get(ShareViewModel::class.java)
        val root: View = inflater.inflate(R.layout.fragment_share, container, false)
//        ButtonBox(root)
//        val Personal = activity as MainActivity?
//        PermissionCheck(Personal.PERSONAL().get(11), stock) //查詢料號庫存 //Permission(services_stock)
//        PermissionCheck(Personal.PERSONAL()
//            .get(12), errorcode) //查詢錯誤代碼 Permission(services_errorcode)
        return root
    }
//
//    private fun ButtonBox(root: View) {
//        errorcode = root.findViewById<LinearLayout>(R.id.errorcode)
//        stock = root.findViewById<LinearLayout>(R.id.stock)
//        errorcode.setOnClickListener(this)
//        stock.setOnClickListener(this)
//    }
//
//    private fun PermissionCheck(permission: String, TargetButton: LinearLayout?) {
//        println("permission = $permission")
//        if (permission == "啟動") {
//            TargetButton.setEnabled(true)
//        }
//        else if (permission == "關閉") {
//            TargetButton.setEnabled(false)
//            val textView: TextView = TargetButton.getChildAt(1) as TextView
//            textView.setTextColor(Color.GRAY)
//        }
//        else {
//            Toast.makeText(activity!!.applicationContext, "Something was wrong !! please contace Maxe 2213", Toast.LENGTH_SHORT)
//                .show()
//        }
//    }
//
//    override fun onClick(v: View) {
//        val navController: NavController = findNavController(view)
//        var fragment: Fragment
//        when (v.id) {
//            R.id.errorcode -> //                fragment = new Ser_ErrCod();
////                Toast.makeText(getActivity().getApplicationContext(),"errorcode",Toast.LENGTH_SHORT).show();
//                navController.navigate(R.id.action_nav_share_to_ser_ErrCod)
//            R.id.stock     -> //                fragment = new Ser_stock();
////                Toast.makeText(getActivity().getApplicationContext(),"stock",Toast.LENGTH_SHORT).show();
//                navController.navigate(R.id.action_nav_share_to_ser_stock)
//            else           -> throw IllegalStateException("Unexpected value: " + v.id)
//        }
//        //        door(fragment);
//    }
//
//    private fun door(fragment: Fragment) {
//        val bundle = Bundle()
//        bundle.putString("", "")
//        fragment.arguments = bundle
//        val fr = fragmentManager!!.beginTransaction()
//        fr.replace(R.id.nav_host_fragment, fragment)
//        fr.addToBackStack(fragment.javaClass.name)
//        fr.commit()
//    }
}