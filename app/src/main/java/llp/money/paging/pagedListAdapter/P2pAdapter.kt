package llp.money.paging.pagedListAdapter

import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import llp.money.entity.P2pVE
import llp.money.paging.viewHolder.P2pViewHolder
import android.arch.paging.PagedListAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.Navigation
import llp.money.R

class P2pAdapter : PagedListAdapter<P2pVE, P2pViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: P2pViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): P2pViewHolder {
        var view:View= LayoutInflater.from(parent.context).inflate(R.layout.p2p_all_recycler_item, parent, false)
        var holder : P2pViewHolder = P2pViewHolder(view)

        holder.p2pView?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                var position: Int=holder.adapterPosition
                //传递数据
                var bundle : Bundle = Bundle()
                bundle.putLong("position", position.toLong())
                //跳转
                Navigation.findNavController(view).navigate(R.id.action_p2pFragment_to_p2pDetailFragment,bundle)
            }
        })
        return holder
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<P2pVE>() {
            override fun areItemsTheSame(oldItem: P2pVE, newItem: P2pVE): Boolean =
                    oldItem.p2pId == newItem.p2pId

            override fun areContentsTheSame(oldItem: P2pVE, newItem: P2pVE): Boolean =
                    oldItem == newItem
        }
    }
}
