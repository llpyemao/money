package llp.money.viewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.flexbox.FlexboxLayoutManager
import llp.money.R
import llp.money.bean.ImageTextBean

class ImageTextViewHolder(itemView: View)   : RecyclerView.ViewHolder(itemView) {

    var imageView : ImageView=itemView.findViewById(R.id.imageView)
    var  textView : TextView=itemView.findViewById(R.id.textView)

    fun bindTo(imageTextBean: ImageTextBean) {
        //设置图片
        imageView.setImageResource(imageTextBean.imageId)
        textView.text=imageTextBean.text
    }


}