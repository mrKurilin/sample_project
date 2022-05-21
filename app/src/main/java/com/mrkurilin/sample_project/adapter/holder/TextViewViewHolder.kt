package com.mrkurilin.sample_project.adapter.holder

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import com.mrkurilin.sample_project.R

class TextViewViewHolder(view: View) : WidgetViewHolder(view) {

    private val actionButton = view.findViewById<Button>(R.id.button_textview_widget)
    private val expandablePart = view.findViewById<TextView>(
        R.id.textview_textview_widget
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