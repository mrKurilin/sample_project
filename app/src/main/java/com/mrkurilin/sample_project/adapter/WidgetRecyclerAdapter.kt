package com.mrkurilin.sample_project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.R
import com.mrkurilin.sample_project.adapter.holder.*

private const val WIDGETS_COUNT = 4

private const val CHECKBOX_VIEW_TYPE = 0
private const val RADIOBUTTON_VIEW_TYPE = 1
private const val TEXTVIEW_VIEW_TYPE = 2
private const val RATINGBAR_VIEW_TYPE = 3

private val viewTypes = mapOf(
    CHECKBOX_VIEW_TYPE to 0,
    RADIOBUTTON_VIEW_TYPE to 1,
    TEXTVIEW_VIEW_TYPE to 2,
    RATINGBAR_VIEW_TYPE to 3,
)

class WidgetRecyclerAdapter(
    context: Context
) : RecyclerView.Adapter<WidgetViewHolder>() {
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WidgetViewHolder {
        return when (viewType) {
            CHECKBOX_VIEW_TYPE -> {
                val view = inflater.inflate(R.layout.widget_checkbox, parent, false)
                CheckBoxViewHolder(view)
            }
            RADIOBUTTON_VIEW_TYPE -> {
                val view = inflater.inflate(R.layout.widget_radio_button, parent, false)
                RadioButtonViewHolder(view)
            }
            TEXTVIEW_VIEW_TYPE -> {
                val view = inflater.inflate(R.layout.widget_text_view, parent, false)
                TextViewViewHolder(view)
            }
            RATINGBAR_VIEW_TYPE -> {
                val view = inflater.inflate(R.layout.widget_rating_bar, parent, false)
                RatingBarViewHolder(view)
            }
            else -> throw IllegalArgumentException("Wrong ViewType")
        }
    }

    override fun onBindViewHolder(holder: WidgetViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return WIDGETS_COUNT
    }

    override fun getItemViewType(position: Int): Int {
        return viewTypes.getValue(position)
    }
}