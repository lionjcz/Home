package com.jekma.futurelab

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.provider.Settings
import android.text.Editable
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.jekma.baselibrary.BaseViewModel
import java.lang.Error
import java.util.*

@RequiresApi(Build.VERSION_CODES.Q)
class LoginViewModel(application: Application) : BaseViewModel(application) {

    //共用 變數
//    private var mMemberLocalModel: MemberLocalModel? = null
    @SuppressLint("StaticFieldLeak")
    private var mApplication: Context? = null
    private var mActionListener: OnActionListener? = null
    private var mApiUrl: String? = null
    private var mLoginApiUrl: String? = null
    private var mRegisterApiUrl: String? = null
    private var mLoginWithTokenUrl: String? = null

    enum class TYPE {
        LOGIN, REGISTER
    }

    val obIsLoginMode = ObservableBoolean(false)
    val obIsNightMode = ObservableBoolean()
    fun getActionListener(): OnActionListener? {
        return mActionListener
    }

    interface OnActionListener {
        fun onLoginResult(error: Error)
        fun onAccountTextInput(error: Error?) {}
        fun onPasswordTextInput(error: Error?) {}
        fun doPressSignUp() {}
        fun onPressForgetPassword() {}
        fun onChangeLoadingState(isRunning: Boolean) {}
        fun onPressLogin() {}
        fun onRegister(ok: Error?) {}
        fun onSignUpPasswordAlert(length: Int): String {
            return ""
        }

        val drawable: Drawable?
            get() = null
    }

    //登入部分 變數
    val obAccount = ObservableField<String>()
    val obPassword = ObservableField<String>()
    val obIsKeepLogin = ObservableBoolean()
    val obSignUpPasswordBackground = ObservableField<Drawable?>()

    //註冊部分 變數
    val obMobileNumber = ObservableField<String>()
    val obEmail = ObservableField<String>()
    val obPassword_register = ObservableField<String>()
    val obPassword2 = ObservableField<String>()
    val obSignUpPasswordHint = ObservableField<String>()
    val obSignUpPasswordHintVisiable = ObservableField(View.GONE)
    val obType = ObservableField<TYPE>()

    override fun create() {
        create(null, null, null)
    }

    fun create(loginApiUrl: String?, registerApiUrl: String?, loginWithTokenUrl: String?) {
        mLoginApiUrl = loginApiUrl
        mRegisterApiUrl = registerApiUrl
        mLoginWithTokenUrl = loginWithTokenUrl
        obType.set(TYPE.LOGIN)
//        obAccount.set(mMemberLocalModel.getAccount())
//        obIsKeepLogin.set(mMemberLocalModel.getAuthToken().length() > 0)
        obIsLoginMode.set(true)
        if (mActionListener != null) {
            obSignUpPasswordBackground.set(mActionListener!!.drawable)
        }
    }

    fun setActionListener(mActionListener: OnActionListener?) {
        this.mActionListener = mActionListener
    }

    // 登入部分
    fun onAccountTextChange(editable: Editable) {
        val text = editable.toString()
        //        obIsLoginMode.set(text.length() > 0);
    }

    fun onPasswordTextChange(editable: Editable) {
        val text = editable.toString()
    }

    fun doPressForgetPassword(view: View?) {
        if (mActionListener != null) {
            mActionListener!!.onPressForgetPassword()
        }
    }

    fun doLogin(view: View?, isTokenLogin: Boolean) {
        MyLog.d("Develop_","doLogin")
        if (view != null) {
            view.isClickable = false
        }
        setLoadingState(true)
//        val onCallback: MemberHttpModel.OnCallback = object : OnCallback() {
//            fun onSuccess(member: Member) {
//                if (mActionListener != null) {

//                    mMemberLocalModel.saveAuthToken(member.getToken())
//                }
//                if (view != null) {
//                    view.isClickable = true
//                }
//                setLoadingState(false)
//            }
//
//            fun onFailed(modelError: MemberHttpModel.Error) {
//                Log.d(TAG, "doLogin - onFailed - error: " + modelError.getMessage())
//                var error: Error? = Error.UNKNOWN
//                if (modelError === MemberHttpModel.Error.LOGIN_ACCOUNT_OR_PASSWORD_ILLEGAL) {
//                    error = Error.RESP_ACCOUNT_OR_PASSWORD_ILLEGAL
//                }
//                else if (modelError === MemberHttpModel.Error.HTTP_RESPONSE_FAILED) {
//                    error = Error.HTTP_RESPONSE_FAILED
//                }
//                if (mActionListener != null) {
//                    mActionListener!!.onLoginResult(error)
//                }
//                if (view != null) {
//                    view.isClickable = true
//                }
//                setLoadingState(false)
//            }
//        }
        if (isTokenLogin) {
            mActionListener!!.onLoginResult(Error.UNKNOWN)

//            val localToken: String = mMemberLocalModel.getAuthToken()
//            mApiUrl = mLoginWithTokenUrl
//            val mMemberHttpModel = MemberHttpModel(mApiUrl)
//            mMemberHttpModel.loginWithToken(localToken, getPhoneId(), getPhoneDesc(), getPushToken(), onCallback)
        }
        else {
            mActionListener!!.onLoginResult(Error.OK)

//            val account = obAccount.get()
//            val password = obPassword.get()
//            mApiUrl = mLoginApiUrl
//            val mMemberHttpModel = MemberHttpModel(mApiUrl)
//            mMemberHttpModel.login(account, password, getPhoneId(), true, getPhoneDesc(), getPushToken(), onCallback)
        }
    }

    // 註冊部分
    fun onSignUpPasswordTextChange(editable: Editable) {
        val text = editable.toString()
        if (mActionListener != null) {
            obSignUpPasswordHint.set(mActionListener!!.onSignUpPasswordAlert(text.length))
        }
    }

    fun doRegister() {
//        setLoadingState(true)
//        try {
//            val mobileNumber = obMobileNumber.get()
//            if (mobileNumber == null || mobileNumber.isEmpty()) {
//                throw ViewModelException(Error.INPUT_MOBILE_NUMBER_IS_EMPTY.getCode())
//            }
//            else if (!FormatUtil.checkMobile(mobileNumber)) {
//                throw ViewModelException(Error.INPUT_MOBILE_NUMBER_FORMAT_IS_WRONG.getCode())
//            }
//            val email = obEmail.get()
//            if (email == null || email.isEmpty()) {
//                throw ViewModelException(Error.INPUT_EMAIL_IS_EMPTY.getCode())
//            }
//            else if (!FormatUtil.checkEmail(email)) {
//                throw ViewModelException(Error.INPUT_EMAIL_FORMAT_IS_WRONG.getCode())
//            }
//            val password = obPassword_register.get()
//            if (password == null || password.isEmpty()) {
//                throw ViewModelException(Error.INPUT_PASSWORD_IS_EMPTY.getCode())
//            }
//            else if (!FormatUtil.checkPassword(password)) {
//                throw ViewModelException(Error.INPUT_PASSWORD_FORMAT_IS_WRONG.getCode())
//            }
//            val password2 = obPassword2.get()
//            if (password2 == null || password2.isEmpty()) {
//                throw ViewModelException(Error.INPUT_PASSWORD2_IS_EMPTY.getCode())
//            }
//            else if (password != password2) {
//                throw ViewModelException(Error.INPUT_PASSWORD_NOT_MATCH.getCode())
//            }
//            val vkey = UUID.randomUUID().toString().replace("-", "")
//            val callback: MemberHttpModel.OnCallback = object : OnCallback() {
//                fun onSuccess(member: Member?) {
//                    val singleton: BundleSingleton = BundleSingleton.getInstance()
//                    singleton.putDataString(BundleSingleton.REG_MOBILE_NUMBER, mobileNumber)
//                    singleton.putDataString(BundleSingleton.REG_EMAIL, email)
//                    singleton.putDataString(BundleSingleton.REG_PASSWORD, password)
//                    singleton.putDataString(BundleSingleton.REG_PASSWORD_2, password2)
//                    singleton.putDataString(BundleSingleton.REG_VKEY, vkey)
//                    if (mActionListener != null) {
//                        mActionListener!!.onRegister(Error.OK)
//                    }
//                    setLoadingState(false)
//                }
//
//                fun onFailed(modelError: MemberHttpModel.Error) {
//                    val error: Error
//                    if (modelError === MemberHttpModel.Error.REGISTER_PHONE_OR_EMAIL_EXIST) {
//                        error = Error.RESP_PHONE_OR_EMAIL_EXIST
//                    }
//                    else {
//                        error = handleError(modelError)
//                    }
//                    if (mActionListener != null) {
//                        mActionListener!!.onRegister(error)
//                    }
//                    setLoadingState(false)
//                }
//            }
//            mApiUrl = mRegisterApiUrl
//            val mMemberHttpModel = MemberHttpModel(mApiUrl)
//            mMemberHttpModel.register(mobileNumber, email, password, callback)
//        } catch (e: ViewModelException) {
//            if (mActionListener != null) {
//                mActionListener!!.onRegister(Error.getError(e.getErrorCode()))
//            }
//            setLoadingState(false)
//        }
    }

    protected fun setLoadingState(isLoadingShow: Boolean) {
        if (mActionListener != null) {
            mActionListener!!.onChangeLoadingState(isLoadingShow)
        }
    }

    fun doPressSignUp(view: View?) {
        if (mActionListener != null) {
            mActionListener!!.doPressSignUp()
        }
    }

    fun doPressLogin(view: View?) {
        if (mActionListener != null) {
            mActionListener!!.onPressLogin()
        }
    }

    fun loadTempData() {
//        val singleton: BundleSingleton = BundleSingleton.getInstance()
//        val mobileNumber: String = singleton.getDataString(BundleSingleton.REG_MOBILE_NUMBER)
//        val email: String = singleton.getDataString(BundleSingleton.REG_EMAIL)
//        val password: String = singleton.getDataString(BundleSingleton.REG_PASSWORD)
//        val password2: String = singleton.getDataString(BundleSingleton.REG_PASSWORD_2)
//        obMobileNumber.set(mobileNumber)
//        obEmail.set(email)
//        obPassword_register.set(password)
//        obPassword2.set(password2)
    }

    private fun getPhoneDesc(): String? {
        return Settings.Global.getString(mApplication!!.contentResolver, "device_name")
    }

    private fun getPhoneId(): String? {
        val packageName = mApplication!!.packageName
        val androidId =
            Settings.Secure.getString(mApplication!!.contentResolver, Settings.Secure.ANDROID_ID)
        val phoneUuid = UUID(packageName.hashCode().toLong(), androidId.hashCode().toLong())
        return phoneUuid.toString().replace("-", "")
    }


    /**
     * 依照 Server 回傳代碼的文件 所對應的訊息
     */
    enum class Error(val code: Int, val message: String) {
        OK(0, "OK"),
        UNKNOWN(-999999, "Unknown"),
        HTTP_TIMEOUT(-1, "HTTP timeout"),
        HTTP_IO_ERROR(-2, "HTTP I/O error"),
        HTTP_CONNECTION_FAILED(-3, "HTTP connection failed"),
        HTTP_BAD_REQUEST_DATA(-4, "HTTP bad request data"),
        HTTP_RESPONSE_FAILED(-5, "HTTP response failed");

        companion object {
            fun getError(code: Int): Error {
                lateinit var error2: Error
                for (error in values()) {
                    if (error.code == code) {
                        error2 = error
                        break
                    }
                }
                return error2
            }
        }
    }


}
