package com.mrkurilin.sample_project.dialog_fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import com.mrkurilin.sample_project.dialog_fragments.DialogFragmentsValues.Companion.checkedColors
import com.mrkurilin.sample_project.dialog_fragments.DialogFragmentsValues.Companion.colors
import com.mrkurilin.sample_project.dialog_fragments.DialogFragmentsValues.Companion.currentColor
import com.mrkurilin.sample_project.dialog_fragments.DialogFragmentsValues.Companion.updateCurrentColor

class MultipleChoiceDialogFragment : MyDialogFragment.Base() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setMultiChoiceItems(colors, checkedColors, DialogInterface.OnMultiChoiceClickListener { _, which, isChecked ->
                checkedColors[which] = isChecked
                updateCurrentColor()
                parentFragmentManager.setFragmentResult(REQUEST_KEY, bundleOf())
            })
            .setPositiveButton("Cancel", null)
            .create()
    }

    companion object {
        @JvmStatic
        val TAG: String = MultipleChoiceDialogFragment::class.java.simpleName

        @JvmStatic
        val REQUEST_KEY = "$TAG:defaultRequestKey"

        @JvmStatic
        val KEY_RESPONSE = "RESPONSE"

        fun show(fragmentManager: FragmentManager) {
            val dialogFragment = MultipleChoiceDialogFragment()
            dialogFragment.show(fragmentManager, TAG)
        }

        fun setupListener(
            fragmentManager: FragmentManager,
            lifecycleOwner: LifecycleOwner,
            listener: () -> Unit
        ) {
            fragmentManager.setFragmentResultListener(
                REQUEST_KEY,
                lifecycleOwner
            ) { _, _ ->
                listener()
            }
        }
    }
}