package com.example.rbcweather.presentation.mainscreen

import android.location.Geocoder
import com.example.rbcweather.MainDispatcherRule
import com.example.rbcweather.domain.Response
import com.example.rbcweather.domain.repository.LocationRepository
import com.example.rbcweather.domain.repository.SearchLocationEntity
import com.example.rbcweather.domain.repository.WeatherRepository
import com.example.rbcweather.presentation.utils.FakeWeather
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainScreenViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    private lateinit var viewModel: MainScreenViewModel

    private lateinit var weatherRepository: WeatherRepository
    private lateinit var locationRepository: LocationRepository
    private lateinit var geocoder: Geocoder

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        weatherRepository = mockk()
        locationRepository = mockk()
        geocoder = mockk()
        viewModel = MainScreenViewModel(
            weatherRepository = weatherRepository,
            locationRepository = locationRepository,
            geocoder = geocoder,
            mainDispatcher = mainDispatcherRule.testDispatcher
        )
    }

    @Test
    fun `onPermissionGranted updates isPermissionGranted state`() = runTest {
        val currentUiState = viewModel.uiState.value
        assert(!currentUiState.isPermissionGranted)
        val newQuery = "New Query"
        viewModel.onPermissionGranted(true)
        val updatedUiState = viewModel.uiState.value
        assert(updatedUiState.isPermissionGranted)
    }

    @Test
    fun `should call loadWeatherInfo on onSearchLocation`() = runTest {
        coEvery {
            locationRepository.getCurrentLocation()
        } returns Response.Error("")

        coEvery {
            weatherRepository.getWeather(any(), any())
        } returns flow { emit(Response.Success(FakeWeather)) }

        viewModel.onSearchLocation(
            SearchLocationEntity(
                name = "Toronto",
                country = "Canada",
                latitude = 43.6532,
                longitude = -79.3832
            )
        )
        coVerify(atLeast = 1) { weatherRepository.getWeather(any(), any()) }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `should update search results on query change`() = runTest {
        val newQuery = "New Query"
        val city = "Toronto"
        val country = "Canada"
        coEvery {
            locationRepository.searchLocation(any())
        } returns Response.Success(
            listOf(
                SearchLocationEntity(
                    name = city,
                    country = country,
                    latitude = 43.6532,
                    longitude = -79.3832
                ),
            )
        )

        viewModel.onSearchQueryChange(newQuery)
        advanceUntilIdle()
        val updatedUiState = viewModel.uiState.value
        assert(updatedUiState.searchLocations.any { it.name == city })
    }
}