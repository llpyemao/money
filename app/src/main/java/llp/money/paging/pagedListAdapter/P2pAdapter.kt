package llp.money.paging.pagedListAdapter

import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import llp.money.entity.P2pVE
import llp.money.paging.viewHolder.P2pViewHolder
import android.arch.paging.PagedListAdapter
class P2pAdapter : PagedListAdapter<P2pVE, P2pViewHolder>(diffCallback) {
    override fun onBindViewHolder(holder: P2pViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): P2pViewHolder =
            P2pViewHolder(parent)

    companion object {
        /**
         * This diff callback informs the PagedListAdapter how to compute list differences when new
         * PagedLists arrive.
         * <p>
         * When you add a Cheese with the 'Add' button, the PagedListAdapter uses diffCallback to
         * detect there's only a single item difference from before, so it only needs to animate and
         * rebind a single view.
         *
         * @see android.support.v7.util.DiffUtil
         */
        private val diffCallback = object : DiffUtil.ItemCallback<P2pVE>() {
            override fun areItemsTheSame(oldItem: P2pVE, newItem: P2pVE): Boolean =
                    oldItem.p2pId == newItem.p2pId

            /**
             * Note that in kotlin, == checking on data classes compares all contents, but in Java,
             * typically you'll implement Object#equals, and use it to compare object contents.
             */
            override fun areContentsTheSame(oldItem: P2pVE, newItem: P2pVE): Boolean =
                    oldItem == newItem
        }
    }
}
