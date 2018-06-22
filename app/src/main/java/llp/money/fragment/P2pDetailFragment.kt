package llp.money.fragment

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import llp.money.R
import llp.money.viewModel.P2pViewModel

class P2pDetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val viewModel by lazy(LazyThreadSafetyMode.NONE) {
            ViewModelProviders.of(getActivity()!!).get(P2pViewModel::class.java)
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_p2p_detail, container, false)
    }

}
