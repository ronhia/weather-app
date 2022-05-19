package com.challenge.weather.utils.extensions

import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import java.util.Timer
import java.util.TimerTask

fun EditText.doAfterTextChangedWithDelay(delay: Long, block: (text: String) -> Unit) {
    var timer = Timer()
    doAfterTextChanged { editable ->
        timer.cancel()
        timer = Timer()
        timer.schedule(
            object : TimerTask() {
                override fun run() {
                    block.invoke(editable.toString())
                }
            },
            delay
        )
    }
}