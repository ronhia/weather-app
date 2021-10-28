package com.challenge.weather.presentation.features.search

import androidx.lifecycle.ViewModel
import timber.log.Timber

class SearchViewModel : ViewModel() {

    fun searchByCity(name: String) {
        Timber.e("city: $name")
    }
}