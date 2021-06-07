package com.mystikcoder.runningapp.repository

import com.mystikcoder.runningapp.database.Run
import com.mystikcoder.runningapp.database.RunDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val runDao: RunDao
) {
    suspend fun insertRun(run: Run)= runDao.insertRun(run)

    fun getAllRunsSortedByDate() =runDao.getAllRunsSortedByDate()

    fun getAllRunsSortedByDistance()= runDao.getAllRunsSortedByDistance()

    fun getAllRunsSortedByAvgSpeed()= runDao.getAllRunsSortedByAvgSpeed()

    fun getAllRunsSortedByCaloriesBurned()= runDao.getAllRunsSortedByCaloriesBurned()

    fun getAllRunsSortedByTimeInMilliseconds() = runDao.getAllRunsSortedByTimeInMilliseconds()

    fun getTotalAvgSpeed() =runDao.getTotalAvgSpeed()

    fun getTotalDistance() =runDao.getTotalDistance()

    fun getTotalTimeInMilliseconds() = runDao.getTotalTimeInMilliseconds()

    fun getTotalCaloriesBurned()= runDao.getTotalCaloriesBurned()
}