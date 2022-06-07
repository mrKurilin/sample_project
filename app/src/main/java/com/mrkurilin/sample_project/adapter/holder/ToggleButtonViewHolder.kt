package com.mrkurilin.sample_project.adapter.holder

import android.graphics.Color
import android.view.View
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.R

class ToggleButtonViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textToggleButton: ToggleButton = view.findViewById(
        R.id.toggle_button_text_toggle_button_widget
    )
    private val contentToggleButton: ToggleButton = view.findViewById(
        R.id.toggle_button_content_toggle_button_widget
    )
    private val backgroundToggleButton: ToggleButton = view.findViewById(
        R.id.toggle_button_background_toggle_button_widget
    )

    private val circleDrawable = ContextCompat.getDrawable(view.context, R.drawable.circle)
    private val rectangleDrawable = ContextCompat.getDrawable(view.context, R.drawable.rectangle)

    private val imageViewToggleButtonWidget: ImageView = view.findViewById(
        R.id.imageview_toggle_button_widget
    )
    private val textViewToggleButtonWIdget: TextView = view.findViewById(
        R.id.textview_toggle_button_widget
    )

    private val onCheckedChangeListener by lazy { createOnCheckedChangeListener() }

    init {
        textToggleButton.setOnCheckedChangeListener(onCheckedChangeListener)
        contentToggleButton.setOnCheckedChangeListener(onCheckedChangeListener)
        backgroundToggleButton.setOnCheckedChangeListener(onCheckedChangeListener)
    }

    private fun createOnCheckedChangeListener(): CompoundButton.OnCheckedChangeListener {
        return CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            when (buttonView) {
                textToggleButton -> setTextColor(isChecked)
                contentToggleButton -> setContent(isChecked)
                backgroundToggleButton -> setImageViewBackground(isChecked)
            }
        }
    }

    private fun setTextColor(checked: Boolean) {
        textViewToggleButtonWIdget.setTextColor(
            if (checked) {
                Color.BLACK
            } else {
                Color.TRANSPARENT
            }
        )
    }

    private fun setContent(checked: Boolean) {
        imageViewToggleButtonWidget.setImageResource(
            if (checked) {
                R.drawable.ic_baseline_self_improvement_24
            } else {
                Color.TRANSPARENT
            }
        )
    }

    private fun setImageViewBackground(checked: Boolean) {
        imageViewToggleButtonWidget.background =
            if (checked) {
                circleDrawable
            } else {
                rectangleDrawable
            }
    }
}