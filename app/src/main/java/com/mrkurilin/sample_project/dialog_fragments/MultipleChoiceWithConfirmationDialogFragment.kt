package com.mrkurilin.sample_project.dialog_fragments

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf

class MultipleChoiceWithConfirmationDialogFragment : MyDialogFragment.ColorSetupFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        initCheckedColors(BOOLEAN_COLOR_KEY)

        return AlertDialog.Builder(requireContext())
            .setTitle("Setup color")
            .setMultiChoiceItems(colors, checkedColors) { _, which, isChecked ->
                checkedColors[which] = isChecked
            }
            .setPositiveButton("Confirm") { _, _ ->
                parentFragmentManager.setFragmentResult(
                    REQUEST_KEY,
                    bundleOf(BOOLEAN_COLOR_KEY to checkedColors)
                )
            }
            .create()
    }

    companion object {
        const val REQUEST_KEY = "MultipleChoiceWithConfirmationDialogFragmentRequestKey"
        const val BOOLEAN_COLOR_KEY = "MultipleChoiceWithConfirmationDialogFragmentBC"
    }
}