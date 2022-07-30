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
import androidx.fragment.app.Fragment
import com.mrkurilin.sample_project.dialog_fragments.*
import kotlin.properties.Delegates

class DialogFragmentsFragment : Fragment() {

    private lateinit var textViewCurrentVolume: TextView
    private lateinit var viewToChangeColor: View
    private lateinit var dialogFragmentsData: DialogFragmentsData
    private var currentColor by Delegates.notNull<Int>()

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

        val volumes: IntArray = (0..100 step 10).toList().toIntArray()
        val volumesStrings: Array<String> =
            volumes.map { getString(R.string.volumes_list, it) }.toTypedArray()

        dialogFragmentsData = DialogFragmentsData(volumes, volumesStrings)

        bindViews()

        buttonsSetOnClickListeners(view)
        setupDialogFragmentsListeners()
    }

    private fun bindViews() {
        updateCurrentColor()
        textViewCurrentVolume.text = getString(
            R.string.current_volume,
            dialogFragmentsData.currentVolume
        )
        viewToChangeColor.setBackgroundColor(currentColor)
    }

    private fun buttonsSetOnClickListeners(view: View) {
        val listener = View.OnClickListener { clickedView: View ->
            val dialogFragment = when (clickedView.id) {
                R.id.button_default_dialog_fragments -> {
                    SimpleDialogFragment()
                }
                R.id.button_single_choice_dialog_fragments -> {
                    SingleChoiceDialogFragment()
                }
                R.id.button_single_choice_with_confirmation_dialog_fragments -> {
                    SingleChoiceWithConfirmationDialogFragment()
                }
                R.id.button_multiple_choice_dialog_fragments -> {
                    MultipleChoiceDialogFragment()
                }
                R.id.button_multiple_choice_with_confirmation_dialog_fragments -> {
                    MultipleChoiceWithConfirmationDialogFragment()
                }
                else -> {
                    throw IllegalArgumentException("Illegal id")
                }
            }
            dialogFragment.arguments = bundleOf(
                DialogFragmentsData.RESPONSE_KEY to dialogFragmentsData
            )
            dialogFragment.show(parentFragmentManager, null)
        }

        val linearLayout =
            view.findViewById<LinearLayoutCompat>(R.id.linear_layout_dialog_fragments)

        linearLayout.forEach { childView: View ->
            if (childView is Button) {
                childView.setOnClickListener(listener)
            }
        }
    }

    private fun setupDialogFragmentsListeners() {
        parentFragmentManager.setFragmentResultListener(
            DialogFragmentsData.REQUEST_KEY,
            this
        ) { _, result ->
            dialogFragmentsData = result.getParcelable(DialogFragmentsData.REQUEST_KEY)
                ?: dialogFragmentsData
            bindViews()
        }
    }

    private fun updateCurrentColor() {
        val myColor = dialogFragmentsData.currentColorAsBooleans
        currentColor = Color.rgb(
            if (myColor.redEnabled) 255 else 0,
            if (myColor.greenEnabled) 255 else 0,
            if (myColor.blueEnabled) 255 else 0
        )
    }
}