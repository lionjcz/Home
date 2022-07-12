package com.jekma.home


import com.jekma.baselibrary.BaseActivity

class MainActivity : BaseActivity() {
<<<<<<< HEAD
    override val layoutResId: Structure get() = Structure.GENERAL_FRAGMENT
=======
    override val defaultNavGraph: Int
        get() = R.navigation.nav_graph_app


}


>>>>>>> i1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPageController().setNextPage(FirstFragment.newInstance())?.forward()
    }

}