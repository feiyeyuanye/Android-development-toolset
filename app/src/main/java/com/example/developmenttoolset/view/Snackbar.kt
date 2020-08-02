package com.example.developmenttoolset.view

import android.view.View
import com.google.android.material.snackbar.Snackbar

/**
 * 记得要添加依赖库：implementation 'com.google.android.material:material:1.1.0'
 * 将扩展函数添加到了 View 类中
 */
//fun View.showSnackbar(text:String, duration:Int = Snackbar.LENGTH_SHORT){
//    Snackbar.make(this,text,duration).show()
//}
//
//fun View.showSnackbar(resId:Int, duration:Int = Snackbar.LENGTH_SHORT){
//    Snackbar.make(this,resId,duration).show()
//}


/**
 * 通过高阶函数来添加对 setAction() 的支持
 * 这里将新增的两个参数都设置成可为空的类型，并将默认值都设置为空，然后只有当两个参数都不为空时才去调用 Snackbar 的 setAction() 来设置额外的点击事件。
 * 如果触发了点击事件，只需要调用函数类型参数将事件传递给外部的 Lambda 表达式即可。
 */
fun View.showSnackbar(text:String, actionText:String? = null, duration:Int = Snackbar.LENGTH_SHORT, block:(() -> Unit)? = null){
    val snackbar = Snackbar.make(this,text,duration)
    if (actionText != null && block != null){
        snackbar.setAction(actionText){
            block()
        }
    }
    snackbar.show()
}

fun View.showSnackbar(resId:Int, actionResId:Int? = null, duration:Int = Snackbar.LENGTH_SHORT, block:(() -> Unit)? = null){
    val snackbar = Snackbar.make(this,resId,duration)
    if (actionResId != null && block != null){
        snackbar.setAction(actionResId){
            block()
        }
    }
    snackbar.show()
}