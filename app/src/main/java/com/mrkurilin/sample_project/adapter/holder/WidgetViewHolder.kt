package com.mrkurilin.sample_project.adapter.holder

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.ExpandableView
import com.mrkurilin.sample_project.R

abstract class WidgetViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val toggleButton = view.findViewById<Button>(R.id.button_expandable_view)
    var isExpanded = false

    init {
        toggleButton.setOnClickListener {
            isExpanded = !isExpanded
            (itemView as ExpandableView).toggle()
        }
    }

    fun bind(){
        (itemView as ExpandableView).isExpanded = isExpanded
    }
}