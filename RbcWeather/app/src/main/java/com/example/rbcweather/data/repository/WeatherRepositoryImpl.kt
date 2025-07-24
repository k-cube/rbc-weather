package com.example.rbcweather.data.repository

import com.example.rbcweather.data.models.toWeatherEntity
import com.example.rbcweather.data.network.WeatherApi
import com.example.rbcweather.domain.Response
import com.example.rbcweather.domain.WeatherEntity
import com.example.rbcweather.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeather(
        lat: Double,
        long: Double
    ): Flow<Response<WeatherEntity>> = flow {
        try {
            val weatherResponse = api.getWeatherData(lat = lat, long = long)
            val entity = weatherResponse.toWeatherEntity()
            emit(Response.Success(entity))
        } catch (e: Exception) {
            emit(Response.Error(e.message ?: "Something went wrong"))
        }
    }
}