package com.example.rbcweather.domain.repository

data class SearchLocationEntity (
    val name: String? = null,
    val country: String? = null,
    val latitude: Double,
    val longitude: Double,
)
