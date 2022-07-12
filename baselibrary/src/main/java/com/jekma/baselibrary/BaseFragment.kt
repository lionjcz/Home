package com.jekma.baselibrary
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.*
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.snackbar.Snackbar

/**
 * 2022/7/9，這邊先以Navigation的方式去建立底層
 */
@SuppressLint("UseCompatLoadingForDrawables")
abstract class BaseFragment : Fragment(), Base.IOnBackPressed {
    private val bTAG = this.javaClass.simpleName

    open val isFullScreen: Boolean get() = false
//    open val isMainBarBackgroundTransparent: Boolean = false

    private var secondRequestPermissionLauncher: ActivityResultLauncher<Intent>? = null
    private var firstRequestPermissionLauncher: ActivityResultLauncher<String>? = null
    /**
     * 複寫 標題
     */
    @get:StringRes
    abstract val titleResId: Int
    open val isShowBackOnMainBar: Boolean get() = false

    /**
     * 功能項 右上角選單
     *
     * 設定選單
     *
     * 設定選單點擊事件
     *
     */
    @get:MenuRes
    open val mainBarMenuResId: Int get() = 0
    open val mainBarMenuListener = fun(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId){
            else -> {
                Toast.makeText(requireContext(),"尚未設定選單點擊事件",Toast.LENGTH_LONG).show()
                false
            }
        }
    }

    /**
     *  功能項 LAYOUT
     */
    @get:LayoutRes
    abstract val layoutResId: Int

    /**
     * 功能項 針對 Action Bar的設定
     */
    open val isShowMainBar: Boolean get() = false

    /**
     * 功能項 右下角的懸富按鈕 設定
     */
    open val isShowFab: Boolean get() = false
    open val setFabListener = fun(view:View){
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
    }

    /**
     * 功能項 底部選單
     *
     */
    @get:MenuRes
    open val bottomBarMenuResId: Int get() = 0
    open val listenerBottomBar: NavigationBarView.OnItemSelectedListener? = null


    /**
     * 處理 權限
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        secondRequestPermissionLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {}
        firstRequestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {}
    }

    /**
     * 綁定 activity 的 layout
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutResId, container, false)
    }

    /**
     *  設定功能項
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            setIsFullScreen(isFullScreen)
            showMainBar(isShowMainBar)
//            setMainBarBackground(isMainBarBackgroundTransparent)
            showBackOnMainBar(isShowBackOnMainBar)
            setMainBarMenu(mainBarMenuResId!=0)
            showBottomBar(bottomBarMenuResId!=0)
            showFab(isShowFab)
        } catch (e: Base.Exception) {
            e.printStackTrace()
            Log.e(bTAG, e.message)
        }
    }

    /**
     * 設定 最上面的系統狀態欄位
     * 是否延伸
     */
    private fun setIsFullScreen(fullScreen: Boolean) {
        //FIXME 分離程式碼要處理
        val activity = activity ?: return
        val window = activity.window
        if (fullScreen) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
            window.decorView.systemUiVisibility = 0
            window.statusBarColor = Color.BLACK
        }
    }

    /**
     * 設定 Action Bar
     *
     *  顯示/隱藏
     */
    private fun showMainBar(isShowMainBar: Boolean) {
        if (activity == null) {
            throw Base.Exception(Base.Error.ActivityIsNull)
        } else {
            val activity = activity as BaseActivity
            val bar = activity.supportActionBar ?: throw Base.Exception(Base.Error.ActionBarIsNull)
            if (isShowMainBar) {
                bar.show()
                activity.setMainBarTitle(titleResId)
                /**
                 * 關閉TooleBar
                 */
                bar.setDisplayShowTitleEnabled(false)
            } else {
                bar.hide()
            }
        }
    }


//    /**
//     * 設定 Main Bar 背景顏色是否透明
//     */
//    @SuppressLint("ResourceType")
//    private fun setMainBarBackground(mainBarBackgroundTransparent: Boolean) {
//        val activity = activity as BaseActivity?
//        val bar = activity!!.supportActionBar ?: throw Base.Exception(Base.Error.ActionBarIsNull)
//        if (mainBarBackgroundTransparent) {
//            val colorDrawable = ColorDrawable()
//            colorDrawable.color = getColor(R.color.baseTransparent)
//            bar.setBackgroundDrawable(colorDrawable)
////            var navController = activity.findViewById<ConstraintLayout>(R.id.navContainer)
////            navController.background = setBackground
//        }
//    }

    /**
     * 設定 左上角返回按鈕
     * 顯示/隱藏
     */
    private fun showBackOnMainBar(isShowBackOnMainBar: Boolean) {
        if (activity == null) {
            throw Base.Exception(Base.Error.ActivityIsNull)
        }
        if (isShowBackOnMainBar) {
            val activity = activity as BaseActivity
            val bar = activity.supportActionBar ?: throw Base.Exception(Base.Error.ActionBarIsNull)
            bar.setDisplayShowHomeEnabled(isShowBackOnMainBar)
            bar.setDisplayHomeAsUpEnabled(isShowBackOnMainBar)
        }
    }

    /**
     * 設定 右上角的選單
     *
     * 選單的ID
     *
     * 選單的點擊事件
     *
     */
    private fun setMainBarMenu(isMainBarMenuResIdEmpty: Boolean) {
        if (activity == null) {
            throw Base.Exception(Base.Error.ActivityIsNull)
        }
        if (isMainBarMenuResIdEmpty){
            val activity = activity as BaseActivity
            activity.addMenuProvider(object : MenuProvider {
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(mainBarMenuResId, menu)
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    return mainBarMenuListener(menuItem)
                }
            })
        }

    }

    private fun showBottomBar(isShow: Boolean) {
        if (activity == null) {
            throw Base.Exception(Base.Error.ActivityIsNull)
        }else{
            val activity = activity as BaseActivity
            if (isShow){
                activity.binding.navBottomBar.visibility = View.VISIBLE
                activity.binding.navBottomBar.menu.clear();
                activity.binding.navBottomBar.inflateMenu(bottomBarMenuResId);
                activity.binding.navBottomBar.setOnItemSelectedListener(listenerBottomBar)
            }else{
                activity.binding.navBottomBar.visibility = View.GONE
            }
        }
    }


    /**
     * 設定 懸浮按鈕
     *
     * 顯示/隱藏
     *
     * 事件
     *
     */
    private fun showFab(isShowFab: Boolean) {
        if (activity == null) {
            throw Base.Exception(Base.Error.ActivityIsNull)
        } else {
            val activity = activity as BaseActivity
            if (isShowFab){
                activity.binding.fab.visibility = View.VISIBLE
                activity.binding.fab.setOnClickListener {
                    setFabListener(it)
                }
            }else{
                activity.binding.fab.visibility = View.GONE
            }
        }
    }

    protected fun gotoNextNavPage(resId: Int, bundle: Bundle?) {
        findNavController().navigate(resId,bundle)
    }

    open fun showLoading(isShow: Boolean, canPressBack: Boolean = true, gif: Any = "") {
        if (activity == null) {
            throw Base.Exception(Base.Error.ActivityIsNull)
        }else{
            try {
                if (activity != null && activity is BaseActivity) {
                    (activity as BaseActivity?)!!.showLoading(isShow, canPressBack,gif)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onBackPressed(): Boolean {
//        showLoading(false)
        return true
    }


    /**
     * 小工具 (用來取得Resource)
     */

    open fun getStringByName(name: String?): String {
        var resId = 0
        try {
            val context = requireContext()
            resId = resources.getIdentifier(name, "string", context.packageName)
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
        return if (resId != 0) getString(resId) else ""
    }

    open fun getDrawable(@DrawableRes resId: Int): Drawable? {
        try {
            val context = requireContext()
            return AppCompatResources.getDrawable(context, resId)
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
        return null
    }

    open fun getDrawableByName(name: String?): Drawable? {
        var resId = 0
        try {
            val context = requireContext()
            resId = resources.getIdentifier(name, "drawable", context.packageName)
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
        return getDrawable(resId)
    }

    open fun getColor(@ColorRes resId: Int): Int {
        try {
            val context = requireContext()
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                context.resources.getColor(resId, null)
            } else {
                context.resources.getColor(resId)
            }
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
        return 0
    }

    open fun getColorByName(name: String?): Int {
        var resId = 0
        try {
            val context = requireContext()
            resId = resources.getIdentifier(name, "color", context.packageName)
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
        return getColor(resId)
    }

}