package llp.money.tools

import java.text.SimpleDateFormat
import java.util.*



fun getDateTime( date: Date ) : String{
    var sb: StringBuilder = StringBuilder();
    sb.append("yyyy年MM月dd日 HH:mm:SS")

    val sdf = SimpleDateFormat(sb.toString())
    return sdf.format(date);
}
