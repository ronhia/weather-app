package com.challenge.weather.data.mapper

import com.challenge.weather.data.local.json.CityJson
import com.challenge.weather.data.local.room.model.CityRoom
import com.challenge.weather.domain.model.City

fun List<CityRoom>.toDomain(): List<City> {
    return map { it.toDomain() }
}

fun CityRoom.toDomain(): City {
    return City(
        name = name,
        country = country
    )
}

fun List<CityJson.City>.toRoom(): List<CityRoom> {
    return map { it.toRoom() }
}

fun CityJson.City.toRoom(): CityRoom {
    return CityRoom(
        name = name,
        country = country
    )
}