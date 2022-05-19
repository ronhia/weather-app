package com.challenge.weather.domain.city.usecases

import com.challenge.weather.domain.city.model.City
import com.challenge.weather.domain.city.repository.CityRepository

class GetCitiesByNameUseCase(
    private val cityRepository: CityRepository
) {

    suspend fun execute(name: String): List<City> {
        return cityRepository.getByName(name)
    }
}