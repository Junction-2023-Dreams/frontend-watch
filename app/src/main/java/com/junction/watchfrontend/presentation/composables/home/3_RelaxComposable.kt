package com.junction.watchfrontend.presentation.composables.home

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TitleCard
import com.junction.watchfrontend.presentation.composables.utils.ColumnComposable
import com.junction.watchfrontend.presentation.composables.utils.SpacerComposable
import com.junction.watchfrontend.presentation.composables.exercises.breathExerciseComposable
import com.junction.watchfrontend.presentation.composables.utils.toastNotImplemented

@Composable
fun RelaxComposable(activity: ComponentActivity, isDebug: Boolean, startWithBreathingExercise: Boolean = false, onFinish: () -> Unit = {}) {

    var stage by remember { mutableStateOf(if(isDebug) 2 else if(startWithBreathingExercise) 1 else 0) }

    ColumnComposable {
        if (stage == 0) {
            ScalingLazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Text("Choose Method", color = Color.White)
                }
                item {
                    SpacerComposable()
                }
                item {

                    TitleCard(
                        modifier = Modifier.width(200.dp),
                        onClick = {
                            stage = 1;
                        },
                        title = { Text("Breathing") },
                        time = { Text("1 min", color = MaterialTheme.colors.primary) },

                        ) {
                    }
                }

                item {
                    SpacerComposable()
                }
                item {

                    TitleCard(
                        modifier = Modifier.width(200.dp),
                        onClick = {
                           toastNotImplemented(activity)
                        },
                        title = { Text("Walking") },
                        time = { Text("5 min", color = MaterialTheme.colors.primary) },
                        ) {
                    }
                }
                item {
                    SpacerComposable()
                }
                item {

                    TitleCard(
                        modifier = Modifier.width(200.dp),
                        onClick = {
                            toastNotImplemented(activity)
                        },
                        title = { Text("Meditation") },
                        time = { Text("7 min", color = MaterialTheme.colors.primary) },
                    ) {
                    }
                }
                item {
                    SpacerComposable()
                }
                item {
                    TitleCard(
                        modifier = Modifier.width(200.dp),
                        onClick = {

                            Toast.makeText(
                                activity,
                                "Opened on mobile phone",
                                Toast.LENGTH_SHORT,
                            ).show()
                        },
                        title = { Text("Yoga") },
                        time = { Text("15 min", color = MaterialTheme.colors.primary) },

                        ) {
                        Text("Video content in App")
                    }
                }
            }
        } else if (stage == 1) {
            breathExerciseComposable(
                activity,
                iterations = if(isDebug) 0 else 1,
                titleFinished = {
                    Text("Success!")
                    Text("Your heart rate is now")
                    Row {
                        Text("85", color = MaterialTheme.colors.primary)
                        Text(" bpm")
                    }
                }
            ) {
                stage = 2
            }
        } else if(stage == 2) {

            PsychologicalAssessmentComposable(activity, isDebug) {
                onFinish()
            }
        }
    }
}