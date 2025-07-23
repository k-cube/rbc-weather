package com.example.rbcweather.domain

import java.time.LocalDateTime

data class WeatherEntity (
    val temperature: Int,
    val rain: Int,
    val hourlyInfo: Map<LocalDateTime ,Int>,
    val dailyInfo: Map<LocalDateTime, DailyInfo>
)

data class DailyInfo(
    val windSpeed: Int,
    val temperatureMax: Int,
    val temperatureMin: Int,
    val uvIndex: Int,
    val sunrise: LocalDateTime,
    val sunset: LocalDateTime,
)

