package com.challenge.weather.domain.usecases

import com.challenge.weather.domain.repository.WeatherRepository

class GetWeatherByNameCityUseCase(
    private val weatherRepository: WeatherRepository
) {

    suspend fun execute(name: String) {
        weatherRepository.getByNameCity(name)
    }
}