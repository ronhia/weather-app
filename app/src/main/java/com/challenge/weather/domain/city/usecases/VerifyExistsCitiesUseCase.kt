package com.challenge.weather.domain.city.usecases

import com.challenge.weather.domain.city.repository.CityRepository

class VerifyExistsCitiesUseCase(
    private val cityRepository: CityRepository
) {

    suspend fun execute(): Boolean {
        return cityRepository.existsCities()
    }

}