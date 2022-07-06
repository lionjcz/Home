package com.jekma.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jekma.baselibrary.BaseFragment
import com.jekma.home.databinding.FragmentSecondBinding

class SecondFragment : BaseFragment() {
    override val titleResId: Int
        get() = R.string.second_fragment_label
    override val layoutResId: Int
        get() = R.layout.fragment_second

}