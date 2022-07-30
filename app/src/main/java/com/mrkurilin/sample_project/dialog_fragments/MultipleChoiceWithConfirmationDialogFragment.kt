package com.mrkurilin.sample_project.dialog_fragments

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import com.mrkurilin.sample_project.R

class MultipleChoiceWithConfirmationDialogFragment : MyDialogFragment.ColorSetupDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogFragmentsData = requireArguments().getParcelable<DialogFragmentsData>(
            DialogFragmentsData.RESPONSE_KEY
        )!!
        initCheckedColors(dialogFragmentsData)

        return AlertDialog.Builder(requireContext())
            .setTitle("Setup color")
            .setMultiChoiceItems(R.array.colors, checkedColors) { _, which, isChecked ->
                checkedColors[which] = isChecked
            }
            .setPositiveButton("Confirm") { _, _ ->
                updateCurrentColorAsBooleans(dialogFragmentsData)
                parentFragmentManager.setFragmentResult(
                    DialogFragmentsData.REQUEST_KEY,
                    bundleOf(DialogFragmentsData.RESPONSE_KEY to dialogFragmentsData)
                )
            }
            .create()
    }
}