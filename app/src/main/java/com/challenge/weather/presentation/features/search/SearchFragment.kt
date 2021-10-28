package com.challenge.weather.presentation.features.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.challenge.weather.databinding.FragmentSearchBinding
import com.challenge.weather.presentation.base.BaseFragment
import com.challenge.weather.presentation.features.weather.model.WeatherModel
import com.challenge.weather.utils.EventObserver
import com.challenge.weather.utils.extensions.safeNavigateFromNavController
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    private val searchViewModel: SearchViewModel by viewModel()

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSearchBinding {
        return FragmentSearchBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        events()
    }

    private fun events() {
        binding.btnSearch.setOnClickListener { searchCity() }

        searchViewModel.weather.observe(viewLifecycleOwner, EventObserver { weather ->
            goToWeather(weather)
        })
    }

    private fun searchCity() {
        val nameCity = binding.ietCity.text.toString()
        searchViewModel.searchByCity(nameCity)
    }

    private fun goToWeather(weather: WeatherModel) {
        val directions = SearchFragmentDirections.toWeatherFragment(weather)
        safeNavigateFromNavController(directions)
    }
}