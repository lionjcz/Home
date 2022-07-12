package com.jekma.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.get
import com.jekma.baselibrary.BaseFragment
import com.jekma.home.databinding.FragmentProjectsBinding

class ProjectsFragment : BaseFragment() {
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
        binding.projectsMaxe.setOnClickListener {
            Toast.makeText(requireContext(), "Clicke Project:Maxe", Toast.LENGTH_SHORT).show()
            gotoNextNavPage(R.id.action_ProjectsFragment_to_projectsNavContainerFragment,null)
        }
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

