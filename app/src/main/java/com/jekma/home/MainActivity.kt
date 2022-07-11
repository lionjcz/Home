package com.jekma.home

import android.os.Bundle
import com.jekma.baselibrary.BaseActivity

class MainActivity : BaseActivity() {
    override val layoutResId: Structure get() = Structure.GENERAL_FRAGMENT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPageController().setNextPage(FirstFragment.newInstance())?.forward()
    }

}