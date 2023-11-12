package com.junction.watchfrontend.presentation.composables.home

import android.content.Context
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
import androidx.navigation.NavHostController
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.junction.watchfrontend.presentation.composables.home.relax.BreathExerciseComposable
import com.junction.watchfrontend.presentation.composables.navigation.Pages
import com.junction.watchfrontend.presentation.theme.MyApplicationTheme

@Composable
fun FirstMeasurementComposable(activity: ComponentActivity, navController: NavHostController) {

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
                BreathExerciseComposable(activity, 1) {
                    activity.getSharedPreferences("prefs", Context.MODE_PRIVATE).edit()
                        .putBoolean("isPersonsDefaultStateSaved", true).apply()
                    // reload app
                    // activity.recreate()
                    navController.navigate(Pages.Home.route) {
                        popUpTo(Pages.Home.route) {
                            inclusive = true
                        }
                    }
                }
            }
        }

    }
}