package com.mrkurilin.sample_project.adapter.holder

import android.view.View
import android.widget.CompoundButton
import android.widget.TextView
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.mrkurilin.sample_project.R

class ChipsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val chipGroup: ChipGroup = view.findViewById(R.id.chipgroup_chips_widget)
    private val textView: TextView = view.findViewById(R.id.textview_chip_widget)
    private val initialWordsArray = getSourceStringArray()
    private var arrayToShow = initialWordsArray

    private val filterItems = mutableListOf<Int>()

    private val listener = CompoundButton.OnCheckedChangeListener { buttonView, _ ->
        val id = buttonView.id

        if (filterItems.contains(id)) {
            filterItems.remove(id)
        } else {
            filterItems.add(id)
        }

        arrayToShow = initialWordsArray.filter { word ->
            check(word)
        }

        textView.text = arrayToShow.joinToString("\n")
    }

    init {
        textView.text = arrayToShow.joinToString("\n")
        chipGroup.children.forEach {
            (it as Chip).setOnCheckedChangeListener(listener)
        }
    }

    private fun getSourceStringArray(): List<String> {
        return itemView.resources.getString(R.string.lipsum)
            .uppercase()
            .replace(".", "")
            .replace(",", "")
            .split(" ")
            .toMutableSet()
            .sorted()
    }

    private fun check(word: String): Boolean {
        var result = true
        filterItems.forEach { filterItem ->
            result = when (filterItem) {
                R.id.chip_kword_chips_widget -> word.startsWith("K")
                R.id.chip_nend_word_chip_widget -> word.endsWith("N")
                R.id.chip_tcontain_word_chip_widget -> word.contains("L")
                R.id.chip_kotlin_word_chip_widget -> word == "KOTLIN"
                else -> {
                    throw Exception("Illegal id")
                }
            }
        }
        return result
    }
}