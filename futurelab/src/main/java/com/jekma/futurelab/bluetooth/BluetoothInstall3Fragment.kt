package com.jekma.futurelab.bluetooth

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jekma.futurelab.Device
import com.jekma.futurelab.R
import java.util.*

class BluetoothInstall3Fragment private constructor() : BaseBluetoothInstallFragment() {
    private var mSearchedResult = false
    private var mLlNotFound: LinearLayout? = null
    private var mTvTitle: TextView? = null
    private var mTvSubTitle: TextView? = null
    private var mIvIcon: ImageView? = null
    private var mBtnNext: Button? = null
    private var mConnectedResponse = false
    private lateinit var mView: View
    private var mSuccessfulConnected = false
    private var mHandler: Handler? = null
    private var mSelectedItem: String? = null
    private var mTvResearch: TextView? = null
    override val titleResId: Int
        get() = R.string.app_title
    override val layoutResId: Int
        get() = R.layout.fragment_bluetooth_install3
    override val isShowMainBar: Boolean
        get() = true
    override     val isShowBackOnMainBar: Boolean
        get() = true

    override fun dialogDismiss() {
        super.dialogDismiss()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getArguments() != null) {
            mSearchedResult = requireArguments().getBoolean(ARG_SEARCHED_RESULT)
            mSelectedItem = requireArguments().getString(ARG_SELECTED_ITEM)
        }
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mView = view
        mLlNotFound = mView.findViewById<LinearLayout>(R.id.ll_notfound)
        mTvTitle = mView.findViewById<TextView>(R.id.tv_title)
        mTvSubTitle = mView.findViewById<TextView>(R.id.tv_subtitle)
        mIvIcon = mView!!.findViewById(R.id.iv_icon)
        mBtnNext = mView!!.findViewById(R.id.btn_next)
        mTvResearch = mView.findViewById<TextView>(R.id.tv_reserch)
        connectDevices()
    }

    override  fun onResume() {
        super.onResume()
    }

    protected fun back() {}
    override  fun onBackPressed(): Boolean {
        return if (super.mInstallDialog) {
            if (mSuccessfulConnected) {
                back()
                false
            }
            else {
                if (mHandler != null) {
                    Dialog(mHandler)
                }
                else {
                    Dialog(null)
                }
                super.onBackPressed()
                false
            }
        }
        else {
            true
        }
    }

    private fun connectDevices() {
        super.mInstallDialog = true
        if (mSearchedResult) {
            val Connected =
                UiState("Connecting", "Connecting to fragrance machine 001", R.drawable.ic_connecting, "", false)
            settingView(Connected)
            val rand = Random()
            mConnectedResponse = rand.nextBoolean()
            delay(3000)
        }
        else {
            val mArrayListDevice: ArrayList<Device> = ArrayList<Device>()
            for (i in 0 until Data.names.length) {
                val device = Device()
                device.setName(Data.names.get(i))
                mArrayListDevice.add(device)
            }
            val deviceAdapter =
                BluetoothInstall3Adapter(mArrayListDevice, R.layout.display_item_bluetoothfragment3)
            deviceAdapter.setList(mArrayListDevice)
            deviceAdapter.setOnItemClickListener(object : OnItemClickListener() {
                fun onResponse(position: Int) {
                    val selectedItem: String? = null
                    gotoNextPage(tw.com.futurelab.iotmain.feature.main.BluetoothInstall1Fragment.newInstance(selectedItem), true)
                }
            })
            val rvDeviceList = mView!!.findViewById<RecyclerView>(R.id.rv_devicelist)
            rvDeviceList.adapter = deviceAdapter
            val dividerItemDecoration =
                DividerItemDecoration(rvDeviceList.context, LinearLayout.VERTICAL)
            dividerItemDecoration.setDrawable(getDrawable(R.drawable.divider_1))
            rvDeviceList.addItemDecoration(dividerItemDecoration)
            val linearLayoutManager: LinearLayoutManager =
                object : LinearLayoutManager(this.getContext()) {
                    override fun canScrollVertically(): Boolean {
                        return false
                    }
                }
            rvDeviceList.layoutManager = linearLayoutManager
            rvDeviceList.isNestedScrollingEnabled = false
            mTvTitle.setVisibility(View.INVISIBLE)
            mTvSubTitle.setVisibility(View.INVISIBLE)
            mIvIcon!!.visibility = View.INVISIBLE
            mBtnNext!!.visibility = View.INVISIBLE
            mLlNotFound.setVisibility(View.VISIBLE)
            mTvResearch.setOnClickListener(View.OnClickListener { gotoNextPage(BluetoothInstall2Fragment.Companion.newInstance(true, mSelectedItem), false) })
        }
    }

    private fun delay(second: Int) {
        mHandler = Handler()
        mHandler!!.postDelayed({
            dialogDismiss()
            if (mConnectedResponse) {
                val Connected =
                    UiState("Connect successful !", "Now you can use the machine", R.drawable.ic_connect_success, "Done", true)
                settingView(Connected)
                showBackOnMainBar()
                val button = mView!!.findViewById<Button>(R.id.btn_next)
                button.setOnClickListener { gotoNextPage(DeviceListFragment.newInstance(), false) }
                val dynamicallyDeviceId = Random()
                val deviceID = dynamicallyDeviceId.nextInt(10)
                val mMemberLocalModel = MemberLocalModel(getActivity().getApplication())
                val deviceList: MutableList<Device>
                if (mMemberLocalModel.getDevice() != null) {
                    deviceList = mMemberLocalModel.getDevice()
                }
                else {
                    deviceList = ArrayList<Device>()
                }
                val device = Device(deviceID.toString(), "Type$deviceID")
                device.setName(mSelectedItem)
                deviceList.add(device)
                mMemberLocalModel.saveDevice(deviceList)
            }
            else {
                val Connected =
                    UiState("Connect fail !", "Something was wrong in connecting , please try again.", R.drawable.ic_connect_fail, "Connect again", true)
                settingView(Connected)
                val button = mView!!.findViewById<Button>(R.id.btn_next)
                button.setOnClickListener { connectDevices() }
            }
        }, second.toLong())
    }

    private fun settingView(uiState: UiState) {
        mTvTitle.setText(uiState.getTitle())
        mTvSubTitle.setText(uiState.getSubTitle())
        mIvIcon!!.setImageDrawable(getDrawable(uiState.getLayoutIconResId()))
        mBtnNext.setText(uiState.getButtonText())
        mTvTitle.setVisibility(View.VISIBLE)
        mTvSubTitle.setVisibility(View.VISIBLE)
        mIvIcon!!.visibility = View.VISIBLE
        mLlNotFound.setVisibility(View.INVISIBLE)
        if (uiState.getIsDisplayButton()) {
            mBtnNext!!.visibility = View.VISIBLE
        }
        else {
            mBtnNext!!.visibility = View.INVISIBLE
        }
    }

    private fun showBackOnMainBar() {
        mSuccessfulConnected = true
        try {
            super.showBackOnMainBar(false)
        } catch (e: Base.Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        const val ARG_SEARCHED_RESULT = "arg_searched_result"
        const val ARG_SELECTED_ITEM = "arg_selected_item"
        fun newInstance(serchedResult: Boolean, selectedItem: String?): BluetoothInstall3Fragment {
            val bundle = Bundle()
            bundle.putBoolean(ARG_SEARCHED_RESULT, serchedResult)
            bundle.putString(ARG_SELECTED_ITEM, selectedItem)
            val bluetoothInstall3Fragment = BluetoothInstall3Fragment()
            bluetoothInstall3Fragment.setArguments(bundle)
            return bluetoothInstall3Fragment
        }
    }
}