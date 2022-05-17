package com.mrkurilin.sample_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.recycler_view_fragment, container, false)

        recyclerView = view.findViewById(R.id.recycler_view_fragment)
        val lim = LinearLayoutManager(context)
        recyclerView.layoutManager = lim
        val adapter = WidgetRecyclerAdapter(requireActivity().baseContext, WidgetItem.widgets)
        recyclerView.adapter = adapter

        return view

    }

    class WidgetViewHodler constructor(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.widget_list_item_text_view)
        val layout = view.findViewById<ViewStub>(R.id.widget_list_item_stub_view)

        init {
            name.setOnClickListener {
                if (layout.isVisible) {
                    layout.visibility = View.GONE
                } else {
                    layout.visibility = View.VISIBLE
                }
            }
        }

        fun bind(widgetItem: WidgetItem) {
            name.text = widgetItem.name
            layout.layoutResource = widgetItem.layout
            layout.inflate()
            layout.visibility = View.GONE
        }

    }
}