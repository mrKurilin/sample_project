package com.mrkurilin.sample_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.adapter.WidgetRecyclerAdapter
import com.mrkurilin.sample_project.ui_model.*

class RecyclerViewFragment : Fragment() {

    private val wifiStateActivityResultContract = WifiStateActivityResultContract()
    private val wifiStateActivityResultContractLauncher = registerForActivityResult(
        wifiStateActivityResultContract,
    ) {
        updateItems()
    }

    private val adapter = WidgetRecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_fragment)

        val linearLayoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = linearLayoutManager

        adapter.setActivityLauncher {
            wifiStateActivityResultContractLauncher.launch(Any())
        }

        recyclerView.adapter = adapter
        updateItems()
    }

    private fun updateItems() {
        val items = listOf(
            AutocompleteUiModel,
            CheckBoxUiModel,
            ChipsUiModel,
            EditTextUiModel,
            ProgressBarUiModel,
            RadioButtonUiModel,
            RatingBarUiModel,
            SeekBarUiModel,
            SpinnerUiModel,
            SwitchUiModel,
            TextViewUiModel,
            ToggleButtonUiModel,
        )
        adapter.setItems(items)

        adapter.notifyDataSetChanged()
    }
}