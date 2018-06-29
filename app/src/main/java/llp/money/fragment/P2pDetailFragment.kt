package llp.money.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import llp.money.R
import llp.money.entity.P2pVE
import llp.money.viewModel.P2pViewModel
import llp.money.tools.getDateTime

class P2pDetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        if(getActivity() == null)
            Log.i("aa","getArguments() is null")

        val viewModel by lazy(LazyThreadSafetyMode.NONE) {
            //getActivity()  同一个Activity的多个fragment之间共享ViewModel
            ViewModelProviders.of(getActivity()!!).get(P2pViewModel::class.java)
        }

        var view:View;
        view=inflater.inflate(R.layout.fragment_p2p_detail, container, false)


        //接收P2pAdapter通过bundle传过来的数据
        var position : Long=getArguments()!!.getLong("position")
        //通过viewModel获取其中的数据是
        var p2pVE : P2pVE? =viewModel?.allP2ps?.value!![position.toInt()]

        var textView : TextView? =view.findViewById(R.id.p2pId)//view与布局关联，在view的布局中找id
        textView?.text= p2pVE?.p2pId.toString()

        textView =view.findViewById(R.id.companyName)//view与布局关联，在view的布局中找id
        textView?.text= p2pVE?.companyName

        textView =view.findViewById(R.id.url)
        textView?.text= p2pVE?.url?: "未知"

        textView =view.findViewById(R.id.bank)
        textView?.text=p2pVE?.bank

        textView =view.findViewById(R.id.type)
        textView?.text=p2pVE?.type

        textView =view.findViewById(R.id.principal)
        textView?.text=p2pVE?.principal?.toString()

        textView =view.findViewById(R.id.rate)
        textView?.text=p2pVE?.rate?.toString()

        textView =view.findViewById(R.id.rateActual)
        textView?.text=p2pVE?.rateActual?.toString()?: "未知"

        textView =view.findViewById(R.id.dateFrom)
        textView?.text=getDateTime(p2pVE!!.dateFrom)

        textView =view.findViewById(R.id.dateEnd)
        textView?.text=getDateTime(p2pVE?.dateEnd)

        textView =view.findViewById(R.id.dateActual)
        textView?.text=getDateTime(p2pVE?.dateActual)?: "未知"

        textView =view.findViewById(R.id.interest)
        textView?.text=p2pVE?.interest?.toString()?: "未知"

        textView =view.findViewById(R.id.isNormal)
        textView?.text=p2pVE?.isNormal?.toString()?: "未知"

        return view
    }

}
