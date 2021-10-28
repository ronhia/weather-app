package com.challenge.weather.domain.repository

import com.challenge.weather.domain.model.City

interface CityRepository {

    suspend fun getByName(name: String): List<City>

}