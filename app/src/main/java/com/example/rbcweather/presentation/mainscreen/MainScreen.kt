@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.rbcweather.presentation.mainscreen

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.rbcweather.R
import com.example.rbcweather.domain.WeatherDailyInfo
import com.example.rbcweather.domain.repository.SearchLocationEntity
import com.example.rbcweather.presentation.utils.PermissionUtil.checkPermission
import com.example.rbcweather.presentation.utils.PermissionUtil.openAppSettings

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel,
    onDayClick: (WeatherDailyInfo) -> Unit = {},
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    val locationPermissionResultLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            viewModel.onPermissionGranted(isGranted = isGranted)
        }
    )
    LaunchedEffect(Unit) {
        checkPermission(
            context = context,
            locationPermissionResultLauncher = locationPermissionResultLauncher,
            viewModel = viewModel
        )
    }

    MainScreenBody(
        modifier = modifier,
        uiState = uiState,
        onDayClick = onDayClick,
        onSearchQueryChange = viewModel::onSearchQueryChange,
        onSearchLocation = viewModel::onSearchLocation,
        onRefresh = {
            checkPermission(
                context = context,
                locationPermissionResultLauncher = locationPermissionResultLauncher,
                viewModel = viewModel
            )
            viewModel.loadWeatherInfo()
        },
        onEmptyStateClick = { openAppSettings(context) }
    )
}

@Composable
fun MainScreenBody(
    modifier: Modifier = Modifier,
    uiState: MainScreenUiState,
    onDayClick: (WeatherDailyInfo) -> Unit = {},
    onSearchQueryChange: (String) -> Unit = {},
    onSearchLocation: (SearchLocationEntity) -> Unit = {},
    onRefresh: () -> Unit = {},
    onEmptyStateClick: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            LocationSearchBar(
                searchResults = uiState.searchLocations,
                onQueryChanged = { query -> onSearchQueryChange(query) },
                onSearchResultClick = { search -> onSearchLocation(search) }
            )
        }
    ) { innerPadding ->
        PullToRefreshBox(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.primaryContainer
                        )
                    )
                )
                .padding(innerPadding),
            onRefresh = onRefresh,
            isRefreshing = uiState.isLoading
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                when {
                    (uiState.weatherInfo == null && !uiState.isLoading) -> {
                        Text(
                            color = Color.White,
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center,
                            text = stringResource(if (uiState.isPermissionGranted) R.string.empty_screen_message else R.string.location_permission_message),
                            modifier = Modifier
                                .padding(top = 80.dp)
                                .clickable(
                                    enabled = !uiState.isPermissionGranted,
                                    onClick = onEmptyStateClick
                                )
                        )
                    }

                    else -> {
                        MainScreenContent(
                            weatherInfo = uiState.weatherInfo,
                            onDayClick = onDayClick,
                            locationName = uiState.locationName,
                            innerPadding = innerPadding,
                            modifier = modifier
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreenBodyPreview(modifier: Modifier = Modifier) {
    MainScreenBody(
        uiState = MainScreenUiState(),
        modifier = modifier,
    )
}