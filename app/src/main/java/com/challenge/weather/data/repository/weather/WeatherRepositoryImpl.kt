package com.challenge.weather.data.repository.weather

import com.challenge.weather.data.mapper.toDomain
import com.challenge.weather.domain.model.Weather
import com.challenge.weather.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val weatherRemoteStorage: WeatherRemoteStorage
) : WeatherRepository {

    override suspend fun getByNameCity(name: String): Weather {
        return weatherRemoteStorage.getByCityName(name).toDomain()
    }
}