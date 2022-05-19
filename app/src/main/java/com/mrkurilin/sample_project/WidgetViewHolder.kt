package com.mrkurilin.sample_project

import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

class WidgetViewHodler constructor(view: View) : RecyclerView.ViewHolder(view) {
    val name = view.findViewById<Button>(R.id.widget_list_item_button)
    val expandapleLayout = view.findViewById<LinearLayout>(R.id.widget_list_item_expandaple_layout)
}