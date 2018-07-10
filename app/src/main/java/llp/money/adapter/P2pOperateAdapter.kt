package llp.money.adapter

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import llp.money.R
import llp.money.bean.ImageTextBean
import llp.money.paging.viewHolder.P2pViewHolder
import llp.money.viewHolder.ImageTextViewHolder

class P2pOperateAdapter : RecyclerView.Adapter<ImageTextViewHolder>(){

    companion object {
        private val imageTextBeans = listOf(
                ImageTextBean(R.drawable.ic_notifications_black_24dp,"操作") ,
                ImageTextBean(R.drawable.ic_notifications_black_24dp,"买p2p") ,
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

    //onCreateViewHolder中赋值，onBindViewHolder中跳转时使用
    var view:View?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageTextViewHolder {
        view = LayoutInflater.from(parent.context)
                .inflate(R.layout.imagetext_recycler_item, parent, false)
        return ImageTextViewHolder(view!!)
    }

    override fun onBindViewHolder(holder: ImageTextViewHolder, position: Int) {
        val adapterPosition = holder.adapterPosition

        //绑定item的点击事件
        holder.imageTextView?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                var position: Int=holder.adapterPosition

                when (position) {//根据情况跳转到具体功能  position从0开始计算
                    1 -> Navigation.findNavController(view!!).navigate(R.id.action_p2pOperateFragment_to_p2pAddFragment)
                    2 -> print("x == 2")
                    else -> { // 注意这个块
                        print("x 不是 1 ，也不是 2")
                    }
                }
            }
        })
        holder.bindTo(imageTextBeans!![position])
    }

    override fun getItemCount() = imageTextBeans!!.size
}