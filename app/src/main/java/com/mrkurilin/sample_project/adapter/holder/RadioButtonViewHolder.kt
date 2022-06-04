package com.mrkurilin.sample_project.adapter.holder

import android.graphics.Color
import android.view.View
import android.widget.RadioGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.R

class RadioButtonViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val radioGroup = view.findViewById<RadioGroup>(R.id.radio_group_radiobutton_widget)
    private val viewToChangeColor = view.findViewById<View>(R.id.view_radiobutton_widget)

    private val listener = RadioGroup.OnCheckedChangeListener { _, checkedId ->
        when (checkedId) {
            R.id.red_radiobutton_radiobutton_widget -> viewToChangeColor.setBackgroundColor(Color.RED)
            R.id.green_radiobutton_radiobutton_widget -> viewToChangeColor.setBackgroundColor(Color.GREEN)
            R.id.blue_radiobutton_radiobutton_widget -> viewToChangeColor.setBackgroundColor(Color.BLUE)
        }
    }

    init {
        radioGroup.setOnCheckedChangeListener(listener)
    }
}