package llp.money.bean

import android.support.annotation.DrawableRes

class ImageTextBean {
    var text:String=""

    var  imageId : Int=0

    constructor( imageId : Int, text:String){
        this.imageId=imageId
        this.text=text
    }

    constructor(){}
}