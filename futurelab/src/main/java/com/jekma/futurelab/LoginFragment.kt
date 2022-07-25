package com.jekma.futurelab

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import androidx.annotation.RequiresApi
import com.jekma.baselibrary.BaseBindingFragment
import com.jekma.futurelab.databinding.LoginBinding
import java.util.regex.Pattern

@RequiresApi(Build.VERSION_CODES.Q)
class LoginFragment() : BaseBindingFragment<LoginBinding,LoginViewModel>() {
    override var permissionOnViewListener: PermissionOnView? = null
    override val isShowMainBar: Boolean get() = false
    override val titleResId: Int get() = R.string.app_title_login
    override val layoutResId: Int get() = R.layout.fragment_login
    private var mIsHintShow = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.setActionListener(object : LoginViewModel.OnActionListener{
            override fun onLoginResult(error: LoginViewModel.Error) {

            }

            override fun onPressLogin() {
                mViewModel.obIsLoginMode.set(true)
            }

            override fun doPressSignUp() {
                mViewModel.obIsLoginMode.set(false)
            }

            override val drawable: Drawable @SuppressLint("UseCompatLoadingForDrawables") get() = requireContext().resources.getDrawable(R.drawable.bg_radius,null)

            @SuppressLint("ClickableViewAccessibility")
            override fun onSignUpPasswordAlert(length: Int): String {
                var text = ""
                val left = requireContext().getDrawable(R.drawable.ic_lock)
                val right_fail = requireContext().getDrawable(R.drawable.ic_pwd_fail)
                val right_suc = requireContext().getDrawable(R.drawable.ic_pwd_suc)

                if (!FormatUtil.checkPassword(mViewModel.obPassword_register.get())) {
                    mIsHintShow = true
                    text = getString(R.string.text_hint_register_password)
                    mViewBinding.etPwdInSignup.setOnTouchListener(OnTouchListener { v, event ->
                        val DRAWABLE_RIGHT = 2
                        if (event.action == MotionEvent.ACTION_UP) {
                            try {
                                if (event.rawX >= mViewBinding.etPwdInSignup.right - mViewBinding.etPwdInSignup.compoundDrawables[DRAWABLE_RIGHT].bounds.width()) {
                                    mViewModel.obPassword_register.set("")
                                    return@OnTouchListener true
                                }
                            } catch (e: Exception) {
                            }
                        }
                        false
                    })
                    val drawable = requireContext().getDrawable(R.drawable.bg_input_fail)
                    mViewBinding.cvThird.background = drawable
                    mViewModel.obSignUpPasswordHintVisiable.set(View.VISIBLE)
                    mViewBinding.etPwdInSignup.setCompoundDrawablesWithIntrinsicBounds(left, null, right_fail, null)
                }
                else {
                    mIsHintShow = true
                    val drawable = requireContext().getDrawable(R.drawable.bg_input_suc)
                    mViewBinding.cvThird.background = drawable
                    mViewModel.obSignUpPasswordHintVisiable.set(View.GONE)
                    mViewBinding.etPwdInSignup.setCompoundDrawablesWithIntrinsicBounds(left, null, right_suc, null)
                }
                return text!!
            }
        })
        mViewModel.create()
        mViewBinding.vm = mViewModel
    }

}

object FormatUtil {
    fun checkMobile(mobile: String?): Boolean {
        val format = "09[0-9]{8}"
        val pattern = Pattern.compile(format)
        val matcher = pattern.matcher(mobile)
        return matcher.matches()
    }

    fun checkEmail(email: String?): Boolean {
        val format = "^\\w{1,63}@[a-zA-Z0-9]{2,63}\\.[a-zA-Z]{2,63}(\\.[a-zA-Z]{2,63})?$"
        val pattern = Pattern.compile(format)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun checkPassword(password: String?): Boolean {
//        String format = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
        val format = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[\\s\\S]{8,16}$"
        val pattern = Pattern.compile(format)
        val matcher = pattern.matcher(password)
        return matcher.matches()
    }
}