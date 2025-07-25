package com.example.rbcweather.di;

import com.example.rbcweather.data.network.GeocodingApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class AppModule_ProvideGeoCodingApiFactory implements Factory<GeocodingApi> {
  @Override
  public GeocodingApi get() {
    return provideGeoCodingApi();
  }

  public static AppModule_ProvideGeoCodingApiFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static GeocodingApi provideGeoCodingApi() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideGeoCodingApi());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideGeoCodingApiFactory INSTANCE = new AppModule_ProvideGeoCodingApiFactory();
  }
}
