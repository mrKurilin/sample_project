package com.mrkurilin.sample_project.adapter.holder

import android.view.View
import android.widget.*
import androidx.core.view.isVisible
import com.mrkurilin.sample_project.R

class SeekBarViewHolder(view: View) : WidgetViewHolder(view) {

    private val actionButton = view.findViewById<Button>(R.id.button_seekbar_widget)
    private val expandablePart = view.findViewById<LinearLayout>(
        R.id.linearlayout_seekbar_widget
    )
    private val textView = view.findViewById<TextView>(R.id.textview_seekbar_widget)
    private val seekBar = view.findViewById<SeekBar>(R.id.seekbar_seekbar_widget)
    private var isExpanded = false

    init {
        actionButton.setOnClickListener {
            isExpanded = !isExpanded
            expandablePart.isVisible = isExpanded
        }
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(view.context, "onStartTrackingTouch", Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(view.context, "onStopTrackingTouch", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun bind() {
        expandablePart.isVisible = isExpanded
    }
}