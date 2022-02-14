package com.challenge.weather.data.repository.city

import com.challenge.weather.data.repository.city.mapper.toCities
import com.challenge.weather.domain.city.model.City
import com.google.android.gms.common.api.ApiException
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.model.TypeFilter
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.PlacesClient
import kotlinx.coroutines.tasks.await
import timber.log.Timber

class CityRemoteStorage(
    private val placesClient: PlacesClient
) {

    suspend fun getByName(name: String): List<City> {
        val token = AutocompleteSessionToken.newInstance()

        val request = FindAutocompletePredictionsRequest.builder()
            .setTypeFilter(TypeFilter.CITIES)
            .setSessionToken(token)
            .setQuery(name)
            .build()

        return try {
            val result = placesClient.findAutocompletePredictions(request).await()
            result.autocompletePredictions.toCities()
        } catch (e: Exception) {
            when (e) {
                is ApiException -> Timber.e("Place not found: " + e.statusCode)
                else -> Timber.e(e)
            }
            emptyList()
        }
    }
}