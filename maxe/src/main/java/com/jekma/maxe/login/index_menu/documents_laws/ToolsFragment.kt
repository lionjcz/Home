package com.company.maxe.Login.index_menu.documents_laws

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
//import androidx.navigation.NavController
import com.jekma.maxe.R
import java.lang.IllegalStateException

class ToolsFragment : Fragment()
//    , View.OnClickListener
{
//
//    //    FunctionBox
//    private var view: View? = null
//    var Laws: LinearLayout? = null
//    var Documents: LinearLayout? = null
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        this.view = view
//        Laws = view.findViewById<LinearLayout>(R.id.L2_D_LmenuLaw)
//        Documents = view.findViewById<LinearLayout>(R.id.L2_D_Lmenuocuments)
//        Laws.setOnClickListener(this)
//        Documents.setOnClickListener(this)
//    }
//
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tools, container, false)
    }
//
//    override fun onClick(v: View) {
//        val navController: NavController = findNavController(view)
//        val linearLayout: LinearLayout = v as LinearLayout
//        val changeLayout: Int = linearLayout.getId()
//        when (changeLayout) {
//            R.id.L2_D_LmenuLaw      -> navController.navigate(R.id.action_nav_tools_to_laws)
//            R.id.L2_D_Lmenuocuments -> navController.navigate(R.id.action_nav_tools_to_documents)
//            else                    -> throw IllegalStateException("Unexpected value: " + v.id)
//        }
//    }
}