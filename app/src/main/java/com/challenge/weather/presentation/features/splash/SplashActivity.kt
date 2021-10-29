package com.challenge.weather.presentation.features.splash

import android.content.Intent
import android.os.Bundle
import androidx.core.view.isVisible
import com.challenge.weather.databinding.ActivitySplashBinding
import com.challenge.weather.presentation.base.BaseActivity
import com.challenge.weather.presentation.features.main.MainActivity
import com.challenge.weather.utils.EventObserver
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    private val splashViewModel: SplashViewModel by viewModel()

    override fun getActivityBinding(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        events()
        splashViewModel.loadData()
    }

    private fun events() {
        splashViewModel.action.observe(this, EventObserver {
            goToMain()
        })

        splashViewModel.loadingData.observe(this, EventObserver { loading ->
            binding.tvLoading.isVisible = loading
        })
    }

    private fun goToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}