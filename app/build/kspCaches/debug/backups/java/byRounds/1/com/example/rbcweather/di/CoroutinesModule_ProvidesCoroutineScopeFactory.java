package com.example.rbcweather.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({
    "com.example.rbcweather.di.ApplicationScope",
    "com.example.rbcweather.di.DefaultDispatcher"
})
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
public final class CoroutinesModule_ProvidesCoroutineScopeFactory implements Factory<CoroutineScope> {
  private final Provider<CoroutineDispatcher> dispatcherProvider;

  public CoroutinesModule_ProvidesCoroutineScopeFactory(
      Provider<CoroutineDispatcher> dispatcherProvider) {
    this.dispatcherProvider = dispatcherProvider;
  }

  @Override
  public CoroutineScope get() {
    return providesCoroutineScope(dispatcherProvider.get());
  }

  public static CoroutinesModule_ProvidesCoroutineScopeFactory create(
      Provider<CoroutineDispatcher> dispatcherProvider) {
    return new CoroutinesModule_ProvidesCoroutineScopeFactory(dispatcherProvider);
  }

  public static CoroutineScope providesCoroutineScope(CoroutineDispatcher dispatcher) {
    return Preconditions.checkNotNullFromProvides(CoroutinesModule.INSTANCE.providesCoroutineScope(dispatcher));
  }
}
