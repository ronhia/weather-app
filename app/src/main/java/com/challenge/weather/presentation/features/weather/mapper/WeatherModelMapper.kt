package com.challenge.weather.presentation.features.weather.mapper

import com.challenge.weather.domain.model.Weather
import com.challenge.weather.presentation.features.weather.model.WeatherModel

fun Weather.toModel(): WeatherModel {
    return WeatherModel(
        country = country,
        city = city,
        icon = icon,
        description = description,
        temperature = temperature,
        windSpeed = windSpeed,
        humidity = humidity
    )
}