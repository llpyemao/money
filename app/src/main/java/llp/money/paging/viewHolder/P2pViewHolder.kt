package llp.money.paging.viewHolder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import llp.money.R
import llp.money.entity.P2pVE
import android.view.View
class P2pViewHolder(parent : View) : RecyclerView.ViewHolder(parent) {
    var p2pVE : P2pVE? = null
    var p2pView : View? = null

    val bankView = itemView.findViewById<TextView>(R.id.p2p_bank)
    val typeView = itemView.findViewById<TextView>(R.id.p2p_type)
    /**
     * Items might be null if they are not paged in yet. PagedListAdapter will re-bind the
     * ViewHolder when Item is loaded.
     */
    fun bindTo(p2pVE : P2pVE?) {
        this.p2pVE = p2pVE
        bankView.text = p2pVE?.bank
        typeView.text = p2pVE?.type

    }

    init {
        p2pView=parent
    }
}

