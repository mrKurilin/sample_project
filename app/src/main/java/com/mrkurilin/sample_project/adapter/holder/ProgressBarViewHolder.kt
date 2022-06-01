package com.mrkurilin.sample_project.adapter.holder

import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.R

private const val DEFAULT_TIMER_DURATION = 15000L
private const val DEFAULT_FINISH_TIME = 0L

class ProgressBarViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val startButton: Button = view.findViewById(R.id.button_start_progressbar_widget)
    private val progressBarCircle: ProgressBar = view.findViewById(
        R.id.progressbar_circular_progressbar_widget
    )
    private val progressBarHorizontal: ProgressBar = view.findViewById(
        R.id.progressbar_horizontal_progressbar_widget
    )
    private var finishTime = DEFAULT_FINISH_TIME
    private var countDownTimer: CountDownTimer? = null

    init {
        progressBarHorizontal.max = DEFAULT_TIMER_DURATION.toInt()

        startButton.setOnClickListener {
            progressBarHorizontal.progress = 0

            setContentVisibility(inProgress = true)

            finishTime = System.currentTimeMillis() + DEFAULT_TIMER_DURATION

            countDownTimer = getCountDownTimer(DEFAULT_TIMER_DURATION)
            countDownTimer?.start()
        }
    }

    fun setContentVisibility(inProgress: Boolean) {
        startButton.isVisible = !inProgress
        progressBarCircle.isVisible = inProgress
        progressBarHorizontal.isVisible = inProgress
    }

    private fun getCountDownTimer(millisInFuture: Long): CountDownTimer {
        return object : CountDownTimer(millisInFuture, 15) {

            override fun onTick(millisUntilFinished: Long) {
                val timePast = (DEFAULT_TIMER_DURATION - millisUntilFinished).toInt()
                progressBarHorizontal.progress = timePast
            }

            override fun onFinish() {
                setContentVisibility(inProgress = false)
            }
        }
    }

    fun onViewAttachedToWindow() {
        val timeLeft = finishTime - System.currentTimeMillis()
        if (timeLeft > 0) {
            countDownTimer = getCountDownTimer(timeLeft)
            countDownTimer?.start()
        } else {
            setContentVisibility(false)
        }
    }

    fun onViewDetachedFromWindow() {
        countDownTimer?.cancel()
    }
}