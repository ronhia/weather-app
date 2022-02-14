package com.challenge.weather.di

import com.challenge.weather.data.local.json.CityJson
import com.challenge.weather.data.repository.city.CityLocalStorage
import com.challenge.weather.data.repository.city.CityRemoteStorage
import com.challenge.weather.data.repository.city.CityRepositoryData
import com.challenge.weather.domain.city.repository.CityRepository
import com.challenge.weather.domain.city.usecases.GetCitiesByNameUseCase
import com.challenge.weather.domain.city.usecases.LoadCitiesUseCase
import com.challenge.weather.domain.city.usecases.VerifyExistsCitiesUseCase
import com.google.android.libraries.places.api.Places
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val cityModules = module {

    single { CityJson(context = androidApplication()) }

    single { Places.createClient(androidApplication()) }

    single {
        CityLocalStorage(
            cityRoomDao = get(),
            cityJson = get()
        )
    }

    single {
        CityRemoteStorage(
            placesClient = get()
        )
    }

    single<CityRepository> {
        CityRepositoryData(
            cityLocalStorage = get(),
            cityRemoteStorage = get()
        )
    }

    single {
        VerifyExistsCitiesUseCase(
            cityRepository = get()
        )
    }

    single {
        LoadCitiesUseCase(
            cityRepository = get()
        )
    }

    single {
        GetCitiesByNameUseCase(
            cityRepository = get()
        )
    }

}