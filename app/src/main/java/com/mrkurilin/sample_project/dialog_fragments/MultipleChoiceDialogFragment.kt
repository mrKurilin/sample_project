package com.mrkurilin.sample_project.dialog_fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.core.os.bundleOf
import com.mrkurilin.sample_project.R

class MultipleChoiceDialogFragment : MyDialogFragment.ColorSetupDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogFragmentsData = requireArguments().getParcelable<DialogFragmentsData>(
            DialogFragmentsData.RESPONSE_KEY
        )!!
        initCheckedColors(dialogFragmentsData)

        return AlertDialog.Builder(requireContext())
            .setTitle("Setup Color")
            .setMultiChoiceItems(R.array.colors, checkedColors) { _, which, isChecked ->
                checkedColors[which] = isChecked
                updateCurrentColorAsBooleans(dialogFragmentsData)
                parentFragmentManager.setFragmentResult(
                    DialogFragmentsData.REQUEST_KEY,
                    bundleOf(DialogFragmentsData.RESPONSE_KEY to dialogFragmentsData)
                )
            }
            .setPositiveButton("Cancel", null)
            .create()
    }
}