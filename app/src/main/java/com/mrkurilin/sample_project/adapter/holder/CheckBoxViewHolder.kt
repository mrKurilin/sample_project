package com.mrkurilin.sample_project.adapter.holder

import android.graphics.Color
import android.view.View
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.R

class CheckBoxViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

    private var redColor = 0
    private var greenColor = 0
    private var blueColor = 0
    private val viewColor = view.findViewById<View>(R.id.view_checkbox_widget)

    init {
        view.findViewById<CheckBox>(R.id.checkbox_red_checkbox_widget).setOnClickListener(this)
        view.findViewById<CheckBox>(R.id.checkbox_green_checkbox_widget).setOnClickListener(this)
        view.findViewById<CheckBox>(R.id.checkbox_blue_checkbox_widget).setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view is CheckBox) {
            when (view.id) {
                R.id.checkbox_red_checkbox_widget -> redColor = if (view.isChecked) 255 else 0
                R.id.checkbox_green_checkbox_widget -> greenColor = if (view.isChecked) 255 else 0
                R.id.checkbox_blue_checkbox_widget -> blueColor = if (view.isChecked) 255 else 0
            }
            updateUI()
        }
    }

    fun updateUI() {
        viewColor.setBackgroundColor(Color.rgb(redColor, greenColor, blueColor))
    }
}