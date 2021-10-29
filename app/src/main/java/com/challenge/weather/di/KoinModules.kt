package com.challenge.weather.di

import org.koin.core.context.loadKoinModules

object KoinModules {

    fun init() = loadKoinModules(
        listOf(
            weatherModules,
            networkWeatherModules,
            cityModules,
            splashModules
        )
    )

}