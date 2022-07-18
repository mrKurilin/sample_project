package com.mrkurilin.sample_project.adapter.holder

import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.R

class AutocompleteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val autoCompleteTextView = view.findViewById<AutoCompleteTextView>(
        R.id.autocomplete_textview_widget
    )
    private val autoCompleteStringArray = view.resources.getStringArray(
        R.array.widgets_auto_complete_sample
    )

    private val adapter = ArrayAdapter(
        view.context,
        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
        autoCompleteStringArray
    )

    init {
        autoCompleteTextView.setAdapter(adapter)
    }
}