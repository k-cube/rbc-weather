package com.example.rbcweather.data.network

import com.example.rbcweather.data.models.SearchLocationModel
import com.example.rbcweather.data.models.SearchLocationResultModel
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApi {
    @GET("v1/search")
    suspend fun getSearchLocations(
        @Query("name") query: String
    ): SearchLocationResultModel
}