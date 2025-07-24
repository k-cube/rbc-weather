package com.example.rbcweather.presentation

import com.example.rbcweather.domain.WeatherDailyInfo
import kotlinx.serialization.Serializable


@Serializable
data object MainScreen

@Serializable
data class DetailScreen(
    val weather: WeatherDailyInfo
)
