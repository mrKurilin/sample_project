package com.mrkurilin.sample_project.adapter.holder

import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.R

class SwitchViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val switchWifi: SwitchCompat = view.findViewById(R.id.switch_wifi_switch_widget)
    private val switchBluetooth: SwitchCompat = view.findViewById(R.id.switch_bluetooth_switch_widget)
    private val switchAirplaneMode: SwitchCompat = view.findViewById(R.id.switch_airplane_mode_switch_widget)
    private val onCheckedChangeListener: CompoundButton.OnCheckedChangeListener by lazy { getOnChangeCheckedListener() }

    init {
        switchWifi.setOnCheckedChangeListener(onCheckedChangeListener)
        switchBluetooth.setOnCheckedChangeListener(onCheckedChangeListener)
        switchAirplaneMode.setOnCheckedChangeListener(onCheckedChangeListener)
    }

    private fun getOnChangeCheckedListener(): CompoundButton.OnCheckedChangeListener{
        return CompoundButton.OnCheckedChangeListener{ buttonView, isChecked ->
            when (buttonView) {
                switchWifi -> showWifiState(isChecked)
                switchBluetooth -> showBluetoothState(isChecked)
                switchAirplaneMode -> showAirplaneModeState(isChecked)
            }
        }
    }

    private fun showWifiState(isChecked: Boolean) {
        var wifiState = "Wifi: "
        wifiState += if (isChecked) "On" else "Off"
        sendToast(wifiState)
    }

    private fun showBluetoothState(isChecked: Boolean) {
        var bluetoothState = "Bluetooth: "
        bluetoothState += if (isChecked) "On" else "Off"
        sendToast(bluetoothState)
    }

    private fun showAirplaneModeState(isChecked: Boolean) {
        var airplaneModeState = "Airplane mode: "
        airplaneModeState += if (isChecked) "On" else "Off"
        sendToast(airplaneModeState)
    }

    private fun sendToast(text: String) {
        Toast.makeText(itemView.context, text, Toast.LENGTH_SHORT).show()
    }
}