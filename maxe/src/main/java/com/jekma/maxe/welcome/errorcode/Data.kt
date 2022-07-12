package com.company.maxe.welcome.errorcode

data class Data (
        var Hint:String = "",
        var LeftButton:String ="",
        var RightButton:String =""

){
    fun Hint(): String {
        return Hint;
    }


}