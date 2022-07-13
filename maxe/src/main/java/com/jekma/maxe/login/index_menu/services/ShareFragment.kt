package com.jekma.maxe.login.index_menu.services

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
//import androidx.navigation.NavController
import com.company.maxe.Login.MainActivity
import com.jekma.baselibrary.BaseFragment
import com.jekma.maxe.R
import java.lang.IllegalStateException

class ShareFragment : BaseFragment(), View.OnClickListener {
    override val isShowMainBar: Boolean
        get() = true
    override val titleResId: Int
        get() = R.string.maxe_title_services
    override val layoutResId: Int
        get() = R.layout.fragment_share

    private lateinit var errorcode: LinearLayout
    private lateinit var stock: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val root: View = inflater.inflate(R.layout.fragment_share, container, false)
        ButtonBox(root)
        PermissionCheck("啟動", stock) //查詢料號庫存 //Permission(services_stock)
        PermissionCheck("啟動", errorcode) //查詢錯誤代碼 Permission(services_errorcode)
        return root
    }
//
    private fun ButtonBox(root: View) {
        errorcode = root.findViewById<LinearLayout>(R.id.errorcode)
        stock = root.findViewById<LinearLayout>(R.id.stock)
        errorcode.setOnClickListener(this)
        stock.setOnClickListener(this)
    }

    private fun PermissionCheck(permission: String, TargetButton: LinearLayout?) {
        println("permission = $permission")
        if (permission == "啟動") {
            TargetButton?.setEnabled(true)
        }
        else if (permission == "關閉") {
            TargetButton?.setEnabled(false)
            val textView: TextView = TargetButton?.getChildAt(1) as TextView
            textView.setTextColor(Color.GRAY)
        }
        else {
            Toast.makeText(requireActivity().applicationContext, "Something was wrong !! please contace Maxe 2213", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.errorcode -> {
                gotoNextNavPage(R.id.action_nav_share_to_ser_ErrCod,null)
            }
            R.id.stock     -> {
                gotoNextNavPage(R.id.action_nav_share_to_ser_stock,null)
            }
            else           -> {
                throw IllegalStateException("Unexpected value: " + v.id)
            }
        }
    }
}