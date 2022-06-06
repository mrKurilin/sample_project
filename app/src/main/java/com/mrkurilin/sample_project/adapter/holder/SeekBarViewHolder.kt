package com.mrkurilin.sample_project.adapter.holder

import android.graphics.Color
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.R

class SeekBarViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val redSeekBar: SeekBar = view.findViewById(R.id.seekbar_red_seekbar_widget)
    private val greenSeekBar: SeekBar = view.findViewById(R.id.seekbar_green_seekbar_widget)
    private val blueSeekBar: SeekBar = view.findViewById(R.id.seekbar_blue_seekbar_widget)
    private val colorSampleView: View = view.findViewById(R.id.view_seekbar_widget)
    private val onSeekBarChangeListener by lazy { createOnSeekBarChangeListener() }
    private var redColor = 0
    private var greenColor = 0
    private var blueColor = 0

    init {
        redSeekBar.setOnSeekBarChangeListener(onSeekBarChangeListener)
        greenSeekBar.setOnSeekBarChangeListener(onSeekBarChangeListener)
        blueSeekBar.setOnSeekBarChangeListener(onSeekBarChangeListener)
    }

    private fun createOnSeekBarChangeListener() : SeekBar.OnSeekBarChangeListener{
        return object : SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                when (seekBar) {
                    redSeekBar-> {
                        redColor = progress
                    }
                    greenSeekBar -> {
                        greenColor = progress
                    }
                    blueSeekBar -> {
                        blueColor = progress
                    }
                }
                updateViewColor()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        }
    }

    private fun updateViewColor() {
        val color = Color.rgb(redColor, greenColor, blueColor)
        colorSampleView.setBackgroundColor(color)
    }
}