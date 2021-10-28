package com.challenge.weather.data.repository.city

import com.challenge.weather.domain.model.City
import com.challenge.weather.domain.repository.CityRepository

class CityRepositoryImpl(
    private val cityLocalStorage: CityLocalStorage
) : CityRepository {

    override suspend fun getByName(name: String): List<City> {
        return listOf(City(name = "Juliaca", country = "PE"), City(name = "Puno", country = "PE"))
    }

}