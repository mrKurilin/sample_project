package com.mrkurilin.sample_project.dialog_fragments

import android.content.DialogInterface
import android.graphics.Color
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.mrkurilin.sample_project.R
import kotlin.properties.Delegates

interface MyDialogFragment {

    open class Base : DialogFragment(), MyDialogFragment {

        override fun onCancel(dialog: DialogInterface) {
            super.onCancel(dialog)
            Toast.makeText(requireContext(), "Dialog canceled!", Toast.LENGTH_LONG).show()
        }
    }

    open class VolumeSetupDialogFragment : Base() {

        protected val volumes = (0..100 step 10).toList().toIntArray()
        protected var currentVolume by Delegates.notNull<Int>()
        protected var currentIndex by Delegates.notNull<Int>()
        protected lateinit var volumesStrings: Array<String>

        fun initVariables(key: String) {
            currentVolume = requireArguments().getInt(key)
            currentIndex = volumes.indexOf(currentVolume)
            volumesStrings = volumes.map { getString(R.string.volumes_list, it) }.toTypedArray()
        }
    }

    open class ColorSetupFragment : Base() {

        protected val colors = arrayOf("Red", "Green", "Blue")
        protected lateinit var checkedColors: BooleanArray

        fun initCheckedColors(key: String) {
            checkedColors = requireArguments().getBooleanArray(key) ?: booleanArrayOf(false, false, false)
        }
    }
}