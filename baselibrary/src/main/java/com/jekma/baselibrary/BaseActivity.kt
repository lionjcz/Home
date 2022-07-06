package com.jekma.baselibrary

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.jekma.baselibrary.Base.IOnBackPressed
import com.jekma.baselibrary.Base.IPageController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

abstract class BaseActivity : AppCompatActivity() {
    lateinit var mNavController: NavController
    val TAG = this.javaClass.simpleName
    private var mMainBar: Toolbar? = null
    private var mMainBarTitle: TextView? = null
    private var mFragmentMgr: FragmentManager? = null
    private var mCanPressBack = true
    private var mNavBottomBar: BottomNavigationView? = null
    val isLoading: Boolean
        get() {
            val view = findViewById<View>(mainLoading)
            return view != null && view.visibility == View.VISIBLE
        }

    protected val containerId: Int
        get() = R.id.main_container

    private val mainLoading: Int
        get() = R.id.main_loading


    protected val currentFragment: Fragment?
        protected get() = mFragmentMgr!!.findFragmentById(containerId)

    protected inner class PageController : IPageController {
        private var mNextPage: Fragment? = null
        private var mTag = ""
        private var mIsAdd = false
        private var mIsKeepBack = false
        private var mIsCleanTop = false
        private var mName: String? = null
        private var mAnimateMode = 0
        private val mAnimateNext = IntArray(2)
        private val mAnimateBack = IntArray(2)
        override fun setNextPage(nextPage: Fragment?): IPageController? {
            if (nextPage != null) {
                mTag = nextPage.javaClass.simpleName
            }
            mNextPage = nextPage
            return this
        }

        override fun setAdd(): IPageController {
            mIsAdd = true
            return this
        }

        override fun setReplace(): IPageController {
            mIsAdd = false
            return this
        }

        override fun setKeepBack(name: String?): IPageController {
            mName = name
            mIsKeepBack = name != null && !name.isEmpty()
            return this
        }

        override fun setCleanTop(): IPageController {
            mIsCleanTop = true
            return this
        }

        override fun setAnimate(enter: Int, exit: Int): IPageController {
            mAnimateMode = 1
            mAnimateNext[0] = enter
            mAnimateNext[1] = exit
            return this
        }

        override fun setAnimate(enter: Int, exit: Int, back_enter: Int, back_exit: Int): IPageController {
            setAnimate(enter, exit)
            mAnimateMode = 2
            mAnimateBack[0] = back_enter
            mAnimateBack[1] = back_exit
            return this
        }

        @Throws(Base.Exception::class)
        override fun back() {
            if (mFragmentMgr!!.backStackEntryCount > 0) {
                mFragmentMgr!!.popBackStack()
                removeCurrentFragment()
            }
            else {
                throw Base.Exception(Base.Error.StackIsEmpty)
            }
        }

        override fun back(name: String?) {
            if (mFragmentMgr!!.backStackEntryCount > 0) {
                mFragmentMgr!!.popBackStack(name, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                removeCurrentFragment()
            }
            else {
                throw Base.Exception(Base.Error.StackIsEmpty)
            }
        }

        override fun forward() {
            if (mNextPage == null) {
                throw Base.Exception(Base.Error.FragmentIsNull)
            }
            val ft = mFragmentMgr!!.beginTransaction()
            if (mIsCleanTop) {
                val count = mFragmentMgr!!.backStackEntryCount
                for (i in 0 until count) {
                    val id = mFragmentMgr!!.getBackStackEntryAt(i).id
                    mFragmentMgr!!.popBackStack(id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                }
            }
            if (mIsKeepBack) {
                ft.addToBackStack(mName)
            }
            else {
                val count = mFragmentMgr!!.backStackEntryCount
                for (i in 0 until count) {
                    val entry = mFragmentMgr!!.getBackStackEntryAt(i)
                    val id = entry.id
                }
                val fragment = currentFragment
                if (fragment != null) {
                    ft.remove(fragment)
                }
            }
            if (mAnimateMode > 0) {
                if (mAnimateMode == 1) {
                    ft.setCustomAnimations(mAnimateNext[0], mAnimateNext[1])
                }
                else {
                    ft.setCustomAnimations(mAnimateNext[0], mAnimateNext[1], mAnimateBack[0], mAnimateBack[1])
                }
            }
            try {
                if (mIsAdd) {
                    ft.add(containerId, mNextPage!!, mTag).commit()
                }
                else {
                    ft.replace(containerId, mNextPage!!, mTag).commit()
                }
            } catch (e: IllegalStateException) {
                throw Base.Exception(Base.Error.FragmentTransactionFailed)
            }
        }

        private fun removeCurrentFragment() {
            val fragment = currentFragment
            if (fragment != null) {
                val ft = mFragmentMgr!!.beginTransaction()
                ft.remove(currentFragment!!)
                ft.commit()
            }
        }
    }

    enum class Structure {
        NAV_GRAPH, GENERAL_FRAGMENT
    }

    /**
     * 這邊要選擇使用
     *
     * Navigation還是一般的架構開發
     *
     */
    abstract val layoutResId: Structure

    fun setBottomItemDefault(deskTopFragment: Int) {
        mNavBottomBar?.selectedItemId = deskTopFragment;
    }

    open val layoutId: Int
        get() = R.layout.activity_base

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        mFragmentMgr = supportFragmentManager
        initMainBar()
        initBottomBar()
        initStructure()
    }

    /**
     * 初始化元件
     */
    private fun initMainBar() {

        when(layoutResId){
            Structure.NAV_GRAPH        -> {
                mMainBar = findViewById(R.id.navMainBar)
            }
            Structure.GENERAL_FRAGMENT -> {
                mMainBar = findViewById(R.id.generalMainBar)
            }
        }

        setSupportActionBar(mMainBar)

        mMainBarTitle = findViewById(R.id.navMainBarTitle)
        mMainBarTitle?.text = mMainBar?.title

        val actBar = supportActionBar
        if (actBar != null) {
            actBar.setDisplayShowTitleEnabled(false)
            actBar.setDisplayHomeAsUpEnabled(true)
            actBar.setHomeButtonEnabled(true)
            actBar.hide()
        }
    }

    private fun initBottomBar() {
        mNavBottomBar = findViewById(R.id.navBottomBar)
    }

    private fun initStructure() {
        when (layoutResId) {
            Structure.NAV_GRAPH        ->
            {
                mNavController = findNavController(R.id.nav_host_fragment)
                val generalContainer = findViewById<ConstraintLayout>(R.id.generalContainer)
                generalContainer.visibility = View.GONE
            }
            Structure.GENERAL_FRAGMENT -> {
                val navContainer = findViewById<ConstraintLayout>(R.id.navContainer)
                navContainer.visibility = View.GONE
            }
        }
    }

    /**
     * 共同使用的
     */
    fun setMainBarTitle(@StringRes resId: Int) {
        if (mMainBarTitle != null) mMainBarTitle!!.setText(resId)
    }

    override fun onBackPressed() {
        hideKeyboard()
        if (!mCanPressBack) return
        val fragment = currentFragment
        if (fragment!=null) {
            if (fragment is IOnBackPressed) {
                if ((fragment as IOnBackPressed).onBackPressed()) {
                    try {
                        initPageController().back()
                    } catch (e: Base.Exception) {
                        if (e.isEqual(Base.Error.StackIsEmpty)) {
                            Log.d(TAG, e.message!!)
                            super.onBackPressed()
                        }
                    }
                }
            }
            else {
                super.onBackPressed()
            }
        }
    }

    @JvmOverloads
    fun hideKeyboard(view: View? = currentFocus) {
        if (view == null) return
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun showLoading(isShow: Boolean, canPressBack: Boolean, gif: Any) {
        val view = findViewById<View>(mainLoading)
        if (view != null) {
            val visibility = view.visibility
            if (isShow) {
                if (visibility != View.VISIBLE) {
                    view.visibility = View.VISIBLE
                }
                Log.d("Develop_","gid:$gif")
                when(gif){
                    is String->{
                        if (gif!="") {
                            view.findViewById<View>(R.id.main_default_progress).apply {
                                this.visibility = View.INVISIBLE
                            }
                            view.findViewById<ImageView>(R.id.main_custom_loading).apply {
                                this.visibility = View.VISIBLE
                                Glide.with(this).load(gif).into(this)
                            }
                        }else{
                            view.findViewById<View>(R.id.main_default_progress).apply {
                                this.visibility = View.VISIBLE
                            }
                            view.findViewById<ImageView>(R.id.main_custom_loading).apply {
                                this.visibility = View.INVISIBLE
                            }
                        }
                    }
                    is Int->{
                        view.findViewById<View>(R.id.main_default_progress).apply {
                            this.visibility = View.INVISIBLE
                        }
                        view.findViewById<ImageView>(R.id.main_custom_loading).apply {
                            this.visibility = View.VISIBLE
                            Glide.with(this).load(gif).into(this)
                        }
                    }
                    else->{
                        view.findViewById<View>(R.id.main_default_progress).apply {
                            this.visibility = View.VISIBLE
                        }
                        view.findViewById<ImageView>(R.id.main_custom_loading).apply {
                            this.visibility = View.INVISIBLE
                        }
                    }
                }

                mCanPressBack = canPressBack
            }
            else {
                if (visibility != View.GONE) {
                    view.visibility = View.GONE
                }
                mCanPressBack = true
            }
        }
        else {
            val id = resources.getResourceEntryName(mainLoading)
            throw NullPointerException("No get main activity loading view id: '$id'!")
        }
    }

    /**
     * Navigation架構專用
     */
    fun setGraph(navGraph: Int) {
        mNavController.setGraph(navGraph)
    }

    fun navWithBundle(resId: Int,bundle:Bundle?) {
        try{
            if (bundle!=null) {
                mNavController.navigate(resId,bundle)
            }else{
                mNavController.navigate(resId)
            }
        }catch (e:Exception){
            Log.e("Develop_","NAVIGATION模式下一頁錯誤:${e.message}")
        }
    }

    fun navWithSafeArgs(resId: NavDirections) {
        try{
            mNavController.navigate(resId)
        }catch (e:Exception){
            Log.e("Develop_","NAVIGATION模式下一頁錯誤:${e.message}")
        }
    }

    fun showBottomBar(isShow: Boolean){
        if (isShow){
            mNavBottomBar?.visibility = View.VISIBLE
        }else{
            mNavBottomBar?.visibility = View.GONE
        }
    }

    fun setBottomBarMenu(bottomBarMenuResId: Int) {
        try {
            mNavBottomBar?.menu?.clear();
            mNavBottomBar?.inflateMenu(bottomBarMenuResId);
        }catch (e:Exception){
            Log.e("Develop_${TAG}","底部選單設定錯誤:${e.message}")
        }
    }

    fun setBottomBarMenuTheme() {
        try {
        }catch (e:Exception){
            Log.e("Develop_${TAG}","底部選單主題設定錯誤:${e.message}")
        }
    }

    fun setBottomBarListener(listenerBottomBar: NavigationBarView.OnItemSelectedListener) {
        mNavBottomBar?.setOnItemSelectedListener(listenerBottomBar)
    }

    fun getCurrentDestination(): NavDestination? {
        return mNavController?.currentDestination
    }

    /**
     *  一般架構專用
     */
    fun initPageController(): IPageController {
        return PageController()
    }




    /**
     * 其他
     */
    protected fun cleanIntent() {
        val intent = intent
        if (intent != null) {
            intent.replaceExtras(Intent())
            intent.action = ""
            intent.data = null
            intent.flags = 0
        }
    }

    fun popBackStack() {
        mNavController?.popBackStack()
    }

    fun setNavigationListener(actionBarBackListener: View.OnClickListener?) {
        when(layoutResId){
            Structure.NAV_GRAPH        -> {
                if (actionBarBackListener == null){
                    mMainBar?.setNavigationOnClickListener { onBackPressed() }
                }else{
                    mMainBar?.setNavigationOnClickListener(actionBarBackListener)
                }
            }
            Structure.GENERAL_FRAGMENT -> {
                mMainBar?.setNavigationOnClickListener { onBackPressed() }
            }
        }
    }

    fun setDestinationChangedListener(listener: NavController.OnDestinationChangedListener?) {
        if (listener!=null) {
            mNavController.addOnDestinationChangedListener(listener)
        }
    }


}