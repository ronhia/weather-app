package com.challenge.weather.presentation.features.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.challenge.weather.domain.city.usecases.GetCitiesByNameUseCase
import com.challenge.weather.domain.weather.usecases.GetWeatherByNameCityUseCase
import com.challenge.weather.presentation.features.search.mapper.toModel
import com.challenge.weather.presentation.features.search.model.CityModel
import com.challenge.weather.presentation.features.weather.mapper.toModel
import com.challenge.weather.presentation.features.weather.model.WeatherModel
import com.challenge.weather.utils.Event
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber

class SearchViewModel(
    private val getWeatherByNameCityUseCase: GetWeatherByNameCityUseCase,
    private val getCitiesByNameUseCase: GetCitiesByNameUseCase
) : ViewModel() {

    private var searchJob: Job? = null

    private val _weather = MutableLiveData<Event<WeatherModel>>()
    val weather: LiveData<Event<WeatherModel>>
        get() = _weather

    private val _cities = MutableLiveData<List<CityModel>>()
    val cities: LiveData<List<CityModel>>
        get() = _cities

    fun searchByCity(name: String) {
        viewModelScope.launch {
            try {
                val result = getWeatherByNameCityUseCase.execute(name)
                _weather.value = Event(result.toModel())
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    fun searchCities(name: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            if (name.isEmpty()) {
                _cities.value = emptyList()
            } else {
                val result = getCitiesByNameUseCase.execute(name)
                _cities.value = result.toModel()
            }
        }
    }
}