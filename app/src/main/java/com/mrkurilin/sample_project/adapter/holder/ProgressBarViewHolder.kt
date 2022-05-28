package com.mrkurilin.sample_project.adapter.holder

import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.R

class ProgressBarViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val startButton = view.findViewById<Button>(R.id.button_start_progressbar_widget)
    val progressBarCircle =
        view.findViewById<ProgressBar>(R.id.progressbar_circular_progressbar_widget)
    val progressBarHorizontal =
        view.findViewById<ProgressBar>(R.id.progressbar_horizontal_progressbar_widget)
    val handler = Handler(Looper.getMainLooper())

    init {
        progressBarHorizontal.max = 100

        startButton.setOnClickListener {
            progressBarHorizontal.progress = 0
            startButton.visibility = View.GONE
            progressBarCircle.visibility = View.VISIBLE
            progressBarHorizontal.visibility = View.VISIBLE

            handler.post(object : Runnable {
                override fun run() {
                    progressBarHorizontal.progress += 1
                    if (progressBarHorizontal.progress < 100) {
                        handler.postDelayed(this, 100)
                    } else {
                        startButton.visibility = View.VISIBLE
                        progressBarCircle.visibility = View.GONE
                        progressBarHorizontal.visibility = View.GONE
                    }
                }
            })
        }
    }
}