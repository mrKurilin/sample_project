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
import com.mrkurilin.sample_project.RecyclerViewFragment

class SwitchViewHolder(view: View, private val recyclerViewFragment: RecyclerViewFragment) :
    RecyclerView.ViewHolder(view) {

    private val wifiSwitch: SwitchCompat = view.findViewById(R.id.switch_wifi_switch_widget)
    private val bluetoothSwitch: SwitchCompat = view.findViewById(
        R.id.switch_bluetooth_switch_widget
    )

    private val onClickListener by lazy { createOnClickListener() }

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
        recyclerViewFragment.switchViewHolder = this

        wifiSwitch.isChecked = wifiManager.isWifiEnabled
        bluetoothSwitch.isChecked = bluetoothAdapter.isEnabled

        wifiSwitch.setOnClickListener(onClickListener)
        bluetoothSwitch.setOnClickListener(onClickListener)
    }

    private fun createOnClickListener(): View.OnClickListener {
        return View.OnClickListener { view ->
            when (view) {
                wifiSwitch -> changeWifiState()
                bluetoothSwitch -> changeBluetoothState()
            }
        }
    }

    @SuppressWarnings("deprecation")
    private fun changeWifiState() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            recyclerViewFragment.launchWifiStateActivity()
        } else {
            val isWifiEnabled = wifiManager.isWifiEnabled
            wifiManager.isWifiEnabled = !isWifiEnabled
            updateWifiSwitchState()
        }
    }

    private fun changeBluetoothState() {
        if (ActivityCompat.checkSelfPermission(
                itemView.context,
                Manifest.permission.BLUETOOTH_CONNECT
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            when (bluetoothAdapter.isEnabled) {
                true -> {
                    bluetoothAdapter.disable()
                    sendToast(bluetoothStateOff)
                    bluetoothSwitch.isChecked = false
                }
                false -> {
                    bluetoothAdapter.enable()
                    sendToast(bluetoothStateOn)
                    bluetoothSwitch.isChecked = true
                }
            }
        } else {
            sendToast("Permission denied")
        }
    }

    fun updateWifiSwitchState() {
        wifiSwitch.isChecked = wifiManager.isWifiEnabled
        if (wifiSwitch.isChecked) {
            sendToast(wifiStateOn)
        } else {
            sendToast(wifiStateOff)
        }
    }

    private fun sendToast(text: String) {
        Toast.makeText(itemView.context, text, Toast.LENGTH_SHORT).show()
    }
}