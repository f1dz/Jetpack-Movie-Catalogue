package `in`.khofid.moviecatalogue.utils

import android.view.View

fun View.show(){
    this.visibility = View.VISIBLE
}

fun View.hide(){
    this.visibility = View.GONE
}

fun String.year(): String{
    return this.substring(0,4)
}