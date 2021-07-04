package com.example.stopwatch

data class Stopwatch(
    val id: Int,
    var currentMs: Long,
    var isStarted: Boolean
)