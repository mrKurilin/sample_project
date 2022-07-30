package com.mrkurilin.sample_project.adapter.holder

import android.Manifest
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.pm.PackageManager
import android.net.wifi.WifiManager
import android.os.Build
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.R
import com.mrkurilin.sample_project.ui_model.SwitchUiModel

class SwitchViewHolder(
    view: View,
    private val toggleWifi: () -> Unit
) : RecyclerView.ViewHolder(view) {

    private val wifiSwitch: SwitchCompat = view.findViewById(R.id.switch_wifi_switch_widget)
    private val bluetoothSwitch: SwitchCompat = view.findViewById(
        R.id.switch_bluetooth_switch_widget
    )

    private val wifiManager = view.context.applicationContext.getSystemService(
        Context.WIFI_SERVICE
    ) as WifiManager

    private val wifiStateOn = view.resources.getString(R.string.wifi_on)
    private val wifiStateOff = view.resources.getString(R.string.wifi_off)
    private val bluetoothStateOn = view.resources.getString(R.string.bluetooth_on)
    private val bluetoothStateOff = view.resources.getString(R.string.bluetooth_off)

    private val bluetoothManager = view.context.applicationContext.getSystemService(
        Context.BLUETOOTH_SERVICE
    ) as BluetoothManager
    private val bluetoothAdapter = bluetoothManager.adapter

    init {
        wifiSwitch.isChecked = wifiManager.isWifiEnabled
        bluetoothSwitch.isChecked = bluetoothAdapter.isEnabled

        wifiSwitch.setOnClickListener {
            changeWifiState()
        }
        bluetoothSwitch.setOnClickListener {
            changeBluetoothState()
        }
    }

    @SuppressWarnings("deprecation")
    private fun changeWifiState() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            toggleWifi()
        } else {
            wifiManager.isWifiEnabled = !wifiManager.isWifiEnabled
            sendWifiToast()
        }
    }

    private fun changeBluetoothState() {
        val bluetoothPermissionGranted = ActivityCompat.checkSelfPermission(
            itemView.context,
            Manifest.permission.BLUETOOTH_ADMIN
        ) == PackageManager.PERMISSION_GRANTED

        if (bluetoothPermissionGranted) {
            if (bluetoothAdapter.isEnabled) {
                bluetoothAdapter.disable()
                Toast.makeText(itemView.context, bluetoothStateOff, Toast.LENGTH_LONG).show()
                bluetoothSwitch.isChecked = false

            } else {
                bluetoothAdapter.enable()
                Toast.makeText(itemView.context, bluetoothStateOn, Toast.LENGTH_LONG).show()
                bluetoothSwitch.isChecked = true
            }
        } else {
            Toast.makeText(itemView.context, "Permission denied", Toast.LENGTH_LONG).show()
            bluetoothSwitch.isEnabled = false
        }
    }

    private fun sendWifiToast() {
        if (wifiSwitch.isChecked) {
            Toast.makeText(itemView.context, wifiStateOn, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(itemView.context, wifiStateOff, Toast.LENGTH_LONG).show()
        }
    }

    fun bind(uiModel: SwitchUiModel) {
        bluetoothSwitch.isChecked = uiModel.bluetoothEnabled
    }
}