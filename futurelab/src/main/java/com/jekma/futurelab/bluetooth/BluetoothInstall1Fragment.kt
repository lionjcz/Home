package com.jekma.futurelab.bluetooth

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.jekma.baselibrary.BaseDialogFragment
import com.jekma.baselibrary.BaseFragment
import com.jekma.baselibrary.sTAG
import com.jekma.futurelab.R
import java.util.*

class BluetoothInstall1Fragment: BaseBluetoothInstallFragment() {
    private val mRandom = Random(1)
    private var mSelectedItem: String? = null
    override val titleResId: Int
        get() = R.string.app_title
    override val layoutResId: Int
        get() = R.layout.fragment_bluetooth_install1
    override val isShowMainBar: Boolean
        get() = true
    override val isShowBackOnMainBar: Boolean
        get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSelectedItem = requireArguments().getString(ARG_SELECTED_ITEM)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnNext = view.findViewById<Button>(R.id.btn_next)
        btnNext.setOnClickListener {
            if (mRandom.nextBoolean()) {
                gotoNextNavPage(R.id.action_bluetoothInstall1Fragment_to_bluetoothInstall2Fragment,Bundle().apply {
                    this.putBoolean(BluetoothInstall2Fragment.ARG_BLUETOOTH_STATUS,true)
                    this.putString(BluetoothInstall2Fragment.ARG_SELECTED_ITEM,mSelectedItem)
                })
            }
            else {
                gotoNextNavPage(R.id.action_bluetoothInstall1Fragment_to_bluetoothInstall2Fragment,Bundle().apply {
                    this.putBoolean(BluetoothInstall2Fragment.ARG_BLUETOOTH_STATUS,false)
                    this.putString(BluetoothInstall2Fragment.ARG_SELECTED_ITEM,mSelectedItem)
                })
            }
        }
    }

    companion object {
        private const val ARG_SELECTED_ITEM = "arg_selected_item"
        fun newInstance(selectedItem: String?): BluetoothInstall1Fragment {
            val bluetoothInstall1Fragment = BluetoothInstall1Fragment()
            val bundle = Bundle()
            bundle.putString(ARG_SELECTED_ITEM, selectedItem)
            bluetoothInstall1Fragment.arguments = bundle
            return bluetoothInstall1Fragment
        }

        fun newInstance(): BluetoothInstall1Fragment {
            return BluetoothInstall1Fragment()
        }
    }
}


open class BaseBluetoothInstallFragment : BaseFragment() {
    protected var mInstallDialog = false
    protected var mMsgDialogFragment: MsgDialogFragment? = null
    fun Dialog(mHandler: Handler?) {
        if (!mInstallDialog) return
        val tipDialogFragment =
            TipDialogFragment(TipDialogFragment.TYPE.DEFAULT, getString(R.string.member_alert_save_change), getString(R.string.btn_save), getString(R.string.btn_cancel))
        tipDialogFragment.setOnButtonPressed(object : TipDialogFragment.OnButtonPressed {
            override fun inPressOk() {
                Log.d(sTAG,"press ok"+javaClass.simpleName)
//                gotoNextPage(InstallDevicesFragment.newInstance(), false)
                mHandler?.removeCallbacksAndMessages(null)
            }

            override fun inPressCancel() {}
            override fun inPressX() {}
        })
        tipDialogFragment.show(childFragmentManager, null)
    }

    override  val titleResId: Int
        get() = 0
    override val layoutResId: Int
        get() = 0

    fun dialogDismiss() {
        if (mMsgDialogFragment != null && mMsgDialogFragment?.isShowing == true) {
            mMsgDialogFragment?.dismiss()
        }
    }
}


class MsgDialogFragment(private val mType: TYPE, private val mMessage: String, private val mButtonText: String) :
    BaseDialogFragment() {
    enum class TYPE {
        Success, Fail, Alert
    }

    var mOnButtonPressed: OnButtonPressed? = null
    override  val titleResId: Int
        get() = 0
    override  val layoutResId: Int
        get() = R.layout.dialog_fragment_msg

    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppTheme_Dialog)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override  fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = super.onCreateView(inflater, container, savedInstanceState)!!
        val ivIcon = view.findViewById<ImageView>(R.id.iv_icon)
        val tvMessage = view.findViewById<TextView>(R.id.tv_message)
        val tvButton = view.findViewById<TextView>(R.id.tv_button)
        tvMessage.text = mMessage
        tvButton.text = mButtonText
        when (mType) {
            TYPE.Success -> {
                Log.d("issue_175", "onClick in inButtonPressed1")
                ivIcon.setImageResource(R.drawable.ic_succeed)
                tvButton.background = requireContext().resources
                    .getDrawable(R.drawable.bg_blue_gradient_radius_3, null)
            }
            TYPE.Fail    -> {
                Log.d("issue_175", "onClick in inButtonPressed2")
                ivIcon.setImageResource(R.drawable.ic_fail)
                tvButton.background = requireContext().getResources()
                    .getDrawable(R.drawable.bg_orange_gradient_radius, null)
            }
            TYPE.Alert   -> {
                Log.d("issue_175", "onClick in inButtonPressed3")
                ivIcon.setImageResource(R.drawable.ic_warning)
                tvButton.background = requireContext().getResources()
                    .getDrawable(R.drawable.bg_yellow_gradient_1, null)
            }
            else         -> Log.d("issue_175", "onClick in inButtonPressed4")
        }
        tvButton.setOnClickListener {
            Log.d("issue_175", "onClick in MSGFragment")
            if (mOnButtonPressed != null) {
                mOnButtonPressed!!.inButtonPressed()
            }
            dismiss()
        }
        return view
    }

    fun setOnButtonPressed(onButtonPressed: OnButtonPressed?) {
        mOnButtonPressed = onButtonPressed
    }

    interface OnButtonPressed {
        fun inButtonPressed()
    }
}