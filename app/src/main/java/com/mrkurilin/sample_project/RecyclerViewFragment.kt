package com.mrkurilin.sample_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.recycler_view_fragment, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_fragment)
        val lim = LinearLayoutManager(context)
        recyclerView.layoutManager = lim
        val adapter =
            WidgetRecyclerAdapter(requireActivity().baseContext)
        recyclerView.adapter = adapter

        return view
    }
}