package com.challenge.weather.domain.repository

import com.challenge.weather.domain.model.Weather

interface WeatherRepository {

    suspend fun getByNameCity(name: String): Weather

}