package com.challenge.weather.utils

object WeatherUtils {

    fun generateUrlIcon(iconId: String): String {
        return "https://openweathermap.org/img/wn/$iconId@2x.png"
    }

}