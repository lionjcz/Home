package com.jekma.maxe.login.index_menu.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.jekma.baselibrary.BaseFragment
import com.jekma.maxe.R
import com.jekma.maxe.databinding.MaxeFragmentHomeBinding

class HomeFragment : BaseFragment(), View.OnClickListener {
    override val isShowMainBar: Boolean get() = true
    override val titleResId: Int get() = R.string.maxe_title_home
    override val layoutResId: Int get() = R.layout.maxe_fragment_home

    private var _binding: MaxeFragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = MaxeFragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.announcement.setOnClickListener(this)
        binding.sales.setOnClickListener(this)
        binding.services.setOnClickListener(this)
        binding.hr.setOnClickListener(this)
        binding.documentLaw.setOnClickListener(this)
    }

    /**
     * 選單按鈕
     */
    override fun onClick(v: View) {
        val linearLayout = v as LinearLayout
        when (linearLayout.id) {
            R.id.announcement -> {
                gotoNextNavPage(R.id.action_nav_home_to_nav_announcement, null)
            }
            R.id.sales        -> {
                gotoNextNavPage(R.id.action_nav_home_to_nav_send2, null)
            }
            R.id.services     -> {
                gotoNextNavPage(R.id.action_nav_home_to_nav_share, null)
            }
            R.id.hr           -> {
                gotoNextNavPage(R.id.action_nav_home_to_nav_slideshow, null)
            }
            R.id.document_law -> {
                gotoNextNavPage(R.id.action_nav_home_to_nav_tools2, null)
            }
        }
    }

}