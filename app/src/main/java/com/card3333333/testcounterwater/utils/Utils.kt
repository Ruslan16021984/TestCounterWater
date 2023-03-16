package com.card3333333.testcounterwater.utils

import java.text.SimpleDateFormat
import java.util.*

fun Date.dateToDayMounthYear(): String {
    val format = SimpleDateFormat("EEE, d, MMM", Locale.getDefault())
    return format.format(this)
}

fun targetOfWater(weight: Int, gender: Boolean, actionMoveTime: Int): Int {
    var result = 0
    if (gender) {
        result = ((weight * 1000 * 0.03) + (actionMoveTime * 0.04)).toInt()
    } else {
        result = ((weight * 1000 * 0.03) + (actionMoveTime * 0.04)).toInt()
    }

    return result
}

//val percentage = (count * 100) / totalCount
fun percentageFromCount(totalCount: Int, count: Int) = ((count * 100) / totalCount).toFloat()/100
fun Int.left(lastAmount: Int) = this - lastAmount
fun Int.consuming(lastAmount: Int) = this + lastAmount