package com.challenge.weather.domain.model

data class Weather(
    val country: String,
    val city: String,
    val icon: String,
    val description: String,
    val temperature: Double,
    val windSpeed: Double,
    val humidity: Double
)