package com.challenge.weather.di

import com.challenge.weather.data.local.room.WeatherDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModules = module {

    single { WeatherDatabase.buildDatabase(androidApplication()) }

    single { get<WeatherDatabase>().cityRoomDao() }
}