package com.jekma.futurelab

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.jekma.baselibrary.BaseBindingFragment
import com.jekma.baselibrary.sTAG
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
        mViewModel.setActionListener(object : DeviceListViewModel.OnActionListener{
            override fun onAddDevice() {
                Log.d(sTAG,"click add device")
                gotoNextNavPage(R.id.action_deviceListFragment_to_scanQrcodeFragment)
            }

            override fun onOpenMenu() {
                mViewBinding.drawerLayout.openDrawer(mViewBinding.navigationView)
            }

            override fun onMask() {
                
            }

            override fun onItemPlay(viewModel: DeviceItemViewModel?) {
                
            }

            override fun onItemDelete(viewModel: DeviceItemViewModel?) {
                
            }

            override fun onItemSelect(areaGroupData: List<AreaGroup?>?) {
                
            }

            override fun onGetItemDeviceIcon(type: Device.Type?): Drawable {
                return getDrawable(R.drawable.icon_fragrance)!!
            }

            override fun onGetItemDeviceConnectStatus(status: Device.DeviceConnectStatus?): String {
                var text = ""
                if (status === Device.DeviceConnectStatus.CONNECTING) {
                    text = getString(R.string.tv_connecting)
                }
                return text
            }

            override fun onGetDeviceList(deviceList: List<DeviceItemViewModel>?) {
                
            }

            /**
             * 設定左邊選單的事件
             */
            override fun onSetSettingMenu(memberData: Member) {
                mViewBinding.navigationView.setNavigationItemSelectedListener { item ->
                    when (item.itemId) {
                        R.id.menu_setting -> Log.d(sTAG,"goto Setting")//gotoNextPage(SettingFragment.newInstance(), true)
                        R.id.menu_about   -> Log.d(sTAG,"goto notification")//gotoNextPage(NotificationFragment.newInstance(), true)
                        R.id.menu_privacy -> Log.d(sTAG,"goto About")//gotoNextPage(AboutFragment.newInstance(), true)
                        else              -> throw IllegalStateException("Unexpected value: " + item.itemId)
                    }
                    mViewBinding.drawerLayout.closeDrawer(mViewBinding.navigationView)
                    false
                }
                val navigationHeader = mViewBinding.navigationView.getHeaderView(0)
                val tvDeviceMenuAccountSetting =
                    navigationHeader.findViewById<TextView>(R.id.tv_device_menu_account_setting)
                tvDeviceMenuAccountSetting.setOnClickListener { Log.d(sTAG,"click account setting")//gotoNextPage(AccountSettingFragment.newInstance(), true)
                     }
                val tvDeviceMenuUserName =
                    navigationHeader.findViewById<TextView>(R.id.tv_device_menu_user_name)

                val ivIcon = navigationHeader.findViewById<ImageView>(R.id.iv_icon)
                ivIcon.setOnClickListener { mViewBinding.drawerLayout.closeDrawer(mViewBinding.navigationView) }

                tvDeviceMenuUserName.text = memberData.name

            }

            override fun onSetAreaGroupData(areaGroupData: List<AreaGroup?>?) {
                
            }

            override fun onLogOut() {
                
            }

            override fun onChangeLoadingState(isLoadingShow: Boolean) {
                
            }

            override fun onLogOutResult(error: Error?) {
                
            }

        })
        mViewModel.create()
        mViewBinding.vm = mViewModel
    }
    
    
    
}