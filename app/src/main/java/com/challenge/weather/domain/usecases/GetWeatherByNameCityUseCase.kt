package com.challenge.weather.domain.usecases

import com.challenge.weather.domain.model.Weather
import com.challenge.weather.domain.repository.WeatherRepository

class GetWeatherByNameCityUseCase(
    private val weatherRepository: WeatherRepository
) {

    suspend fun execute(name: String): Weather {
        return weatherRepository.getByNameCity(name)
    }
}