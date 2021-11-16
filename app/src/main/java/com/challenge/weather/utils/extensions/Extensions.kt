package com.challenge.weather.utils.extensions

import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Int?.orZero() = this ?: 0

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Fragment.toast(message: String) {
    context?.toast(message)
}

fun AppCompatActivity.hasPermissions(permissions: List<String>): Boolean {
    return permissions
        .map { permission -> ContextCompat.checkSelfPermission(this, permission) }
        .all { it == PackageManager.PERMISSION_GRANTED }
}

fun Fragment.hasPermissions(permissions: List<String>): Boolean {
    return (activity as? AppCompatActivity)?.hasPermissions(permissions) ?: false
}