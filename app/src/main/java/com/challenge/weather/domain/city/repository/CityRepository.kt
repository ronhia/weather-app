package com.challenge.weather.domain.city.repository

import com.challenge.weather.domain.city.model.City

interface CityRepository {

    suspend fun loadCities()

    suspend fun existsCities(): Boolean

    suspend fun getByName(name: String): List<City>

}