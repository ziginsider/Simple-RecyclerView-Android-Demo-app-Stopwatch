package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val stopwatchAdapter = StopwatchAdapter()
    private val stopwatches = mutableListOf<Stopwatch>()
    private var nextId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = stopwatchAdapter
        }

        binding.addNewStopwatchButton.setOnClickListener {
            stopwatches.add(Stopwatch(nextId++, 0, true))
            stopwatchAdapter.submitList(stopwatches.toList())
        }
    }
}