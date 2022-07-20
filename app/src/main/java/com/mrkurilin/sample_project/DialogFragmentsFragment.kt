package com.mrkurilin.sample_project

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.mrkurilin.sample_project.dialog_fragments.*
import showToast

class DialogFragmentsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog_fragments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_default_dialog_fragments).setOnClickListener {
            SimpleDialogFragment.show(parentFragmentManager)
        }

        view.findViewById<Button>(R.id.button_single_choice_dialog_fragments).setOnClickListener {
            SingleChoiceDialogFragment.show(parentFragmentManager)
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

        setupSimpleDialogFragmentListener()
        setupSingleChoiceDialogFragmentListener()
        setupSingleChoiceWithConfirmationDialogFragmentListener()
        setupMultipleChoiceDialogFragmentListener()
        setupMultipleChoiceWithConfirmationDialogFragmentListener()
    }

    private fun setupSimpleDialogFragmentListener() {
        parentFragmentManager.setFragmentResultListener(
            SimpleDialogFragment.REQUEST_KEY,
            viewLifecycleOwner
        ) { _, result ->
            when (result.getInt(SimpleDialogFragment.KEY_RESPONSE)) {
                DialogInterface.BUTTON_POSITIVE -> showToast(R.string.android_uninstall)
                else -> showToast(R.string.android_uninstall_denied)
            }
        }
    }

    private fun setupSingleChoiceDialogFragmentListener() {
        // TODO:
    }

    private fun setupSingleChoiceWithConfirmationDialogFragmentListener() {
        // TODO:
    }

    private fun setupMultipleChoiceDialogFragmentListener() {
        // TODO:
    }

    private fun setupMultipleChoiceWithConfirmationDialogFragmentListener() {
        // TODO:
    }
}