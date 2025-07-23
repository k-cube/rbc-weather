package com.example.rbcweather.domain.repository

import com.example.rbcweather.domain.Result
import com.example.rbcweather.domain.WeatherEntity

interface WeatherRepository {
    suspend fun getWeather(lat: Double, lon: Double): Result<WeatherEntity>
}