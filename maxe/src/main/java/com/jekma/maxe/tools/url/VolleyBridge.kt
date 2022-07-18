package com.jekma.maxe.tools.url
//
//import androidx.lifecycle.ViewModelProvider.get

class VolleyBridge {
    //登入網址
    fun ip(): String {
        android.util.Log.wtf("VolleyBridge", tmp)
        return Url
    }

    fun Env(): String {
        return switch_Url
    }

    fun URL(): String {
        return Url
    }

    fun version(): String {
        return version
    }

    //以下為Laravel 框架
    //登入網址
    fun Login_Url(): String {
//            tmp = "http://"+switch_Url+"/started_conn/login.php";
        tmp = "http://" + switch_Url + "/public/api/login"
        Log(tmp)
        return tmp
    }

    //註冊網址
    fun Register_Url(): String {
        tmp = "http://" + switch_Url + "/public/api/Register"
        Log(tmp)
        return tmp
    }

    //更改密碼
    fun changePWD(): String {
        tmp = "http://" + switch_Url + "/public/api/FirstLogin"
        Log(tmp)
        return tmp
    }

    //公告
    fun Announcements(): String {
        tmp = "http://" + switch_Url + "/public/api/Announcements"
        Log(tmp)
        return tmp
    }

    //業務_取得經銷商名稱
    fun Customer_sales(): String {
        tmp = "http://" + switch_Url + "/public/api/CustomerName"
        Log(tmp)
        return tmp
    }

    //業務_取得經銷商業績
    fun customer_sell(): String {
        tmp = "http://" + switch_Url + "/public/api/CustomerSell"
        Log(tmp)
        return tmp
    }

    //業務_庫存
    fun Sales_textSerching(): String {
        tmp = "http://" + switch_Url + "/public/api/TextSerching"
        Log(tmp)
        return tmp
    }

    //業務_庫存
    fun Sales_CatalogSerching(): String {
        tmp = "http://" + switch_Url + "/public/api/CatalogSerching"
        Log(tmp)
        return tmp
    }

    fun status(): String {
        tmp = "http://" + switch_Url + "/public/api/Status"
        Log(tmp)
        return tmp
    }

    //服務_錯誤代碼
    fun Services_errorcode(): String {
        tmp = "http://" + switch_Url + "/public/api/ServicesErrorCode"
        Log(tmp)
        return tmp
    }

    //服務_料號庫存
    fun Services_stock(): String {
        tmp = "http://" + switch_Url + "/public/api/ServicesStock"
        Log(tmp)
        return tmp
    }

    //人資_文件
    fun hr(): String {
        tmp = "http://" + switch_Url + "/public/api/Documents"
        Log(tmp)
        return tmp
    }

    //忘記密碼
    fun forgot(): String {
        tmp = "http://" + switch_Url + "/public/api/setChecker"
        Log(tmp)
        return tmp
    }

    val emailContent: String
        get() {
            tmp = "http://" + switch_Url + "/public/api/getEmailContent"
            Log(tmp)
            return tmp
        }

    fun Manager_URL(): String {
        tmp = "http://" + switch_Url + "/public/api/SellTotal"
        Log(tmp)
        return tmp
    }

    // 取得裝置資訊
    fun DeviceInfo(): String {
        tmp = "http://" + switch_Url + "/public/api/DeviceInfo"
        Log(tmp)
        return tmp
    }

    //以下為原生程式碼，並無任何框架
    //    把套件放在laravel裡面但無使用任何laravel相關框架
    fun DovumentsUsePDFViewer(): String {
        tmp = "http://" + Url + "/" + version + "/package/PDFViewer/web/viewer.html?file="
        Log(tmp)
        return tmp
    }

    fun Log(tmp: String?) {
        android.util.Log.wtf("VolleyBridge", tmp)
    }

    companion object {
        private var switch_Url = ""
        private var tmp = ""
        private var version = ""
        private var Url = ""
    }

    init {
        Url = "www.maxe.com.tw"
        //        Url = "60.250.34.243:4747";
//        version = "wse_app(0729)";
        version = "Mobile"
        switch_Url = Url + "/" + version
    }
}