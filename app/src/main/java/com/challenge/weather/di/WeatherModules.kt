package com.challenge.weather.di

import com.challenge.weather.data.repository.WeatherRepositoryImpl
import com.challenge.weather.domain.repository.WeatherRepository
import com.challenge.weather.domain.usecases.GetWeatherByCoordinatesUseCase
import com.challenge.weather.domain.usecases.GetWeatherByNameCityUseCase
import com.challenge.weather.presentation.features.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val weatherModules = module {

    factory<WeatherRepository> {
        WeatherRepositoryImpl()
    }

    factory {
        GetWeatherByCoordinatesUseCase(
            weatherRepository = get()
        )
    }

    factory {
        GetWeatherByNameCityUseCase(
            weatherRepository = get()
        )
    }

    viewModel { SearchViewModel() }

}