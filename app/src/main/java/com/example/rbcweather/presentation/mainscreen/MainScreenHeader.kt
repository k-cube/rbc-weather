package com.example.rbcweather.presentation.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rbcweather.R
import com.example.rbcweather.domain.WeatherEntity
import com.example.rbcweather.presentation.ui.theme.Pink80
import com.example.rbcweather.presentation.ui.theme.Purple80
import com.example.rbcweather.presentation.utils.FakeWeather

@Composable
fun MainScreenHeader(
    modifier: Modifier = Modifier,
    weatherInfo: WeatherEntity
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.padding(16.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(R.string.current_weather), fontSize = 16.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Temperature: ${weatherInfo.temperature}°C")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Rain: ${weatherInfo.rain}mm")
            Spacer(modifier = Modifier.height(16.dp))
            Icon(
                painter = painterResource(
                    if (weatherInfo.isDay) R.drawable.sun else R.drawable.bedtime,
                ),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun MainScreenHeaderPreview() {
    MainScreenHeader(
        weatherInfo = FakeWeather
    )
}