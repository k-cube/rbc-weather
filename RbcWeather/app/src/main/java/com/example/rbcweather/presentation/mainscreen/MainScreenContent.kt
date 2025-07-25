package com.example.rbcweather.presentation.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rbcweather.domain.WeatherDailyInfo
import com.example.rbcweather.domain.WeatherEntity
import com.example.rbcweather.presentation.utils.FakeWeather

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenContent(
    modifier: Modifier = Modifier,
    weatherInfo: WeatherEntity? = null,
    locationName: String? = null,
    onDayClick: (WeatherDailyInfo) -> Unit = {},
    innerPadding: PaddingValues = PaddingValues(0.dp)
) {
    Box(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when {
                weatherInfo != null -> {
                    locationName?.let { locationName ->
                        Text(
                            locationName,
                            modifier = modifier.padding(top = 24.dp),
                            fontSize = 32.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    MainScreenHeader(
                        modifier = modifier.padding(top = 24.dp),
                        weatherInfo = weatherInfo,
                    )
                    HourlyChart(
                        modifier = modifier,
                        weatherInfo = weatherInfo,
                    )
                    MainScreenDaily(
                        modifier = modifier,
                        weatherInfo = weatherInfo,
                        onDayClick = onDayClick
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenContentPreview(modifier: Modifier = Modifier) {
    MainScreenContent(
        weatherInfo = FakeWeather,
        locationName = "New York",
        modifier = modifier,
        onDayClick = {}
    )
}
