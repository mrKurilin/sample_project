package com.mrkurilin.sample_project

data class WidgetItem(val layout: Int) {

    companion object{
        val widgets = arrayListOf(
            WidgetItem(R.layout.widget_checkbox),
            WidgetItem(R.layout.widget_text_view)
        )
    }
}
