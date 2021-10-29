package com.challenge.weather.presentation.features.search.mapper

import com.challenge.weather.domain.model.City
import com.challenge.weather.presentation.features.search.model.CityModel

fun List<City>.toModel(): List<CityModel> {
    return map { it.toModel() }
}

fun City.toModel(): CityModel {
    return CityModel(
        name = name,
        country = country
    )
}