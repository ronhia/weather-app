package com.challenge.weather.presentation.features.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.challenge.weather.R
import com.challenge.weather.databinding.FragmentWeatherBinding
import com.challenge.weather.presentation.base.BaseFragment
import com.challenge.weather.presentation.features.weather.model.WeatherModel
import com.challenge.weather.utils.WeatherUtils
import com.challenge.weather.utils.extensions.kelvinToCelsius
import com.challenge.weather.utils.extensions.loadImageFromUrl
import com.challenge.weather.utils.extensions.withXDecimals
import com.challenge.weather.utils.extensions.withoutZero

class WeatherFragment : BaseFragment<FragmentWeatherBinding>() {

    private val args: WeatherFragmentArgs by navArgs()
    private val weather: WeatherModel by lazy { args.weather }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentWeatherBinding {
        return FragmentWeatherBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayWeather()
    }

    private fun displayWeather() = with(binding) {
        tvCity.text = weather.cityComplete
        ivWeather.loadImageFromUrl(WeatherUtils.generateUrlIcon(weather.icon))
        tvWeatherDescription.text = weather.description.replaceFirstChar { it.uppercase() }
        tvTemperature.text = getString(
            R.string.weather_temperature,
            weather.temperature.kelvinToCelsius().withXDecimals(0).withoutZero()
        )
        tvWind.text = getString(
            R.string.weather_wind,
            weather.windSpeed.withXDecimals(1).withoutZero()
        )
        tvHumidity.text = getString(R.string.weather_humidity, weather.humidity.withoutZero())
    }
}