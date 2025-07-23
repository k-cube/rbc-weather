package com.example.rbcweather.data.models

import com.squareup.moshi.Json

data class WeatherModel(
    @Json(name = "current")
    val currentModel: CurrentModel,
    val daily: DailyModel,
    val hourly: HourlyModel
)

data class CurrentModel (
    val temperature: Int,
    val rain: Int,
)

data class DailyModel (
    val time: List<String>,
    @Json(name = "wind_speed_10m_max")
    val windSpeed: List<Int>,
    @Json(name = "temperature_2m_max")
    val temperatureMax: List<Int>,
    @Json(name = "temperature_2m_min")
    val temperatureMin: List<Int>,
    @Json(name = "uv_index_max")
    val uvIndexMax: List<Int>,
    val sunrise: List<String>,
    val sunset: List<String>
)

data class HourlyModel (
    val time: List<String>,
    val temperature: List<Int>,
)

