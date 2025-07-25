package com.example.rbcweather.data.repository;

import com.example.rbcweather.data.network.WeatherApi;
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
public final class WeatherRepositoryImpl_Factory implements Factory<WeatherRepositoryImpl> {
  private final Provider<WeatherApi> apiProvider;

  public WeatherRepositoryImpl_Factory(Provider<WeatherApi> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public WeatherRepositoryImpl get() {
    return newInstance(apiProvider.get());
  }

  public static WeatherRepositoryImpl_Factory create(Provider<WeatherApi> apiProvider) {
    return new WeatherRepositoryImpl_Factory(apiProvider);
  }

  public static WeatherRepositoryImpl newInstance(WeatherApi api) {
    return new WeatherRepositoryImpl(api);
  }
}
