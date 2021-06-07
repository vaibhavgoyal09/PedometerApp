package com.mystikcoder.runningapp.utilities

import android.content.Context
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import com.mystikcoder.runningapp.database.Run
import kotlinx.android.synthetic.main.marker_view.view.*
import kotlinx.android.synthetic.main.marker_view.view.tvCalories
import kotlinx.android.synthetic.main.marker_view.view.tvDate
import kotlinx.android.synthetic.main.marker_view.view.tvDistance
import java.text.SimpleDateFormat
import java.util.*

class CustomMarkerView(
    private val runs: List<Run>,
    c: Context,
    layoutId: Int
) : MarkerView(c, layoutId) {

    override fun getOffset(): MPPointF {
        return MPPointF(-width/ 2f, -height.toFloat())

    }

    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        super.refreshContent(e, highlight)
        if (e == null){
            return
        }
        val curRunId= e.x.toInt()
        val run = runs[curRunId]

        val calendar = Calendar.getInstance().apply {
            timeInMillis= run.timeStamp
        }
        val dateFormat = SimpleDateFormat("dd.MM.yy" , Locale.getDefault())
        tvDate.text = dateFormat.format(calendar.time)

        val avgSpeed= "${run.avgSpeedInKMHs}km/h"
        tvAverageSpeed.text= avgSpeed

        val distanceInKm = "${run.distanceInMeters / 1000f}km"

        tvDistance.text =distanceInKm

        tvDuration.text= TrackingUtility.getFormattedStopwatchTime(run.timeInMilliseconds)

        val caloriesBurned = "${run.calorieBurned}Kcal"

        tvCalories.text= caloriesBurned
    }

}