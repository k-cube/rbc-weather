package com.example.rbcweather.presentation.utils

import com.example.rbcweather.R
import com.example.rbcweather.domain.DisplayInfo
import com.example.rbcweather.domain.DisplayInfoType
import com.example.rbcweather.domain.WeatherDailyInfo
import com.example.rbcweather.domain.WeatherEntity
import java.time.LocalDate

val FakeWeather = WeatherEntity(
    temperature = 20,
    rain = 10,
    isDay = true,
    hourlyInfo = mapOf(
        "00:00" to 10,
        "01:00" to 11,
        "02:00" to 12,
        "03:00" to 13,
        "04:00" to 14,
        "05:00" to 15,
        "06:00" to 16,
    ),
    dailyInfo = listOf(
        WeatherDailyInfo(
            displayInfo = listOf(
                DisplayInfo("Temperature", "20°C", infoType = DisplayInfoType.TEMPERATURE_MAX),
                DisplayInfo("Humidity", "80%", infoType = DisplayInfoType.TEMPERATURE_MIN),
                DisplayInfo("Wind Speed", "5 mph", infoType = DisplayInfoType.WIND_SPEED),
                DisplayInfo("UV Index", "55", infoType = DisplayInfoType.UV_INDEX),
            ),
            date = "Thursday, July 24"
        ),
        WeatherDailyInfo(
            displayInfo = listOf(
                DisplayInfo("Temperature", "20°C", infoType = DisplayInfoType.TEMPERATURE_MAX),
                DisplayInfo("Humidity", "80%", infoType = DisplayInfoType.TEMPERATURE_MIN),
                DisplayInfo("Wind Speed", "5 mph", infoType = DisplayInfoType.WIND_SPEED),
                DisplayInfo("UV Index", "55", infoType = DisplayInfoType.UV_INDEX),
            ),
            date = "Thursday, July 24"
        ),
        WeatherDailyInfo(
            displayInfo = listOf(
                DisplayInfo("Temperature", "20°C", infoType = DisplayInfoType.TEMPERATURE_MAX),
                DisplayInfo("Humidity", "80%", infoType = DisplayInfoType.TEMPERATURE_MIN),
                DisplayInfo("Wind Speed", "5 mph", infoType = DisplayInfoType.WIND_SPEED),
                DisplayInfo("UV Index", "55", infoType = DisplayInfoType.UV_INDEX),
            ),
            date = "Thursday, July 24"
        ),
        WeatherDailyInfo(
            displayInfo = listOf(
                DisplayInfo("Temperature", "20°C", infoType = DisplayInfoType.TEMPERATURE_MAX),
                DisplayInfo("Humidity", "80%", infoType = DisplayInfoType.TEMPERATURE_MIN),
                DisplayInfo("Wind Speed", "5 mph", infoType = DisplayInfoType.WIND_SPEED),
                DisplayInfo("UV Index", "55", infoType = DisplayInfoType.UV_INDEX),
            ),
            date = "Thursday, July 24"
        ),
        WeatherDailyInfo(
            displayInfo = listOf(
                DisplayInfo("Temperature", "20°C", infoType = DisplayInfoType.TEMPERATURE_MAX),
                DisplayInfo("Humidity", "80%", infoType = DisplayInfoType.TEMPERATURE_MIN),
                DisplayInfo("Wind Speed", "5 mph", infoType = DisplayInfoType.WIND_SPEED),
                DisplayInfo("UV Index", "55", infoType = DisplayInfoType.UV_INDEX),
            ),
            date = "Thursday, July 24"
        ),
        WeatherDailyInfo(
            displayInfo = listOf(
                DisplayInfo("Temperature", "20°C", infoType = DisplayInfoType.TEMPERATURE_MAX),
                DisplayInfo("Humidity", "80%", infoType = DisplayInfoType.TEMPERATURE_MIN),
                DisplayInfo("Wind Speed", "5 mph", infoType = DisplayInfoType.WIND_SPEED),
                DisplayInfo("UV Index", "55", infoType = DisplayInfoType.UV_INDEX),
            ),
            date = "Thursday, July 24"
        ),
        WeatherDailyInfo(
            displayInfo = listOf(
                DisplayInfo("Temperature", "20°C", infoType = DisplayInfoType.TEMPERATURE_MAX),
                DisplayInfo("Humidity", "80%", infoType = DisplayInfoType.TEMPERATURE_MIN),
                DisplayInfo("Wind Speed", "5 mph", infoType = DisplayInfoType.WIND_SPEED),
                DisplayInfo("UV Index", "55", infoType = DisplayInfoType.UV_INDEX),
            ),
            date = "Thursday, July 24"
        ),
    ),
    dailyTemperatureMin = listOf(
        10,
        11,
        12,
        13,
        14,
        15,
        16,
    ),
    dailyTemperatureMax = listOf(
        20,
        21,
        22,
        23,
        24,
        25,
        26,
    ),
    dailyDate = listOf(
        LocalDate.now(),
        LocalDate.now(),
        LocalDate.now(),
        LocalDate.now(),
        LocalDate.now(),
        LocalDate.now(),
        LocalDate.now(),
    ),
)


val FakeWeatherDailyInfo = WeatherDailyInfo(
    date = "Thursday, July 24",
    displayInfo = listOf(
        DisplayInfo("Temperature", "20", unit = "°C", infoType = DisplayInfoType.TEMPERATURE_MAX),
        DisplayInfo("Humidity", "80", unit = "%", infoType = DisplayInfoType.TEMPERATURE_MIN),
        DisplayInfo("Wind Speed", "10", unit = "km/h", infoType = DisplayInfoType.WIND_SPEED),
        DisplayInfo("UV Index", "7", infoType = DisplayInfoType.UV_INDEX),
        DisplayInfo("Sunrise", "06:00", infoType = DisplayInfoType.SUNRISE),
        DisplayInfo("Sunset", "18:00", infoType = DisplayInfoType.SUNSET),
        DisplayInfo("Rain Chance", "50", unit = "%", infoType = DisplayInfoType.RAIN_CHANCE),
        DisplayInfo("Rain Sum", "10", unit = "mm", infoType = DisplayInfoType.RAIN_SUM),
    ),
)
