package com.mrkurilin.sample_project.adapter.holder

import android.graphics.Color
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.R

class SeekBarViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val viewToChangeColor: View = view.findViewById(R.id.view_seekbar_widget)
    private val onSeekBarChangeListener by lazy { createOnSeekBarChangeListener() }
    private var redColor = 0
    private var greenColor = 0
    private var blueColor = 0

    init {
        view.findViewById<ConstraintLayout>(R.id.constraint_layout_seekbar_widget)
            .children
            .forEach { childView ->
            if (childView is SeekBar) childView.setOnSeekBarChangeListener(onSeekBarChangeListener)
        }
    }

    private fun createOnSeekBarChangeListener() : SeekBar.OnSeekBarChangeListener{
        return object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                when (seekBar.id) {
                    R.id.seekbar_red_seekbar_widget -> {
                        redColor = progress
                    }
                    R.id.seekbar_green_seekbar_widget -> {
                        greenColor = progress
                    }
                    R.id.seekbar_blue_seekbar_widget -> {
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
        viewToChangeColor.setBackgroundColor(Color.rgb(redColor, greenColor, blueColor))
    }
}