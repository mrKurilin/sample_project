package com.mrkurilin.sample_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WidgetRecyclerAdapter(
    context: Context
) :
    RecyclerView.Adapter<WidgetRecyclerAdapter.WidgetViewHodler>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WidgetViewHodler {

        when (viewType) {
            0 -> {
                val view = inflater.inflate(R.layout.widget_checkbox, parent, false)
                return WidgetViewHodler(view)
            }
            1 -> {
                val view = inflater.inflate(R.layout.widget_text_view, parent, false)
                return WidgetViewHodler(view)
            }
            else -> {
                val view = inflater.inflate(R.layout.widget_text_view, parent, false)
                return WidgetViewHodler(view)
            }
        }
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
        return 2
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class WidgetViewHodler constructor(view: View) :
        RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.widget_list_item_text_view)
        val expandapleLayout =
            view.findViewById<LinearLayout>(R.id.widget_list_item_expandaple_layout)
    }
}