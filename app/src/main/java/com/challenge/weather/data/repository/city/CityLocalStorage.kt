package com.challenge.weather.data.repository.city

import com.challenge.weather.data.local.json.CityJson
import com.challenge.weather.data.local.room.dao.CityRoomDao
import com.challenge.weather.data.local.room.model.CityRoom
import timber.log.Timber

class CityLocalStorage(
    private val cityJson: CityJson,
    private val cityRoomDao: CityRoomDao
) {

    fun getCitiesFromJson(): List<CityJson.City> {
        return cityJson.get()
    }

    suspend fun existsCities(): Boolean {
        return cityRoomDao.existsCities()
    }

    suspend fun insertCities(cities: List<CityRoom>) {
        cityRoomDao.insertCities(cities)
    }

    suspend fun searchByName(name: String): List<CityRoom> {
        Timber.e("name: $name")
        return cityRoomDao.searchByName(name)
    }

}