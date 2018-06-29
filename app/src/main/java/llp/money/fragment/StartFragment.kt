package llp.money.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import com.mobsandgeeks.saripaar.ValidationError
import com.mobsandgeeks.saripaar.Validator
import com.mobsandgeeks.saripaar.annotation.NotEmpty
import com.mobsandgeeks.saripaar.annotation.Order
import llp.money.R
import llp.money.db.AppDatabase
import llp.money.entity.P2p
import llp.money.entity.P2pcompany
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [StartFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [StartFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class StartFragment : Fragment() , Validator.ValidationListener {
    @NotEmpty(messageResId = R.string.validation_notNull)
    @Order(1)
    var editText : EditText?=null
    var validatorSaripaar : Validator?  =null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
            val view = inflater.inflate(R.layout.fragment_start, container, false)

            view.findViewById<Button>(R.id.button_StartFagment).setOnClickListener {

                Thread(Runnable {
                    val P2pcompanyDao =  AppDatabase.getInstance(this.context).p2pcompanyDao()
                    val p2pDao =  AppDatabase.getInstance(context).p2pDao()
                    val p2pcompany = P2pcompany()
                    p2pcompany.setName("宜人贷")
                    p2pcompany.setBank("招商")

                    val id = P2pcompanyDao.insert(p2pcompany)
                    val p2p = P2p()
                    p2p.setP2pcompanyId(id)
                    p2p.setDateActual(Date())
                    p2p.setDateEnd(Date())
                    p2p.setDateFrom(Date())
                    p2p.setInterest(100.0)
                    p2p.setIsNormal(1)
                    p2p.setPrincipal(10000.0)
                    p2p.setRate(0.01)
                    p2p.setRateActual(0.10)
                    p2p.setType("u计划")
                    val aLong = p2pDao.insert(p2p)
                    if (aLong > 0) {
                        Log.i("add", ":+1")
                    }
                }).start()




                Navigation.findNavController(view).navigate(R.id.action_startFragment_to_p2pFragment)
            }

        editText= view!!.findViewById(R.id.editText)


        //设置验证
        validatorSaripaar = Validator(this);
        validatorSaripaar?.setValidationListener(this)


        var addButton : Button =view.findViewById(R.id.button_1)
        //注册提交按钮点击事件
        addButton?.setOnClickListener( {
            validatorSaripaar?.validate();//开始验证
        } )




        return view
    }

    override fun onValidationSucceeded() {
        AlertDialog.Builder(this.context)
                .setTitle("添加")
                .setMessage("成功")
                .setPositiveButton("确定", null)
                .show()
    }

    override fun onValidationFailed(errors: List<ValidationError>) {
        for (error in errors) {
            val view = error.view
            val message = error.getCollatedErrorMessage(this.context)


            AlertDialog.Builder(this.context)
                    .setTitle("添加")
                    .setMessage(message)
                    .setPositiveButton("确定", null)
                    .show()


            // Display error messages ;)
            if (view is EditText) {
                view.error = message
            } else {
                Toast.makeText(this.context, message, Toast.LENGTH_LONG).show()
            }
        }
    }
}
