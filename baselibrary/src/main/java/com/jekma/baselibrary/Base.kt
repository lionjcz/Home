package com.jekma.baselibrary

import androidx.fragment.app.Fragment;

class Base {
    enum class Error(val value: Int, val message: String) {
        OK(0, "OK"),
        Unknown(-999999, "Unknown"),
        ActivityIsNull(-12, "Activity is NULL"),
        ActivityIsIllegal(-13, "Activity is illegal"),
        ActionBarIsNull(-14, "Action bar is NULL"),
        FragmentIsNull(-15, "Fragment is NULL"),
        StackIsEmpty(-16, "Stack is EMPTY"),
        FragmentTransactionFailed(-17, "Fragment transaction is FAILED");
    }

    class Exception(private val mError: Error) : java.lang.Exception(mError.message) {
        private val mExtCode: Int = Error.Unknown.value
        val code: Int get() = mError.value
        override val message: String get() = "Exception: " + mError.message
        fun isEqual(e: Error): Boolean {
            return e.value == mError.value
        }
    }

    interface IPageController {
        fun setNextPage(nextPage: Fragment?): IPageController?
        fun setAdd(): IPageController?
        fun setReplace(): IPageController?
        fun setKeepBack(name: String?): IPageController?
        fun setCleanTop(): IPageController?
        fun setAnimate(enter: Int, exit: Int): IPageController?
        fun setAnimate(enter: Int, exit: Int, back_enter: Int, back_exit: Int): IPageController?

        @Throws(Exception::class)
        fun back()

        @Throws(Exception::class)
        fun back(name: String?)

        @Throws(Exception::class)
        fun forward()
    }

    interface IOnBackPressed {
        fun onBackPressed(): Boolean
    }
}