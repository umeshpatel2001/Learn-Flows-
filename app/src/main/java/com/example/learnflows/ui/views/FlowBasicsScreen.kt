package com.example.learnflows.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.learnflows.ui.viewmodel.FlowBasicsScreenViewModel
import kotlinx.coroutines.launch

@Composable
fun FlowBasicsScreen(viewModel: FlowBasicsScreenViewModel = hiltViewModel()) {
    var result by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    Column(Modifier.padding(16.dp)) {
        Button(onClick = {
            result = ""
            // Launch a coroutine in Compose
            coroutineScope.launch {
                viewModel.customFlow().collect { value ->
                    result = value
                }
            }
        }) {
            Text("Run customFlow()")
        }

        Spacer(Modifier.height(8.dp))

        Button(onClick = {
            result = ""
            coroutineScope.launch {
                viewModel.staticFlow().collect { value ->
                    result += "$value "
                }
            }
        }) {
            Text("Run staticFlow()")
        }

        Spacer(Modifier.height(8.dp))

        Button(onClick = {
            result = ""
            coroutineScope.launch {
                viewModel.listFlow().collect { value ->
                    result += "$value "
                }
            }
        }) {
            Text("Run listFlow()")
        }

        Spacer(Modifier.height(8.dp))

        Button(onClick = {
            result = ""
            coroutineScope.launch {
                viewModel.concurrentFlow().collect { value ->
                    result += "$value\n"
                }
            }
        }) {
            Text("Run concurrentFlow()")
        }

        Spacer(Modifier.height(16.dp))
        Text(result)
    }
}