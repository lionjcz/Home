package com.jekma.baselibrary

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.core.view.get
import androidx.navigation.ui.setupActionBarWithNavController
import com.jekma.baselibrary.databinding.ActivityBaseBinding


abstract class BaseActivity : AppCompatActivity() {

    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var binding: ActivityBaseBinding
    abstract val defaultNavGraph:Int
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setNavigation(defaultNavGraph!=0)

        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

    }

    private fun setNavigation(isUse: Boolean) {
        try {

            if (isUse){
                val navController = findNavController(R.id.main_nav_host_fragment)
                val inflater = navController.navInflater
                val graph = inflater.inflate(defaultNavGraph)
                navController.graph = graph
                appBarConfiguration = AppBarConfiguration(navController.graph)
                setupActionBarWithNavController(navController, appBarConfiguration)
            }
        }catch (e:Exception){
            Log.e("Develop_","${e.message}")
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.main_nav_host_fragment)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    fun setMainBarTitle(@StringRes titleResId: Int) {
        val title = binding.toolbar[0] as TextView
        title.setText(titleResId)
    }

    fun showLoading(isShow: Boolean, canPressBack: Boolean, gif: Any) {
        val view = binding.mainLoading
        if (view != null) {
            val visibility = view.visibility
            if (isShow) {
                if (visibility != View.VISIBLE) {
                    view.visibility = View.VISIBLE
                }
                Log.d("Develop_","gid:$gif")
                when(gif){
                    is String->{
                        if (gif!="") {
                            view.findViewById<View>(R.id.main_default_progress).apply {
                                this.visibility = View.INVISIBLE
                            }
                            view.findViewById<ImageView>(R.id.main_custom_loading).apply {
                                this.visibility = View.VISIBLE
                                Glide.with(this).load(gif).into(this)
                            }
                        }else{
                            view.findViewById<View>(R.id.main_default_progress).apply {
                                this.visibility = View.VISIBLE
                            }
                            view.findViewById<ImageView>(R.id.main_custom_loading).apply {
                                this.visibility = View.INVISIBLE
                            }
                        }
                    }
                    is Int->{
                        view.findViewById<View>(R.id.main_default_progress).apply {
                            this.visibility = View.INVISIBLE
                        }
                        view.findViewById<ImageView>(R.id.main_custom_loading).apply {
                            this.visibility = View.VISIBLE
                            Glide.with(this).load(gif).into(this)
                        }
                    }
                    else->{
                        view.findViewById<View>(R.id.main_default_progress).apply {
                            this.visibility = View.VISIBLE
                        }
                        view.findViewById<ImageView>(R.id.main_custom_loading).apply {
                            this.visibility = View.INVISIBLE
                        }
                    }
                }

//                mCanPressBack = canPressBack
            }
            else {
                if (visibility != View.GONE) {
                    view.visibility = View.GONE
                }
//                mCanPressBack = true
            }
        }
        else {
//            val id = resources.getResourceEntryName(mainLoading)
//            throw NullPointerException("No get main activity loading view id: '$id'!")
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}