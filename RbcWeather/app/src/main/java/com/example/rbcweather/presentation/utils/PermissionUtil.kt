package com.example.rbcweather.presentation.utils

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.core.content.ContextCompat
import com.example.rbcweather.presentation.mainscreen.MainScreenViewModel

object PermissionUtil {
    fun checkPermission(
        context: Context,
        locationPermissionResultLauncher: ManagedActivityResultLauncher<String, Boolean>,
        viewModel: MainScreenViewModel
    ) {
        if (!isLocationPermissionGranted(context)) {
            viewModel.onPermissionGranted(isGranted = false)
            locationPermissionResultLauncher.launch(Manifest.permission.ACCESS_COARSE_LOCATION)
        } else {
            viewModel.onPermissionGranted(isGranted = true)
        }
    }

    fun isLocationPermissionGranted(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    fun openAppSettings(context: Context) {
        context.startActivity(
            Intent(
                android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                android.net.Uri.fromParts("package", "com.example.rbcweather", null)

            )
        )
    }
}