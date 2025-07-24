package com.example.rbcweather.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.rbcweather.domain.WeatherDailyInfo
import com.example.rbcweather.presentation.detailscreen.WeatherDetailsScreen
import com.example.rbcweather.presentation.mainscreen.MainScreen
import kotlin.reflect.typeOf

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = MainScreen
    ) {
        composable<MainScreen> {
            MainScreen(
                onDayClick = {
                    navController.navigate(DetailScreen(it))
                },
                viewModel = hiltViewModel()

            )
        }
        composable<DetailScreen>(
            typeMap = mapOf(
                typeOf<WeatherDailyInfo>() to CustomNavType.weatherType
            )
        ) { entry ->
            val args = entry.toRoute<DetailScreen>()
            WeatherDetailsScreen(
                weatherInfo = args.weather
            )
        }
    }
}