package com.mrkurilin.sample_project

import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import androidx.activity.result.contract.ActivityResultContract
import androidx.annotation.RequiresApi

@RequiresApi(api = Build.VERSION_CODES.Q)
class WifiStateActivityResultContract : ActivityResultContract<Any, Unit>() {

    override fun createIntent(context: Context, input: Any): Intent {
        return Intent(Settings.Panel.ACTION_WIFI)
    }

    override fun parseResult(resultCode: Int, intent: Intent?) {
        //do nothing
    }
}