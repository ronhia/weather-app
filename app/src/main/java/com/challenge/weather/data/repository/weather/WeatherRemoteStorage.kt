package com.challenge.weather.data.repository.weather

import com.challenge.weather.data.repository.weather.model.WeatherBodyResponse
import com.challenge.weather.data.remote.service.WeatherService

class WeatherRemoteStorage(
    private val weatherService: WeatherService
) {

    suspend fun getByCityName(name: String): WeatherBodyResponse {
        return weatherService.getByCityName(name)
    }

}