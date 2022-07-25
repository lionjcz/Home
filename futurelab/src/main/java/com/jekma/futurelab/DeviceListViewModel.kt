package com.jekma.futurelab

import android.app.Application
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.databinding.ObservableField
import com.jekma.baselibrary.BaseViewModel

@RequiresApi(Build.VERSION_CODES.Q)
class DeviceListViewModel(application: Application) : BaseViewModel(application) {
    var obMenuFooterVisibly = ObservableField<Int>()
    var obMenuHeaderVisibly = ObservableField<Int>()
    var obMaskVisibly = ObservableField(View.INVISIBLE)
    var obDeviceSize = ObservableField(View.INVISIBLE)
    var mActionListener: OnActionListener? = null
    private var mDeviceItemViewModelList: List<DeviceItemViewModel>? = null
    private val mApiUrl: String? = null

    interface OnActionListener {
        fun onAddDevice()
        fun onOpenMenu()
        fun onMask()
        fun onItemPlay(viewModel: DeviceItemViewModel?)
        fun onItemDelete(viewModel: DeviceItemViewModel?)
        fun onItemSelect(areaGroupData: List<AreaGroup?>?)
        fun onGetItemDeviceIcon(type: Device.Type?): Drawable
        fun onGetItemDeviceConnectStatus(status: Device.DeviceConnectStatus?): String
        fun onGetDeviceList(deviceList: List<DeviceItemViewModel>?)
        fun onSetSettingMenu(memberData: Member?)
        fun onSetAreaGroupData(areaGroupData: List<AreaGroup?>?)
        fun onLogOut()
        fun onChangeLoadingState(isLoadingShow: Boolean)
        fun onLogOutResult(error: Error?)
    }

    fun setActionListener(mActionListener: OnActionListener?) {
        this.mActionListener = mActionListener
    }

    protected fun setLoadingState(isLoadingShow: Boolean) {
        if (mActionListener != null) {
            mActionListener!!.onChangeLoadingState(isLoadingShow)
        }
    }

    override fun create() {
        super.create()
        mDeviceItemViewModelList = createViewModelList()
        if (mDeviceItemViewModelList != null) {
            obDeviceSize.set(mDeviceItemViewModelList!!.size)
            if (mActionListener != null) {
                mActionListener!!.onGetDeviceList(mDeviceItemViewModelList)
                mActionListener!!.onSetSettingMenu(memberData)
                mActionListener!!.onSetAreaGroupData(areaGroupData)
            }
            if (areaGroupData.size < 1) {
                obMenuHeaderVisibly.set(View.INVISIBLE)
                obMenuFooterVisibly.set(View.INVISIBLE)
            }
        }
    }

    fun doAddDevice(view: View?) {
        if (mActionListener != null) {
            mActionListener!!.onAddDevice()
        }
    }

    fun doOpenMenu(view: View?) {
        if (mActionListener != null) {
            mActionListener!!.onOpenMenu()
        }
    }

    fun doMask(view: View?) {
        if (mActionListener != null) {
            mActionListener!!.onMask()
        }
    }

    fun doLogOut(view: View?) {
        if (mActionListener != null) {
            mActionListener!!.onLogOut()
        }
    }

    fun onClickLoginOut(apiUrlLoginOut: String) {
//        Log.d("issue_175", "onClickLoginOut url=$apiUrlLoginOut")
//        val onCallback: MemberHttpModel.OnCallback = object : OnCallback() {
//            fun onSuccess(member: Member?) {
//                Log.d("issue_175", "onClickLoginOut-onSuccess")
//                mActionListener!!.onLogOutResult(Error.OK)
//            }
//
//            fun onFailed(modelError: MemberHttpModel.Error) {
//                Log.d("issue_175", "onClickLoginOut-onFailed-error:" + modelError + ",msg-:" + modelError.getMessage())
//                var error: BaseMemberViewModel.Error = BaseMemberViewModel.Error.UNKNOWN
//                if (modelError === MemberHttpModel.Error.LOGIN_ACCOUNT_OR_PASSWORD_ILLEGAL) {
//                    error = BaseMemberViewModel.Error.RESP_ACCOUNT_OR_PASSWORD_ILLEGAL
//                }
//                else if (modelError === MemberHttpModel.Error.HTTP_RESPONSE_FAILED) {
//                    error = BaseMemberViewModel.Error.HTTP_RESPONSE_FAILED
//                }
//                if (mActionListener != null) {
//                    mActionListener!!.onLogOutResult(error)
//                }
//                setLoadingState(false)
//            }
//        }
//        val memberHttpModel = MemberHttpModel(apiUrlLoginOut)
//        memberHttpModel.loginOut(onCallback)
    }

    val memberData: Member
        get() {
            val member = Member()
            member.email = "mabel_123@gmail.com"
            member.mobile = "0987654321"
            member.name = "Mabel Lin"
            member.isEmailVerify = true
            val singleton: BundleSingleton = BundleSingleton.instance
            singleton.putData(BundleSingleton.REG_MEMBER, member)
            return member
        }
    val areaGroupData: List<AreaGroup?>
        get() {
            val memberLocalModel = MemberLocalModel(getApplication())
            return memberLocalModel.areaGroup
        }
    val deviceData: List<Device>
        get() {
            val memberLocalModel = MemberLocalModel(getApplication())
            return memberLocalModel.device
        }

    fun createViewModelList(): List<DeviceItemViewModel> {
        val list: MutableList<DeviceItemViewModel> = ArrayList<DeviceItemViewModel>()
        val deviceList: List<Device> = deviceData
        if (deviceList != null) {
            for (i in deviceList.indices) {
                val viewModel = DeviceItemViewModel(getApplication())
                viewModel.setDevice(deviceList[i])
                viewModel.setActionListener(object : DeviceItemViewModel.OnActionListener{
                    override fun onPlay() {
                        mActionListener!!.onItemPlay(viewModel)
                    }

                    override fun onDelete() {
                        mActionListener!!.onItemDelete(viewModel)
                    }

                    override fun onSelect() {
                        mActionListener!!.onItemSelect(areaGroupData)
                    }

                    // FIXME: ?
                    override fun onGetDeviceIcon(type: Device.Type?): Drawable {
                        return mActionListener!!.onGetItemDeviceIcon(type)
                    }

                    // FIXME: ?
                    override fun onGetDeviceItemConnectStatus(status: Device.DeviceConnectStatus?): String {
                        return mActionListener!!.onGetItemDeviceConnectStatus(status)
                    }
                })
                list.add(viewModel)
            }
        }
        return list
    }

    fun doDefaultUI() {
        obMaskVisibly.set(View.INVISIBLE)
        if (mDeviceItemViewModelList!!.size > 0) {
            for (i in mDeviceItemViewModelList!!.indices) {
                mDeviceItemViewModelList!![i].obMaskVisibly.set(View.INVISIBLE)
                mDeviceItemViewModelList!![i].obIsEditMode.set(false)
            }
        }
    }
}

class AreaGroup : JsonBase() {
    var name: String? = null
    var id: String? = null
}


class Member : JsonBase() {
    var email: String? = null
    var mobile: String? = null
    var isEmailVerify: Boolean? = null
    var isMobileVerify: Boolean? = null
        private set
    var name: String? = null
    var account: String? = null
    var password: String? = null
    var newPassword: String? = null
    var verifyCode: String? = null
    var vkey: String? = null
    var vcode: String? = null
    var token: String? = null

    fun setIsMobileVerify(isMobileVerify: Boolean) {
        this.isMobileVerify = isMobileVerify
    }
}


class BundleSingleton private constructor() {
    private var mViewModel: BaseViewModel? = null
    private val mDataMap: MutableMap<String, Any> = HashMap()
    fun saveViewModel(viewModel: BaseViewModel?) {
        mViewModel = viewModel
    }

    fun loadViewModel(): BaseViewModel? {
        return mViewModel
    }

    fun putData(key: String, data: Any) {
        mDataMap[key] = data
    }

    fun getData(key: String): Any? {
        return mDataMap[key]
    }

    fun putDataString(key: String, data: String) {
        putData(key, data)
    }

    fun putDataInt(key: String, data: Int) {
        putData(key, data)
    }

    fun getDataString(key: String): String? {
        val data = getData(key)
        return if (data is String) {
            data
        }
        else null
    }

    fun getDataInt(key: String): Int? {
        val data = getData(key)
        return if (data is Int) {
            data
        }
        else null
    }

    fun removeDataString(key: String) {
        mDataMap.remove(key)
    }

    companion object {
        // Common (CMN)
        const val CMN_DEVICE_ID = "cmn_device_id"
        const val CMN_DEVICE_MODEL = "cmn_device_model"

        // Register (REG)
        const val REG_MOBILE_NUMBER = "reg_mobile_number"
        const val REG_EMAIL = "reg_email"
        const val REG_PASSWORD = "reg_password"
        const val REG_PASSWORD_2 = "reg_password_2"
        const val REG_VKEY = "reg_vkey"
        const val REG_VCODE = "reg_vcode"
        const val REG_ACCOUNT = "reg_account"
        const val REG_MODE = "reg_mode"
        const val REG_MEMBER = "reg_member"

        // Fragrance Machine (FM)
        const val FM_FRAGRANCE_NAME = "fm_fragrance_name"
        const val FM_FRAGRANCE_IMAGE_INDEX = "fm_fragrance_image_index"
        const val FM_FRAGRANCE_LIST = "fm_fragrance_list"
        const val FM_FRAGRANCE_START_TIME = "fm_fragrance_start_time"
        const val FM_FRAGRANCE_DURATION_SECOND = "fm_fragrance_duration_second"

        // Setting
        const val SETTING_SAVE_RUNNABLE = "setting_save_runnable"
        val instance = BundleSingleton()
    }
}


