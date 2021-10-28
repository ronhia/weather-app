package com.challenge.weather.domain.usecases

import com.challenge.weather.domain.model.Coordinates
import com.challenge.weather.domain.repository.WeatherRepository

class GetWeatherByCoordinatesUseCase(
    private val weatherRepository: WeatherRepository
) {

    fun execute(coordinates: Coordinates) {
        weatherRepository.getByCoordinates(coordinates)
    }
}