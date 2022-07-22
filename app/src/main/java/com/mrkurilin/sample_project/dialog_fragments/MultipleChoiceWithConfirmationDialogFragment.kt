package com.mrkurilin.sample_project.dialog_fragments

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import com.mrkurilin.sample_project.dialog_fragments.DialogFragmentsValues.Companion.checkedColors
import com.mrkurilin.sample_project.dialog_fragments.DialogFragmentsValues.Companion.colors
import com.mrkurilin.sample_project.dialog_fragments.DialogFragmentsValues.Companion.updateCurrentColor

class MultipleChoiceWithConfirmationDialogFragment : MyDialogFragment.Base() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val lCheckedColors = checkedColors
        return AlertDialog.Builder(requireContext())
            .setTitle("Setup color")
            .setMultiChoiceItems(colors, checkedColors) { _, which, isChecked ->
                lCheckedColors[which] = isChecked
            }
            .setPositiveButton("Confirm") { _, _ ->
                checkedColors = lCheckedColors
                updateCurrentColor()
                parentFragmentManager.setFragmentResult(REQUEST_KEY, bundleOf())
            }
            .create()
    }

    companion object {
        @JvmStatic
        val TAG: String = MultipleChoiceWithConfirmationDialogFragment::class.java.simpleName

        @JvmStatic
        val REQUEST_KEY = "$TAG:defaultRequestKey"

        fun show(fragmentManager: FragmentManager) {
            val dialogFragment = MultipleChoiceWithConfirmationDialogFragment()
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