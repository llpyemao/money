package llp.money.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import llp.money.R
import llp.money.db.AppDatabase
import llp.money.entity.P2pcompany
import android.widget.AdapterView.OnItemSelectedListener
import android.app.DatePickerDialog
import com.mobsandgeeks.saripaar.Validator
import llp.money.entity.P2p
import java.text.SimpleDateFormat
import java.util.*
import android.widget.Toast
import android.widget.EditText
import com.mobsandgeeks.saripaar.ValidationError
import com.mobsandgeeks.saripaar.annotation.*


class P2pAddFragment : Fragment() , Validator.ValidationListener {
    var p2pcompany = P2pcompany()
    var p2p = P2p()

    @NotEmpty(messageResId = R.string.validation_notNull)
    @Order(1)
    var type : EditText?=null

    @NotEmpty(sequence =1 ,messageResId = R.string.validation_notNull)
    @DecimalMin(value=100.0, sequence =2 ,messageResId = R.string.validation_p2p_principal)
    @DecimalMax(value=100000.0, sequence =3 ,messageResId = R.string.validation_p2p_principal)
    @Order(2)
    var principal : EditText?=null

    @NotEmpty(messageResId = R.string.validation_notNull , sequence =1)
    @DecimalMin(value=0.01, sequence =2,messageResId = R.string.validation_p2p_rate)
    @DecimalMax(value=0.2, sequence =3,messageResId = R.string.validation_p2p_rate)
    @Order(3)
    var rate : EditText?=null

    @NotEmpty(messageResId = R.string.validation_notNull, sequence =1)
    @Pattern(regex = "^[1-9]\\d{3}-([1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])\$", messageResId = R.string.validation_date, sequence =2)
    @Order(4)
    var dateFrom : EditText?=null

    @NotEmpty(messageResId = R.string.validation_notNull, sequence =1)
    @Pattern(regex = "((((19|20)\\d{2})-(0?(1|[3-9])|1[012])-(0?[1-9]|[12]\\d|30))|(((19|20)\\d{2})-(0?[13578]|1[02])-31)|(((19|20)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|((((19|20)([13579][26]|[2468][048]|0[48]))|(2000))-0?2-29))\$", messageResId = R.string.validation_date, sequence =2)
    @Order(5)
    var dateEnd : EditText?=null

    var addButton : Button?=null
    var validatorSaripaar : Validator? = null
    var viewAdd : View?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewAdd = inflater.inflate(R.layout.fragment_p2p_add, container, false)
        //处理p2pcompany的name
        var mySpinner : Spinner =viewAdd!!.findViewById(R.id.p2pcompanyId1)

        val p2pcompanyDao = AppDatabase.getInstance(this.context).p2pcompanyDao()
        val p2pcompanys : List<String> = p2pcompanyDao.names

        //R.layout.simple_spinner_item是系统已定义好的，可以直接使用
        var myaAdapter : ArrayAdapter<String>  =  ArrayAdapter<String>(this.activity, android.R.layout.simple_spinner_item, p2pcompanys)

        mySpinner.setAdapter(myaAdapter)

        mySpinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                //获取选中的值
                p2pcompany.name= mySpinner.selectedItem as String
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }

        //产品类型
        type=viewAdd?.findViewById(R.id.type)
        //本金
        principal =viewAdd?.findViewById(R.id.principal)
        //预期利率
        rate=viewAdd?.findViewById(R.id.rate)


        //dateFrom日历
        dateFrom= viewAdd!!.findViewById(R.id.dateFrom)

        dateFrom?.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                showDatePickDlg(dateFrom!!)
                return@OnTouchListener true
            }
            return@OnTouchListener false
        })
        dateFrom?.onFocusChangeListener = View.OnFocusChangeListener { view, b ->
            if (b) {
                showDatePickDlg(dateFrom!!)
            }
        }

        //dateEnd日历
        dateEnd= viewAdd!!.findViewById(R.id.dateEnd)

        dateEnd?.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                showDatePickDlg(dateEnd!!)
                return@OnTouchListener true
            }
            return@OnTouchListener false
        })
        dateEnd?.onFocusChangeListener = View.OnFocusChangeListener { view, b ->
            if (b) {
                showDatePickDlg(dateEnd!!)
            }
        }

        //设置验证
        validatorSaripaar = Validator(this);
        validatorSaripaar?.setValidationListener(this);


        addButton =viewAdd?.findViewById(R.id.addButton)
        //注册提交按钮点击事件
        addButton?.setOnClickListener( {
            //开始验证前，必须先将所有待验证的控件对象初始化（赋值），否则会出现null异常
            validatorSaripaar?.validate();//开始验证
        } )

        return viewAdd
    }

    protected fun showDatePickDlg(editText : EditText) {
        val calendar = Calendar.getInstance()//设置当前日期到日历控件
        val datePickerDialog = DatePickerDialog(this.activity,
                DatePickerDialog.OnDateSetListener {view, year, monthOfYear, dayOfMonth ->
                    editText.setText(year.toString() + "-" + monthOfYear + "-" + dayOfMonth )
                },calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
        datePickerDialog.show()
    }

    override fun onValidationSucceeded() {
        try {
            val p2pcompanyDao = AppDatabase.getInstance(this.context).p2pcompanyDao()
            val p2pcompanyId=p2pcompanyDao.getIdByName(p2pcompany.name)

            p2p.p2pcompanyId=p2pcompanyId

            //准备提交数据
            //产品类型
            type=viewAdd?.findViewById(R.id.type)
            p2p.type=type!!.text.toString()
            //本金
            principal =viewAdd?.findViewById(R.id.principal)
            p2p.principal=principal!!.text.toString().toDouble()
            //预期利率
            rate=viewAdd?.findViewById(R.id.rate)
            p2p.rate=rate!!.text.toString().toDouble()
            //起始日期
            var date:String=dateFrom!!.text.toString()
            p2p.dateFrom= SimpleDateFormat("yyyy-MM-dd").parse(date)
            date=dateEnd!!.text.toString()
            p2p.dateEnd=SimpleDateFormat("yyyy-MM-dd").parse(date)

            //添加

            val p2pDao = AppDatabase.getInstance(this.context).p2pDao()
            p2pDao.insert(p2p)
            AlertDialog.Builder(this.context)
                    .setTitle("添加")
                    .setMessage("成功！")
                    .setPositiveButton("确定", null)
                    .show()

            principal!!.text=null
            dateEnd!!.text=null
        }catch (e:Exception){
            AlertDialog.Builder(this.context)
                    .setTitle("添加")
                    .setMessage("失败！")
                    .setPositiveButton("确定", null)
                    .show()
        }
    }

    override fun onValidationFailed(errors: List<ValidationError>) {
        for (error in errors) {
            val view = error.view
            val message = error.getCollatedErrorMessage(this.context)
            // Display error messages ;)
            if (view is EditText) {
                view.error = message
            } else {
                Toast.makeText(this.context, message, Toast.LENGTH_LONG).show()
            }
        }
    }

}