package com.junction.watchfrontend.presentation.composables.home.relax

import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
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
import kotlinx.coroutines.delay

@Composable
fun BreathExerciseComposable(
    activity: ComponentActivity,
    iterations: Int = 1,
    titleFinished: @Composable () -> Unit = {
        Text(
            "Default Body State\nMeasurement\nfinished",
            textAlign = TextAlign.Center,
        )
    },
    onFinish: () -> Unit = {}
) {
    var stage by remember { mutableStateOf(0) }
    var progress by remember { mutableStateOf(100f) }

    val delayMillis = 1500.toLong()

    fun countDownProgress() {
        progress -= 1f;
        if (progress <= 1) {
            progress = 100f;
            return;
        } else {
            Handler().postDelayed({
                countDownProgress()
            }, delayMillis / 200);
        }
    }

    var hasHandlerStarted by remember { mutableStateOf(false) };

    fun startSchedule(iterations: Int) {
        if (iterations <= 0) {
            stage = 3
            return;
        }

        if (!hasHandlerStarted) {
            hasHandlerStarted = true;

            Handler().postDelayed({
                stage = 0
                countDownProgress()
                Handler().postDelayed({
                    stage = 1
                    countDownProgress()
                    Handler().postDelayed({
                        stage = 2
                        countDownProgress()
                        Handler().postDelayed({
                            hasHandlerStarted = false;
                            startSchedule(iterations - 1);
                        }, delayMillis)
                    }, delayMillis)
                }, delayMillis)
            }, delayMillis)
        }
    }


    startSchedule(iterations);
    MyApplicationTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                progress = progress / 100,
                modifier = Modifier
                    .fillMaxSize(),
                strokeWidth = 3.dp,
                color = MaterialTheme.colors.primary,
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
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

                    // HorizontalPageIndicator()

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
                    titleFinished()
                    Spacer(modifier = Modifier.height(6.dp))
                    Button(onClick = {
                        onFinish()
                    }) {
                        Text("Finish")
                    }
                }
            }
        }
    }
}