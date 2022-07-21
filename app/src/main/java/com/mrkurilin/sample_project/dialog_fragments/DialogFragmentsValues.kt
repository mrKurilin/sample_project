package com.mrkurilin.sample_project.dialog_fragments

import android.graphics.Color
import androidx.core.graphics.red

class DialogFragmentsValues {

    companion object {
        val volumes = (0..100 step 10).toList().toIntArray()
        var currentVolume = 0

        var currentColor = Color.WHITE
        val colors = arrayOf("Red", "Green", "Blue")
        var checkedColors = booleanArrayOf(false, false, false)

        fun updateCurrentColor() {
            currentColor = Color.rgb(
                if (checkedColors[0]) 255 else 0,
                if (checkedColors[1]) 255 else 0,
                if (checkedColors[2]) 255 else 0,
            )
        }
    }
}