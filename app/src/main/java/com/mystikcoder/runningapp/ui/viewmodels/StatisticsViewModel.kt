package com.mystikcoder.runningapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.mystikcoder.runningapp.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(

    private val mainRepository: MainRepository

) : ViewModel() {

    val totalTimeRun = mainRepository.getTotalTimeInMilliseconds()
    val totalDistance = mainRepository.getTotalDistance()
    val totalCalorieBurned = mainRepository.getTotalCaloriesBurned()
    val totalAvgSpeed = mainRepository.getTotalAvgSpeed()

    val runsSortedByDate = mainRepository.getAllRunsSortedByDate()
}