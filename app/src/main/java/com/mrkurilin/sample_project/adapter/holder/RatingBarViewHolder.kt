package com.mrkurilin.sample_project.adapter.holder

import android.view.View
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.view.isVisible
import com.mrkurilin.sample_project.R

class RatingBarViewHolder(view: View) : WidgetViewHolder(view) {

    private val actionButton = view.findViewById<Button>(R.id.button_rating_bar_widget)
    private val expandablePart = view.findViewById<RatingBar>(
        R.id.rating_bar_rating_bar_widget
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