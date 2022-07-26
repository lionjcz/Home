package com.jekma.futurelab

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.annotation.RequiresApi
import com.jekma.baselibrary.BaseFragment

class LaunchFragment : BaseFragment() {
    private val LOADING_MILLISECOND: Long = 1000
    private lateinit var mViewModel: LoginViewModel

    override val titleResId: Int
        get() = R.string.app_title_load
    override val layoutResId: Int
        get() = R.layout.fragment_launch

    override val isShowMainBar: Boolean
        get() = false

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = LoginViewModel(requireActivity().application)
        mViewModel.setActionListener(object : LoginViewModel.OnActionListener {
            override fun onLoginResult(error: LoginViewModel.Error) {
                /**
                 * 使用Token做登入後的結果
                 */
                if (error == LoginViewModel.Error.OK) {
                    gotoNextNavPage(R.id.action_launchFragment_to_deviceListFragment,null)
                }
                else {
                    MyLog.d("Develop_"+javaClass.simpleName, "Error=" + error.message)
                    gotoNextNavPage(R.id.action_launchFragment_to_loginFragment,null)
                }
            }
        })
        mViewModel.create(null, null, "Config.API_URL_LOGIN_WITH_TOKEN")
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({
            mViewModel.doLogin(null, true) //-> onLoginResult()
        }, LOADING_MILLISECOND)
    }

}

