package com.jekma.home

import android.os.Bundle
import android.view.View
import com.jekma.baselibrary.BaseFragment

class FirstFragment : BaseFragment() {

    companion object {
        fun newInstance() = FirstFragment()
    }

    override val titleResId: Int
        get() = R.string.title_first
    override val layoutResId: Int
        get() = R.layout.fragment_first

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoading(true, gif = "https://media1.giphy.com/media/YeH7jDG54fHWw/giphy.gif?cid=ecf05e47f8jr6wcbbibygu7mie28clxkzjhbkmvu2etyhbn3&rid=giphy.gif&ct=g")
    }

}