package com.mrkurilin.sample_project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.R
import com.mrkurilin.sample_project.adapter.holder.*

private const val CHECKBOX_VIEW_TYPE = 0
private const val RADIOBUTTON_VIEW_TYPE = 1
private const val TEXTVIEW_VIEW_TYPE = 2
private const val RATINGBAR_VIEW_TYPE = 3
private const val SWITCH_VIEW_TYPE = 4
private const val EDITTEXT_VIEW_TYPE = 5
private const val SPINNER_VIEW_TYPE = 6
private const val AUTOCOMPLETE_TEXTVIEW_VIEW_TYPE = 7

private val viewTypes = arrayOf(
    CHECKBOX_VIEW_TYPE,
    RADIOBUTTON_VIEW_TYPE,
    TEXTVIEW_VIEW_TYPE,
    RATINGBAR_VIEW_TYPE,
    SWITCH_VIEW_TYPE,
    EDITTEXT_VIEW_TYPE,
    SPINNER_VIEW_TYPE,
    AUTOCOMPLETE_TEXTVIEW_VIEW_TYPE,
)

class WidgetRecyclerAdapter(
    context: Context
) : RecyclerView.Adapter<WidgetViewHolder>() {
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WidgetViewHolder {
        return when (viewType) {
            CHECKBOX_VIEW_TYPE -> {
                val view = inflater.inflate(R.layout.widget_checkbox, parent, false)
                CheckBoxViewHolder(view)
            }
            RADIOBUTTON_VIEW_TYPE -> {
                val view = inflater.inflate(R.layout.widget_radio_button, parent, false)
                RadioButtonViewHolder(view)
            }
            TEXTVIEW_VIEW_TYPE -> {
                val view = inflater.inflate(R.layout.widget_text_view, parent, false)
                TextViewViewHolder(view)
            }
            RATINGBAR_VIEW_TYPE -> {
                val view = inflater.inflate(R.layout.widget_rating_bar, parent, false)
                RatingBarViewHolder(view)
            }
            SWITCH_VIEW_TYPE -> {
                val view = inflater.inflate(R.layout.widget_switch, parent, false)
                SwitchViewHolder(view)
            }
            EDITTEXT_VIEW_TYPE -> {
                val view = inflater.inflate(R.layout.widget_edittext, parent, false)
                EditTextViewHolder(view)
            }
            SPINNER_VIEW_TYPE -> {
                val view = inflater.inflate(R.layout.widget_spinner, parent, false)
                SpinnerViewHolder(view)
            }
            AUTOCOMPLETE_TEXTVIEW_VIEW_TYPE -> {
                val view = inflater.inflate(R.layout.widget_autocomplete_textview, parent, false)
                AutocompleteViewHolder(view)
            }


            else -> throw IllegalArgumentException("Wrong ViewType")
        }
    }

    override fun onBindViewHolder(holder: WidgetViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return viewTypes.size
    }

    override fun getItemViewType(position: Int): Int {
        return viewTypes[position]
    }
}