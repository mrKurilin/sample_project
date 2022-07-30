package com.mrkurilin.sample_project.dialog_fragments

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf

class SingleChoiceWithConfirmationDialogFragment : MyDialogFragment.VolumeSetupDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogFragmentsData = requireArguments()
            .getParcelable<DialogFragmentsData>(DialogFragmentsData.RESPONSE_KEY)!!
        val currentIndex = dialogFragmentsData.volumes.indexOf(dialogFragmentsData.currentVolume)

        return AlertDialog.Builder(requireContext())
            .setTitle("Setup volume")
            .setSingleChoiceItems(dialogFragmentsData.volumesStrings, currentIndex, null)
            .setPositiveButton("Confirm") { dialog, _ ->
                val index = (dialog as AlertDialog).listView.checkedItemPosition
                dialogFragmentsData.currentVolume = dialogFragmentsData.volumes[index]
                parentFragmentManager.setFragmentResult(
                    DialogFragmentsData.REQUEST_KEY,
                    bundleOf(DialogFragmentsData.RESPONSE_KEY to dialogFragmentsData)
                )
                dismiss()
            }
            .create()
    }
}