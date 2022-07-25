package com.jekma.home

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.get
import com.jekma.baselibrary.BaseFragment
import com.jekma.home.databinding.FragmentProjectsBinding

class ProjectsFragment : BaseFragment() {
    companion object{
        const val NAV_GRAPH = "NAV_GRAPH"
    }
    override val titleResId: Int
        get() = R.string.title_projects
    override val layoutResId: Int
        get() = R.layout.fragment_projects

    override val isShowMainBar: Boolean
        get() = true

    private var _binding: FragmentProjectsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProjectsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setProjectName(resources.getStringArray(R.array.projects))

        setProjectButton(name = "Maxe",image = getDrawable(com.jekma.maxe.R.mipmap.maxe_logo)!!,view = binding.llMaxe,listener = View.OnClickListener {
            gotoNextNavPage(R.id.action_ProjectsFragment_to_projectsNavContainerFragment,Bundle().apply {
                this.putInt(NAV_GRAPH,com.jekma.maxe.R.navigation.maxe_mobile_navigation)
            })
        })


        setProjectButton(name = "FutureLab",image = getDrawable(com.jekma.futurelab.R.mipmap.ic_logo)!!,view = binding.llFutureLab,listener = View.OnClickListener {
            gotoNextNavPage(R.id.action_ProjectsFragment_to_projectsNavContainerFragment,Bundle().apply {
                this.putInt(NAV_GRAPH,com.jekma.futurelab.R.navigation.default_navigation)
            })
        })
    }

    private fun setProjectButton(name: String, image: Drawable, view: LinearLayout, listener: View.OnClickListener) {
        val imageView = view[0] as ImageView
        val textView = view[1] as TextView
        imageView.background = image
        textView.text = name
        view.setOnClickListener(listener)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun setProjectName(stringArray: Array<String>) {

        for (i in stringArray.indices) {
            val ll = binding.llProjects[i] as LinearLayout
            val ImageView = ll[0] as ImageView
//            setBackground(ImageView)
//            val textView = ll[1] as TextView
//            textView.text = stringArray[i]
        }

    }
}

