package com.challenge.weather.di

import android.content.Context
import com.challenge.weather.BuildConfig
import com.challenge.weather.data.remote.interceptor.WeatherInterceptor
import com.challenge.weather.data.remote.service.WeatherService
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkWeatherModules = module {

    single { provideChuckerInterceptor(context = androidApplication()) }

    single { WeatherInterceptor() }

    single(named("HttpClientWeather")) {
        provideHttpClientWeather(
            weatherInterceptor = get(),
            chuckerInterceptor = get()
        )
    }

    single(named("RetrofitWeather")) {
        provideRetrofitWeather(
            httpClient = get(named("HttpClientWeather"))
        )
    }

    single {
        provideWeatherService(
            retrofit = get(named("RetrofitWeather"))
        )
    }
}

fun provideChuckerInterceptor(context: Context): ChuckerInterceptor {
    return ChuckerInterceptor.Builder(context)
        .build()
}

fun provideHttpClientWeather(
    weatherInterceptor: WeatherInterceptor,
    chuckerInterceptor: ChuckerInterceptor
): OkHttpClient {
    val httpClient = OkHttpClient().newBuilder()
        .addInterceptor(weatherInterceptor)

    if (BuildConfig.DEBUG) {
        httpClient.addInterceptor(chuckerInterceptor)
    }

    return httpClient.build()
}

fun provideRetrofitWeather(httpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.OPEN_WEATHER_API_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideWeatherService(retrofit: Retrofit): WeatherService {
    return retrofit.create(WeatherService::class.java)
}

