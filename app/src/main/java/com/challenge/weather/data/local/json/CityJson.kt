package com.challenge.weather.data.local.json

import android.content.Context
import com.challenge.weather.utils.extensions.fromJson
import com.google.gson.annotations.SerializedName

class CityJson(context: Context) {

    companion object {
        const val FILE = "json/cities.json"
    }

    private val dataSource: String by lazy {
        context.assets.open(FILE).bufferedReader().use { it.readLine() }
    }

    fun get(): List<City> {
        return dataSource.fromJson<List<City>>().toSet().distinctBy { it.complete }.toList()
    }

    data class City(
        @SerializedName("name") val name: String,
        @SerializedName("country") val country: String
    ) {
        val complete: String
            get() = "$name.$country"
    }
}