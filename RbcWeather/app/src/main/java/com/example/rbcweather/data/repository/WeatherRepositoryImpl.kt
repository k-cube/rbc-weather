package com.example.rbcweather.data.repository

import com.example.rbcweather.data.models.WeatherModel
import com.example.rbcweather.data.network.WeatherApi
import com.example.rbcweather.domain.Result
import com.example.rbcweather.domain.WeatherEntity

import com.example.rbcweather.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeather(
        lat: Double,
        long: Double
    ): Result<WeatherEntity> {
        return try {
            val weatherresponse = api.getWeatherData(lat= lat, long = long)
            return Result.Success(WeatherEntity())
        } catch (e: Exception) {
            Result.Error()
        }
    }


}