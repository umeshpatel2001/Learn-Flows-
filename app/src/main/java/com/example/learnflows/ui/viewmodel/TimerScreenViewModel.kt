package com.example.learnflows.ui.viewmodel

import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class TimerScreenViewModel @Inject constructor() : ViewModel() {

    private val _timerState = MutableStateFlow(0)
    val timerState: StateFlow<Int> = _timerState

    private val _event = MutableSharedFlow<String>()
    val event = _event.asSharedFlow()


    suspend fun startTimer() {
        for (i in 1..10) {
            _timerState.value = i
            delay(1000)
        }

        _event.emit("Timer Reached")

    }

    fun resetTimer() {
        _timerState.value = 1

    }

}