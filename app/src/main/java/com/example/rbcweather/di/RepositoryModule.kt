package com.example.rbcweather.di

import com.example.rbcweather.data.repository.LocationRepositoryImpl
import com.example.rbcweather.data.repository.WeatherRepositoryImpl
import com.example.rbcweather.domain.repository.LocationRepository
import com.example.rbcweather.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository

    @Binds
    @Singleton
    abstract fun bindLocationRepository(
        locationRepositoryImpl: LocationRepositoryImpl
    ): LocationRepository
}