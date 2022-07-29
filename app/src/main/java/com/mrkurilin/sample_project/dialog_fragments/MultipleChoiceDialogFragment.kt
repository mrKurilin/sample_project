package com.mrkurilin.sample_project.dialog_fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.core.os.bundleOf

class MultipleChoiceDialogFragment : MyDialogFragment.ColorSetupFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        initCheckedColors(BOOLEAN_COLOR_KEY)

        return AlertDialog.Builder(requireContext())
            .setTitle("Setup Color")
            .setMultiChoiceItems(colors, checkedColors) { _, which, isChecked ->
                checkedColors[which] = isChecked
                parentFragmentManager.setFragmentResult(
                    REQUEST_KEY,
                    bundleOf(BOOLEAN_COLOR_KEY to checkedColors)
                )
            }
            .setPositiveButton("Cancel", null)
            .create()
    }

    companion object {
        const val REQUEST_KEY = "MultipleChoiceDialogFragmentRequestKey"
        const val BOOLEAN_COLOR_KEY = "MultipleChoiceDialogFragmentBC"
    }
}