package com.example.rbcweather.presentation

import android.net.Uri
import androidx.navigation.NavType
import androidx.savedstate.SavedState
import com.example.rbcweather.domain.WeatherDailyInfo
import kotlinx.serialization.json.Json
object CustomNavType {

    val weatherType = object : NavType<WeatherDailyInfo>(isNullableAllowed = false) {
        override fun put(
            bundle: SavedState,
            key: String,
            value: WeatherDailyInfo
        ) {
            bundle.putString(key, Json.encodeToString(value))
        }

        override fun get(
            bundle: SavedState,
            key: String
        ): WeatherDailyInfo? {
            return Json.decodeFromString<WeatherDailyInfo>(bundle.getString(key) ?: return null)
        }

        override fun serializeAsValue(value: WeatherDailyInfo): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun parseValue(value: String): WeatherDailyInfo {
            return Json.decodeFromString(value)
        }
    }
}