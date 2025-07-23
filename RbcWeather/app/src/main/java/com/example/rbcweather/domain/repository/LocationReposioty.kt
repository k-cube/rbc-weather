package com.example.rbcweather.domain.repository

import android.location.Location

interface LocationRepository {
    suspend fun getCurrentLocation(): Result<Location>
}