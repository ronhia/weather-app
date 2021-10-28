package com.challenge.weather.domain.repository

import com.challenge.weather.domain.model.Coordinates

interface WeatherRepository {

    fun getByCoordinates(coordinates: Coordinates)

    fun getByNameCity(name: String)

}