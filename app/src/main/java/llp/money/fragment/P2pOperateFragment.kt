package llp.money.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.flexbox.*
import llp.money.R
import llp.money.adapter.P2pOperateAdapter

class P2pOperateFragment: Fragment()  {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_p2p_operate, container, false)

        val flexboxLayoutManager = FlexboxLayoutManager(this.context).apply {
            flexDirection = FlexDirection.ROW
            flexWrap = FlexWrap.WRAP
            justifyContent= JustifyContent.FLEX_START
            alignItems = AlignItems.FLEX_START
        }

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.apply {
            layoutManager = flexboxLayoutManager
            adapter = P2pOperateAdapter()
        }
        return view

    }
}