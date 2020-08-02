package com.example.developmenttoolset.math
import java.lang.RuntimeException

/**
 * 简化多个数比较时的 max() 嵌套
 * 借助 vararg 关键字，它允许方法接收任意多个同等类型的参数。
 */
//fun mMax(vararg nums:Int):Int{
//    // 记录所有数中的最大值，并在一开始将它赋值成了整形范围的最小值。
//    var maxNum = Int.MIN_VALUE
//    for (num in nums){
//        maxNum = max(maxNum,num)
//    }
//    return maxNum
//}

/**
 * 上面的方法只能比较整型数字。
 * 那如果想要比较浮点型或长整型数字，可以重载多个 mMax()，来接收不同类型的参数。
 * 但在这里会使用一种更加巧妙的做法。
 * ------------------------------------------------------------------------------------------
 * Java 中规定，所有类型的数字都是可比较的，因为必须实现 Comparable 接口，
 * 这个规则在 Kotlin 中也同样成立。我们可借助泛型，将 mMax() 修改成接收任意多个实现 Comparable 接口 的参数。
 * ------------------------------------------------------------------------------------------
 * 这里将泛型 T 的上界指定成了 Comparable<T>，那么参数 T 就必然是 Comparable<T> 的子类型了。
 * 现在不管是双精度浮点型、单精度浮点型，还是短整型、整型、长整型，只要是实现 Comparable 接口的子类型，此函数都支持获取它们的最大值。
 */
fun <T:Comparable<T>> mMax(vararg nums:T):T{
    if (nums.isEmpty()) throw RuntimeException("Params can not be empty")
    var maxNum = nums[0]
    for (num in nums){
        if (num > maxNum){
            maxNum = num
        }
    }
    return maxNum
}

fun <T:Comparable<T>> mMin(vararg nums:T):T{
    if (nums.isEmpty()) throw RuntimeException("Params can not be empty")
    var minNum = nums[0]
    for (num in nums){
        if (num < minNum){
            minNum = num
        }
    }
    return minNum
}