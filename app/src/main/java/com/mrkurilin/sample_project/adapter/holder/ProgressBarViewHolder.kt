package com.mrkurilin.sample_project.adapter.holder

import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.mrkurilin.sample_project.R
import kotlin.math.absoluteValue
import kotlin.properties.Delegates

class ProgressBarViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val startButton: Button = view.findViewById(R.id.button_start_progressbar_widget)
    private val progressBarCircle: ProgressBar = view.findViewById(
        R.id.progressbar_circular_progressbar_widget
    )
    private val progressBarHorizontal: ProgressBar = view.findViewById(
        R.id.progressbar_horizontal_progressbar_widget
    )
    var started = false
    private var finishTime by Delegates.notNull<Long>()
    lateinit var countDownTimer: CountDownTimer

    init {
        progressBarHorizontal.max = DEFAULT_TIMER_DURATION.toInt()

        startButton.setOnClickListener {
            progressBarHorizontal.progress = 0

            startButton.visibility = View.GONE
            progressBarCircle.visibility = View.VISIBLE
            progressBarHorizontal.visibility = View.VISIBLE

            finishTime = System.currentTimeMillis() + DEFAULT_TIMER_DURATION

            countDownTimer = getCountDownTimer(DEFAULT_TIMER_DURATION)
            countDownTimer.start()
            started = true
        }
    }

    fun buttonToVisible() {
        startButton.visibility = View.VISIBLE
        progressBarCircle.visibility = View.GONE
        progressBarHorizontal.visibility = View.GONE

        started = false
    }

    private fun getCountDownTimer(millisInFuture: Long): CountDownTimer {
        return object : CountDownTimer(millisInFuture, 15) {
            override fun onTick(millisUntilFinished: Long) {
                progressBarHorizontal.progress = (
                        DEFAULT_TIMER_DURATION
                                - finishTime
                                + System.currentTimeMillis()
                        ).absoluteValue.toInt()
            }

            override fun onFinish() {
                buttonToVisible()
                started = false
            }
        }
    }

    fun stopTimer() {
        countDownTimer.cancel()
    }

    fun resumeTimer() {
        val timeLeft = finishTime - System.currentTimeMillis()
        countDownTimer = getCountDownTimer(timeLeft)
        countDownTimer.start()
    }

    companion object {
        private const val DEFAULT_TIMER_DURATION = 1500L
    }
}