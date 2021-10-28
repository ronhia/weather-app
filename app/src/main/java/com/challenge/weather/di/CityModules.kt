package com.challenge.weather.di

import com.challenge.weather.data.repository.city.CityLocalStorage
import com.challenge.weather.data.repository.city.CityRepositoryImpl
import com.challenge.weather.domain.repository.CityRepository
import com.challenge.weather.domain.usecases.GetCitiesByNameUseCase
import org.koin.dsl.module

val cityModules = module {

    factory { CityLocalStorage() }

    factory<CityRepository> {
        CityRepositoryImpl(
            cityLocalStorage = get()
        )
    }

    factory {
        GetCitiesByNameUseCase(
            cityRepository = get()
        )
    }

}