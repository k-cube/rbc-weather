package com.example.rbcweather.presentation;

import com.example.rbcweather.domain.repository.WeatherRepository;
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
public final class MainScreenViewModel_Factory implements Factory<MainScreenViewModel> {
  private final Provider<WeatherRepository> repositoryProvider;

  public MainScreenViewModel_Factory(Provider<WeatherRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public MainScreenViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static MainScreenViewModel_Factory create(Provider<WeatherRepository> repositoryProvider) {
    return new MainScreenViewModel_Factory(repositoryProvider);
  }

  public static MainScreenViewModel newInstance(WeatherRepository repository) {
    return new MainScreenViewModel(repository);
  }
}
