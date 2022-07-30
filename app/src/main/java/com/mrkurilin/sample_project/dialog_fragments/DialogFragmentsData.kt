package com.mrkurilin.sample_project.dialog_fragments

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DialogFragmentsData(
    val volumes: IntArray,
    val volumesStrings: Array<String>,
    var currentVolume: Int = 0,
    var currentColorAsBooleans: MyColor = MyColor(),
) : Parcelable {

    companion object {
        const val RESPONSE_KEY = "RESPONSE_KEY"
        const val REQUEST_KEY = "REQUEST_KEY"
    }
}

@Parcelize
data class MyColor(
    var redEnabled: Boolean = true,
    var greenEnabled: Boolean = true,
    var blueEnabled: Boolean = true,
) : Parcelable