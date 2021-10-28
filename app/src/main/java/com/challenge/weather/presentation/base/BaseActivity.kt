package com.challenge.weather.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B : ViewBinding> : AppCompatActivity() {

    private var _binding: B? = null
    val binding
        get() = _binding ?: throw IllegalStateException(
            "Cannot access view in after view destroyed and before view creation"
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getActivityBinding()
        setContentView(binding.root)
    }

    abstract fun getActivityBinding(): B
}