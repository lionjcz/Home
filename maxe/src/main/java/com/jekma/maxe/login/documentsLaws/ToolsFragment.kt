package com.jekma.maxe.login.documentsLaws

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jekma.baselibrary.BaseFragment
//import androidx.navigation.NavController
import com.jekma.maxe.R

class ToolsFragment : BaseFragment()
//    , View.OnClickListener
{
    override val isShowMainBar: Boolean
        get() = true
    override val titleResId: Int
        get() = R.string.maxe_title_document_law
    override val layoutResId: Int
        get() = R.layout.maxe_fragment_tools

    //
//    //    FunctionBox
//    private var view: View? = null
//    var Laws: LinearLayout? = null
//    var Documents: LinearLayout? = null
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        this.view = view
//        Laws = view.findViewById<LinearLayout>(R.id.L2_D_LmenuLaw)
//        Documents = view.findViewById<LinearLayout>(R.id.L2_D_Lmenuocuments)
//        Laws.setOnClickListener(this)
//        Documents.setOnClickListener(this)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?, savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_tools, container, false)
//    }
//
//    override fun onClick(v: View) {
//        val navController: NavController = findNavController(view)
//        val linearLayout: LinearLayout = v as LinearLayout
//        val changeLayout: Int = linearLayout.getId()
//        when (changeLayout) {
//            R.id.L2_D_LmenuLaw      -> navController.navigate(R.id.action_nav_tools_to_laws)
//            R.id.L2_D_Lmenuocuments -> navController.navigate(R.id.action_nav_tools_to_documents)
//            else                    -> throw IllegalStateException("Unexpected value: " + v.id)
//        }
//    }
}


class ToolsViewModel : ViewModel() {
    private val mText: MutableLiveData<String>
    val text: LiveData<String>
        get() = mText

    init {
        mText = MutableLiveData()
        mText.value = "This is tools fragment"
    }
}