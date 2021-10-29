package com.challenge.weather.di

import com.challenge.weather.data.local.json.CityJson
import com.challenge.weather.data.local.room.WeatherDatabase
import com.challenge.weather.data.repository.city.CityLocalStorage
import com.challenge.weather.data.repository.city.CityRepositoryImpl
import com.challenge.weather.domain.repository.CityRepository
import com.challenge.weather.domain.usecases.GetCitiesByNameUseCase
import com.challenge.weather.domain.usecases.LoadCitiesUseCase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val cityModules = module {

    single { get<WeatherDatabase>().cityRoomDao() }

    single { CityJson(context = androidApplication()) }

    factory {
        CityLocalStorage(
            cityRoomDao = get(),
            cityJson = get()
        )
    }

    factory<CityRepository> {
        CityRepositoryImpl(
            cityLocalStorage = get()
        )
    }

    factory {
        LoadCitiesUseCase(
            cityRepository = get()
        )
    }

    factory {
        GetCitiesByNameUseCase(
            cityRepository = get()
        )
    }

}