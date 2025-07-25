package com.example.rbcweather.presentation.utils

import java.time.DayOfWeek
import java.time.LocalDate

fun LocalDate.toDisplayDate() : String {
    val dayOfTheWeek = getDayOfTheWeek(dayOfWeek)
    val dayOfMonth = dayOfMonth
    val month = getMonthOfTheYear(monthValue)
    return "$dayOfTheWeek, $dayOfMonth $month"
}

fun getDayOfTheWeek(dayOfWeek: DayOfWeek): String =
    when (dayOfWeek) {
        DayOfWeek.MONDAY -> "Monday"
        DayOfWeek.TUESDAY -> "Tuesday"
        DayOfWeek.WEDNESDAY -> "Wednesday"
        DayOfWeek.THURSDAY -> "Thursday"
        DayOfWeek.FRIDAY -> "Friday"
        DayOfWeek.SATURDAY -> "Saturday"
        DayOfWeek.SUNDAY -> "Sunday"
    }

fun getMonthOfTheYear(month: Int): String =
    when (month) {
        1 -> "January"
        2 -> "February"
        3 -> "March"
        4 -> "April"
        5 -> "May"
        6 -> "June"
        7 -> "July"
        8 -> "August"
        9 -> "September"
        10 -> "October"
        11 -> "November"
        12 -> "December"
        else -> ""
    }
