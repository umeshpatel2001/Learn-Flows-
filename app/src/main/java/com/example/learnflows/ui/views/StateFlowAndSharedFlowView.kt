package com.example.learnflows.ui.views

import android.widget.Toast
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
import com.example.learnflows.ui.viewmodel.StateFlowAndSharedFlowViewModel
import kotlinx.coroutines.launch

@Composable
fun StateFlowAndSharedFlowView(viewModel: StateFlowAndSharedFlowViewModel = hiltViewModel()) {
    val count by viewModel.count.collectAsState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.event.collect { msg ->
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }
    Text("Your count $count")
    Spacer(Modifier.height(13.dp))
    Button(onClick = {
        viewModel.increment()
        scope.launch {
            viewModel.showToast()
        }
    }) {
        Text("Increment")
    }
    Spacer(Modifier.height(13.dp))
    Button(onClick = {
        viewModel.decrement()
    }) {
        Text("Decrement")
    }
}