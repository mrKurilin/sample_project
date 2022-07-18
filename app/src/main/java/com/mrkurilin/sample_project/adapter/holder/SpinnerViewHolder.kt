package com.mrkurilin.sample_project.adapter.holder

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.R

class SpinnerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val spinnerColor: Spinner = view.findViewById(R.id.spinner_color_spinner_widget)
    private val spinnerShape: Spinner = view.findViewById(R.id.spinner_shape_spinner_widget)
    private val spinnerContent: Spinner = view.findViewById(R.id.spinner_content_spinner_widget)
    private val imageView: ImageView = view.findViewById(R.id.imageview_spinner_widget)
    private val onItemSelectedListener by lazy { createOnItemSelectedListener() }

    private val colorMap = mapOf(
        "Red" to R.color.red,
        "Green" to R.color.green,
        "Blue" to R.color.blue,
    )

    private val shapeMap = mapOf(
        "Rectangle" to R.drawable.rectangle,
        "Circle" to R.drawable.circle,
    )

    private val contentMap = mapOf(
        "Android" to R.drawable.ic_baseline_android_24,
        "Land scape" to R.drawable.ic_baseline_landscape_24,
        "Self improvement" to R.drawable.ic_baseline_self_improvement_24,
    )

    init {
        setAdapter(spinnerColor, colorMap)
        setAdapter(spinnerShape, shapeMap)
        setAdapter(spinnerContent, contentMap)

        spinnerShape.onItemSelectedListener = onItemSelectedListener
        spinnerColor.onItemSelectedListener = onItemSelectedListener
        spinnerContent.onItemSelectedListener = onItemSelectedListener
    }

    private fun createOnItemSelectedListener(): AdapterView.OnItemSelectedListener {
        return object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                when (parent) {
                    spinnerColor -> setImageViewBackgroundColor()
                    spinnerShape -> setImageViewBackgroundShape()
                    spinnerContent -> setImageViewContent()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun setImageViewBackgroundColor() {
        val colorId = colorMap.getValue(spinnerColor.selectedItem.toString())
        val tint = ContextCompat.getColor(spinnerColor.context, colorId)
        DrawableCompat.setTint(
            imageView.background,
            tint
        )
    }

    private fun setAdapter(spinner: Spinner, map: Map<String, *>) {
        spinner.adapter = ArrayAdapter(
            imageView.context,
            android.R.layout.simple_spinner_dropdown_item,
            map.keys.toTypedArray()
        )
    }

    private fun setImageViewBackgroundShape() {
        val drawableId = shapeMap.getValue(spinnerShape.selectedItem.toString())
        val backgroundDrawable = ContextCompat.getDrawable(itemView.context, drawableId)
        imageView.background = backgroundDrawable
        setImageViewBackgroundColor()
    }

    private fun setImageViewContent() {
        val contentDrawableId = contentMap.getValue(spinnerContent.selectedItem.toString())
        val contentDrawable = ContextCompat.getDrawable(itemView.context, contentDrawableId)
        imageView.setImageDrawable(contentDrawable)
    }
}