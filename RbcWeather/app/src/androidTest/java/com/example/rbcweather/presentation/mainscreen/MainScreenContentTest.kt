package com.example.rbcweather.presentation.mainscreen

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.rbcweather.R
import com.example.rbcweather.presentation.utils.FakeWeather
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainScreenContentTest {

    @get:Rule
    val rule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun shouldShowLocationName() {
        val locationName = "Toronto"
        val currentWeather = rule.activity.getString(R.string.current_weather)
        rule.setContent { MainScreenContent(locationName = locationName, weatherInfo = FakeWeather) }
        rule.onNodeWithText(locationName).assertIsDisplayed()
        rule.onNodeWithText(currentWeather).assertIsDisplayed()

    }

    @Test
    fun emptyStateShouldShowWhenNoData() {
        val emptyString = rule.activity.getString(R.string.empty_screen_message)
        rule.setContent {
            MainScreenBody(
                uiState = MainScreenUiState(isLoading = false, isPermissionGranted = true)
            )
        }
        rule.onNodeWithText(emptyString).assertIsDisplayed()
    }

    @Test
    fun locationMessageShouldShowAndClickableWhenPermissionIsNotGranted() {
        val permissionMessage = rule.activity.getString(R.string.location_permission_message)
        rule.setContent {
            MainScreenBody(
                uiState = MainScreenUiState(isLoading = false, isPermissionGranted = false)
            )
        }
        val permissionNode = rule.onNodeWithText(permissionMessage)
        permissionNode.assertIsDisplayed()
        permissionNode.assertHasClickAction()
    }
}