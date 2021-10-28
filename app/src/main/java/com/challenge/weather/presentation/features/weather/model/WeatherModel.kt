package com.challenge.weather.presentation.features.weather.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherModel(
    val country: String,
    val city: String,
    val temperature: Double,
    val windSpeed: Double,
    val humidity: Double
) : Parcelable {

    val cityComplete: String
        get() = "$city, $country"
}