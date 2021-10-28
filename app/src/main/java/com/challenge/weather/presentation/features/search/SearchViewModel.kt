package com.challenge.weather.presentation.features.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.challenge.weather.domain.usecases.GetWeatherByNameCityUseCase
import kotlinx.coroutines.launch
import timber.log.Timber

class SearchViewModel(
    private val getWeatherByNameCityUseCase: GetWeatherByNameCityUseCase
) : ViewModel() {

    fun searchByCity(name: String) {

        viewModelScope.launch {
            try {
                getWeatherByNameCityUseCase.execute(name)
            } catch (e: Exception) {
                Timber.e(e)
            }
        }

    }
}