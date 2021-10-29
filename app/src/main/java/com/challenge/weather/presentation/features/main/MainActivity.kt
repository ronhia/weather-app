package com.challenge.weather.presentation.features.main

import com.challenge.weather.databinding.ActivityMainBinding
import com.challenge.weather.presentation.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getActivityBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

}