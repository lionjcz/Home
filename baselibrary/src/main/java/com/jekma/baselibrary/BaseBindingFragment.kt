package com.jekma.baselibrary

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

@RequiresApi(api = Build.VERSION_CODES.Q)
abstract class BaseBindingFragment<VDB : ViewDataBinding, VM : BaseViewModel> : BaseFragment() {

    protected lateinit var mViewBinding: VDB
    protected lateinit var mViewModel: VM

    @Suppress("UNCHECKED_CAST")
    /**
     * 綁定生命周即-創造
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val type = javaClass.genericSuperclass!!
        val vmClass = (type as ParameterizedType).actualTypeArguments[1] as Class<VM>
        mViewModel = ViewModelProvider(this)[vmClass]
    }

    /**
     * 綁定ViewModel
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mViewBinding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        mViewBinding.lifecycleOwner = this
        return mViewBinding.root
    }

    /**
     * 綁定生命週期
     * 因為需要要求權限，所以傳入Activity以及權限的Callback進去ViewModel
     */
    override fun onResume() {
        super.onResume()
        mViewModel?.resume(requireActivity(),permissionOnViewListener)
    }

    /**
     * 綁定生命周即-暫停
     */
    override fun onPause() {
        super.onPause()
        mViewModel?.pause()
    }

    /**
     * 綁定生命周即-銷毀
     */
    override fun onDestroy() {
        super.onDestroy()
        mViewModel?.destroy()
    }

    abstract var permissionOnViewListener: PermissionOnView?

    interface PermissionOnView{
        fun onFirstRequest(s: String)
        fun onSecondRequest(permission: String)
        fun requestSuccess()
        fun currentPermissionResult(hasPermissions: Boolean)
    }


}