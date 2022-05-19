package com.challenge.weather.di

import com.challenge.weather.data.repository.weather.WeatherRemoteStorage
import com.challenge.weather.data.repository.weather.WeatherRepositoryData
import com.challenge.weather.domain.weather.repository.WeatherRepository
import com.challenge.weather.domain.weather.usecases.GetWeatherByNameCityUseCase
import com.challenge.weather.presentation.features.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val weatherModules = module {

    single {
        WeatherRemoteStorage(
            weatherService = get()
        )
    }

    single<WeatherRepository> {
        WeatherRepositoryData(
            weatherRemoteStorage = get()
        )
    }

    single {
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