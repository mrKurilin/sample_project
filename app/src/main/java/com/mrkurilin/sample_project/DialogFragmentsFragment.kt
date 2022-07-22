package com.mrkurilin.sample_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.mrkurilin.sample_project.dialog_fragments.*
import com.mrkurilin.sample_project.dialog_fragments.DialogFragmentsValues.Companion.currentColor
import com.mrkurilin.sample_project.dialog_fragments.DialogFragmentsValues.Companion.currentVolume

class DialogFragmentsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog_fragments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateUI(view)

        buttonsSetOnClickListeners(view)
        setupDialogFragmentsListeners()
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

    private fun buttonsSetOnClickListeners(view: View) {
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
        SingleChoiceDialogFragment.setupListener(parentFragmentManager, viewLifecycleOwner) {
            currentVolume = it
            updateUI(requireView())
        }

        SingleChoiceWithConfirmationDialogFragment.setupListener(
            parentFragmentManager,
            viewLifecycleOwner
        ) {
            updateUI(requireView())
        }

        MultipleChoiceDialogFragment.setupListener(parentFragmentManager, viewLifecycleOwner) {
            updateUI(requireView())
        }

        MultipleChoiceWithConfirmationDialogFragment.setupListener(
            parentFragmentManager,
            viewLifecycleOwner
        ) {
            updateUI(requireView())
        }
    }
}