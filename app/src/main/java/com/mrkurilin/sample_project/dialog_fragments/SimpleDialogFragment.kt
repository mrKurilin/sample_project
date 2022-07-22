package com.mrkurilin.sample_project.dialog_fragments

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import com.mrkurilin.sample_project.R
import showToast

class SimpleDialogFragment : MyDialogFragment.Base() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val listener = DialogInterface.OnClickListener { _, which ->
            when (which) {
                DialogInterface.BUTTON_POSITIVE -> showToast(R.string.android_uninstall)
                else -> showToast(R.string.android_uninstall_denied)
            }
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
        val TAG: String = SimpleDialogFragment::class.java.simpleName

        fun show(fragmentManager: FragmentManager) {
            val dialogFragment = SimpleDialogFragment()
            dialogFragment.show(fragmentManager, TAG)
        }
    }
}