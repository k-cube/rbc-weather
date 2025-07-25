package com.example.rbcweather.presentation.mainscreen

import com.example.rbcweather.domain.WeatherEntity
import com.example.rbcweather.domain.repository.SearchLocationEntity

data class MainScreenUiState(
    val isLoading: Boolean = false,
    val isPermissionGranted: Boolean = false,
    val weatherInfo: WeatherEntity? = null,
    val error: String? = null,
    val locationName: String? = null,
    val searchQuery: String = "",
    val searchLocations: List<SearchLocationEntity> = emptyList()
)
