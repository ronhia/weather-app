package com.challenge.weather.presentation.features.search.model

data class CityModel(
    val name: String,
    val country: String
) {

    val cityFull: String
        get() = "$name, $country"

}