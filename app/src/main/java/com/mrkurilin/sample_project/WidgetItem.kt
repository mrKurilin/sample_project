package com.mrkurilin.sample_project

import android.widget.LinearLayout

data class WidgetItem(
    val name: String,
    val layout: Int
) {
    companion object {
        val widgets = arrayListOf(
            WidgetItem("Check Box", R.layout.widget_checkbox),
            WidgetItem("Text View", R.layout.widget_text_view)
        )
    }
}
