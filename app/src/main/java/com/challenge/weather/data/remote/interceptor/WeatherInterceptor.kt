package com.challenge.weather.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class WeatherInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("APPID", "175945f4c1b842c4c106c57e80be4b83")
            .addQueryParameter("lang", "es")
            .build()

        val requestBuilder = original.newBuilder()
            .url(url)

        val request = requestBuilder.build()

        return chain.proceed(request)
    }
}