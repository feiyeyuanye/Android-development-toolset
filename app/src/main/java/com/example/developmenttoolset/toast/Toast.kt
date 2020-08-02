package com.example.developmenttoolset.toast

import android.content.Context
import android.widget.Toast
import com.example.developmenttoolset.config.MyApplication
import com.example.developmenttoolset.config.MyApplication.Companion.context

/**
 * Toast 第二个参数是要显示的内容，可以传入字符串和字符串资源 id 两种类型，
 * 所以，可以给 String 和 Int 类各添加一个扩展函数。
 */
//fun String.showToast(context: Context){
//    Toast.makeText(context,this,Toast.LENGTH_SHORT).show()
//}
//
//fun Int.showToast(context: Context){
//    Toast.makeText(context,this,Toast.LENGTH_SHORT).show()
//}

/**
 * 指定 Toast 的显示时长
 * 通过给函数设定参数默认值，当需要 Toast.LENGTH_LONG 时可直接传入。
 */
fun String.showToast(context: Context,duration:Int = Toast.LENGTH_SHORT){
    Toast.makeText(context,this,duration).show()
}

fun Int.showToast(context: Context,duration:Int = Toast.LENGTH_SHORT){
    Toast.makeText(context,this,duration).show()
}

/**
 * 使用 MyApplication 提供的 context 来简化代码
 */
fun String.showToast(duration:Int = Toast.LENGTH_SHORT){
    Toast.makeText(context,this,duration).show()
}

fun Int.showToast(duration:Int = Toast.LENGTH_SHORT){
    Toast.makeText(context,this,duration).show()
}