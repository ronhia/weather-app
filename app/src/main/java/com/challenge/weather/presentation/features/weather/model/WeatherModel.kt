package com.challenge.weather.presentation.features.weather.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherModel(
    val country: String,
    val city: String,
    val date: Double,
    val icon: String,
    val description: String,
    val temperature: Double,
    val temperatureMax: Double,
    val windSpeed: Double,
    val humidity: Double
) : Parcelable {

    val cityComplete: String
        get() = "$city, $country"
}