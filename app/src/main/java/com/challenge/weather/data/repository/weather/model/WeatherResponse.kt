package com.challenge.weather.data.repository.weather.model

import com.google.gson.annotations.SerializedName

data class WeatherBodyResponse(
    @SerializedName("coord")
    val coordinates: WeatherCoordinatesResponse,
    val weather: List<WeatherResponse>,
    val main: WeatherMainResponse,
    val wind: WeatherWindResponse,
    val sys: WeatherSysResponse,
    @SerializedName("dt")
    val date: Long,
    val timezone: Double,
    val id: Long,
    val name: String,
    val code: Long
)

data class WeatherCoordinatesResponse(
    @SerializedName("lon")
    val longitude: String,
    @SerializedName("lat")
    val latitude: String
)

data class WeatherResponse(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String
)

data class WeatherMainResponse(
    val temp: Double,
    val feelsLike: Double,
    val humidity: Double,
    @SerializedName("temp_max")
    val tempMax: Double,
)

data class WeatherWindResponse(
    val speed: Double
)

data class WeatherSysResponse(
    val country: String
)