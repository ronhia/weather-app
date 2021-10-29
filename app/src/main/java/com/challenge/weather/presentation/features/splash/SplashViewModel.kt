package com.challenge.weather.presentation.features.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.challenge.weather.domain.usecases.LoadCitiesUseCase
import com.challenge.weather.utils.Event
import kotlinx.coroutines.launch

class SplashViewModel(
    private val loadCitiesUseCase: LoadCitiesUseCase
) : ViewModel() {

    private val _action = MutableLiveData<Event<Unit>>()
    val action: LiveData<Event<Unit>>
        get() = _action

    fun loadData() {
        viewModelScope.launch {
            loadCitiesUseCase.execute()

            _action.value = Event(Unit)
        }
    }

}