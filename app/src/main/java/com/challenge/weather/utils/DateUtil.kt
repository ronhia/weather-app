package com.challenge.weather.utils

import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.util.Locale

object DateUtil {

    fun customSimpleDateFormat(
        format: String,
        locale: Locale = Locale.getDefault()
    ): SimpleDateFormat {
        val simpleFormatInput = SimpleDateFormat(format, locale)
        simpleFormatInput.dateFormatSymbols = getCustomSymbols()
        return simpleFormatInput
    }

    private fun getCustomSymbols(): DateFormatSymbols {
        val symbols = DateFormatSymbols(Locale.getDefault())
        symbols.amPmStrings = getAmPmSymbols()
        symbols.months = getMonthsSymbols()
        symbols.weekdays = getWeekDaysSymbols()
        return symbols
    }

    private fun getAmPmSymbols(): Array<String> {
        return arrayOf("am", "pm")
    }

    private fun getMonthsSymbols(): Array<String> {
        return arrayOf(
            "Enero",
            "Febrero",
            "Marzo",
            "Abril",
            "Mayo",
            "Junio",
            "Julio",
            "Agosto",
            "Septiembre",
            "Octubre",
            "Noviembre",
            "Diciembre"
        )
    }

    private fun getWeekDaysSymbols(): Array<String> {
        return arrayOf(
            "",
            "Domingo",
            "Lunes",
            "Martes",
            "Miércoles",
            "Jueves",
            "Viernes",
            "Sábado"
        )
    }

}