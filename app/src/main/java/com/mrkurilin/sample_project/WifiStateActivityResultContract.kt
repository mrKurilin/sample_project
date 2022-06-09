package com.mrkurilin.sample_project

import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import androidx.activity.result.contract.ActivityResultContract

class WifiStateActivityResultContract : ActivityResultContract<Any, Unit>() {

    override fun createIntent(context: Context, input: Any): Intent {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            Intent(Settings.Panel.ACTION_WIFI)
        } else {
            throw IllegalArgumentException("Invoked ActivityResultContract.createIntent() " +
                    "with Android version < Android.Q")
        }
    }

    override fun parseResult(resultCode: Int, intent: Intent?) {
    }
}