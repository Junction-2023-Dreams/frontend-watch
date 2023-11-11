package com.junction.watchfrontend.presentation.composables

import android.content.Context
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.junction.watchfrontend.R
import com.junction.watchfrontend.presentation.theme.MyApplicationTheme

@Composable
fun breathExcerciseComposable(activity: ComponentActivity, iterations: Int = 1) {
    var stage by remember { mutableStateOf(0) }


    fun startSchedule(iterations: Int) {
        if(iterations <= 0) {
            stage = 3
            return;
        }

        Handler().postDelayed({
            stage = 0
            Handler().postDelayed({
                stage = 1
                Handler().postDelayed({
                    stage = 2

                    Handler().postDelayed({
                        startSchedule(iterations - 1);
                    }, 1500)
                }, 1500)
            }, 1500)
        }, 1500)
    }

    startSchedule(iterations);
    MyApplicationTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (stage <= 0) {
                Icon(
                    painter = painterResource(id = R.drawable.outline_workspaces_24),
                    "Breath in",
                    tint = MaterialTheme.colors.primary,
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Breath in"
                )
            } else if (stage == 1) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_more_horiz_24),
                    "Breath in",
                    tint = MaterialTheme.colors.primary,
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Hold"
                )
            } else if (stage == 2) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_air_24),
                    "Breath out",
                    tint = MaterialTheme.colors.primary,
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Breath out"
                )
            } else {

                Text(
                    "Default Body State \nMeasurement\nfinished",
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(6.dp))
                Button(onClick = {
                    activity.getSharedPreferences("prefs", Context.MODE_PRIVATE).edit()
                        .putBoolean("isPersonsDefaultStateSaved", true).apply()
                    // reload app
                    activity.recreate()
                }) {
                    Text("Finish")
                }
            }
        }

    }
}