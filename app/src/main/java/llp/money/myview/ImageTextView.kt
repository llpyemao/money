package llp.money.myview

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import llp.money.R

//自定义组件
class ImageTextView : LinearLayout {
    var textView : TextView=TextView(context)
    var imageView : ImageView= ImageView(context)

    //设置父组件的布局方式
    private fun init(context: Context) {
        orientation = LinearLayout.VERTICAL//垂直布局

        //gravity:是用来指定文字在控件中的对齐方式。
        //layout_gravity:是用来指定控件在父控件(布局)的对齐方式。
        //此处相当于布局文件中的Android:layout_gravity属性
        gravity= Gravity.CENTER
        setBackgroundColor(getResources().getColor(R.color.colorBackground))
    }

    //构造函数，如果子类没有主构造函数，则必须在每一个二级构造函数中用 super 关键字初始化基类
    constructor(context: Context) : super(context) { init(context) }

    constructor(context : Context, attrs : AttributeSet, defStyleAttr:Int ): super(context,attrs,defStyleAttr){ init(context) }

    constructor(context : Context, attrs : AttributeSet): super(context,attrs){
        init(context)

        //设置子组件在父组件中的布局方式，可以由多个子组件重用
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
        params.gravity=Gravity.CENTER//此处相当于布局文件中的Android：gravity属性
        //通过TypedArray来得到布局文件的属性
        var ta : TypedArray =context.obtainStyledAttributes(attrs, R.styleable.ImageTextView);
        //ImageTextView_title由两部分构成：ImageTextView和title  见属性文件values/attr.xml文件
        textView.setText(ta.getString(R.styleable.ImageTextView_title))
        //设置图片
        imageView.setImageResource(ta.getResourceId(R.styleable.ImageTextView_icon1,0))

        addView(imageView,params)//添加到布局管理器中  子组件重用params
        addView(textView,params)//添加到布局管理器中
    }
}