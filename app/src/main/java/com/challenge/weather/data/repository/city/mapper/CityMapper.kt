package com.challenge.weather.data.repository.city.mapper

import com.challenge.weather.data.local.json.CityJson
import com.challenge.weather.data.local.room.model.CityRoom
import com.challenge.weather.domain.city.model.City
import com.google.android.libraries.places.api.model.AutocompletePrediction

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

fun AutocompletePrediction.toCity(): City {
    return City(
        name = getPrimaryText(null).toString(),
        country = getSecondaryText(null).toString(),
    )
}

fun List<AutocompletePrediction>.toCities(): List<City> {
    return map { it.toCity() }
}