package com.mystikcoder.runningapp.database

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "running_table")
data class Run(
    var img: Bitmap? = null,
    var timeStamp: Long = 0L,
    var avgSpeedInKMHs: Float = 0f,
    var distanceInMeters: Int = 0,
    var timeInMilliseconds: Long = 0L,
    var calorieBurned: Int = 0
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}