package com.mrkurilin.sample_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WidgetRecyclerAdapter(context: Context, private val widgets: List<WidgetItem>) :
    RecyclerView.Adapter<RecyclerViewFragment.WidgetViewHodler>() {
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewFragment.WidgetViewHodler {
        val view = inflater.inflate(R.layout.widget_list_item, parent, false)
        return RecyclerViewFragment.WidgetViewHodler(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewFragment.WidgetViewHodler, position: Int) {
        holder.bind(widgets[position])
    }

    override fun getItemCount(): Int {
        return widgets.size
    }

}