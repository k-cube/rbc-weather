package com.example.rbcweather.domain.repository

import android.location.Location
import com.example.rbcweather.domain.Response

interface LocationRepository {
    suspend fun getCurrentLocation(): Response<Location>

    suspend fun searchLocation(query: String): Response<List<SearchLocationEntity>>
}