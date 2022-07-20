package com.mrkurilin.sample_project.dialog_fragments

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class MultipleChoiceDialogFragment : MyDialogFragment.Base() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }

    companion object {
        @JvmStatic
        val TAG: String = SimpleDialogFragment::class.java.simpleName

        @JvmStatic
        val REQUEST_KEY = "$TAG:defaultRequestKey"

        @JvmStatic
        val KEY_RESPONSE = "RESPONSE"

        fun show(fragmentManager: FragmentManager) {
            val dialogFragment = MultipleChoiceDialogFragment()
            dialogFragment.show(fragmentManager, TAG)
        }
    }
}