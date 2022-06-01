package com.mrkurilin.sample_project.adapter.holder

import android.graphics.Color
import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.R

class CheckBoxViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var redColor = 0
    private var greenColor = 0
    private var blueColor = 0
    private val viewColor = view.findViewById<View>(R.id.view_checkbox_widget)

    private val listener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
        when (buttonView.id) {
            R.id.checkbox_red_checkbox_widget -> redColor = if (isChecked) 255 else 0
            R.id.checkbox_green_checkbox_widget -> greenColor = if (isChecked) 255 else 0
            R.id.checkbox_blue_checkbox_widget -> blueColor = if (isChecked) 255 else 0
        }
        updateUI()
    }

    init {
        view.findViewById<CheckBox>(R.id.checkbox_red_checkbox_widget).setOnCheckedChangeListener(listener)
        view.findViewById<CheckBox>(R.id.checkbox_green_checkbox_widget).setOnCheckedChangeListener(listener)
        view.findViewById<CheckBox>(R.id.checkbox_blue_checkbox_widget).setOnCheckedChangeListener(listener)
    }

    private fun updateUI() {
        viewColor.setBackgroundColor(Color.rgb(redColor, greenColor, blueColor))
    }
}