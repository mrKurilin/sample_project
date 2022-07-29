package com.mrkurilin.sample_project.dialog_fragments

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf

class SingleChoiceWithConfirmationDialogFragment : MyDialogFragment.VolumeSetupDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        initVariables(CURRENT_VOLUME_KEY)

        return AlertDialog.Builder(requireContext())
            .setTitle("Setup volume")
            .setPositiveButton("Confirm") { dialog, _ ->
                val index = (dialog as AlertDialog).listView.checkedItemPosition
                currentVolume = volumes[index]
                parentFragmentManager.setFragmentResult(
                    REQUEST_KEY, bundleOf(CURRENT_VOLUME_KEY to currentVolume)
                )
                dismiss()
            }
            .setSingleChoiceItems(volumesStrings, volumes.indexOf(currentVolume), null)
            .create()
    }

    companion object {
        const val CURRENT_VOLUME_KEY = "SingleChoiceWithConfirmationDialogFragmentKey"
        const val REQUEST_KEY = "SingleChoiceWithConfirmationDialogFragmentRequestKey"
    }
}