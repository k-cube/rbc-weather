package com.example.rbcweather.presentation

import androidx.lifecycle.ViewModel
import com.example.rbcweather.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: WeatherRepository,

) : ViewModel(

) {
}