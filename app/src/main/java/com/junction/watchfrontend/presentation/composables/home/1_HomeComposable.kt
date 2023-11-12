package com.junction.watchfrontend.presentation.composables.home

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.junction.watchfrontend.R
import com.junction.watchfrontend.presentation.composables.navigation.Pages
import com.junction.watchfrontend.presentation.composables.utils.DialogComposableOneAction
import com.junction.watchfrontend.presentation.composables.utils.SpacerComposable
import com.junction.watchfrontend.presentation.composables.utils.Constants
import com.junction.watchfrontend.presentation.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeComposable(
    activity: ComponentActivity,
    isDebug: Boolean,
    navController: NavHostController
) {

    var showSosDialog by remember { mutableStateOf(false) }

    MyApplicationTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpacerComposable(70)
            Button(
                onClick = {
                    navController.navigate(Pages.Pain.route)
                    Log.d("WatchDebug", "HomeComposable: PRESSED")
                },
                Modifier
                    .width(100.dp)
                    .height(Constants.buttonHeight)
            ) {
                Text("I feel pain")
            }

            SpacerComposable(32)

            Row {

                IconButton(colors = IconButtonDefaults.filledIconButtonColors(
                ), onClick = {
                    navController.navigate(Pages.Achievements.route)
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_emoji_events_24),
                        contentDescription = "Achievements",
                        modifier = Modifier.scale(-1f, 1f)
                    )
                }

                IconButton(colors = IconButtonDefaults.filledIconButtonColors(
                ), onClick = {
                    navController.navigate(Pages.Chart.route)
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_insert_chart_outlined_24),
                        contentDescription = "Analytics",
                        modifier = Modifier.scale(-1f, 1f)
                    )
                }
                DialogComposableOneAction(
                    activity,
                    showSosDialog,
                    onDismiss = { showSosDialog = false },
                    title = "SOS",
                    description = "Notifying your emergency contacts",
                )


                IconButton(colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = Color.Red
                ), onClick = {
                    showSosDialog = true
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_sos_24),
                        contentDescription = "SOS"
                    )
                }
            }

        }

    }
}
