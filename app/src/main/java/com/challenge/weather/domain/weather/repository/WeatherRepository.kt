package com.challenge.weather.domain.weather.repository

import com.challenge.weather.domain.weather.model.Weather

interface WeatherRepository {

    suspend fun getByNameCity(name: String): Weather

}