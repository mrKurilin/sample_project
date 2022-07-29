package com.mrkurilin.sample_project.dialog_fragments

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf

class SingleChoiceDialogFragment : MyDialogFragment.VolumeSetupDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        initVariables(CURRENT_VOLUME_KEY)

        return AlertDialog.Builder(requireContext())
            .setTitle("Setup volume")
            .setSingleChoiceItems(volumesStrings, currentIndex) { _, which ->
                val chosenVolume = volumes[which]
                parentFragmentManager.setFragmentResult(
                    REQUEST_KEY,
                    bundleOf(CURRENT_VOLUME_KEY to chosenVolume)
                )
                dismiss()
            }
            .create()
    }

    companion object {
        const val CURRENT_VOLUME_KEY = "CURRENT_VOLUME_KEY"
        const val REQUEST_KEY = "REQUEST_KEY"
    }
}