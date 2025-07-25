package com.example.rbcweather.data.repository;

import android.app.Application;
import com.example.rbcweather.data.network.GeocodingApi;
import com.google.android.gms.location.FusedLocationProviderClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class LocationRepositoryImpl_Factory implements Factory<LocationRepositoryImpl> {
  private final Provider<FusedLocationProviderClient> fusedLocationProviderClientProvider;

  private final Provider<GeocodingApi> geocodingApiProvider;

  private final Provider<Application> applicationProvider;

  public LocationRepositoryImpl_Factory(
      Provider<FusedLocationProviderClient> fusedLocationProviderClientProvider,
      Provider<GeocodingApi> geocodingApiProvider, Provider<Application> applicationProvider) {
    this.fusedLocationProviderClientProvider = fusedLocationProviderClientProvider;
    this.geocodingApiProvider = geocodingApiProvider;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public LocationRepositoryImpl get() {
    return newInstance(fusedLocationProviderClientProvider.get(), geocodingApiProvider.get(), applicationProvider.get());
  }

  public static LocationRepositoryImpl_Factory create(
      Provider<FusedLocationProviderClient> fusedLocationProviderClientProvider,
      Provider<GeocodingApi> geocodingApiProvider, Provider<Application> applicationProvider) {
    return new LocationRepositoryImpl_Factory(fusedLocationProviderClientProvider, geocodingApiProvider, applicationProvider);
  }

  public static LocationRepositoryImpl newInstance(
      FusedLocationProviderClient fusedLocationProviderClient, GeocodingApi geocodingApi,
      Application application) {
    return new LocationRepositoryImpl(fusedLocationProviderClient, geocodingApi, application);
  }
}
