package com.junction.watchfrontend.presentation.composables.home

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TitleCard
import com.junction.watchfrontend.presentation.composables.navigation.Pages
import com.junction.watchfrontend.presentation.composables.utils.ColumnComposable
import com.junction.watchfrontend.presentation.composables.utils.SpacerComposable
import com.junction.watchfrontend.presentation.composables.utils.toast

@Composable
fun RelaxComposable(
    activity: ComponentActivity,
    isDebug: Boolean,
    startWithBreathingExercise: Boolean = false,
    navController: NavHostController,
) {

    ColumnComposable {
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
                        navController.navigate(Pages.ExerciseBreath.route)
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
                        toast(activity)
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
                        toast(activity)
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
    }
}