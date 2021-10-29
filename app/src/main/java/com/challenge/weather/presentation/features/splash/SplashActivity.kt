package com.challenge.weather.presentation.features.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.challenge.weather.presentation.features.main.MainActivity
import com.challenge.weather.utils.EventObserver
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private val splashViewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        events()
        splashViewModel.loadData()
    }

    private fun events() {
        splashViewModel.action.observe(this, EventObserver {
            goToMain()
        })
    }

    private fun goToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}