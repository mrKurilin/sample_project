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
) : LinearLayout(context, attrs, defStyleAttr) {

    private val toggleButton: Button
    private var isContentVisible = false

    init {
        View.inflate(context, R.layout.view_expandable_layout, this)
        orientation = VERTICAL

        toggleButton = findViewById(R.id.button_expandable_view)

        initializeAttributes(attrs)
    }

    fun initializeAttributes(attrs: AttributeSet?) {
        if (attrs == null) {
            return
        }

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ExpandableView)
        val text = typedArray.getString(R.styleable.ExpandableView_toggleButtonText)
        toggleButton.text = text
        typedArray.recycle()
    }

    fun toggle() {
        changeContentVisibility()
    }

    private fun changeContentVisibility() {
        isContentVisible = !isContentVisible
        children.forEach { child ->
            if (child.id != R.id.button_expandable_view) {
                child.isVisible = isContentVisible
            }
        }
    }
}