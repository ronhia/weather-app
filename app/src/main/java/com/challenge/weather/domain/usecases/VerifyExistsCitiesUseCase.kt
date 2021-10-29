package com.challenge.weather.domain.usecases

import com.challenge.weather.domain.repository.CityRepository

class VerifyExistsCitiesUseCase(
    private val cityRepository: CityRepository
) {

    suspend fun execute(): Boolean {
        return cityRepository.existsCities()
    }

}