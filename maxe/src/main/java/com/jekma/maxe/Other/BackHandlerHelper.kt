package com.company.maxe.Other

//import androidx.lifecycle.ViewModelProvider.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

object BackHandlerHelper {
    fun handleBackPress(fragmentManager: FragmentManager): Boolean {
        val fragments = fragmentManager.fragments ?: return false
        var i = fragments.size - 1
        while (i >= 0) {
            val child = fragments[i]
            if (isFragmentBackHandler(child)) {
                return true
            }
            i++
        }
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStack()
            return true
        }
        return false
    }

    fun handleBackPress(fragment: Fragment): Boolean {
        return handleBackPress(fragment.childFragmentManager)
    }

    fun handleBackPress(fragmentActivity: FragmentActivity): Boolean {
        return handleBackPress(fragmentActivity.supportFragmentManager)
    }

    fun isFragmentBackHandler(fragment: Fragment?): Boolean {
        return (fragment != null && fragment.isVisible && fragment.userVisibleHint && fragment is FragmentBackHandler && (fragment as FragmentBackHandler).onBackPressed())
    }
}