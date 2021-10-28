package com.challenge.weather.domain.usecases

import com.challenge.weather.domain.repository.WeatherRepository

class GetWeatherByNameCityUseCase(
    private val weatherRepository: WeatherRepository
) {

    fun execute(name: String) {
        weatherRepository.getByNameCity(name)
    }
}