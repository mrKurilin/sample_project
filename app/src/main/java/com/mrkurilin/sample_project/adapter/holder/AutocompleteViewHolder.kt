package com.mrkurilin.sample_project.adapter.holder

import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.core.view.isVisible
import com.mrkurilin.sample_project.R

class AutocompleteViewHolder(view: View) : WidgetViewHolder(view) {

    private val actionButton = view.findViewById<Button>(R.id.button_autocomplete_textview_widget)
    private val expandablePart = view.findViewById<AutoCompleteTextView>(
        R.id.autocomplete_textview_widget
    )
    private var isExpanded = false

    private val autoCompleteStringArray = view.resources.getStringArray(R.array.widgets_auto_complete_sample)

    init {
        val adapter = ArrayAdapter(
            view.context,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            autoCompleteStringArray
        )
        expandablePart.setAdapter(adapter)
        expandablePart.threshold = 1
        actionButton.setOnClickListener {
            isExpanded = !isExpanded
            expandablePart.isVisible = isExpanded
        }
    }

    override fun bind() {
        expandablePart.isVisible = isExpanded
    }
}