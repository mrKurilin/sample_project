package com.mrkurilin.sample_project.adapter.holder

import android.view.View
import android.widget.Button
import android.widget.Spinner
import androidx.core.view.isVisible
import com.mrkurilin.sample_project.R

class SpinnerViewHolder(view: View) : WidgetViewHolder(view) {

    private val actionButton = view.findViewById<Button>(R.id.button_spinner_widget)
    private val expandablePart = view.findViewById<Spinner>(
        R.id.spinner_spinner_widget
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