package com.challenge.weather.utils

object WeatherUtils {

    fun generateUrlIcon(iconId: String): String {
        return "http://openweathermap.org/img/wn/$iconId@2x.png"
    }

}