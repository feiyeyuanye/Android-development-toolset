package com.example.developmenttoolset.log

import android.util.Log

/**
 * LogUtil 单例类，用来控制日志的打印。
 * 当存在过多的日志打印时，不仅会降低程序的运行效率，还可能泄露机密性的数据。
 * 所以，最好是在开发阶段就打印日志，当程序上线后就把日志屏蔽掉。
 */
object LogUtil {
    /**
     * 定义了 5 个整型常量，并且数值递增，表示日志级别。
     * 然后又定义了一个静态变量，可将它的值指定为这 5 个常量中的任意一个，用来控制打印日志。
     * --------------------------------------------------------------------------------------
     * 这样，当开发阶段将 level 设为 VERBOSE，当项目正式上线时将 level 设为 ERROR 表示只打印程序的错误日志。
     */
    private const val VERBOSE = 1

    private const val DEBUG = 2

    private const val INFO = 3

    private const val WARN = 4

    private const val ERROR = 5

    private var level = VERBOSE

    /**
     * 定义了 5 个日志方法，用来打印不同级别的日志。
     * ------------------------------------
     * 使用方法：
     * LogUtil.d("TAG","debug log")
     */
    fun v(tag: String, msg: String) {
        if (level <= VERBOSE) {
            Log.v(tag, msg)
        }
    }

    fun d(tag: String, msg: String) {
        if (level <= DEBUG) {
            Log.d(tag, msg)
        }
    }

    fun i(tag: String, msg: String) {
        if (level <= INFO) {
            Log.i(tag, msg)
        }
    }

    fun w(tag: String, msg: String) {
        if (level <= WARN) {
            Log.w(tag, msg)
        }
    }

    fun e(tag: String, msg: String) {
        if (level <= ERROR) {
            Log.e(tag, msg)
        }
    }

}