package com.mrkurilin.sample_project

import android.bluetooth.BluetoothManager
import android.content.Context
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

    private val adapter by lazy {
        val wifiStateActivityResultContractLauncher = registerForActivityResult(
            WifiStateActivityResultContract()
        ) {
            updateItems()
        }
        WidgetRecyclerAdapter {
            wifiStateActivityResultContractLauncher.launch(Any())
        }
    }

    private val bluetoothAdapter by lazy {
        val bluetoothManager = requireContext().applicationContext.getSystemService(
            Context.BLUETOOTH_SERVICE
        ) as BluetoothManager
        bluetoothManager.adapter
    }

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

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

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
            SwitchUiModel(bluetoothAdapter.isEnabled),
            TextViewUiModel,
            ToggleButtonUiModel,
        )
        adapter.setItems(items)
        adapter.notifyDataSetChanged()
    }
}