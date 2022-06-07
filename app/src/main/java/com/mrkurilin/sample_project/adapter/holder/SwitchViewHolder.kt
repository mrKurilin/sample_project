package com.mrkurilin.sample_project.adapter.holder

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.pm.PackageManager
import android.net.wifi.WifiManager
import android.provider.Settings
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.R

class SwitchViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val wifiSwitch: SwitchCompat = view.findViewById(R.id.switch_wifi_switch_widget)
    private val bluetoothSwitch: SwitchCompat = view.findViewById(
        R.id.switch_bluetooth_switch_widget
    )

    private val onCheckedChangeListener by lazy { createOnCheckedChangeListener() }

    private val wifiStateOn = view.resources.getString(R.string.wifi_on)
    private val wifiStateOff = view.resources.getString(R.string.wifi_off)
    private val bluetoothStateOn = view.resources.getString(R.string.bluetooth_on)
    private val bluetoothStateOff = view.resources.getString(R.string.bluetooth_off)

    private val wifiManager = view.context.applicationContext.getSystemService(
        Context.WIFI_SERVICE
    ) as WifiManager

    private val bluetoothManager = view.context.applicationContext.getSystemService(
        Context.BLUETOOTH_SERVICE
    ) as BluetoothManager
    private val bluetoothAdapter = bluetoothManager.adapter

    init {

        wifiSwitch.isChecked = wifiManager.isWifiEnabled
        bluetoothSwitch.isChecked = bluetoothAdapter.isEnabled

        wifiSwitch.setOnCheckedChangeListener(onCheckedChangeListener)
        bluetoothSwitch.setOnCheckedChangeListener(onCheckedChangeListener)
    }

    private fun createOnCheckedChangeListener(): CompoundButton.OnCheckedChangeListener {
        return CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            when (buttonView) {
                wifiSwitch -> showWifiState(isChecked)
                bluetoothSwitch -> showBluetoothState(isChecked)
            }
        }
    }

    private fun showWifiState(isChecked: Boolean) {
        wifiManager.isWifiEnabled = isChecked
        if (isChecked) {
            sendToast(wifiStateOn)
        } else {
            sendToast(wifiStateOff)
        }
    }

    private fun showBluetoothState(isChecked: Boolean) {
        if (ActivityCompat.checkSelfPermission(
                itemView.context,
                Manifest.permission.BLUETOOTH_CONNECT
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (isChecked) {
                bluetoothAdapter.enable()
                sendToast(bluetoothStateOn)
            } else {
                bluetoothAdapter.disable()
                sendToast(bluetoothStateOff)
            }
        } else {
            sendToast("Permission denied")
        }

    }

    private fun sendToast(text: String) {
        Toast.makeText(itemView.context, text, Toast.LENGTH_SHORT).show()
    }
}