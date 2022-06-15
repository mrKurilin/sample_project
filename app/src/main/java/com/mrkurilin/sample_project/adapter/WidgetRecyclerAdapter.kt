package com.mrkurilin.sample_project.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.R
import com.mrkurilin.sample_project.adapter.holder.*
import com.mrkurilin.sample_project.ui_model.*

private const val AUTOCOMPLETE_TEXTVIEW_VIEW_TYPE = 0
private const val CHECKBOX_VIEW_TYPE = 1
private const val EDITTEXT_VIEW_TYPE = 2
private const val RADIOBUTTON_VIEW_TYPE = 3
private const val RATINGBAR_VIEW_TYPE = 4
private const val SEEKBAR_VIEW_TYPE = 5
private const val SPINNER_VIEW_TYPE = 6
private const val SWITCH_VIEW_TYPE = 7
private const val TEXTVIEW_VIEW_TYPE = 8
private const val TOGGLE_BUTTON_VIEW_TYPE = 9
private const val CHIPS_VIEW_TYPE = 10
private const val PROGRESSBAR_VIEW_TYPE = 11

class WidgetRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items = emptyList<RecyclerViewUiModel>()

    private lateinit var launchWifiStateActivity: () -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

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
                SwitchViewHolder(view, launchWifiStateActivity)
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
                val view = inflater.inflate(
                    R.layout.widget_autocomplete_textview,
                    parent,
                    false
                )
                AutocompleteViewHolder(view)
            }
            SEEKBAR_VIEW_TYPE -> {
                val view = inflater.inflate(R.layout.widget_seekbar, parent, false)
                SeekBarViewHolder(view)
            }
            TOGGLE_BUTTON_VIEW_TYPE -> {
                val view = inflater.inflate(R.layout.widget_toggle_button, parent, false)
                ToggleButtonViewHolder(view)
            }
            CHIPS_VIEW_TYPE -> {
                val view = inflater.inflate(R.layout.widget_chips, parent, false)
                ChipsViewHolder(view)
            }
            PROGRESSBAR_VIEW_TYPE -> {
                val view = inflater.inflate(R.layout.widget_progressbar, parent, false)
                ProgressBarViewHolder(view)
            }
            else -> throw IllegalArgumentException("Wrong ViewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SwitchViewHolder -> holder.bind()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is AutocompleteUiModel -> AUTOCOMPLETE_TEXTVIEW_VIEW_TYPE
            is CheckBoxUiModel -> CHECKBOX_VIEW_TYPE
            is ChipsUiModel -> CHIPS_VIEW_TYPE
            is EditTextUiModel -> EDITTEXT_VIEW_TYPE
            is ProgressBarUiModel -> PROGRESSBAR_VIEW_TYPE
            is RadioButtonUiModel -> RADIOBUTTON_VIEW_TYPE
            is RatingBarUiModel -> RATINGBAR_VIEW_TYPE
            is SeekBarUiModel -> SEEKBAR_VIEW_TYPE
            is SpinnerUiModel -> SPINNER_VIEW_TYPE
            is SwitchUiModel -> SWITCH_VIEW_TYPE
            is TextViewUiModel -> TEXTVIEW_VIEW_TYPE
            is ToggleButtonUiModel -> TOGGLE_BUTTON_VIEW_TYPE
            else -> throw IllegalArgumentException("Illegal items' position")
        }
    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        if (holder is ProgressBarViewHolder) {
            holder.onViewAttachedToWindow()
        }
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        if (holder is ProgressBarViewHolder) {
            holder.onViewDetachedFromWindow()
        }
    }

    fun setItems(items: List<RecyclerViewUiModel>) {
        this.items = items
    }

    fun setActivityLauncher(activityLauncher: () -> Unit) {
        this.launchWifiStateActivity = activityLauncher
    }
}