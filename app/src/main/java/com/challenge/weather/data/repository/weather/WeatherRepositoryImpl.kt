package com.challenge.weather.data.repository.weather

import com.challenge.weather.domain.model.Coordinates
import com.challenge.weather.domain.repository.WeatherRepository
import timber.log.Timber

class WeatherRepositoryImpl(
    private val weatherRemoteStorage: WeatherRemoteStorage
) : WeatherRepository {

    override fun getByCoordinates(coordinates: Coordinates) {
        TODO("Not yet implemented")
    }

    override suspend fun getByNameCity(name: String) {
        val response = weatherRemoteStorage.getByCityName(name)
        Timber.e("response: $response")
    }
}