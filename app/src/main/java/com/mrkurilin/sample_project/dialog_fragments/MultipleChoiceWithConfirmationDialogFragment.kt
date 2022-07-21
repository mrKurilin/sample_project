package com.mrkurilin.sample_project.dialog_fragments

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager

class MultipleChoiceWithConfirmationDialogFragment : MyDialogFragment.Base() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val listener = DialogInterface.OnClickListener { _, which ->
            parentFragmentManager.setFragmentResult(
                SimpleDialogFragment.REQUEST_KEY,
                bundleOf(SimpleDialogFragment.KEY_RESPONSE to which)
            )
        }

        return AlertDialog.Builder(requireContext())
            .setCancelable(true)
            .setTitle("Alert Dialog Title")
            .setMessage("Would you like to uninstall Android?")
            .setPositiveButton("Yes", listener)
            .setNegativeButton("No", listener)
            .setNeutralButton("Ignore", listener)
            .create()
    }

    companion object {
        @JvmStatic
        val TAG: String = MultipleChoiceWithConfirmationDialogFragment::class.java.simpleName

        @JvmStatic
        val REQUEST_KEY = "$TAG:defaultRequestKey"

        @JvmStatic
        val KEY_RESPONSE = "RESPONSE"

        fun show(fragmentManager: FragmentManager) {
            val dialogFragment = MultipleChoiceWithConfirmationDialogFragment()
            dialogFragment.show(fragmentManager, TAG)
        }
    }
}