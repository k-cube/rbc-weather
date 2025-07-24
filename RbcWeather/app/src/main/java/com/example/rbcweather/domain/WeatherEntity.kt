package com.example.rbcweather.domain

import com.example.rbcweather.R
import kotlinx.serialization.Serializable
import java.time.LocalDate

data class WeatherEntity (
    val temperature: Int,
    val rain: Int,
    val isDay: Boolean,
    val hourlyInfo: Map<String ,Int>,
    val dailyInfo: List<WeatherDailyInfo>,
    val dailyTemperatureMin: List<Int>,
    val dailyTemperatureMax: List<Int>,
    val dailyDate: List<LocalDate>
)

@Serializable
data class WeatherDailyInfo (
    val displayInfo: List<DisplayInfo>,
    val date: String,
)

@Serializable
data class DisplayInfo (
    val name: String,
    val value: String,
    val unit: String? = null,
    val infoType: DisplayInfoType,
)

fun DisplayInfo.getIcon(): Int {
    return when (infoType) {
        DisplayInfoType.TEMPERATURE_MAX -> R.drawable.temp_max
        DisplayInfoType.TEMPERATURE_MIN -> R.drawable.temp_min
        DisplayInfoType.WIND_SPEED -> R.drawable.wind
        DisplayInfoType.UV_INDEX -> R.drawable.uv
        DisplayInfoType.SUNRISE -> R.drawable.sunrise
        DisplayInfoType.SUNSET -> R.drawable.sunset
        DisplayInfoType.RAIN_CHANCE -> R.drawable.rain_chance
        DisplayInfoType.RAIN_SUM -> R.drawable.rain_sum
    }
}

enum class DisplayInfoType {
    TEMPERATURE_MAX,
    TEMPERATURE_MIN,
    WIND_SPEED,
    UV_INDEX,
    SUNRISE,
    SUNSET,
    RAIN_CHANCE,
    RAIN_SUM,
}



