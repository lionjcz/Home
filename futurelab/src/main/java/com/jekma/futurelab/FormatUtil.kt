package com.jekma.futurelab

import java.util.regex.Pattern

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