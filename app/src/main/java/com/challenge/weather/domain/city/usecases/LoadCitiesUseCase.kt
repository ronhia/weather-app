package com.challenge.weather.domain.city.usecases

import com.challenge.weather.domain.city.repository.CityRepository

class LoadCitiesUseCase(
    private val cityRepository: CityRepository
) {

    suspend fun execute() {
        cityRepository.loadCities()
    }

}