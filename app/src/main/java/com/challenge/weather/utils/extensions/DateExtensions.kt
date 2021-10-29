package com.challenge.weather.utils.extensions

import com.challenge.weather.utils.DateUtil
import java.util.Date
import java.util.Locale

const val dateFormat = "EEEE dd 'de' MMMM 'del' yyyy"
const val timeFormat = "hh:mm a"

fun Date.asStringFormat(format: String): String {
    val simpleFormat = DateUtil.customSimpleDateFormat(format, Locale.getDefault())
    return simpleFormat.format(this)
}