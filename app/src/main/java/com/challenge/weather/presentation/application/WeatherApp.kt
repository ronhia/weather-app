package com.challenge.weather.presentation.application

import android.app.Application
import coil.Coil
import coil.ImageLoader
import coil.util.CoilUtils
import com.challenge.weather.BuildConfig
import com.challenge.weather.di.KoinModules
import com.challenge.weather.utils.TimberDebugTree
import com.facebook.stetho.Stetho
import com.google.android.libraries.places.api.Places
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber
import java.util.concurrent.TimeUnit

@Suppress("unused")
class WeatherApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initKoin()
        initStetho()
        initCoil()
        initPlaces()
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

    private fun initStetho() {
        Stetho.initializeWithDefaults(this)
    }

    private fun initCoil() {
        val imageLoader = ImageLoader.Builder(this)
            .crossfade(true)
            .okHttpClient {
                OkHttpClient.Builder()
                    .connectTimeout(45, TimeUnit.SECONDS)
                    .readTimeout(45, TimeUnit.SECONDS)
                    .writeTimeout(45, TimeUnit.SECONDS)
                    .cache(CoilUtils.createDefaultCache(this))
                    .build()
            }
            .build()

        Coil.setImageLoader(imageLoader)
    }

    private fun initPlaces() {
        Places.initialize(applicationContext, BuildConfig.google_maps_key)
    }

}