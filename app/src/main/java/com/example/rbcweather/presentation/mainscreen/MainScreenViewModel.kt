package com.example.rbcweather.presentation.mainscreen

import android.location.Geocoder
import android.location.Location
import android.os.Build
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rbcweather.di.MainDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import com.example.rbcweather.domain.Response
import com.example.rbcweather.domain.repository.LocationRepository
import com.example.rbcweather.domain.repository.SearchLocationEntity
import com.example.rbcweather.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val locationRepository: LocationRepository,
    private val geocoder: Geocoder,
    @MainDispatcher private val mainDispatcher: CoroutineDispatcher
) : ViewModel() {
    var uiState: MutableStateFlow<MainScreenUiState> = MutableStateFlow(MainScreenUiState())
        private set

    private var currentLocation: MutableStateFlow<SearchLocationEntity?> = MutableStateFlow(null)

    private var searchQuery: MutableStateFlow<String> = MutableStateFlow("")

    private var locationPermissionFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)

    private var searchedLocation: MutableStateFlow<SearchLocationEntity?> = MutableStateFlow(null)

    init {
        observeSearchQuery()
        observePermission()
    }

    fun onSearchLocation(location: SearchLocationEntity) {
        searchedLocation.value = location
        loadWeatherInfo()
    }

    fun onSearchQueryChange(query: String) {
        searchQuery.value = query
    }

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    private fun observeSearchQuery() {
        viewModelScope.launch(mainDispatcher) {
            searchQuery
                .debounce(300)
                .map { it.trim() }
                .distinctUntilChanged()
                .filter { it.isNotEmpty() }
                .transform { query ->
                    emit(locationRepository.searchLocation(query))
                }
                .collect { results ->
                    if (results is Response.Success) {
                        uiState.value = uiState.value.copy(
                            searchLocations = results.data
                        )
                    }
                }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    private fun observePermission() {
        viewModelScope.launch(mainDispatcher) {
            locationPermissionFlow
                .collect { granted ->
                    if (granted) {
                        loadWeatherInfo()
                    }
                }
        }
    }

    fun onPermissionGranted(isGranted: Boolean) {
        uiState.value = uiState.value.copy(isPermissionGranted = isGranted)
        locationPermissionFlow.value = isGranted
    }

    fun loadWeatherInfo() {
        viewModelScope.launch(mainDispatcher) {
            uiState.value = uiState.value.copy(isLoading = true)
            val currentLocation = searchedLocation.value ?: getCurrentLocation().also {
                currentLocation.value = it
            }
            val location = currentLocation ?: return@launch

            getLocationName(location.latitude, location.longitude)
            weatherRepository.getWeather(lat = location.latitude, long = location.longitude)
                .catch {
                    uiState.value = uiState.value.copy(
                        isLoading = false,
                        error = it.message
                    )
                }
                .collect { result ->
                    when (result) {
                        is Response.Success -> {
                            uiState.value = uiState.value.copy(
                                isLoading = false,
                                weatherInfo = result.data
                            )
                        }

                        is Response.Error -> uiState.value = uiState.value.copy(
                            isLoading = false,
                            error = result.error
                        )
                    }
                }
        }.invokeOnCompletion {
            viewModelScope.launch (mainDispatcher) {
                // This is an Android bug that pull down refresh indicator stays and doesn't go away without a delay
                // https://issuetracker.google.com/issues/248274004
                delay(100)
                uiState.value = uiState.value.copy(isLoading = false)
            }
        }
    }

    private fun getLocationName(lat: Double, long: Double) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            geocoder.getFromLocation(
                lat,
                long,
                1,
            ) { it ->
                val address = it.first()
                uiState.value = uiState.value.copy(
                    locationName = address.locality
                )
            }
        }
    }

    private suspend fun getCurrentLocation(): SearchLocationEntity? {
        if (uiState.value.isPermissionGranted) {
            val location = locationRepository.getCurrentLocation()
            return if (location is Response.Success) location.data else null
        }
        return null
    }
}