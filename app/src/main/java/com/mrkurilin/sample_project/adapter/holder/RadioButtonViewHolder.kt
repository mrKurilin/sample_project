package com.mrkurilin.sample_project.adapter.holder

import android.graphics.Color
import android.view.View
import android.widget.RadioGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.R

class RadioButtonViewHolder(view: View) : RecyclerView.ViewHolder(view),
    RadioGroup.OnCheckedChangeListener {

    private val radioGroup = view.findViewById<RadioGroup>(R.id.radio_group_radiobutton_widget)
    private val viewColor = view.findViewById<View>(R.id.view_radiobutton_widget)

    init {
        radioGroup.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when (checkedId) {
            R.id.red_radiobutton_radiobutton_widget -> viewColor.setBackgroundColor(Color.RED)
            R.id.green_radiobutton_radiobutton_widget -> viewColor.setBackgroundColor(Color.GREEN)
            R.id.blue_radiobutton_radiobutton_widget -> viewColor.setBackgroundColor(Color.BLUE)
        }
    }
}