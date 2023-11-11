package com.junction.watchfrontend.presentation.composables

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.junction.watchfrontend.presentation.theme.MyApplicationTheme

@Composable
fun personDefaultStateEvaluationComposable(activity: ComponentActivity) {

    var hasStarted by remember { mutableStateOf(false) }

    MyApplicationTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {
            if (!hasStarted) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Default Body State \nMeasurement"
                )
                Spacer(modifier = Modifier.height(16.dp))
                // button min size
                Button(
                    onClick = {
                        hasStarted = true

                    },
                    modifier = Modifier
                        .minimumInteractiveComponentSize()
                        .height(38.dp),
                ) {
                    Text(text = "Start")
                }


            } else {
                breathExcerciseComposable(activity, 1);
            }
        }

    }
}