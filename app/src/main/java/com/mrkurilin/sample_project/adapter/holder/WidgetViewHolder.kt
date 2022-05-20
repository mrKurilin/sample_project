package com.mrkurilin.sample_project.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class WidgetViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind()
}