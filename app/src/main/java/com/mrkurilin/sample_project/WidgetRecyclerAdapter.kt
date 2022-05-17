package com.mrkurilin.sample_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView

class WidgetRecyclerAdapter(
    context: Context,
    private val widgets: List<WidgetItem>,
    private val recyclerView: RecyclerView
) :
    RecyclerView.Adapter<WidgetRecyclerAdapter.WidgetViewHodler>() {
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WidgetViewHodler {
        val view = inflater.inflate(R.layout.widget_list_item, parent, false)
        return WidgetViewHodler(view, recyclerView)
    }

    override fun onBindViewHolder(holder: WidgetViewHodler, position: Int) {
        holder.bind(widgets[position])
    }

    override fun getItemCount(): Int {
        return widgets.size
    }

    class WidgetViewHodler constructor(view: View, private val recyclerView: RecyclerView) :
        RecyclerView.ViewHolder(view), View.OnClickListener {
        val name = view.findViewById<TextView>(R.id.widget_list_item_text_view)
        val layout = view.findViewById<ViewStub>(R.id.widget_list_item_stub_view)

        init {
            name.setOnClickListener(this)
        }


        fun bind(widgetItem: WidgetItem) {
            name.text = widgetItem.name
            layout.layoutResource = widgetItem.layout
            layout.inflate()
            layout.visibility = View.GONE
        }

        override fun onClick(p0: View?) {
            if (layout.visibility == View.VISIBLE) {
                layout.visibility = View.GONE
            } else {
                layout.visibility = View.VISIBLE
            }
        }

    }

}