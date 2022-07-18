package com.mrkurilin.sample_project.dialog_fragments

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment

class SimpleDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val listener = DialogInterface.OnClickListener { _, which ->
            parentFragmentManager.setFragmentResult(
                REQUEST_KEY,
                bundleOf(KEY_RESPONSE to which)
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

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        Toast.makeText(requireContext(), "Dialog canceled!", Toast.LENGTH_LONG).show()
    }

    companion object {
        @JvmStatic
        val TAG: String = SimpleDialogFragment::class.java.simpleName

        @JvmStatic
        val REQUEST_KEY = "$TAG:defaultRequestKey"

        @JvmStatic
        val KEY_RESPONSE = "RESPONSE"
    }
}