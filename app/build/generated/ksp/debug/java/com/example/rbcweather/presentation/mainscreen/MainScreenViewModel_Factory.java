package com.example.rbcweather.presentation.mainscreen;

import android.location.Geocoder;
import com.example.rbcweather.domain.repository.LocationRepository;
import com.example.rbcweather.domain.repository.WeatherRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata
@QualifierMetadata("com.example.rbcweather.di.MainDispatcher")
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
public final class MainScreenViewModel_Factory implements Factory<MainScreenViewModel> {
  private final Provider<WeatherRepository> weatherRepositoryProvider;

  private final Provider<LocationRepository> locationRepositoryProvider;

  private final Provider<Geocoder> geocoderProvider;

  private final Provider<CoroutineDispatcher> mainDispatcherProvider;

  public MainScreenViewModel_Factory(Provider<WeatherRepository> weatherRepositoryProvider,
      Provider<LocationRepository> locationRepositoryProvider, Provider<Geocoder> geocoderProvider,
      Provider<CoroutineDispatcher> mainDispatcherProvider) {
    this.weatherRepositoryProvider = weatherRepositoryProvider;
    this.locationRepositoryProvider = locationRepositoryProvider;
    this.geocoderProvider = geocoderProvider;
    this.mainDispatcherProvider = mainDispatcherProvider;
  }

  @Override
  public MainScreenViewModel get() {
    return newInstance(weatherRepositoryProvider.get(), locationRepositoryProvider.get(), geocoderProvider.get(), mainDispatcherProvider.get());
  }

  public static MainScreenViewModel_Factory create(
      Provider<WeatherRepository> weatherRepositoryProvider,
      Provider<LocationRepository> locationRepositoryProvider, Provider<Geocoder> geocoderProvider,
      Provider<CoroutineDispatcher> mainDispatcherProvider) {
    return new MainScreenViewModel_Factory(weatherRepositoryProvider, locationRepositoryProvider, geocoderProvider, mainDispatcherProvider);
  }

  public static MainScreenViewModel newInstance(WeatherRepository weatherRepository,
      LocationRepository locationRepository, Geocoder geocoder,
      CoroutineDispatcher mainDispatcher) {
    return new MainScreenViewModel(weatherRepository, locationRepository, geocoder, mainDispatcher);
  }
}
