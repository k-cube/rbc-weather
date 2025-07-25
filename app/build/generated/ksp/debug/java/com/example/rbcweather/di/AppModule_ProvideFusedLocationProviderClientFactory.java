package com.example.rbcweather.di;

import android.app.Application;
import com.google.android.gms.location.FusedLocationProviderClient;
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
public final class AppModule_ProvideFusedLocationProviderClientFactory implements Factory<FusedLocationProviderClient> {
  private final Provider<Application> appProvider;

  public AppModule_ProvideFusedLocationProviderClientFactory(Provider<Application> appProvider) {
    this.appProvider = appProvider;
  }

  @Override
  public FusedLocationProviderClient get() {
    return provideFusedLocationProviderClient(appProvider.get());
  }

  public static AppModule_ProvideFusedLocationProviderClientFactory create(
      Provider<Application> appProvider) {
    return new AppModule_ProvideFusedLocationProviderClientFactory(appProvider);
  }

  public static FusedLocationProviderClient provideFusedLocationProviderClient(Application app) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideFusedLocationProviderClient(app));
  }
}
