package com.jekma.baselibrary


import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDirections
import com.jekma.baselibrary.Base.IPageController
import com.google.android.material.navigation.NavigationBarView

@SuppressLint("UseCompatLoadingForDrawables")
abstract class BaseFragment : Fragment(), Base.IOnBackPressed {
    val mTAG = this.javaClass.simpleName
    private var mPageController: IPageController? = null
    protected var mDialog: AlertDialog? = null
    protected var mIsBackEmpty = false
    protected var secondRequestPermissionLauncher: ActivityResultLauncher<Intent>? = null
    protected var firstRequestPermissionLauncher: ActivityResultLauncher<String>? = null

    open val listenerBottomBar:NavigationBarView.OnItemSelectedListener? = null
    open val mActionBarBackListener:View.OnClickListener? = null

    open fun setBottomNavigationDefaultItem(deskTopFragment: Int) {
        if (activity == null) {
            throw Base.Exception(Base.Error.ActivityIsNull)
        }
        val activity = activity as BaseActivity?
        activity!!.setBottomItemDefault(deskTopFragment)
    }
    /**
     * 複寫 標題
     */
    @get:StringRes
    abstract val titleResId: Int

    /**
     * 複寫 LAYOUT
     */
    @get:LayoutRes
    abstract val layoutResId: Int

    open val isUseMainBar: Boolean get() = true

    @get:MenuRes
    val mainBarMenuResId: Int
        get() = 0

    @get:MenuRes
    open val bottomBarMenuResId: Int
        get() = 0

    open val isShowMainBar: Boolean get() = false

    open val isShowBottomBar: Boolean get() = false

    open val isShowBackOnMainBar: Boolean get() = false

    open val isFullScreen: Boolean get() = false

    open val isMainBarBackgroundTransparent: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        secondRequestPermissionLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {}
        firstRequestPermissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) {}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutResId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            setIsFullScreen(isFullScreen)
            showMainBar(isShowMainBar)
            setMainBarBackground(isMainBarBackgroundTransparent)
            showBackOnMainBar(isShowBackOnMainBar)
            setHasOptionsMenu(mainBarMenuResId != 0)
            showBottomBar(isShowBottomBar)
            setBottomBarMenuListener()
            setNavigationListener()
            setDestinationChangedListener()
        } catch (e: Base.Exception) {
            e.printStackTrace()
        }
    }
    open val destinationChangedListener:NavController.OnDestinationChangedListener? = null
    private fun setDestinationChangedListener() {
        if (activity == null) {
            throw Base.Exception(Base.Error.ActivityIsNull)
        }
        val activity = activity as BaseActivity?

        activity!!.setDestinationChangedListener(destinationChangedListener)

    }

    private fun setNavigationListener() {
        if (activity == null) {
            throw Base.Exception(Base.Error.ActivityIsNull)
        }
        val activity = activity as BaseActivity?
        activity!!.setNavigationListener(mActionBarBackListener)
    }

    fun popBackStack() {
        if (activity == null) {
            throw Base.Exception(Base.Error.ActivityIsNull)
        }
        val activity = activity as BaseActivity?
        activity!!.popBackStack()
    }

    fun getCurrentDestination(): NavDestination? {
        if (activity == null) {
            throw Base.Exception(Base.Error.ActivityIsNull)
        }
        val activity = activity as BaseActivity?
        return activity!!.getCurrentDestination()
    }

    private fun setBottomBarMenuListener() {
        try {
            if (activity == null) {
                throw Base.Exception(Base.Error.ActivityIsNull)
            }
            val activity = activity as BaseActivity?

            if (listenerBottomBar!=null) {
                activity!!.setBottomBarListener(listenerBottomBar!!)
            }

        }catch (e:Exception){
            e.printStackTrace()
            Log.e("Develop_$mTAG","底部選單設定點擊事件錯誤:${e.message}")
        }
    }

    private fun setBottomBarMenuTheme() {
        if (activity == null) {
            throw Base.Exception(Base.Error.ActivityIsNull)
        }
        val activity = activity as BaseActivity?
        activity!!.setBottomBarMenuTheme()
    }

    private fun setBottomBarMenu(b: Boolean) {
//        if (activity == null) {
//            throw Base.Exception(Base.Error.ActivityIsNull)
//        }
//        val activity = activity as BaseActivity?
//        activity!!.setBottomBarMenu(bottomBarMenuResId)
    }

    private fun showBottomBar(isShow: Boolean) {
        if (activity == null) {
            throw Base.Exception(Base.Error.ActivityIsNull)
        }
        val activity = activity as BaseActivity?
        activity!!.showBottomBar(isShow)
    }

    /**
     * 設定 Main Bar 背景顏色是否透明
     */
    @SuppressLint("ResourceType")
    private fun setMainBarBackground(mainBarBackgroundTransparent: Boolean) {
        val activity = activity as BaseActivity?
        val bar = activity!!.supportActionBar ?: throw Base.Exception(Base.Error.ActionBarIsNull)
        if (mainBarBackgroundTransparent){
            val colorDrawable = ColorDrawable()
            colorDrawable.color = getColor(R.color.baseTransparent)
            bar.setBackgroundDrawable(colorDrawable)
//            var navController = activity.findViewById<ConstraintLayout>(R.id.navContainer)
//            navController.background = setBackground
        }
    }

    protected open fun setIsFullScreen(fullScreen: Boolean) {
        val activity = activity ?: return
        val window = activity.window
        if (fullScreen) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.decorView.systemUiVisibility =
                (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
        else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
            window.decorView.systemUiVisibility = 0
            window.statusBarColor = Color.BLACK
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        if (mainBarMenuResId != 0) {
            inflater.inflate(mainBarMenuResId, menu)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onBackPressed(): Boolean {
        showLoading(false)
        return true
    }

    @Throws(Base.Exception::class)
    protected fun showMainBar(isShow: Boolean) {
        if (activity == null) {
            throw Base.Exception(Base.Error.ActivityIsNull)
        }
        val activity = activity as BaseActivity?
        val bar = activity!!.supportActionBar ?: throw Base.Exception(Base.Error.ActionBarIsNull)
        if (isUseMainBar && isShow) {
            bar.show()
            bar.setTitle(titleResId)
            activity.setMainBarTitle(titleResId)
        }
        else {
            bar.hide()
        }
    }

    @Throws(Base.Exception::class)
    protected fun showBackOnMainBar(isShow: Boolean) {
        var isShow = isShow
        if (activity == null) {
            throw Base.Exception(Base.Error.ActivityIsNull)
        }
        val bar = (activity as AppCompatActivity?)!!.supportActionBar
            ?: throw Base.Exception(Base.Error.ActionBarIsNull)
        isShow = isShow && isUseMainBar
        bar.setDisplayShowHomeEnabled(isShow)
        bar.setDisplayHomeAsUpEnabled(isShow)
    }

    override fun setHasOptionsMenu(hasMenu: Boolean) {
        super.setHasOptionsMenu(hasMenu && isUseMainBar)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    protected fun back() {
        hideKeyboard()
        showLoading(false)
        try {
            pageController.back()
        } catch (e: Base.Exception) {
            Log.d(mTAG, e.message!!)
            if (e.isEqual(Base.Error.StackIsEmpty)) {
                mIsBackEmpty = true
                if (activity != null) {
                    activity!!.onBackPressed()
                }
            }
        }
    }

    @get:Throws(Base.Exception::class)
    protected val pageController: IPageController
        protected get() {
            if (mPageController == null) {
                if (activity == null) {
                    throw Base.Exception(Base.Error.ActivityIsNull)
                }
                mPageController = if (activity is BaseActivity) {
                    (activity as BaseActivity?)!!.initPageController()
                }
                else {
                    throw Base.Exception(Base.Error.ActivityIsIllegal)
                }
            }
            return mPageController!!
        }

    protected fun gotoNextPage(fragment: Fragment?, isKeep: Boolean) {
        try {
            pageController.setNextPage(fragment)?.setKeepBack(if (isKeep) mTAG else null)?.forward()
        } catch (e: Base.Exception) {
            e.printStackTrace()
        }
    }

    protected fun gotoNextNavPage(resId: Int,bundle:Bundle?) {
        try {
            (requireActivity() as BaseActivity).navWithBundle(resId,bundle)
        } catch (e: Exception) {
            Log.e("Develop_${mTAG}", "gotoNextNavPage():${e}")
        }
    }

    protected fun gotoNextNavPageBundleData(navDirections: NavDirections) {
        try {
            (requireActivity() as BaseActivity).navWithSafeArgs(navDirections)
        } catch (e: Exception) {
            Log.e("Develop_$mTAG", "gotoNextNavPageBundleData():${e}")
        }
    }


    protected fun dismissDialog() {
        if (mDialog != null && mDialog!!.isShowing) {
            mDialog!!.dismiss()
        }
        mDialog = null
    }

    protected fun getStringByName(name: String?): String {
        var resId = 0
        try {
            val context = requireContext()
            resId = resources.getIdentifier(name, "string", context.packageName)
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
        return if (resId != 0) getString(resId) else ""
    }

    protected fun getDrawable(@DrawableRes resId: Int): Drawable? {
        try {
            val context = requireContext()
            return AppCompatResources.getDrawable(context, resId)
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
        return null
    }

    protected fun getDrawableByName(name: String?): Drawable? {
        var resId = 0
        try {
            val context = requireContext()
            resId = resources.getIdentifier(name, "drawable", context.packageName)
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
        return getDrawable(resId)
    }

    protected fun getColor(@ColorRes resId: Int): Int {
        try {
            val context = requireContext()
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                context.resources.getColor(resId, null)
            }
            else {
                context.resources.getColor(resId)
            }
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
        return 0
    }

    protected fun getColorByName(name: String?): Int {
        var resId = 0
        try {
            val context = requireContext()
            resId = resources.getIdentifier(name, "color", context.packageName)
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
        return getColor(resId)
    }

    protected fun hideKeyboard() {
        if (activity != null && activity is BaseActivity) {
            (activity as BaseActivity?)!!.hideKeyboard()
        }
    }

    protected fun hideKeyboard(view: View?) {
        if (activity != null && activity is BaseActivity) {
            (activity as BaseActivity?)!!.hideKeyboard(view)
        }
    }

    open fun showLoading(isShow: Boolean, canPressBack: Boolean = true,gif:Any="") {
        try {
            if (activity != null && activity is BaseActivity) {
                (activity as BaseActivity?)!!.showLoading(isShow, canPressBack,gif)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    protected val isLoading: Boolean
        protected get() = if (activity != null && activity is BaseActivity) {
            (activity as BaseActivity?)!!.isLoading
        }
        else false
}