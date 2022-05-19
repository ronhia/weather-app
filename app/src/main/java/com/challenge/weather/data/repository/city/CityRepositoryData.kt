package com.challenge.weather.data.repository.city

import com.challenge.weather.data.repository.city.mapper.toRoom
import com.challenge.weather.domain.city.model.City
import com.challenge.weather.domain.city.repository.CityRepository

class CityRepositoryData(
    private val cityLocalStorage: CityLocalStorage,
    private val cityRemoteStorage: CityRemoteStorage
) : CityRepository {

    override suspend fun loadCities() {
        val cities = cityLocalStorage.getCitiesFromJson()
        cityLocalStorage.insertCities(cities.toRoom())
    }

    override suspend fun existsCities(): Boolean {
        return cityLocalStorage.existsCities()
    }

    override suspend fun getByName(name: String): List<City> {
        return cityRemoteStorage.getByName(name)
    }

}