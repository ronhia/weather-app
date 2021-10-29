package com.challenge.weather.domain.usecases

import com.challenge.weather.domain.repository.CityRepository

class LoadCitiesUseCase(
    private val cityRepository: CityRepository
) {

    suspend fun execute() {
        cityRepository.loadCities()
    }

}