package com.example.rbcweather.presentation.mainscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rbcweather.domain.WeatherDailyInfo
import com.example.rbcweather.domain.WeatherEntity
import com.example.rbcweather.presentation.utils.FakeWeather
import com.example.rbcweather.presentation.utils.toDisplayDate

@Composable
fun MainScreenDaily(
    modifier: Modifier = Modifier,
    weatherInfo: WeatherEntity,
    onDayClick: (WeatherDailyInfo) -> Unit = {}
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {

            for (i in 0..6) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.background,
                    ),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable(
                                onClick = {
                                    onDayClick(weatherInfo.dailyInfo[i])
                                }
                            ),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(weatherInfo.dailyDate[i].toDisplayDate())
                        Text("min: ${weatherInfo.dailyTemperatureMin[i]}°C")
                        Text("max: ${weatherInfo.dailyTemperatureMax[i]}°C")
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenDailyPreview(modifier: Modifier = Modifier) {
    MainScreenDaily(
        weatherInfo = FakeWeather
    )
}
