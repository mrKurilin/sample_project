package com.mrkurilin.sample_project.dialog_fragments

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import com.mrkurilin.sample_project.R
import com.mrkurilin.sample_project.dialog_fragments.VolumeValues.Companion.volumes

class SingleChoiceDialogFragment(currentVolume: Int) : MyDialogFragment.Base() {

    private val currentIndex = volumes.indexOf(currentVolume)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val volumesStrings = volumes.map { getString(R.string.volumes_list, it) }.toTypedArray()

        return AlertDialog.Builder(requireContext())
            .setCancelable(true)
            .setTitle("Volume setup")
            .setSingleChoiceItems(volumesStrings, currentIndex) { _, which ->
                val chosenVolume = volumes[which]
                parentFragmentManager.setFragmentResult(
                    REQUEST_VOLUME_KEY,
                    bundleOf(KEY_VOLUME_RESPONSE to chosenVolume)
                )
                dismiss()
            }
            .create()
    }

    companion object {
        @JvmStatic
        val TAG: String = SingleChoiceDialogFragment::class.java.simpleName

        @JvmStatic
        val REQUEST_VOLUME_KEY = "$TAG:defaultRequestKey"

        @JvmStatic
        val KEY_VOLUME_RESPONSE = "RESPONSE"

        fun show(fragmentManager: FragmentManager, currentVolume: Int) {
            val dialogFragment = SingleChoiceDialogFragment(currentVolume)
            dialogFragment.show(fragmentManager, TAG)
        }

        fun setupListener(
            fragmentManager: FragmentManager,
            lifecycleOwner: LifecycleOwner,
            listener: (Int) -> Unit
        ) {
            fragmentManager.setFragmentResultListener(
                REQUEST_VOLUME_KEY,
                lifecycleOwner
            ) { _, result ->
                listener(result.getInt(KEY_VOLUME_RESPONSE))
            }
        }
    }
}