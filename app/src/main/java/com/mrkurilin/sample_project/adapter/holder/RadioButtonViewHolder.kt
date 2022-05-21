package com.mrkurilin.sample_project.adapter.holder

import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import androidx.core.view.isVisible
import com.mrkurilin.sample_project.R

class RadioButtonViewHolder(view: View) : WidgetViewHolder(view) {

    private val actionButton = view.findViewById<Button>(R.id.button_radio_button_widget)
    private val expandablePart = view.findViewById<RadioGroup>(
        R.id.radio_group_radiobutton_widget
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