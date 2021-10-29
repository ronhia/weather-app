package com.challenge.weather.utils

import timber.log.Timber

class TimberDebugTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String? {
        val tag = super.createStackElementTag(element)
        return String.format(FORMAT, tag, element.lineNumber, element.methodName)
    }

    companion object {
        private const val FORMAT = "Class:%s: Line: %s, Method: %s"
    }
}