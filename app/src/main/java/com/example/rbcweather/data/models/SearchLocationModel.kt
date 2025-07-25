package com.example.rbcweather.data.models


data class SearchLocationResultModel(
    val results: List<SearchLocationModel>
)

data class SearchLocationModel(
    val name: String,
    val country: String,
    val latitude: Double,
    val longitude: Double,
)
