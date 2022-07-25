package com.jekma.futurelab

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.jekma.baselibrary.BaseBindingFragment
import com.jekma.futurelab.databinding.DeviceListBinding


@RequiresApi(Build.VERSION_CODES.Q)
class DeviceListFragment : BaseBindingFragment<DeviceListBinding,DeviceListViewModel>() {

    override var permissionOnViewListener: PermissionOnView? = null
    override val titleResId: Int
        get() = R.string.app_title_device
    override val layoutResId: Int
        get() = R.layout.fragment_device_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.create()
        mViewBinding.vm = mViewModel
    }
}