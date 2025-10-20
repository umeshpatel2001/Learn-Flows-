package com.example.learnflows.ui

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

object FlowBasics {

    fun numberFlows(): Flow<Int> {
        return flow {
            for (i in 1..10) {
                emit(i)
                delay(100)
            }
        }
    }

    fun countdownFlow(): Flow<Int> = flow {
        for (i in 10 downTo 0) {
            emit(i)
            delay(1000)
        }
    }

    fun customFlow(): Flow<String>{
        return flow {
            emit("Loading data...")
            delay(1000)
            emit("Fetching user info...")
            delay(1000)
            emit("Success ✅")
        }
    }

    fun listFlow(): Flow<String> {
        val list = listOf("Apple", "Banana", "Cherry")
        return list.asFlow()
    }

    fun staticFlow(): Flow<Int> = flowOf(10, 20, 30, 40)

    fun concurrentFlow(): Flow<String> = channelFlow {
        launch {
            delay(1000)
            send("Data from coroutine 1")
        }
        launch {
            delay(500)
            send("Data from coroutine 2")
        }
        launch {
            delay(1500)
            send("Data from coroutine 3")
        }
    }

}