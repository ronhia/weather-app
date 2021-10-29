package com.challenge.weather.data.mapper

import com.challenge.weather.data.remote.model.WeatherBodyResponse
import com.challenge.weather.domain.model.Weather

fun WeatherBodyResponse.toDomain(): Weather {
    return Weather(
        country = sys.country,
        city = name,
        icon = weather.firstOrNull()?.icon.orEmpty(),
        description = weather.firstOrNull()?.description.orEmpty(),
        temperature = main.temp,
        windSpeed = wind.speed,
        humidity = main.humidity
    )
}