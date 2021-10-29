package com.challenge.weather.di

import com.challenge.weather.data.repository.weather.WeatherRemoteStorage
import com.challenge.weather.data.repository.weather.WeatherRepositoryImpl
import com.challenge.weather.domain.repository.WeatherRepository
import com.challenge.weather.domain.usecases.GetWeatherByNameCityUseCase
import com.challenge.weather.presentation.features.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val weatherModules = module {

    factory {
        WeatherRemoteStorage(
            weatherService = get()
        )
    }

    factory<WeatherRepository> {
        WeatherRepositoryImpl(
            weatherRemoteStorage = get()
        )
    }

    factory {
        GetWeatherByNameCityUseCase(
            weatherRepository = get()
        )
    }

    viewModel {
        SearchViewModel(
            getWeatherByNameCityUseCase = get(),
            getCitiesByNameUseCase = get()
        )
    }

}