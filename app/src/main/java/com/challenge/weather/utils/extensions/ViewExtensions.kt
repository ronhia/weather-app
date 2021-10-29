package com.challenge.weather.utils.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import timber.log.Timber

fun View.hideKeyboard() {
    try {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    } catch (e: IllegalStateException) {
        Timber.e(e)
    }
}