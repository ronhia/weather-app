package com.challenge.weather.domain.usecases

import com.challenge.weather.domain.model.City
import com.challenge.weather.domain.repository.CityRepository

class GetCitiesByNameUseCase(
    private val cityRepository: CityRepository
) {

    suspend fun execute(name: String): List<City> {
        return cityRepository.getByName(name)
    }
}