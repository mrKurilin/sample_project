package com.mrkurilin.sample_project.adapter.holder

import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.mrkurilin.sample_project.R

class CheckBoxViewHolder(view: View) : WidgetViewHolder(view) {

    private val actionButton = view.findViewById<Button>(R.id.button_checkbox_widget)
    private val expandableLayout = view.findViewById<LinearLayout>(
        R.id.expandable_layout_checkbox_widget
    )

    override fun bind() {
        actionButton.setOnClickListener {
            if (expandableLayout.visibility == View.GONE) {
                expandableLayout.visibility = View.VISIBLE
            } else {
                expandableLayout.visibility = View.GONE
            }
        }
    }
}