package com.challenge.weather.presentation.features.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.challenge.weather.domain.usecases.GetWeatherByNameCityUseCase
import com.challenge.weather.presentation.features.weather.mapper.toModel
import com.challenge.weather.presentation.features.weather.model.WeatherModel
import com.challenge.weather.utils.Event
import kotlinx.coroutines.launch
import timber.log.Timber

class SearchViewModel(
    private val getWeatherByNameCityUseCase: GetWeatherByNameCityUseCase
) : ViewModel() {

    private val _weather = MutableLiveData<Event<WeatherModel>>()
    val weather: LiveData<Event<WeatherModel>>
        get() = _weather

    fun searchByCity(name: String) {

        viewModelScope.launch {
            try {
                val result = getWeatherByNameCityUseCase.execute(name)
                Timber.e("response: $result")
                _weather.value = Event(result.toModel())
            } catch (e: Exception) {
                Timber.e(e)
            }
        }

    }
}