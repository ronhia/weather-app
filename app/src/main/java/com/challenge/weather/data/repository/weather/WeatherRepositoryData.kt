package com.challenge.weather.data.repository.weather

import com.challenge.weather.data.repository.weather.mapper.toDomain
import com.challenge.weather.domain.weather.model.Weather
import com.challenge.weather.domain.weather.repository.WeatherRepository

class WeatherRepositoryData(
    private val weatherRemoteStorage: WeatherRemoteStorage
) : WeatherRepository {

    override suspend fun getByNameCity(name: String): Weather {
        return weatherRemoteStorage.getByCityName(name).toDomain()
    }
}