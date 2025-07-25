package com.example.rbcweather.data.repository

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.location.Location
import android.location.LocationManager
import com.example.rbcweather.data.network.GeocodingApi
import com.example.rbcweather.domain.Response
import com.example.rbcweather.domain.repository.LocationRepository
import com.example.rbcweather.domain.repository.SearchLocationEntity
import com.google.android.gms.location.FusedLocationProviderClient
import jakarta.inject.Inject
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class LocationRepositoryImpl @Inject constructor(
    private val fusedLocationProviderClient: FusedLocationProviderClient,
    private val geocodingApi: GeocodingApi,
    private val application: Application
) : LocationRepository {
    @SuppressLint("MissingPermission")
    override suspend fun getCurrentLocation(): Response<SearchLocationEntity?> {

        val locationManager = application.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        if (!isGpsEnabled) {
            return Response.Error("GPS is disabled")
        }

        return suspendCancellableCoroutine { cont ->
            fusedLocationProviderClient.lastLocation.apply {
                if (isComplete) {
                    if (isSuccessful) {
                        cont.resume(Response.Success(result?.toSearchLocationEntity()))
                    } else {
                        cont.resume(Response.Error("Something went wrong, can't get location"))
                    }
                    return@suspendCancellableCoroutine
                }
                addOnSuccessListener {
                    cont.resume(Response.Success(it?.toSearchLocationEntity()))
                }
                addOnFailureListener {
                    cont.resume(Response.Error("Something went wrong, can't get location"))
                }
                addOnCanceledListener {
                    cont.cancel()
                }
            }
        }
    }

    override suspend fun searchLocation(query: String): Response<List<SearchLocationEntity>> {
        try {
            val searchLocationsResponse = geocodingApi.getSearchLocations(query)
            return (Response.Success(searchLocationsResponse.results.map {
                SearchLocationEntity(
                    name = it.name,
                    country = it.country,
                    latitude = it.latitude,
                    longitude = it.longitude
                )
            }))
        } catch (e: Exception) {
            return Response.Error(e.message ?: "Something went wrong")
        }
    }

    private fun Location.toSearchLocationEntity(): SearchLocationEntity {
        return SearchLocationEntity(
            latitude = latitude,
            longitude = longitude
        )
    }
}