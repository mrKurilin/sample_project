package com.mrkurilin.sample_project.dialog_fragments

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import com.mrkurilin.sample_project.R
import com.mrkurilin.sample_project.dialog_fragments.VolumeValues.Companion.currentVolume
import com.mrkurilin.sample_project.dialog_fragments.VolumeValues.Companion.volumes

class SingleChoiceWithConfirmationDialogFragment : MyDialogFragment.Base() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val volumesStrings = volumes.map { getString(R.string.volumes_list, it) }.toTypedArray()

        return AlertDialog.Builder(requireContext())
            .setTitle("Volume setup")
            .setPositiveButton("Confirm") { dialog, _ ->
                val index = (dialog as AlertDialog).listView.checkedItemPosition
                currentVolume = volumes[index]
                parentFragmentManager.setFragmentResult(REQUEST_KEY, bundleOf())
                dismiss()
            }
            .setSingleChoiceItems(volumesStrings, volumes.indexOf(currentVolume), null)
            .create()
    }

    companion object {
        @JvmStatic
        val TAG: String = SingleChoiceWithConfirmationDialogFragment::class.java.simpleName

        @JvmStatic
        val REQUEST_KEY = "$TAG:defaultRequestKey"

        fun show(fragmentManager: FragmentManager) {
            val dialogFragment = SingleChoiceWithConfirmationDialogFragment()
            dialogFragment.show(fragmentManager, TAG)
        }

        fun setupListener(
            fragmentManager: FragmentManager,
            lifecycleOwner: LifecycleOwner,
            listener: () -> Unit
        ) {
            fragmentManager.setFragmentResultListener(REQUEST_KEY, lifecycleOwner) { _, _ ->
                listener()
            }
        }
    }
}