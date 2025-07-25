package com.example.rbcweather.domain.repository

import com.example.rbcweather.domain.Response

interface LocationRepository {
    suspend fun getCurrentLocation(): Response<SearchLocationEntity?>

    suspend fun searchLocation(query: String): Response<List<SearchLocationEntity>>
}