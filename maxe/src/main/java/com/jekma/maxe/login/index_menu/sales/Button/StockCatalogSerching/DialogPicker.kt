package com.company.maxe.Login.index_menu.sales.Button.StockCatalogSerching
//package com.example.redeady.ui.Login.L1.Button.sales.Button.SerchingStock.CatalogSerching;
import android.app.AlertDialog
import android.app.Dialog
import android.view.View
import androidx.appcompat.app.AppCompatDialogFragment
import com.jekma.maxe.R

class DialogPicker(private val OnChosen: Int)
//    : AppCompatDialogFragment()
//    , OnValueChangeListener
{
//
//    //        壁掛_變頻_1級_一對一_0
//    private val 壁掛_變頻_1級_一對一_0 =
//        arrayOf("請選擇", "2.2~2.3KW", "2.8~2.9KW", "3.6KW", "4.1~4.2KW", "5.0~5.3KW", "7.2~7.3KW", "8.0KW", "8.5KW", "9.0KW", "11.2KW")
//
//    //        壁掛_變頻_1級_一對二_1
//    private val 壁掛_變頻_1級_一對二_1 =
//        arrayOf("請選擇", "5.6KW", "6.4KW", "6.9KW", "7.8KW", "8.2KW", "10.1KW", "14.4KW")
//
//    //        壁掛_變頻_1級_一對多_2
//    private val 壁掛_變頻_1級_一對多_2 =
//        arrayOf("請選擇", "5.0~5.3KW", "6.5KW", "7.4KW", "8.5KW", "10.5KW", "13.0KW")
//
//    //        壁掛_變頻_4級_一對一_3
//    private val 壁掛_變頻_4級_一對一_3 =
//        arrayOf("請選擇", "2.2~2.3KW", "2.8~2.9KW", "3.6KW", "4.1~4.2KW", "5.0~5.3KW", "7.2~7.3KW", "8.0KW")
//
//    //        壁掛_定頻_5級_一對一_4
//    private val 壁掛_定頻_5級_一對一_4 =
//        arrayOf("請選擇", "2.2~2.3KW", "2.8~2.9KW", "3.6KW", "4.1~4.2KW", "5.0~5.3KW", "6.3KW", "7.2~7.3KW", "8.0KW", "8.5KW", "9.0KW", "10.0KW", "11.2KW")
//
//    //        壁掛_定頻_5級_一對二_5
//    private val 壁掛_定頻_5級_一對二_5 =
//        arrayOf("請選擇", "4.4KW", "5.6KW", "6.9KW", "7.8KW", "8.2KW", "10.0KW", "14.4KW", "17.0KW")
//
//    //        吊隱式_變頻_x_一對一_6
//    private val 吊隱式_變頻_x_一對一_6 =
//        arrayOf("請選擇", "2.8~2.9KW", "3.6KW", "4.1~4.2KW", "5.0~5.3KW", "7.2~7.3KW", "8.5KW", "9.0KW", "11.2KW", "14.0KW")
//
//    //        吊隱式_變頻_x_一對二_7
//    private val 吊隱式_變頻_x_一對二_7 =
//        arrayOf("請選擇", "5.6KW", "6.4KW", "6.9KW", "7.8KW", "8.2KW", "10.1KW", "14.4KW")
//
//    //        吊隱式_變頻_x_一對多_8
//    private val 吊隱式_變頻_x_一對多_8 =
//        arrayOf("請選擇", "5.0~5.3KW", "6.5KW", "7.4KW", "8.5KW", "10.5KW", "13.0KW")
//
//    //        吊隱式_定頻_x_一對一_9
//    private val 吊隱式_定頻_x_一對一_9 =
//        arrayOf("請選擇", "2.8~2.9KW", "4.1~4.2KW", "5.0~5.3KW", "7.2~7.3KW", "8.5KW", "10.0KW", "11.2KW", "14.0KW")
//
//    //        吊隱式_定頻_x_一對二_10
//    private val 吊隱式_定頻_x_一對二_10 =
//        arrayOf("請選擇", "4.4KW", "5.6KW", "6.9KW", "7.8KW", "8.2KW", "10.0KW", "14.4KW", "17.0KW")
//
//    //        落地箱型_變頻_1級_x_11
//    private val 落地箱型_變頻_1級_x_11 = arrayOf("請選擇", "11.2KW", "14.0KW")
//
//    //        落地箱型_定頻_5級_x_12
//    private val 落地箱型_定頻_5級_x_12 = arrayOf("請選擇", "11.2KW", "14.0KW")
//    private val condition1 = arrayOf("請選擇", "壁掛", "吊隱式", "落地箱型")
//    private val condition2 = arrayOf("請選擇", "定頻", "變頻")
//    private val 壁掛_變頻 = arrayOf("請選擇", "1級", "4級")
//    private val 壁掛_定頻 = arrayOf("請選擇", "5級")
//    private val 落地箱型_變頻 = arrayOf("請選擇", "1級")
//    private val 落地箱型_定頻 = arrayOf("請選擇", "5級")
//    private val 壁掛_變頻_1級 = arrayOf("請選擇", "一對一", "一對二", "一對多")
//    private val 壁掛_變頻_4級 = arrayOf("請選擇", "一對一")
//    private val 壁掛_定頻_5級 = arrayOf("請選擇", "一對一", "一對二")
//    private val 吊隱式_變頻 = arrayOf("請選擇", "一對一", "一對二", "一對多")
//    private val 吊隱式_定頻 = arrayOf("請選擇", "一對一", "一對二")
//    private var condition3 = arrayOf("請選擇", "1級", "2級", "4級", "5級")
//    private var condition4 = arrayOf("請選擇", "一對一", "一對二", "一對多")
//    private var condition5 = arrayOf("abceew", "awdawdaw")
//    private var c3: TextView? = null
//    private var c4: TextView? = null
//    private var c: TextView? = null
//    private var c2: TextView? = null
//    private var c5: TextView? = null
//    private var valuePicker: String? = null
//    private var TextSet: Array<TextView?>
//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        val builder = AlertDialog.Builder(activity)
//        val inflater: LayoutInflater = activity!!.layoutInflater
//        val root: View = inflater.inflate(R.layout.dialogpicker, null, false)
//        val testpicker: NumberPicker
//        c = activity!!.findViewById<View>(R.id.chosen1) as TextView
//        c2 = activity!!.findViewById<View>(R.id.chosen2) as TextView
//        c3 = activity!!.findViewById<View>(R.id.chosen3) as TextView
//        c4 = activity!!.findViewById<View>(R.id.chosen4) as TextView
//        c5 = activity!!.findViewById<View>(R.id.chosen5) as TextView
//        TextSet = arrayOf<TextView?>(c, c2, c3, c4, c5)
//        testpicker = root.findViewById<NumberPicker>(R.id.picke1)
//        testpicker.setMinValue(0)
//        when (OnChosen) {
//            R.id.chosen1 -> {
//                testpicker.setMaxValue(condition1.size - 1)
//                testpicker.setDisplayedValues(condition1)
//                valuePicker = condition1[testpicker.getValue()]
//                testpicker.setOnValueChangedListener(this)
//            }
//            R.id.chosen2 -> {
//                if (c.getText() == "壁掛" || c.getText() == "吊隱式" || c.getText() == "落地箱型") {
//                    testpicker.setMaxValue(condition2.size - 1)
//                    testpicker.setDisplayedValues(condition2)
//                    valuePicker = condition2[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                    testpicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS)
//                }
//                else {
//                    val testttarray = arrayOf("請選擇完畢")
//                    testpicker.setMaxValue(testttarray.size - 1)
//                    testpicker.setDisplayedValues(testttarray)
//                    condition3 = testttarray
//                    valuePicker = condition3[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//            }
//            R.id.chosen3 -> {
//                if (c.getText() == "壁掛" && c2.getText() == "變頻") {
//                    testpicker.setMaxValue(壁掛_變頻.size - 1)
//                    testpicker.setDisplayedValues(壁掛_變頻)
//                    condition3 = 壁掛_變頻
//                    valuePicker = condition3[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "壁掛" && c2.getText() == "定頻") {
//                    testpicker.setMaxValue(壁掛_定頻.size - 1)
//                    testpicker.setDisplayedValues(壁掛_定頻)
//                    condition3 = 壁掛_定頻
//                    valuePicker = condition3[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "吊隱式" && c2.getText() == "變頻") {
//                    testpicker.setMaxValue(壁掛_定頻.size - 1)
//                    testpicker.setDisplayedValues(壁掛_定頻)
//                    condition3 = 壁掛_定頻
//                    valuePicker = condition3[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "吊隱式" && c2.getText() == "變頻") {
//                    testpicker.setMaxValue(壁掛_定頻.size - 1)
//                    testpicker.setDisplayedValues(壁掛_定頻)
//                    condition3 = 壁掛_定頻
//                    valuePicker = condition3[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "落地箱型" && c2.getText() == "定頻") {
//                    testpicker.setMaxValue(落地箱型_定頻.size - 1)
//                    testpicker.setDisplayedValues(落地箱型_定頻)
//                    condition3 = 落地箱型_定頻
//                    valuePicker = condition3[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "落地箱型" && c2.getText() == "變頻") {
//                    testpicker.setMaxValue(落地箱型_變頻.size - 1)
//                    testpicker.setDisplayedValues(落地箱型_變頻)
//                    condition3 = 落地箱型_變頻
//                    valuePicker = condition3[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else {
//                    val testttarray = arrayOf("請選擇完畢")
//                    testpicker.setMaxValue(testttarray.size - 1)
//                    testpicker.setDisplayedValues(testttarray)
//                    condition3 = testttarray
//                    valuePicker = condition3[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//            }
//            R.id.chosen4 -> {
//                if (c.getText() == "壁掛" && c2.getText() == "變頻" && c3.getText() == "1級") {
//                    testpicker.setMaxValue(壁掛_變頻_1級.size - 1)
//                    testpicker.setDisplayedValues(壁掛_變頻_1級)
//                    condition4 = 壁掛_變頻_1級
//                    valuePicker = condition4[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "壁掛" && c2.getText() == "變頻" && c3.getText() == "4級") {
//                    testpicker.setMaxValue(壁掛_變頻_4級.size - 1)
//                    testpicker.setDisplayedValues(壁掛_變頻_4級)
//                    condition4 = 壁掛_變頻_4級
//                    valuePicker = condition4[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "壁掛" && c2.getText() == "定頻" && c3.getText() == "5級") {
//                    testpicker.setMaxValue(壁掛_定頻_5級.size - 1)
//                    testpicker.setDisplayedValues(壁掛_定頻_5級)
//                    condition4 = 壁掛_定頻_5級
//                    valuePicker = condition4[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "吊隱式" && c2.getText() == "變頻") {
//                    testpicker.setMaxValue(吊隱式_變頻.size - 1)
//                    testpicker.setDisplayedValues(吊隱式_變頻)
//                    condition4 = 吊隱式_變頻
//                    valuePicker = condition4[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "吊隱式" && c2.getText() == "定頻") {
//                    testpicker.setMaxValue(吊隱式_定頻.size - 1)
//                    testpicker.setDisplayedValues(吊隱式_定頻)
//                    condition4 = 吊隱式_定頻
//                    valuePicker = condition4[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "落地箱型" && c2.getText() == "變頻" && c3.getText() == "1級") {
//                    testpicker.setMaxValue(壁掛_變頻_1級_一對一_0.size - 1)
//                    testpicker.setDisplayedValues(壁掛_變頻_1級_一對一_0)
//                    condition4 = 壁掛_變頻_1級_一對一_0
//                    valuePicker = condition4[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "落地箱型" && c2.getText() == "定頻" && c3.getText() == "5級") {
//                    testpicker.setMaxValue(壁掛_變頻_1級_一對一_0.size - 1)
//                    testpicker.setDisplayedValues(壁掛_變頻_1級_一對一_0)
//                    condition4 = 壁掛_變頻_1級_一對一_0
//                    valuePicker = condition4[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else {
//                    val testttarray = arrayOf("請選擇完畢")
//                    testpicker.setMaxValue(testttarray.size - 1)
//                    testpicker.setDisplayedValues(testttarray)
//                    condition4 = testttarray
//                    valuePicker = condition4[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//            }
//            R.id.chosen5 -> {
//
//                //        壁掛_變頻_1級_一對一_0 checked
//                if (c.getText() == "壁掛" && c2.getText() == "變頻" && c3.getText() == "1級" && c4.getText() == "一對一") {
//                    testpicker.setMaxValue(壁掛_變頻_1級_一對一_0.size - 1)
//                    testpicker.setDisplayedValues(壁掛_變頻_1級_一對一_0)
//                    condition5 = 壁掛_變頻_1級_一對一_0
//                    valuePicker = condition5[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "壁掛" && c2.getText() == "變頻" && c3.getText() == "1級" && c4.getText() == "一對二") {
//                    testpicker.setMaxValue(壁掛_變頻_1級_一對二_1.size - 1)
//                    testpicker.setDisplayedValues(壁掛_變頻_1級_一對二_1)
//                    condition5 = 壁掛_變頻_1級_一對二_1
//                    valuePicker = condition5[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "壁掛" && c2.getText() == "變頻" && c3.getText() == "1級" && c4.getText() == "一對多") {
//                    testpicker.setMaxValue(壁掛_變頻_1級_一對多_2.size - 1)
//                    testpicker.setDisplayedValues(壁掛_變頻_1級_一對多_2)
//                    condition5 = 壁掛_變頻_1級_一對多_2
//                    valuePicker = condition5[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "壁掛" && c2.getText() == "變頻" && c3.getText() == "4級" && c4.getText() == "一對一") {
//                    testpicker.setMaxValue(壁掛_變頻_4級_一對一_3.size - 1)
//                    testpicker.setDisplayedValues(壁掛_變頻_4級_一對一_3)
//                    condition5 = 壁掛_變頻_4級_一對一_3
//                    valuePicker = condition5[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "壁掛" && c2.getText() == "定頻" && c3.getText() == "5級" && c4.getText() == "一對一") {
//                    testpicker.setMaxValue(壁掛_定頻_5級_一對一_4.size - 1)
//                    testpicker.setDisplayedValues(壁掛_定頻_5級_一對一_4)
//                    condition5 = 壁掛_定頻_5級_一對一_4
//                    valuePicker = condition5[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "壁掛" && c2.getText() == "定頻" && c3.getText() == "5級" && c4.getText() == "一對二") {
//                    testpicker.setMaxValue(壁掛_定頻_5級_一對二_5.size - 1)
//                    testpicker.setDisplayedValues(壁掛_定頻_5級_一對二_5)
//                    condition5 = 壁掛_定頻_5級_一對二_5
//                    valuePicker = condition5[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "吊隱式" && c2.getText() == "變頻" && c4.getText() == "一對一") {
//                    testpicker.setMaxValue(吊隱式_變頻_x_一對一_6.size - 1)
//                    testpicker.setDisplayedValues(吊隱式_變頻_x_一對一_6)
//                    condition5 = 吊隱式_變頻_x_一對一_6
//                    valuePicker = condition5[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "吊隱式" && c2.getText() == "變頻" && c4.getText() == "一對二") {
//                    testpicker.setMaxValue(吊隱式_變頻_x_一對二_7.size - 1)
//                    testpicker.setDisplayedValues(吊隱式_變頻_x_一對二_7)
//                    condition5 = 吊隱式_變頻_x_一對二_7
//                    valuePicker = condition5[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "吊隱式" && c2.getText() == "變頻" && c4.getText() == "一對多") {
//                    testpicker.setMaxValue(吊隱式_變頻_x_一對多_8.size - 1)
//                    testpicker.setDisplayedValues(吊隱式_變頻_x_一對多_8)
//                    condition5 = 吊隱式_變頻_x_一對多_8
//                    valuePicker = condition5[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "吊隱式" && c2.getText() == "定頻" && c4.getText() == "一對一") {
//                    testpicker.setMaxValue(吊隱式_定頻_x_一對一_9.size - 1)
//                    testpicker.setDisplayedValues(吊隱式_定頻_x_一對一_9)
//                    condition5 = 吊隱式_定頻_x_一對一_9
//                    valuePicker = condition5[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "吊隱式" && c2.getText() == "定頻" && c4.getText() == "一對二") {
//                    testpicker.setMaxValue(吊隱式_定頻_x_一對二_10.size - 1)
//                    testpicker.setDisplayedValues(吊隱式_定頻_x_一對二_10)
//                    condition5 = 吊隱式_定頻_x_一對二_10
//                    valuePicker = condition5[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "落地箱型" && c2.getText() == "變頻" && c3.getText() == "1級") {
//                    testpicker.setMaxValue(落地箱型_變頻_1級_x_11.size - 1)
//                    testpicker.setDisplayedValues(落地箱型_變頻_1級_x_11)
//                    condition5 = 落地箱型_變頻_1級_x_11
//                    valuePicker = condition5[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else if (c.getText() == "落地箱型" && c2.getText() == "定頻" && c3.getText() == "5級") {
//                    testpicker.setMaxValue(落地箱型_定頻_5級_x_12.size - 1)
//                    testpicker.setDisplayedValues(落地箱型_定頻_5級_x_12)
//                    condition5 = 落地箱型_定頻_5級_x_12
//                    valuePicker = condition5[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//                else {
////                    Toast.makeText(getActivity().getApplicationContext(),"switcher closed",Toast.LENGTH_SHORT).show();
//                    val testttarray = arrayOf("請選擇完畢")
//                    testpicker.setMaxValue(testttarray.size - 1)
//                    testpicker.setDisplayedValues(testttarray)
//                    condition5 = testttarray
//                    valuePicker = condition5[testpicker.getValue()]
//                    testpicker.setOnValueChangedListener(this)
//                }
//            }
//        }


        //for test
//        switch(OnChosen){
//            case R.id.chosen1:{
//                testpicker.setMaxValue(condition1.length-1);
//                testpicker.setDisplayedValues(condition1);
//                valuePicker = condition1[testpicker.getValue()];
//                testpicker.setOnValueChangedListener(this);
//
//                break;
//            }
//            case R.id.chosen2:{
//                testpicker.setMaxValue(condition2.length-1);
//                testpicker.setDisplayedValues(condition2);
//                valuePicker = condition2[testpicker.getValue()];
//                testpicker.setOnValueChangedListener(this);
//                break;
//            }
//            case R.id.chosen3:{
//                testpicker.setMaxValue(壁掛_變頻.length - 1);
//                testpicker.setDisplayedValues(壁掛_變頻);
//                condition3 = 壁掛_變頻;
//                valuePicker = condition3[testpicker.getValue()];
//                testpicker.setOnValueChangedListener(this);
//                break;
//            }
//            case R.id.chosen4:{
//                testpicker.setMaxValue(壁掛_變頻_1級.length - 1);
//                testpicker.setDisplayedValues(壁掛_變頻_1級);
//                condition4 = 壁掛_變頻_1級;
//                valuePicker = condition4[testpicker.getValue()];
//
//                testpicker.setOnValueChangedListener(this);
//                break;
//            }
//            case R.id.chosen5:{
//
//                testpicker.setMaxValue(壁掛_變頻_1級.length - 1);
//                testpicker.setDisplayedValues(壁掛_變頻_1級);
//                condition5 = 壁掛_變頻_1級;
//                valuePicker = condition5[testpicker.getValue()];
//
//                testpicker.setOnValueChangedListener(this);
//
//                break;
//            }
//        }
//        builder.setView(root).setTitle("請選擇")
//            .setNegativeButton("cancel", object : DialogInterface.OnClickListener {
//                override fun onClick(dialog: DialogInterface, which: Int) {}
//            }).setPositiveButton("confirm", object : DialogInterface.OnClickListener {
//                override fun onClick(dialog: DialogInterface, which: Int) {
//                    val tevdge: TextView = activity!!.findViewById<View>(OnChosen) as TextView
//                    tevdge.setText(valuePicker)
//                    when (valuePicker) {
//                        "壁掛"   -> {
//                            c.setVisibility(View.VISIBLE)
//                            c2.setVisibility(View.VISIBLE)
//                            c2.setText("請選擇")
//                            c3.setVisibility(View.VISIBLE)
//                            c3.setText("級數")
//                            c4.setVisibility(View.VISIBLE)
//                            c4.setText("規格")
//                            c5.setVisibility(View.VISIBLE)
//                            c5.setText("K瓦數")
//                        }
//                        "吊隱式"  -> {
//                            c3.setVisibility(View.GONE)
//                            c4.setVisibility(View.VISIBLE)
//                            c2.setText("請選擇")
//                            c3.setText("級數")
//                            c4.setText("規格")
//                            c5.setText("K瓦數")
//                        }
//                        "落地箱型" -> {
//                            c3.setVisibility(View.VISIBLE)
//                            c4.setVisibility(View.GONE)
//                            c2.setText("請選擇")
//                            c3.setText("級數")
//                            c4.setText("規格")
//                            c5.setText("K瓦數")
//                        }
//                        "定頻"   -> {
//                            c3.setText("請選擇")
//                            if (c.getText() == "吊隱式") {
//                                c4.setText("請選擇")
//                            }
//                        } //3
//                        "變頻"   -> {
//                            c3.setText("請選擇")
//                            if (c.getText() == "吊隱式") {
//                                c4.setText("請選擇")
//                            }
//                        } //3
//                        "1級"   -> {
//                            c4.setText("請選擇")
//                            if (c.getText() == "落地箱型") {
//                                c5.setText("請選擇")
//                            }
//                        } //4
//                        "2級"   -> {
//                            c4.setText("請選擇")
//                        } //4
//                        "4級"   -> {
//                            c4.setText("請選擇")
//                        } //4
//                        "5級"   -> {
//                            c4.setText("請選擇")
//                            if (c.getText() == "落地箱型") {
//                                c5.setText("請選擇")
//                            }
//                        } //4
//                        "一對一"  -> {
//                            c5.setText("請選擇")
//                        } //5
//                        "一對二"  -> {
//                            c5.setText("請選擇")
//                        } //5
//                        "一對多"  -> {
//                            c5.setText("請選擇")
//                        } //5
//                        else   -> {}
//                    }
//                    for (i in TextSet.indices) {
//                        if (TextSet[i].getText() == "請選擇" || TextSet[i].getText() == "請選擇完畢") {
//                            TextSet[i].setTextColor(resources.getColor(R.color.red))
//                        }
//                        else {
//                            TextSet[i].setTextColor(resources.getColor(R.color.green))
//                        }
//                    }
//                }
//            })
//        return builder.create()
//    }

//    override fun onValueChange(picker: NumberPicker, oldVal: Int, newVal: Int) {
//        if (OnChosen == R.id.chosen1) {
//            valuePicker = condition1[newVal]
//        }
//        else if (OnChosen == R.id.chosen2) {
//            valuePicker = condition2[newVal]
//        }
//        else if (OnChosen == R.id.chosen3) {
//            valuePicker = condition3[newVal]
//        }
//        else if (OnChosen == R.id.chosen4) {
//            valuePicker = condition4[newVal]
//        }
//        else if (OnChosen == R.id.chosen5) {
//            valuePicker = condition5[newVal]
//        }

//        if(newVal==newVal){
//            picker.setValue(newVal);
//        }
    }
//}