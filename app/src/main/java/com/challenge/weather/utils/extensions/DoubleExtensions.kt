package com.challenge.weather.utils.extensions

import java.math.BigDecimal

fun Double.kelvinToCelsius(): Double {
    return this - 273.15
}

fun Double.withXDecimals(x: Int): Double {
    return this.toBigDecimal().setScale(x, BigDecimal.ROUND_HALF_EVEN).toDouble()
}

fun Double.withoutZero(): String {
    return this.toBigDecimal().stripTrailingZeros().toPlainString()
}