package com.jekma.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.navigation.NavigationBarView
import com.jekma.baselibrary.BaseFragment
import com.jekma.home.databinding.FragmentSecondBinding

class SecondFragment : BaseFragment() {
    override val titleResId: Int
        get() = R.string.second_fragment_label
    override val layoutResId: Int
        get() = R.layout.fragment_second

    override val isShowMainBar: Boolean
        get() = true

    override val listenerBottomBar: NavigationBarView.OnItemSelectedListener?
        get() = NavigationBarView.OnItemSelectedListener { item ->
            when(item.itemId){
                R.id.menu_job_thermaltake_gamingdesk_record->{
                    Toast.makeText(requireContext(),"底部選單按下了record",Toast.LENGTH_LONG).show()
                    gotoNextNavPage(R.id.action_SecondFragment_to_FirstFragment,null)
                    true
                }
                else->{
                    false
                }
            }
        }
    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

