package com.example.rbcweather.data.models

import com.example.rbcweather.domain.DisplayInfo
import com.example.rbcweather.domain.DisplayInfoType
import com.example.rbcweather.domain.WeatherDailyInfo
import com.example.rbcweather.domain.WeatherEntity
import com.example.rbcweather.presentation.utils.toDisplayDate
import com.squareup.moshi.Json
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class WeatherModel(
    @Json(name = "current")
    val currentModel: CurrentModel,
    val daily: DailyModel,
    val hourly: HourlyModel
)

data class CurrentModel(
    @Json(name = "temperature_2m")
    val temperature: Double,
    val rain: Double,
    @Json(name = "is_day")
    val isDay: Int
)

data class DailyModel(
    val time: List<String>,
    @Json(name = "wind_speed_10m_max")
    val windSpeed: List<Double>,
    @Json(name = "temperature_2m_max")
    val temperatureMax: List<Double>,
    @Json(name = "temperature_2m_min")
    val temperatureMin: List<Double>,
    @Json(name = "uv_index_max")
    val uvIndexMax: List<Double>,
    val sunrise: List<String>,
    val sunset: List<String>,
    @Json(name = "precipitation_probability_max")
    val rainChance: List<Int>,
    @Json(name = "rain_sum")
    val rainSum: List<Double>,
)

data class HourlyModel(
    val time: List<String>,
    @Json(name = "temperature_2m")
    val temperature: List<Double>,
)

fun WeatherModel.toWeatherEntity(): WeatherEntity {
    val timeFormatter = DateTimeFormatter.ISO_DATE_TIME
    val pattern = DateTimeFormatter.ofPattern("HH:mm")


    return WeatherEntity(
        temperature = currentModel.temperature.toInt(),
        rain = currentModel.rain.toInt(),
        hourlyInfo = hourly.time.map { time ->
            LocalDateTime.parse(time, timeFormatter).format(pattern)
        }.zip(hourly.temperature.map { it.toInt() }).toMap(),
        dailyInfo = daily.time.mapIndexed { index, time ->
            val localDate = LocalDate.parse(time)
            val displayInfo = mutableListOf<DisplayInfo>()
            displayInfo.add(
                DisplayInfo(
                    "Temperature Max",
                    daily.temperatureMax[index].toInt().toString(),
                    unit = "°C",
                    infoType = DisplayInfoType.TEMPERATURE_MAX
                )
            )
            displayInfo.add(
                DisplayInfo(
                    "Temperature Min",
                    daily.temperatureMin[index].toInt().toString(),
                    unit = "°C",
                    infoType = DisplayInfoType.TEMPERATURE_MIN
                )
            )
            displayInfo.add(
                DisplayInfo(
                    "Wind Speed",
                    daily.windSpeed[index].toString(),
                    unit = "km/h",
                    infoType = DisplayInfoType.WIND_SPEED
                )
            )
            displayInfo.add(DisplayInfo(
                "UV Index",
                daily.uvIndexMax[index].toString(),
                infoType = DisplayInfoType.UV_INDEX
            ))
            displayInfo.add(
                DisplayInfo(
                    "Sunrise",
                    LocalDateTime.parse(daily.sunrise[index], timeFormatter).format(pattern),
                    infoType = DisplayInfoType.SUNRISE
                )
            )
            displayInfo.add(
                DisplayInfo(
                    "Sunset",
                    LocalDateTime.parse(daily.sunset[index], timeFormatter).format(pattern),
                    infoType = DisplayInfoType.SUNSET
                )
            )
            displayInfo.add(
                DisplayInfo(
                    "Rain Chance",
                    daily.rainChance[index].toString(),
                    unit = "%",
                    infoType = DisplayInfoType.RAIN_CHANCE
                )
            )
            displayInfo.add(
                DisplayInfo(
                    "Rain Sum",
                    daily.rainSum[index].toString(),
                    unit = "mm",
                    infoType = DisplayInfoType.RAIN_SUM
                )
            )
            WeatherDailyInfo(
                displayInfo = displayInfo,
                date = localDate.toDisplayDate()
            )
        },
        dailyTemperatureMin = daily.temperatureMin.map { it.toInt() },
        dailyTemperatureMax = daily.temperatureMax.map { it.toInt() },
        isDay = currentModel.isDay == 1,
        dailyDate = daily.time.map { LocalDate.parse(it) }
    )
}

