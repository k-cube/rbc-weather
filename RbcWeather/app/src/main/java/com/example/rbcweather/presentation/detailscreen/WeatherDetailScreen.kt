package com.example.rbcweather.presentation.detailscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rbcweather.R
import com.example.rbcweather.domain.WeatherDailyInfo
import com.example.rbcweather.presentation.utils.FakeWeatherDailyInfo

@Composable
fun WeatherDetailsScreen(
    modifier: Modifier = Modifier,
    weatherInfo: WeatherDailyInfo
) {
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.primaryContainer
                        )
                    )
                )
                .padding(top = 16.dp)
                .fillMaxSize()
        ) {
            LazyVerticalGrid(
                modifier = modifier.padding(innerPadding),
                columns = GridCells.Fixed(2)
            ) {
                item(
                    span = {
                        GridItemSpan(maxLineSpan)
                    }
                ) {
                    Row(horizontalArrangement = Arrangement.Center) {
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                stringResource(R.string.weather_overview),
                                fontSize = 32.sp,
                                fontWeight = FontWeight.W300,
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.surface,
                                modifier = Modifier.padding(top = 32.dp),
                                textAlign = TextAlign.Center
                            )

                            Text(
                                weatherInfo.date,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.W300,
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.surface,
                                modifier = Modifier.padding(8.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
                items(weatherInfo.displayInfo) { displayInfo ->
                    WeatherDetailsInfoCard(displayInfo = displayInfo)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherDetailsScreenPreview() {
    WeatherDetailsScreen(
        weatherInfo = FakeWeatherDailyInfo
    )
}
