package com.example.rbcweather.domain.repository

import com.example.rbcweather.domain.Response
import com.example.rbcweather.domain.WeatherEntity
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getWeather(lat: Double, long: Double): Flow<Response<WeatherEntity>>
}