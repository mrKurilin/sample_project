package com.mrkurilin.sample_project.adapter.holder

import android.view.View
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.mrkurilin.sample_project.R

class ChipsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    init {
        view.findViewById<ChipGroup>(R.id.chipgroup_chips_widget).children.forEach { child ->
            (child as Chip).setOnCloseIconClickListener {
                child.visibility = View.GONE
            }
        }
    }
}