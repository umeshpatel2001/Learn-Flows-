package com.example.learnflows.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learnflows.ui.FlowBasics
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FlowBasicsScreenViewModel @Inject constructor() : ViewModel() {

    init {
        viewModelScope.launch {
            filterAndMapFlow().collect {
                println("Filtered and mapped value: $it")
            }
        }
    }

    val countDownFlow = FlowBasics.countdownFlow()
    fun customFlow() = FlowBasics.customFlow()
    fun staticFlow() = FlowBasics.staticFlow()
    fun listFlow() = FlowBasics.listFlow()
    fun concurrentFlow() = FlowBasics.concurrentFlow()

    fun numberFlow(): Flow<Int> {
        return flow {
            for (i in 1..10) {
                emit(i)
                delay(100)
            }
        }
    }

    fun filterAndMapFlow(): Flow<Int> {
        return numberFlow().filter { it % 2 == 0 }.map { it * 2 }
    }
}