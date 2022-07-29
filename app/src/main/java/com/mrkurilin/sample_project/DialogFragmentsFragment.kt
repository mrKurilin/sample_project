package com.mrkurilin.sample_project

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.os.bundleOf
import androidx.core.view.forEach
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.mrkurilin.sample_project.dialog_fragments.*

class DialogFragmentsFragment : Fragment() {

    private lateinit var textViewCurrentVolume: TextView
    private lateinit var viewToChangeColor: View
    private var currentVolume = 0
    private var currentColor = Color.WHITE
    var colorAsBooleanArray = booleanArrayOf(false, false, false)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog_fragments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewCurrentVolume = view.findViewById(R.id.textview_dialog_fragments)
        viewToChangeColor = view.findViewById(R.id.view_dialog_fragments_fragment)

        bindViews()

        buttonsSetOnClickListeners(view)
        setListeners()
    }

    private fun bindViews() {
        textViewCurrentVolume.text = getString(
            R.string.current_volume,
            currentVolume
        )
        viewToChangeColor.setBackgroundColor(currentColor)
    }

    private fun buttonsSetOnClickListeners(view: View) {
        val listener = View.OnClickListener { v: View ->
            val dialogFragment: DialogFragment
            when (v.id) {
                R.id.button_default_dialog_fragments -> {
                    dialogFragment = SimpleDialogFragment()
                }
                R.id.button_single_choice_dialog_fragments -> {
                    dialogFragment = SingleChoiceDialogFragment()
                    dialogFragment.arguments = bundleOf(
                        SingleChoiceDialogFragment.CURRENT_VOLUME_KEY to currentVolume
                    )
                }
                R.id.button_single_choice_with_confirmation_dialog_fragments -> {
                    dialogFragment = SingleChoiceWithConfirmationDialogFragment()
                    dialogFragment.arguments = bundleOf(
                        SingleChoiceWithConfirmationDialogFragment.CURRENT_VOLUME_KEY to currentVolume
                    )
                }
                R.id.button_multiple_choice_dialog_fragments -> {
                    dialogFragment = MultipleChoiceDialogFragment()
                    dialogFragment.arguments = bundleOf(
                        MultipleChoiceDialogFragment.BOOLEAN_COLOR_KEY to colorAsBooleanArray
                    )
                }
                R.id.button_multiple_choice_with_confirmation_dialog_fragments -> {
                    dialogFragment = MultipleChoiceWithConfirmationDialogFragment()
                    dialogFragment.arguments = bundleOf(
                        MultipleChoiceWithConfirmationDialogFragment.BOOLEAN_COLOR_KEY
                                to colorAsBooleanArray
                    )
                }
                else -> {
                    throw IllegalArgumentException("Illegal id")
                }
            }
            dialogFragment.show(parentFragmentManager, "TAG")
        }

        val linearLayout =
            view.findViewById<LinearLayoutCompat>(R.id.linear_layout_dialog_fragments)

        linearLayout.forEach { childView: View ->
            if (childView is Button) childView.setOnClickListener(listener)
        }
    }

    private fun setListeners() {
        parentFragmentManager.setFragmentResultListener(
            SingleChoiceDialogFragment.REQUEST_KEY,
            this
        ) { _, result ->
            currentVolume = result.getInt(SingleChoiceDialogFragment.CURRENT_VOLUME_KEY)
            bindViews()
        }

        parentFragmentManager.setFragmentResultListener(
            SingleChoiceWithConfirmationDialogFragment.REQUEST_KEY,
            this
        ) { _, result ->
            currentVolume = result.getInt(
                SingleChoiceWithConfirmationDialogFragment.CURRENT_VOLUME_KEY
            )
            bindViews()
        }

        parentFragmentManager.setFragmentResultListener(
            MultipleChoiceDialogFragment.REQUEST_KEY,
            this
        ) { _, result ->
            updateCurrentColor(
                result.getBooleanArray(
                    MultipleChoiceDialogFragment.BOOLEAN_COLOR_KEY
                )
            )
            bindViews()
        }

        parentFragmentManager.setFragmentResultListener(
            MultipleChoiceWithConfirmationDialogFragment.REQUEST_KEY,
            this
        ) { _, result ->
            updateCurrentColor(
                result.getBooleanArray(
                    MultipleChoiceWithConfirmationDialogFragment.BOOLEAN_COLOR_KEY
                )
            )
            bindViews()
        }
    }

    private fun updateCurrentColor(array: BooleanArray?) {
        if (array != null) {
            colorAsBooleanArray = array
            currentColor = Color.rgb(
                if (array[0]) 255 else 0,
                if (array[1]) 255 else 0,
                if (array[2]) 255 else 0
            )
        }
    }
}