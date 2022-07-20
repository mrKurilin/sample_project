package com.mrkurilin.sample_project.dialog_fragments

import android.content.DialogInterface
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

interface MyDialogFragment {

    open class Base : DialogFragment(), MyDialogFragment {

        override fun onCancel(dialog: DialogInterface) {
            super.onCancel(dialog)
            Toast.makeText(requireContext(), "Dialog canceled!", Toast.LENGTH_LONG).show()
        }
    }
}