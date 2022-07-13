package com.jekma.home

import android.os.Bundle
import android.view.View
import com.jekma.baselibrary.BaseFragment
import androidx.navigation.fragment.NavHostFragment
import java.lang.Exception

class ProjectsNavContainerFragment : BaseFragment() {

    override val titleResId: Int
        get() = R.string.title_projects_nav_container
    override val layoutResId: Int
        get() = R.layout.fragment_projects_nav_container

    override val isShowMainBar: Boolean
        get() = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            val navHostFragment =
                childFragmentManager.findFragmentById(R.id.projects_nav_host) as NavHostFragment
            val navController = navHostFragment.navController
            val inflater = navController.navInflater
            val defaultNavGraph = com.jekma.maxe.R.navigation.maxe_mobile_navigation
            val graph = inflater.inflate(defaultNavGraph)
            navController.graph = graph
        }catch (e:Exception){
            e.printStackTrace()
        }
    }


}