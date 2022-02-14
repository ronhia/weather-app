package com.challenge.weather.domain.weather.usecases

import com.challenge.weather.domain.weather.model.Weather
import com.challenge.weather.domain.weather.repository.WeatherRepository

class GetWeatherByNameCityUseCase(
    private val weatherRepository: WeatherRepository
) {

    suspend fun execute(name: String): Weather {
        return weatherRepository.getByNameCity(name)
    }
}