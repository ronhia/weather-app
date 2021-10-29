package com.challenge.weather.presentation.features.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.challenge.weather.databinding.FragmentSearchBinding
import com.challenge.weather.presentation.base.BaseFragment
import com.challenge.weather.presentation.features.search.model.CityModel
import com.challenge.weather.presentation.features.weather.model.WeatherModel
import com.challenge.weather.utils.EventObserver
import com.challenge.weather.utils.extensions.afterTextChanged
import com.challenge.weather.utils.extensions.hideKeyboard
import com.challenge.weather.utils.extensions.safeNavigateFromNavController
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>(), SearchAdapter.SearchOnListener {

    private val searchViewModel: SearchViewModel by viewModel()
    private val searchAdapter: SearchAdapter by lazy { SearchAdapter(this) }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSearchBinding {
        return FragmentSearchBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        events()
    }

    private fun events() {
        binding.ietCity.afterTextChanged { name ->
            searchCities(name)
        }

        searchViewModel.cities.observe(viewLifecycleOwner, { cities ->
            showCities(cities)
        })

        searchViewModel.weather.observe(viewLifecycleOwner, EventObserver { weather ->
            goToWeather(weather)
        })
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupRecycler() = with(binding) {
        rvCities.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rvCities.adapter = searchAdapter
        rvCities.setOnTouchListener { view, _ ->
            ietCity.clearFocus()
            view.hideKeyboard()
            false
        }
    }

    private fun showCities(cities: List<CityModel>) {
        searchAdapter.items = cities
    }

    override fun onClickCity(city: CityModel) {
        binding.root.hideKeyboard()
        showProgressDialog()

        val nameCity = city.cityFull
        searchViewModel.searchByCity(nameCity)
    }

    private fun searchCities(name: String) {
        searchViewModel.searchCities(name)
    }

    private fun goToWeather(weather: WeatherModel) {
        val directions = SearchFragmentDirections.toWeatherFragment(weather)
        safeNavigateFromNavController(directions)
        hideProgressDialog()
    }
}