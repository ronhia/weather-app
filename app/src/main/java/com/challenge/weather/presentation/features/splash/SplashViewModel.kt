package com.challenge.weather.presentation.features.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.challenge.weather.domain.usecases.LoadCitiesUseCase
import com.challenge.weather.domain.usecases.VerifyExistsCitiesUseCase
import com.challenge.weather.utils.Event
import kotlinx.coroutines.launch

class SplashViewModel(
    private val verifyExistsCitiesUseCase: VerifyExistsCitiesUseCase,
    private val loadCitiesUseCase: LoadCitiesUseCase
) : ViewModel() {

    private val _loadingData = MutableLiveData<Event<Boolean>>()
    val loadingData: LiveData<Event<Boolean>>
        get() = _loadingData

    private val _action = MutableLiveData<Event<Unit>>()
    val action: LiveData<Event<Unit>>
        get() = _action

    fun loadData() {
        viewModelScope.launch {

            val exists = verifyExistsCitiesUseCase.execute()
            if (exists.not()) {
                _loadingData.value = Event(true)
                loadCitiesUseCase.execute()
                _loadingData.value = Event(false)
            }
            _action.value = Event(Unit)

        }
    }

}