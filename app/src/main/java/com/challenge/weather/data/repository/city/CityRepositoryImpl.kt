package com.challenge.weather.data.repository.city

import com.challenge.weather.data.mapper.toDomain
import com.challenge.weather.data.mapper.toRoom
import com.challenge.weather.domain.model.City
import com.challenge.weather.domain.repository.CityRepository

class CityRepositoryImpl(
    private val cityLocalStorage: CityLocalStorage
) : CityRepository {

    override suspend fun loadCities() {
        val cities = cityLocalStorage.getCitiesFromJson()
        cityLocalStorage.insertCities(cities.toRoom())
    }

    override suspend fun existsCities(): Boolean {
        return cityLocalStorage.existsCities()
    }

    override suspend fun getByName(name: String): List<City> {
        return cityLocalStorage.searchByName(name).toDomain()
    }

}