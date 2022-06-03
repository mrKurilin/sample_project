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
    private val sourceArray = getSourceStringArray()
    private var arrayToShow = sourceArray

    init {
        textView.text = arrayToShow.joinToString("\n")
        chipGroup.children.forEach {
            (it as Chip).setOnCheckedChangeListener(getListener())
        }
    }

    private fun getListener(): CompoundButton.OnCheckedChangeListener {
        return object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                arrayToShow = sourceArray
                if (!isChecked && chipGroup.checkedChipIds.size == 1) {
                    textView.text = arrayToShow.joinToString("\n")
                    return
                } else {
                    if (isChecked) {
                        updateText(buttonView!!.id)
                    }
                    chipGroup.checkedChipIds.forEach { checkedChipId ->
                        if (checkedChipId != buttonView!!.id) {
                            updateText(checkedChipId)
                        }
                    }
                }
            }
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

    private fun updateText(chipId: Int = 0) {
        when (chipId) {
            R.id.chip_kword_chips_widget -> {
                arrayToShow = arrayToShow.filter { it.startsWith("K") }
            }
            R.id.chip_nend_word_chip_widget -> {
                arrayToShow = arrayToShow.filter { it.endsWith("N") }
            }
            R.id.chip_tcontain_word_chip_widget -> {
                arrayToShow = arrayToShow.filter { it.contains("L") }
            }
            R.id.chip_kotlin_word_chip_widget -> {
                arrayToShow = mutableListOf("KOTLIN")
            }
        }
        textView.text = arrayToShow.joinToString("\n")
    }
}