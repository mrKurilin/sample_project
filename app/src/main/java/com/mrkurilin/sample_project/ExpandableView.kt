package com.mrkurilin.sample_project

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.view.children
import androidx.core.view.isVisible

class ExpandableView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val toggleButton: Button
    var isExpanded = false
    var toggleButtonText: String = "Widget"
        set(value) {
            field = value
            toggleButton.text = field
        }

    init {
        View.inflate(context, R.layout.view_expandable_layout, this)
        orientation = VERTICAL

        toggleButton = findViewById(R.id.button_expandable_view)

        initializeAttributes(attrs, defStyleAttr, defStyleRes)
    }

    fun initializeAttributes(attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) {
        if (attrs == null) return

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ExpandableView, defStyleAttr, defStyleRes)
        val text = typedArray.getString(R.styleable.ExpandableView_toggleButtonText)
        toggleButtonText = text ?: "Widget"
        typedArray.recycle()
    }

    fun toggle() {
        pToggle()
    }

    private fun pToggle() {
        isExpanded = !isExpanded
        children.forEach { child ->
            if (child.id != R.id.button_expandable_view) {
                child.isVisible = isExpanded
            }
        }
    }
}