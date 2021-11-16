package com.challenge.weather.presentation.features.location.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoordinateModel(
    val latitude: Double,
    val longitude: Double
): Parcelable