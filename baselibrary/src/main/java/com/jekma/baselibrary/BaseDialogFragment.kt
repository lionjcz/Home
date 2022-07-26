package com.jekma.baselibrary

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.annotation.MenuRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.DialogFragment
import java.util.*

abstract class BaseDialogFragment : DialogFragment() {
    private lateinit var mToolbar: Toolbar
    private lateinit var mViewLoading: ViewGroup
    protected var mCanPressBack = true

    @get:StringRes
    abstract val titleResId: Int

    private val mainLayoutResId: Int get() = R.layout.fragment_dialog_base

    @get:LayoutRes
    abstract val layoutResId: Int
    private val isUseMainBar: Boolean get() = false

    @get:MenuRes
    val mainBarMenuResId: Int get() = 0
    val isShowMainBar: Boolean get() = false
    private val isShowBackOnMainBar: Boolean get() = false

    @get:IdRes
    protected val mainBarId: Int get() = R.id.main_bar

    @get:IdRes
    protected val mainBarTitleId: Int get() = R.id.main_bar_title

    @get:IdRes
    protected val mainContainerId: Int
    get() = R.id.main_container

    @get:IdRes
    protected val mainLoadingId: Int     get() = R.id.main_loading

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(mainLayoutResId, container, false)
        mToolbar = view.findViewById(mainBarId)
        if (isUseMainBar) {
            mToolbar.visibility = View.VISIBLE
            showMainBar(isShowMainBar)
            setMainBarTitle(titleResId)
            if (isShowBackOnMainBar) {
                mToolbar.setNavigationOnClickListener {
                    try {
                        Objects.requireNonNull(dialog!!).onBackPressed()
                    } catch (e: NullPointerException) {
                        e.printStackTrace()
                    }
                }
            }
            else {
                mToolbar.navigationIcon = null
            }
            if (mainBarMenuResId != 0) {
                mToolbar.inflateMenu(mainBarMenuResId)
                mToolbar.setOnMenuItemClickListener { item: MenuItem -> onMenuItemClick(item) }
            }
        }
        else {
            mToolbar.visibility = View.GONE
        }
        setMainContainer(view, inflater.inflate(layoutResId, container, false))
        mViewLoading = view.findViewById(mainLoadingId)
        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var dialog: Dialog
        try {
            dialog = object : Dialog(requireContext(), theme) {
                override fun onBackPressed() {
                    if (mCanPressBack) {
                        if (isLoading) {
                            showLoading(false)
                        }
                        else {
                            super.onBackPressed()
                        }
                    }
                }
            }
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        } catch (e: NullPointerException) {
            e.printStackTrace()
            dialog = super.onCreateDialog(savedInstanceState)
        }
        return dialog
    }

    private fun setMainContainer(rootView: View?, childView: View?) {
        if (rootView == null) return
        val mainContainer = rootView.findViewById<ViewGroup>(mainContainerId)
        mainContainer.removeAllViews()
        mainContainer.addView(childView)
    }

    @SuppressLint("ResourceType")
    fun setMainBarTitle(@StringRes titleResId: Int) {
        if (titleResId > 0) {
            setMainBarTitle(getString(titleResId))
        }
    }

    private fun setMainBarTitle(title: String?) {
        if (isUseMainBar) {
            val tvTitle = mToolbar.findViewById<TextView>(mainBarTitleId)
            tvTitle.text = title
        }
    }

    private fun onMenuItemClick(item: MenuItem): Boolean {
        return false
    }

    private fun showMainBar(isShow: Boolean) {
        if (isUseMainBar) {
            mToolbar.visibility = if (isShow) View.VISIBLE else View.GONE
        }
    }

    @JvmOverloads
    fun showLoading(isShow: Boolean, canPressBack: Boolean = true) {
        mCanPressBack = canPressBack
        mViewLoading.visibility = if (isShow) View.VISIBLE else View.GONE
    }

    val isLoading: Boolean
        get() = mViewLoading.visibility == View.VISIBLE
    val isShowing: Boolean
        get() = dialog != null && dialog!!.isShowing && !isRemoving
}
