package com.mrkurilin.sample_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.mrkurilin.sample_project.dialog_fragments.SimpleDialogFragment

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
            showSimpleDialogFragment()
        }

        view.findViewById<Button>(R.id.button_single_choice_dialog_fragments).setOnClickListener {

        }

        view.findViewById<Button>(R.id.button_single_choice_with_confirmation_dialog_fragments)
            .setOnClickListener {

            }

        view.findViewById<Button>(R.id.button_multiple_choice_dialog_fragments).setOnClickListener {

        }

        view.findViewById<Button>(R.id.button_multiple_choice_with_confirmation_dialog_fragments)
            .setOnClickListener {

            }
    }

    fun showSimpleDialogFragment() {
        val dialogFragment = SimpleDialogFragment()
        dialogFragment.show(parentFragmentManager, SimpleDialogFragment.TAG)
    }

}