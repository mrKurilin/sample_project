package com.mrkurilin.sample_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class WidgetRecyclerAdapter(
    context: Context
) :
    RecyclerView.Adapter<WidgetViewHodler>() {
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WidgetViewHodler {
        val layout = WidgetItem.widgets[viewType].layout

        val view = inflater.inflate(layout, parent, false)
        return WidgetViewHodler(view)
    }

    override fun onBindViewHolder(holder: WidgetViewHodler, position: Int) {
        holder.name.setOnClickListener {
            val expandableLayout = holder.expandapleLayout
            if (expandableLayout.visibility == View.GONE) {
                expandableLayout.visibility = View.VISIBLE
            } else {
                expandableLayout.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return WidgetItem.widgets.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}