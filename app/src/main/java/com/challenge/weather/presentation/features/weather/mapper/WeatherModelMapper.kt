package com.challenge.weather.presentation.features.weather.mapper

import com.challenge.weather.domain.model.Weather
import com.challenge.weather.presentation.features.weather.model.WeatherModel

fun Weather.toModel(): WeatherModel {
    return WeatherModel(
        country = country,
        city = city,
        date = date,
        icon = icon,
        description = description,
        temperature = temperature,
        temperatureMax = temperatureMax,
        windSpeed = windSpeed,
        humidity = humidity
    )
}