package llp.money.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import llp.money.R
import llp.money.bean.ImageTextBean
import llp.money.viewHolder.ImageTextViewHolder

class P2pOperateAdapter : RecyclerView.Adapter<ImageTextViewHolder>(){

    companion object {
        private val imageTextBeans = listOf(
                ImageTextBean(R.drawable.ic_notifications_black_24dp,"操作") ,
                ImageTextBean(R.drawable.ic_notifications_black_24dp,"操作") ,
                ImageTextBean(R.drawable.ic_notifications_black_24dp,"操作") ,
                ImageTextBean(R.drawable.ic_notifications_black_24dp,"操作") ,
                ImageTextBean(R.drawable.ic_notifications_black_24dp,"操作") ,
                ImageTextBean(R.drawable.ic_notifications_black_24dp,"操作") ,
                ImageTextBean(R.drawable.ic_notifications_black_24dp,"操作") ,
                ImageTextBean(R.drawable.ic_notifications_black_24dp,"操作") ,
                ImageTextBean(R.drawable.ic_notifications_black_24dp,"操作") ,
                ImageTextBean(R.drawable.ic_notifications_black_24dp,"操作") ,
                ImageTextBean(R.drawable.ic_notifications_black_24dp,"操作") ,
                ImageTextBean(R.drawable.ic_notifications_black_24dp,"操作") ,
                ImageTextBean(R.drawable.ic_notifications_black_24dp,"操作") ,
                ImageTextBean(R.drawable.ic_notifications_black_24dp,"操作") ,
                ImageTextBean(R.drawable.ic_notifications_black_24dp,"操作") ,
                ImageTextBean(R.drawable.ic_notifications_black_24dp,"操作") ,
                ImageTextBean(R.drawable.ic_notifications_black_24dp,"操作")
        )
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageTextViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.imagetext_recycler_item, parent, false)
        return ImageTextViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageTextViewHolder, position: Int) {
        holder.bindTo(imageTextBeans!![position])
    }

    override fun getItemCount() = imageTextBeans!!.size
}