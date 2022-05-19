package com.mrkurilin.sample_project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.R
import com.mrkurilin.sample_project.adapter.holder.CheckBoxViewHolder
import com.mrkurilin.sample_project.adapter.holder.WidgetViewHolder

private const val WIDGETS_COUNT = 1

private const val CHECKBOX_VIEW_TYPE = 0

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
//          TODO() add viewHolders Constructors
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

        return when(position){
            0 -> CHECKBOX_VIEW_TYPE
            else -> throw IllegalArgumentException("Wrong Position")
        }
        // TODO: get view type by position
    }
}