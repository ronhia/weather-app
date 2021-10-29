package com.challenge.weather.domain.usecases

import com.challenge.weather.domain.repository.CityRepository
import timber.log.Timber

class LoadCitiesUseCase(
    private val cityRepository: CityRepository
) {

    suspend fun execute() {
        val existsCities = cityRepository.existsCities()
        if (existsCities.not()) {
            cityRepository.loadCities()
            Timber.e("exists")
        } else {
            Timber.e("not exists")
        }
    }

}