package com.company.maxe.Tools

//import androidx.lifecycle.ViewModelProvider.get

class Tool(variable: Any) {
    private var variable: Any? = null

    /*
    * 檢查傳進來的字串是否為空值，或是不存在，在依照判斷回傳字串
    * */
    var checkNull: String
        get() = if (variable != null && variable != "") {
            variable.toString()
        }
        else if (variable == "") {
            "wasEmpty"
        }
        else if (variable == "false") {
            "false is string"
        }
        else {
            "CheckNull"
        }
        private set(variable) {
            this.variable = variable
        }

//    init {
//        checkNull = variable
//    }
}