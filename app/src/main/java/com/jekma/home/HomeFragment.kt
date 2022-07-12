package com.jekma.home

import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jekma.baselibrary.BaseFragment
import com.jekma.home.databinding.FragmentFirstBinding

class HomeFragment : BaseFragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }


    override val setFabListener: (View) -> Unit
        get() = fun(view: View) {
            Toast.makeText(requireContext(), "我在FGMT接收了事件觸發", Toast.LENGTH_LONG).show()
        }

    override val titleResId: Int
        get() = R.string.title_first
    override val layoutResId: Int
        get() = R.layout.fragment_first

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBackground(view)
        setProjectName(resources.getStringArray(R.array.projects))
        listener()
    }

    private fun setBackground(container: View) {
        container.background = resources.getDrawable(R.drawable.ic_dialog_email,null)
        container.background.alpha = 80
    }

    private fun setProjectName(stringArray: Array<String>) {
        for (i in stringArray.indices){
            val ll = binding.llProjects[i] as LinearLayout
            val ImageView = ll[0] as ImageView
            setBackground(ImageView)
//            val textView = ll[1] as TextView
//            textView.text = stringArray[i]
        }

    }

    private fun projectTextView(): TextView {
        val textView = TextView(requireContext())
        return textView
    }

    private fun listener() {
        binding.projects.setOnClickListener {
            gotoNextNavPage(R.id.action_FirstFragment_to_SecondFragment, null)
        }
//        binding.projects.findViewById<BottomNavigationView>(bottomResId).setOnItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.menu_job_thermaltake_gamingdesk_desktop -> {
//                    Toast.makeText(requireContext(), "底部選單按下了desk", Toast.LENGTH_LONG).show()
//                    gotoNextNavPage(R.id.action_FirstFragment_to_SecondFragment, null)
//                    true
//                }
//                else -> {
//                    false
//                }
//            }
//        }
    }

    private fun setBackground(imageview: ImageView) {
        imageview.alpha = 1f;
        Glide.with(this).load(R.drawable.progress).into(imageview)
    }

}