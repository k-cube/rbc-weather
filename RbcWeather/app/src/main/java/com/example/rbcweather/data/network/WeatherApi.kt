package com.example.rbcweather.data.network

import com.example.rbcweather.data.models.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/forecast?daily=wind_speed_10m_max,temperature_2m_max,temperature_2m_min,uv_index_max,sunrise,sunset&hourly=temperature_2m&current=temperature_2m,rain")
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ): WeatherModel

}