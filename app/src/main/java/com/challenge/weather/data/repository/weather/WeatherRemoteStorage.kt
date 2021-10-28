package com.challenge.weather.data.repository.weather

import com.challenge.weather.data.remote.model.WeatherBodyResponse
import com.challenge.weather.data.remote.service.WeatherService
import timber.log.Timber

class WeatherRemoteStorage(
    private val weatherService: WeatherService
) {

    suspend fun getByCityName(name: String): WeatherBodyResponse {
        return weatherService.getByCityName(name)
    }

}