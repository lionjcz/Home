package com.company.maxe.Login.index_menu.sales.Button.Customer_Serching

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jekma.maxe.R

class BySerchingResult : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root: View = inflater.inflate(R.layout.fragment_byserchingresult, container, false)
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