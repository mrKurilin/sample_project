package com.mrkurilin.sample_project

import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.mrkurilin.sample_project.dialog_fragments.*
import showToast

class DialogFragmentsFragment : Fragment() {

    private var currentVolume = 0
    private var currentColor = Color.RED

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog_fragments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currentVolume = savedInstanceState?.getInt(KEY_VOLUME) ?: 0
        currentColor = savedInstanceState?.getInt(KEY_COLOR) ?: Color.RED

        updateUI(view)

        dialogFragmentsSetOnClickListeners(view)
        setupDialogFragmentsListeners()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_VOLUME, currentVolume)
        outState.putInt(KEY_COLOR, currentColor)
    }

    private fun updateUI(view: View) {
        view.findViewById<TextView>(R.id.textview_dialog_fragments).text = getString(
            R.string.current_volume,
            currentVolume
        )

        view.findViewById<View>(R.id.view_dialog_fragments_fragment).setBackgroundColor(
            currentColor
        )

    }

    private fun dialogFragmentsSetOnClickListeners(view: View) {
        view.findViewById<Button>(R.id.button_default_dialog_fragments).setOnClickListener {
            SimpleDialogFragment.show(parentFragmentManager)
        }

        view.findViewById<Button>(R.id.button_single_choice_dialog_fragments).setOnClickListener {
            SingleChoiceDialogFragment.show(parentFragmentManager, currentVolume)
        }

        view.findViewById<Button>(R.id.button_single_choice_with_confirmation_dialog_fragments)
            .setOnClickListener {
                SingleChoiceWithConfirmationDialogFragment.show(parentFragmentManager)
            }

        view.findViewById<Button>(R.id.button_multiple_choice_dialog_fragments).setOnClickListener {
            MultipleChoiceDialogFragment.show(parentFragmentManager)
        }

        view.findViewById<Button>(R.id.button_multiple_choice_with_confirmation_dialog_fragments)
            .setOnClickListener {
                MultipleChoiceWithConfirmationDialogFragment.show(parentFragmentManager)
            }
    }

    private fun setupDialogFragmentsListeners() {
        parentFragmentManager.setFragmentResultListener(
            SimpleDialogFragment.REQUEST_KEY,
            viewLifecycleOwner
        ) { _, result ->
            when (result.getInt(SimpleDialogFragment.KEY_RESPONSE)) {
                DialogInterface.BUTTON_POSITIVE -> showToast(R.string.android_uninstall)
                else -> showToast(R.string.android_uninstall_denied)
            }
        }

        SingleChoiceDialogFragment.setupListener(parentFragmentManager, viewLifecycleOwner) {
            currentVolume = it
            updateUI(requireView())
        }



    }

    companion object {
        @JvmStatic
        private val KEY_VOLUME = "KEY_VOLUME"
        @JvmStatic
        private val KEY_COLOR = "KEY_COLOR"
    }
}