package com.challenge.weather.data.remote.interceptor

import com.challenge.weather.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class WeatherInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(API_KEY_PARAM, BuildConfig.OPEN_WEATHER_API_KEY)
            .addQueryParameter(LANGUAGE_PARAM, LANGUAGE_VALUE)
            .build()

        val requestBuilder = original.newBuilder()
            .url(url)

        val request = requestBuilder.build()

        return chain.proceed(request)
    }

    companion object {
        const val LANGUAGE_PARAM = "lang"
        const val LANGUAGE_VALUE = "es"

        const val API_KEY_PARAM = "APPID"
    }
}