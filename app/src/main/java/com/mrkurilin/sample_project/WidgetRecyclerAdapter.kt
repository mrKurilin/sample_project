package com.mrkurilin.sample_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

class WidgetRecyclerAdapter(
    context: Context
) :
    RecyclerView.Adapter<WidgetRecyclerAdapter.WidgetViewHodler>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WidgetViewHodler {

        val layout = WidgetItem.widgets[viewType].layout

        val view = inflater.inflate(layout, parent, false)
        return WidgetViewHodler(view)
    }

    override fun onBindViewHolder(holder: WidgetViewHodler, position: Int) {
        with(holder) {
            name.setOnClickListener {
                if (this.expandapleLayout.visibility == View.GONE) {
                    this.expandapleLayout.visibility = View.VISIBLE
                } else {
                    this.expandapleLayout.visibility = View.GONE
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return WidgetItem.widgets.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class WidgetViewHodler constructor(view: View) :
        RecyclerView.ViewHolder(view) {
        val name = view.findViewById<Button>(R.id.widget_list_item_button)
        val expandapleLayout =
            view.findViewById<LinearLayout>(R.id.widget_list_item_expandaple_layout)
    }
}