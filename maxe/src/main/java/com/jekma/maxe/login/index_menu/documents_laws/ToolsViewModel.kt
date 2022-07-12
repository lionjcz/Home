package com.company.maxe.Login.index_menu.documents_laws

//import androidx.navigation.Navigation.findNavController
import com.company.maxe.Tools.Callback.IResult
import com.company.maxe.Tools.URL.VolleyBridge
import com.company.maxe.Tools.URL.VolleyService
import android.widget.Toast
import android.widget.LinearLayout
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToolsViewModel : ViewModel() {
    private val mText: MutableLiveData<String>
    val text: LiveData<String>
        get() = mText

    init {
        mText = MutableLiveData()
        mText.value = "This is tools fragment"
    }
}