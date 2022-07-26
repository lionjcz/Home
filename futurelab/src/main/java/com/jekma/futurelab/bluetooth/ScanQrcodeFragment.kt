package com.jekma.futurelab.bluetooth

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.jekma.baselibrary.BaseBindingFragment
import com.jekma.baselibrary.BaseDialogFragment
import com.jekma.futurelab.MyLog
import com.jekma.futurelab.R
import com.jekma.futurelab.ScanQrCodeViewDataBinding
import com.jekma.futurelab.view.custom.CustomZxing
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.CaptureManager
import com.journeyapps.barcodescanner.DecoratedBarcodeView


@RequiresApi(Build.VERSION_CODES.Q)
class ScanQrcodeFragment: BaseBindingFragment<ScanQrCodeViewDataBinding, ScanQrCodeViewModel>(), DecoratedBarcodeView.TorchListener {
    override var permissionOnViewListener: PermissionOnView? = null

    override val titleResId: Int get() = R.string.app_title_qrcode
    override val layoutResId: Int get() = R.layout.fragment_scan_qrcode
    override val isShowMainBar: Boolean get() = true
    override val isShowBackOnMainBar: Boolean get() = true
    private lateinit var mCapture: CaptureManager
    private val mCallback: BarcodeCallback = BarcodeCallback {
//        gotoNextPage(BluetoothInstall1Fragment.newInstance(), false)

    }
    private val mRequestPermissionLauncher: ActivityResultLauncher<String> =
        registerForActivityResult(ActivityResultContracts.RequestPermission(), ActivityResultCallback<Boolean?> { isGranted ->
            if (!isGranted!!) {
                if (!shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                    firstRejectedMsgDialog()
                }
            }
        })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.setActionListener(object : ScanQrCodeViewModel.OnActionListener {
            override fun onPermissionResult(result: Boolean?) {
                MyLog.d("Install_ViewModel", "in mViewModel Permission result = $result")
                mViewModel.obHasPermission.set(result!!)
            }

            override fun onClickedAdd() {
//                gotoNextPage(InstallDevicesFragment.newInstance(), false)
            }

            override fun onClickedWhereQrCode() {
//                gotoNextPage(FindQrCodeFragment.newInstance(), true)
            }

            override fun onClickedSpotLight() {
                if (getString(R.string.tv_turn_on_spotlight).equals(mViewModel.onSpotLight.get())) {
                    mViewBinding.zxingBarcodeScanner.setTorchOn()
                    mViewBinding.ivSpotlight.setImageDrawable(getDrawable(R.drawable.btn_spotlight_close))
                }
                else {
                    mViewBinding.zxingBarcodeScanner.setTorchOff()
                    mViewBinding.ivSpotlight.setImageDrawable(getDrawable(R.drawable.btn_spotlight_open))
                }
            }

            override fun onClickedOpenPermission() {
                checkPermission()
            }
        })
        mViewModel.create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CustomZxing(mViewBinding.world2.zxingViewfinderView, mViewBinding.world2.ivScannerBorderStyle)
        mCapture = CaptureManager(requireActivity(), mViewBinding.zxingBarcodeScanner)
        mCapture.initializeFromIntent(requireActivity().intent, savedInstanceState)
        mCapture.setShowMissingCameraPermissionDialog(false)
        mCapture.decode()
        mViewBinding.zxingBarcodeScanner.decodeContinuous(mCallback)
        mViewBinding.zxingBarcodeScanner.setTorchListener(this)
        if (getString(R.string.tv_turn_on_spotlight).equals(mViewModel.onSpotLight.get())) {
            mViewBinding.zxingBarcodeScanner.setTorchOn()
            mViewBinding.ivSpotlight.setImageDrawable(getDrawable(R.drawable.btn_spotlight_close))
        }
        else {
            mViewBinding.zxingBarcodeScanner.setTorchOff()
            mViewBinding.ivSpotlight.setImageDrawable(getDrawable(R.drawable.btn_spotlight_open))
        }
        mViewBinding.setVm(mViewModel)
    }

    override fun onResume() {
        super.onResume()
        mCapture.onResume()
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            mViewModel.mActionListener?.onPermissionResult(true)
            MyLog.d("Install_ViewModel", "Permission true")
        }
        else {
            mViewModel.mActionListener?.onPermissionResult(false)
            MyLog.d("Install_ViewModel", "Permission false")
        }
    }

    override fun onPause() {
        super.onPause()
        mCapture.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mCapture.onDestroy()
    }

    override fun onTorchOn() {
        mViewModel.onSpotLight.set(getString(R.string.tv_turn_off_spotlight))
    }

    override fun onTorchOff() {
        mViewModel.onSpotLight.set(getString(R.string.tv_turn_on_spotlight))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mCapture.onSaveInstanceState(outState)
    }

    private fun checkPermission() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                firstRejectedMsgDialog()
            }
            else {
                mRequestPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }

    private fun firstRejectedMsgDialog() {
        val msg = "第一次權限拒絕後跳出來的視窗"
        val tipDialogFragment =
            TipDialogFragment(TipDialogFragment.TYPE.DEFAULT, msg, getString(R.string.btn_yes), getString(R.string.btn_cancel))
        tipDialogFragment.setOnButtonPressed(object : TipDialogFragment.OnButtonPressed {
            override fun inPressOk() {
                val intent =
                    Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.fromParts("package", requireActivity().getPackageName(), null))
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }

            override fun inPressCancel() {}
            override fun inPressX() {}
        })
        tipDialogFragment.show(getChildFragmentManager(), null)
    }

}


class TipDialogFragment(private val mType: TYPE, private val mContent: String, private val mButtonOkText: String, private val mButtonCancelText: String) :
    BaseDialogFragment() {
    enum class TYPE {
        DEFAULT, SAVE, SAVE_AS
    }

    private var mOnButtonPressed: OnButtonPressed? = null
    override val titleResId: Int
        get() = 0
    override val layoutResId: Int
        get() = when (mType) {
            TYPE.SAVE    -> R.layout.dialog_fragment_tip_save
            TYPE.SAVE_AS -> R.layout.dialog_fragment_tip_save_as
            else         -> R.layout.dialog_fragment_tip_default
        }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.AppTheme_Dialog)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = super.onCreateView(inflater, container, savedInstanceState)!!
        val tvContent = view.findViewById<TextView>(R.id.tv_content)
        val tvOk = view.findViewById<TextView>(R.id.tv_ok)
        val tvCancel = view.findViewById<TextView>(R.id.tv_cancel)
        tvContent.text = mContent
        tvCancel.text = mButtonCancelText
        tvOk.text = mButtonOkText
        tvOk.setOnClickListener {
            if (mOnButtonPressed != null) {
                mOnButtonPressed!!.inPressOk()
            }
            else {
                MyLog.d("issue_164", "ok == null")
            }
            dismiss()
        }
        tvCancel.setOnClickListener {
            if (mOnButtonPressed != null) {
                mOnButtonPressed!!.inPressCancel()
            }
            dismiss()
        }
        if (mType == TYPE.DEFAULT) {
            val ivClose = view.findViewById<ImageView>(R.id.iv_close)
            ivClose.setOnClickListener {
                if (mOnButtonPressed != null) {
                    mOnButtonPressed!!.inPressX()
                }
                dismiss()
            }
        }
        return view
    }

    fun setOnButtonPressed(onButtonPressed: OnButtonPressed?) {
        mOnButtonPressed = onButtonPressed
        if (mOnButtonPressed == null) return
    }

    interface OnButtonPressed {
        fun inPressOk()
        fun inPressCancel()
        fun inPressX()
    }
}