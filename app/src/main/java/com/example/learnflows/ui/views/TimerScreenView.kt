package com.example.learnflows.ui.views

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.learnflows.ui.viewmodel.TimerScreenViewModel
import kotlinx.coroutines.launch

@Composable
fun TimerScreenView() {
    val viewModel: TimerScreenViewModel = hiltViewModel()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val timer by viewModel.timerState.collectAsState()


    LaunchedEffect(Unit) {
        viewModel.event.collect { msg ->
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }

    Column {

        Text("Timer: $timer")
        Spacer(Modifier.height(13.dp))
        Button(onClick = {
            scope.launch {
                viewModel.startTimer()
            }
        }) {
            Text("Start Timer")
        }
        Spacer(Modifier.height(13.dp))
        Button(onClick = {
            viewModel.resetTimer()
        }) {
            Text("Reset Timer")
        }
    }
}