package com.mrkurilin.sample_project.adapter.holder

import android.view.View
import android.widget.Button
import android.widget.TextView
import com.mrkurilin.sample_project.R

class TextViewViewHolder(view: View) : WidgetViewHolder(view) {

    private val actionButton = view.findViewById<Button>(R.id.button_textview_widget)
    private val expandablePart = view.findViewById<TextView>(
        R.id.textview_textview_widget
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