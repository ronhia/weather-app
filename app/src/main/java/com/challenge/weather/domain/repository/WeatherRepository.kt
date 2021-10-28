package com.challenge.weather.domain.repository

import com.challenge.weather.domain.model.Coordinates
import com.challenge.weather.domain.model.Weather

interface WeatherRepository {

    fun getByCoordinates(coordinates: Coordinates)

    suspend fun getByNameCity(name: String): Weather

}