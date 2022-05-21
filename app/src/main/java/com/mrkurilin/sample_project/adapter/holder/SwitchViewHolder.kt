package com.mrkurilin.sample_project.adapter.holder

import android.view.View
import android.widget.Button
import androidx.appcompat.widget.SwitchCompat
import com.mrkurilin.sample_project.R

class SwitchViewHolder(view: View) : WidgetViewHolder(view) {

    private val actionButton = view.findViewById<Button>(R.id.button_switch_widget)
    private val expandablePart = view.findViewById<SwitchCompat>(
        R.id.switch_switch_widget
    )
    private var isExpanded = false

    init {
        actionButton.setOnClickListener {
            if (expandablePart.visibility == View.GONE) {
                expandablePart.visibility = View.VISIBLE
                isExpanded = true
            } else {
                expandablePart.visibility = View.GONE
                isExpanded = false
            }
        }
    }

    override fun bind() {
        if (isExpanded) expandablePart.visibility = View.VISIBLE
    }
}