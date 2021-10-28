package com.challenge.weather.presentation.application

import android.app.Application
import com.challenge.weather.BuildConfig
import com.challenge.weather.di.KoinModules
import com.challenge.weather.utils.TimberDebugTree
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class WeatherApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initKoin()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(TimberDebugTree())
        }
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@WeatherApp)
            KoinModules.init()
        }
    }
}