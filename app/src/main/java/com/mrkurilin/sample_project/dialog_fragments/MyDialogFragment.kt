package com.mrkurilin.sample_project.dialog_fragments

import android.content.DialogInterface
import android.widget.Toast
import androidx.fragment.app.DialogFragment

interface MyDialogFragment {

    open class Base : DialogFragment(), MyDialogFragment {

        override fun onCancel(dialog: DialogInterface) {
            super.onCancel(dialog)
            Toast.makeText(requireContext(), "Dialog canceled!", Toast.LENGTH_LONG).show()
        }
    }

    open class ColorSetupDialogFragment : Base() {

        protected lateinit var checkedColors: BooleanArray

        fun initCheckedColors(dialogFragmentsData: DialogFragmentsData) {
            checkedColors = booleanArrayOf(
                dialogFragmentsData.currentColorAsBooleans.redEnabled,
                dialogFragmentsData.currentColorAsBooleans.greenEnabled,
                dialogFragmentsData.currentColorAsBooleans.blueEnabled
            )
        }

        fun updateCurrentColorAsBooleans(dialogFragmentsData: DialogFragmentsData) {
            dialogFragmentsData.currentColorAsBooleans.redEnabled = checkedColors[0]
            dialogFragmentsData.currentColorAsBooleans.greenEnabled = checkedColors[1]
            dialogFragmentsData.currentColorAsBooleans.blueEnabled = checkedColors[2]
        }
    }
}