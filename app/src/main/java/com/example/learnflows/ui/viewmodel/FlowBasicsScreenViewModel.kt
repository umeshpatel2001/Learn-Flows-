package com.example.learnflows.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learnflows.ui.FlowBasics
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FlowBasicsScreenViewModel @Inject constructor() : ViewModel() {

    val countDownFlow = FlowBasics.countdownFlow()
    fun customFlow() = FlowBasics.customFlow()
    fun staticFlow() = FlowBasics.staticFlow()
    fun listFlow() = FlowBasics.listFlow()
    fun concurrentFlow() = FlowBasics.concurrentFlow()
}