package com.example.rbcweather.presentation.detailscreen

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.rbcweather.R
import com.example.rbcweather.presentation.mainscreen.MainScreenBody
import com.example.rbcweather.presentation.mainscreen.MainScreenContent
import com.example.rbcweather.presentation.mainscreen.MainScreenUiState
import com.example.rbcweather.presentation.utils.FakeWeather
import com.example.rbcweather.presentation.utils.FakeWeatherDailyInfo
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WeatherDetailScreenTest {

    @get:Rule
    val rule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun shouldShowLocationInfo() {
        val iconContentDescription = FakeWeatherDailyInfo.displayInfo.first().name
        val weatherInfoHeader = rule.activity.getString(R.string.weather_overview)
        rule.setContent { WeatherDetailsScreen(weatherInfo = FakeWeatherDailyInfo) }
        rule.onNodeWithContentDescription(iconContentDescription).assertIsDisplayed()
        rule.onNodeWithText(weatherInfoHeader).assertIsDisplayed()
    }
}