package llp.money.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_p2p.*
import llp.money.R
import llp.money.paging.pagedListAdapter.P2pAdapter
import llp.money.viewModel.P2pViewModel

class P2pFragment : Fragment() {
    private val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(getActivity()!!).get(P2pViewModel::class.java)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view:View;
        view=inflater.inflate(R.layout.fragment_p2p, container, false)

        // Create adapter for the RecyclerView
       // val adapter1=view.findViewById<RecyclerView>(R.id.p2pPaging)
        val adapter = P2pAdapter()
        view.findViewById<RecyclerView>(R.id.p2pPaging).adapter = adapter

        // Subscribe the adapter to the ViewModel, so the items in the adapter are refreshed
        // when the list changes
        viewModel.allP2ps.observe(this, Observer(adapter::submitList))
        return view
    }


}
