package com.challenge.weather.di

import androidx.room.Room
import com.challenge.weather.data.local.room.WeatherDatabase
import com.challenge.weather.presentation.features.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashModules = module {

    single {
        Room.databaseBuilder(get(), WeatherDatabase::class.java, WeatherDatabase.DATABASE_NAME)
            .build()
    }

    viewModel {
        SplashViewModel(
            loadCitiesUseCase = get()
        )
    }

}