package com.mrkurilin.sample_project.adapter.holder

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.R

const val EMPTY_DATA_TEXT = "Enter information!"

class EditTextViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val nameEditText: EditText = view.findViewById(R.id.edittext_name_edittext_widget)
    private val numberEditText: EditText = view.findViewById(R.id.edittext_number_edittext_widget)
    private val okButton: Button = view.findViewById(R.id.button_ok_edittext_widget)

    init {
        okButton.setOnClickListener {
            val nameEntered = nameEditText.text.isNotEmpty()
            val numberEntered = numberEditText.text.length == 11
            if (nameEntered && numberEntered) {
                val nameText = nameEditText.text
                val numText = numberEditText.text
                Toast.makeText(
                    itemView.context,
                    "Спасибо, $nameText! С вашего номера $numText будет списано 15,000 рублей!",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(itemView.context, EMPTY_DATA_TEXT, Toast.LENGTH_LONG).show()

                if (!nameEntered) {
                    nameEditText.error = "Enter your name here"
                }
                if (!numberEntered) {
                    numberEditText.error = "Enter the number in 11-character format"
                }
            }
        }
    }
}