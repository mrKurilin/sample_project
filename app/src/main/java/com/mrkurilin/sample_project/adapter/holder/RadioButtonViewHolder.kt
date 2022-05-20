package com.mrkurilin.sample_project.adapter.holder

import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import com.mrkurilin.sample_project.R

class RadioButtonViewHolder(view: View) : WidgetViewHolder(view) {

    private val actionButton = view.findViewById<Button>(R.id.button_radio_button_widget)
    private val expandablePart = view.findViewById<RadioGroup>(
        R.id.radio_group_radiobutton_widget
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