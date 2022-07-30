package com.mrkurilin.sample_project.dialog_fragments

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf

class SingleChoiceDialogFragment : MyDialogFragment.VolumeSetupDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogFragmentsData = requireArguments()
            .getParcelable<DialogFragmentsData>(DialogFragmentsData.RESPONSE_KEY)!!
        val currentIndex = dialogFragmentsData.volumes.indexOf(dialogFragmentsData.currentVolume)

        return AlertDialog.Builder(requireContext())
            .setTitle("Setup volume")
            .setSingleChoiceItems(
                dialogFragmentsData.volumesStrings,
                currentIndex
            ) { _, which ->
                dialogFragmentsData.currentVolume = dialogFragmentsData.volumes[which]
                parentFragmentManager.setFragmentResult(
                    DialogFragmentsData.REQUEST_KEY,
                    bundleOf(DialogFragmentsData.RESPONSE_KEY to dialogFragmentsData)
                )
                dismiss()
            }
            .create()
    }
}