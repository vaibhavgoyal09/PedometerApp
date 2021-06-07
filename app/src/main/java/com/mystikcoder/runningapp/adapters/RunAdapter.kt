package com.mystikcoder.runningapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mystikcoder.runningapp.R
import com.mystikcoder.runningapp.database.Run
import com.mystikcoder.runningapp.utilities.TrackingUtility
import kotlinx.android.synthetic.main.item_run.view.*
import java.text.SimpleDateFormat
import java.util.*

class RunAdapter : RecyclerView.Adapter<RunAdapter.RunViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Run>() {

        override fun areItemsTheSame(oldItem: Run, newItem: Run): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Run, newItem: Run): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

    }

    val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list: List<Run>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunViewHolder {
        return RunViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_run,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RunViewHolder, position: Int) {
        val run =differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(run.img).into(ivRunImage)

            val calendar = Calendar.getInstance().apply {
                timeInMillis= run.timeStamp
            }
            val dateFormat = SimpleDateFormat("dd.MM.yy" , Locale.getDefault())
            tvDate.text = dateFormat.format(calendar.time)

            val avgSpeed= "${run.avgSpeedInKMHs}km/h"
            tvAvgSpeed.text= avgSpeed

            val distanceInKm = "${run.distanceInMeters / 1000f}km"

            tvDistance.text =distanceInKm

            tvTime.text= TrackingUtility.getFormattedStopwatchTime(run.timeInMilliseconds)

            val caloriesBurned = "${run.calorieBurned}Kcal"

            tvCalories.text= caloriesBurned
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    class RunViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}