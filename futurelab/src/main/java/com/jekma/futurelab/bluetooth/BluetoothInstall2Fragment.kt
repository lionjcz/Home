package com.jekma.futurelab.bluetooth

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.jekma.futurelab.R
import java.util.*

class BluetoothInstall2Fragment: BaseBluetoothInstallFragment() {
    private var isBluetoothStatus = false
    private lateinit var mView: View
    private var mSearchedResponse = 0
    private var mHandler: Handler? = null
    private var mButtonEvent = ButtonEvent.NONE
    private var mSelected: String? = null

    private enum class ButtonEvent {
        BLUETOOTH_4_1, BLUETOOTH_5_1, NONE
    }

    override val titleResId: Int
        get() = R.string.app_title
    override val layoutResId: Int
        get() = R.layout.fragment_bluetooth_install2
    override val isShowMainBar: Boolean
        get() = true
    override val isShowBackOnMainBar: Boolean
        get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isBluetoothStatus = requireArguments().getBoolean(ARG_BLUETOOTH_STATUS)
        mSelected = requireArguments().getString(ARG_SELECTED_ITEM)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mView = view
        searchDevices()
    }

    override fun onResume() {
        super.onResume()
        val rand = Random()
        mSearchedResponse = rand.nextInt(2)
    }

    override fun onBackPressed(): Boolean {
        return if (super.mInstallDialog) {
            Dialog(mHandler)
            false
        }
        else {
            true
        }
    }

    private fun searchDevices() {
        if (isBluetoothStatus) {
            val Searching =
                UiState("Serching", "Searching for connected devices for you, please wait a moment.", R.drawable.ic_turn_on_bluetooth, "", false)
            settingView(Searching)
            super.mInstallDialog = true
            delay(3000)
        }
        else {
            Log.d("BluetoothInstallFragment", "Please Turn on Bluetooth")
            val Searching =
                UiState("Please Turn on Bluetooth", "Please make sure your mobile phone and machine are correctly turned on Bluetooth", R.drawable.ic_turn_on_bluetooth, "Turn on bluetooth", true)
            settingView(Searching)
            val turnOnBluetooth = mView!!.findViewById<Button>(R.id.btn_next)
            mButtonEvent = ButtonEvent.BLUETOOTH_4_1
            clickedEvent(turnOnBluetooth)
        }
    }

    private fun settingView(uiState: UiState) {
        val tvTitle: TextView = mView.findViewById<TextView>(R.id.tv_title)
        val tvSubTitle: TextView = mView.findViewById<TextView>(R.id.tv_subtitle)
        val ivIcon = mView!!.findViewById<ImageView>(R.id.iv_icon)
        val button = mView!!.findViewById<Button>(R.id.btn_next)
        tvTitle.text = uiState.title
        tvSubTitle.text = uiState.subTitle
        ivIcon.setImageDrawable(getDrawable(uiState.layoutIconResId))
        button.text = uiState.buttonText
        if (uiState.isDisplayButton) {
            button.visibility = View.VISIBLE
        }
        else {
            button.visibility = View.INVISIBLE
        }
    }

    private fun delay(second: Int) {
        mHandler = Handler()
        mHandler!!.postDelayed({ searchedResponse() }, second.toLong())
    }

    private fun searchedResponse() {
//        mSearchedResponse = 1;//test
        when (mSearchedResponse) {
            0    -> {
                Log.d("BluetoothInstallFragment 5", "device searched")
                gotoNextNavPage(R.id.action_bluetoothInstall2Fragment_to_bluetoothInstall3Fragment,Bundle().apply {
                    this.putBoolean(BluetoothInstall3Fragment.ARG_SEARCHED_RESULT,true)
                    this.putString(BluetoothInstall3Fragment.ARG_SELECTED_ITEM,mSelected)
                })
            }
            1    -> {
                Log.d("BluetoothInstallFragment 5-2", "device search failed")
                gotoNextNavPage(R.id.action_bluetoothInstall2Fragment_to_bluetoothInstall3Fragment,Bundle().apply {
                    this.putBoolean(BluetoothInstall3Fragment.ARG_SEARCHED_RESULT,false)
                    this.putString(BluetoothInstall3Fragment.ARG_SELECTED_ITEM,mSelected)
                })
            }
            else -> {
                Log.d("BluetoothInstallFragment 5-1", "searching time out")
                val Searching =
                    UiState("Not found Device", "Please make sure your mobile phone and machine are correctly turned on Bluetooth", R.drawable.ic_not_found_device, "Reconnecting", true)
                settingView(Searching)
                val notFound = mView!!.findViewById<Button>(R.id.btn_next)
                clickedEvent(notFound)
                mButtonEvent = ButtonEvent.BLUETOOTH_5_1
                super.mInstallDialog = true
            }
        }
    }

    private fun clickedEvent(button: Button) {
        if (mButtonEvent == ButtonEvent.BLUETOOTH_4_1) {
            button.setOnClickListener { Log.d("BluetoothInstallFragment", "Clicked Please turn on bluetooth !") }
        }
        else if (mButtonEvent == ButtonEvent.BLUETOOTH_5_1) {
            button.setOnClickListener {
                Log.d("BluetoothInstallFragment", "Clicked Searching again !")
                searchDevices()
            }
        }
    }

    companion object {
        const val ARG_BLUETOOTH_STATUS = "arg_bluetooth_status"
        const val ARG_SELECTED_ITEM = "arg_selected_item"
        fun newInstance(bluetoothStatus: Boolean, selectedItem: String?): BluetoothInstall2Fragment {
            val bluetoothInstall2Fragment = BluetoothInstall2Fragment()
            val bundle = Bundle()
            bundle.putBoolean(ARG_BLUETOOTH_STATUS, bluetoothStatus)
            bundle.putString(ARG_SELECTED_ITEM, selectedItem)
            bluetoothInstall2Fragment.setArguments(bundle)
            return bluetoothInstall2Fragment
        }
    }
}


class UiState(val title: String, val subTitle: String, val layoutIconResId: Int, val buttonText: String, val isDisplayButton: Boolean)
