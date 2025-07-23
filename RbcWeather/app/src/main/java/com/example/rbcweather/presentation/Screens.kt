package com.example.rbcweather.presentation

import com.example.rbcweather.domain.WeatherEntity

sealed class Screens {
    object Main: Screens()

    data class Details(val data: WeatherEntity): Screens()

}