package com.challenge.weather.data.remote.service

import com.challenge.weather.data.remote.model.WeatherBodyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("weather")
    suspend fun getByCityName(@Query("q") name: String): WeatherBodyResponse

}