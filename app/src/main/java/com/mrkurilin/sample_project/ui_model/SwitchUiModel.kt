package com.mrkurilin.sample_project.ui_model

import android.app.Application
import android.net.wifi.WifiManager

data class SwitchUiModel(
    val isWifiEnabled: Boolean
): RecyclerViewUiModel