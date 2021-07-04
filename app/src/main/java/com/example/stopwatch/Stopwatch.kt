package com.example.stopwatch

data class Stopwatch(
    val id: Int,
    val currentMs: Long,
    val isStarted: Boolean
)