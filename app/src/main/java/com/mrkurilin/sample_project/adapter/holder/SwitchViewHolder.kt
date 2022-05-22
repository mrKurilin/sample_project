package com.mrkurilin.sample_project.adapter.holder

import android.view.View
import android.widget.Button
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.isVisible
import com.mrkurilin.sample_project.R

class SwitchViewHolder(view: View) : WidgetViewHolder(view) {

    private val actionButton = view.findViewById<Button>(R.id.button_switch_widget)
    private val expandablePart = view.findViewById<SwitchCompat>(
        R.id.switch_switch_widget
    )
    private var isExpanded = false

    init {
        actionButton.setOnClickListener {
            isExpanded = !isExpanded
            expandablePart.isVisible = isExpanded
        }
    }

    override fun bind() {
        expandablePart.isVisible = isExpanded
    }
}