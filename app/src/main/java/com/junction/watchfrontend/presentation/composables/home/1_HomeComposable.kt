package com.junction.watchfrontend.presentation.composables.home

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
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.junction.watchfrontend.R
import com.junction.watchfrontend.presentation.composables.utils.ButtonComposable
import com.junction.watchfrontend.presentation.composables.utils.DialogComposable
import com.junction.watchfrontend.presentation.composables.utils.DialogComposableOneAction
import com.junction.watchfrontend.presentation.composables.utils.DialogConfirmationComposable
import com.junction.watchfrontend.presentation.composables.utils.SpacerComposable
import com.junction.watchfrontend.presentation.composables.utils.toastNotImplemented
import com.junction.watchfrontend.presentation.theme.Constants
import com.junction.watchfrontend.presentation.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeComposable(activity: ComponentActivity, isDebug: Boolean) {

    var stage by remember { mutableStateOf(if (isDebug) 2 else 0) }

    val (showDialog, setShowDialog) = remember { mutableStateOf(false) }
    var showPillConfirmation by remember { mutableStateOf(false) }
    var showSosDialog by remember { mutableStateOf(false) }


    MyApplicationTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (stage == 1) {
                ButtonComposable("Relax", {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_self_improvement_24),
                        contentDescription = "Check"
                    )
                }) {
                    stage = 2
                }

                SpacerComposable()

                ButtonComposable("Ibuprofen", {
                    Icon(
                        painter = painterResource(id = R.drawable.pill),
                        contentDescription = "Check",
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                    )
                }) {
                    setShowDialog(true)
                }

                DialogComposable(activity, showDialog, onDismiss = {
                    android.os.Handler().postDelayed({
                        showPillConfirmation = true
                    }, 500)
                    setShowDialog(false)
                }, onAccept = {
                    showPillConfirmation = false
                    setShowDialog(false)
                    stage = 3
                })

                DialogConfirmationComposable(showPillConfirmation, onDismiss = {
                    stage = 0
                    showPillConfirmation = false
                })
            } else if (stage == 2) {
                RelaxComposable(activity, isDebug) {
                    stage = 0;
                }
            } else if(stage == 3) {
                /* Breathing instead of painkiller */
                RelaxComposable(activity, isDebug, true) {
                    stage = 0
                }
            } else {
                SpacerComposable(70)
                Button(
                    onClick = {
                        stage = 1;
                    },
                    Modifier
                        .width(100.dp)
                        .height(Constants.buttonHeight)
                ) {
                    Text("I have pain")
                }

                SpacerComposable(32)

                Row {

                    IconButton(colors = IconButtonDefaults.filledIconButtonColors(
                    ), onClick = {
                        toastNotImplemented(activity)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_insert_chart_outlined_24),
                            contentDescription = "SOS",
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
}
