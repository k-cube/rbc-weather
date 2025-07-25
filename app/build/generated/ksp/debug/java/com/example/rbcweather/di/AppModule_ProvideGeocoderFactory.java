package com.example.rbcweather.di;

import android.app.Application;
import android.location.Geocoder;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideGeocoderFactory implements Factory<Geocoder> {
  private final Provider<Application> appProvider;

  public AppModule_ProvideGeocoderFactory(Provider<Application> appProvider) {
    this.appProvider = appProvider;
  }

  @Override
  public Geocoder get() {
    return provideGeocoder(appProvider.get());
  }

  public static AppModule_ProvideGeocoderFactory create(Provider<Application> appProvider) {
    return new AppModule_ProvideGeocoderFactory(appProvider);
  }

  public static Geocoder provideGeocoder(Application app) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideGeocoder(app));
  }
}
