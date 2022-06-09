package com.mrkurilin.sample_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.adapter.WidgetRecyclerAdapter
import com.mrkurilin.sample_project.adapter.holder.SwitchViewHolder

class RecyclerViewFragment : Fragment() {

    lateinit var switchViewHolder: SwitchViewHolder
    private val wifiStateActivityResultContract = WifiStateActivityResultContract()
    private val wifiStateActivityResultContractLauncher = registerForActivityResult(
        wifiStateActivityResultContract
    ) {
        switchViewHolder.updateWifiSwitchState()
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
        val linearLayoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = linearLayoutManager
        val adapter = WidgetRecyclerAdapter(requireContext(), this)
        recyclerView.adapter = adapter
    }

    fun launchWifiStateActivity() {
        wifiStateActivityResultContractLauncher.launch(Any())
    }
}