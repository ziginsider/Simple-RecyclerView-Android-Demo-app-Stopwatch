package com.example.stopwatch

import android.os.CountDownTimer
import androidx.recyclerview.widget.RecyclerView
import com.example.stopwatch.databinding.StopwatchItemBinding

class StopwatchViewHolder(
    private val binding: StopwatchItemBinding
): RecyclerView.ViewHolder(binding.root) {

    private val timer: CountDownTimer? = null

    fun bind(stopwatch: Stopwatch) {
        binding.stopwatchTimer.text = stopwatch.currentMs.displayTime()

        if (stopwatch.isStarted) {
            startTimer(stopwatch)
        }
    }

    private fun startTimer(stopwatch: Stopwatch) {

    }

    private fun getCountDownTimer(stopwatch: Stopwatch): CountDownTimer {
        return object : CountDownTimer(
            timer.periodMillis - timer.currentMillis,
            UNIT_TEN_MS
        ) {
            val interval = UNIT_TEN_MS

            override fun onTick(millisUntilFinished: Long) {
                stopwatch.currentMs += interval

            }

            override fun onFinish() {
                binding.timerView.setCurrent(timer.currentMillis)
                timer.currentMillis = 0
                listener.stopTimer(timer)
                val color = binding.root.context.resources.getColor(R.color.deep_orange_100_dark)
                binding.root.setCardBackgroundColor(color)
            }
        }
    }

    private fun Long.displayTime(): String {
        if (this <= 0L) {
            return START_TIME
        }
        val h = this / 1000 / 3600
        val m = this / 1000 % 3600 / 60
        val s = this / 1000 % 60
        val ms = this % 1000 / 10

        return "${displaySlot(h)}:${displaySlot(m)}:${displaySlot(s)}:${displaySlot(ms)}"
    }

    private fun displaySlot(count: Long): String {
        return if (count / 10L > 0) {
            "$count"
        } else {
            "0$count"
        }
    }

    private companion object {

        private const val START_TIME = "00:00:00:00"
        private const val UNIT_TEN_MS = 10L
    }
}