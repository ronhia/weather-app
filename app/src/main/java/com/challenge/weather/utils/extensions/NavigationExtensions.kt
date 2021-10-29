package com.challenge.weather.utils.extensions

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

fun Fragment.safeNavigateFromNavController(directions: NavDirections) = with(findNavController()) {
    currentDestination?.getAction(directions.actionId)?.let {
        navigate(directions)
    }
}