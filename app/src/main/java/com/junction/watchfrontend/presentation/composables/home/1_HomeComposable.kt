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
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.dialog.Alert
import androidx.wear.compose.material.dialog.Dialog
import com.junction.watchfrontend.R
import com.junction.watchfrontend.presentation.composables.ButtonComposable
import com.junction.watchfrontend.presentation.composables.SpacerComposable
import com.junction.watchfrontend.presentation.theme.Constants
import com.junction.watchfrontend.presentation.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homeComposable(activity: ComponentActivity) {

    // todo psych assesment
    var isDebug by remember { mutableStateOf(false) };

    val (showDialog, setShowDialog) = remember { mutableStateOf(false) }

    var stage by remember { mutableStateOf(if (isDebug) 1 else 0) }

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
                    // stage = 0
                    /*Dialog(onDismissRequest = { /*TODO*/ }) {
                        Text(text = "Ibuprofen")
                    }*/
                }

                DialogComposable(activity, showDialog, onDismiss = {
                    setShowDialog(false)
                })
            } else if (stage == 2) {
                RelaxComposable(activity, isDebug) {
                    stage = 0;
                }
            } else {
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
            }
        }
    }
}

@Composable
fun DialogComposable(
    activity: ComponentActivity,
    alertShowDialog: Boolean = false,
    onDismiss: () -> Unit,
    title: String = "Recommended\nPain Solution",
    description: String = "Breathing",
    icon: @Composable () -> Unit = {
        Icon(
            painter = painterResource(id = R.drawable.outline_self_improvement_24),
            contentDescription = "Check"
        )
    }
) {
    Dialog(
        showDialog = alertShowDialog,
        onDismissRequest = {
            onDismiss()
        },
    ) {
        Alert(
            title = {
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onBackground
                )
            },
            negativeButton = {
                Button(
                    onClick = {
                        onDismiss()
                    },
                    colors = ButtonDefaults.secondaryButtonColors()
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_close_24),
                        contentDescription = "Use alternate solution"
                    )
                }
            },
            positiveButton = {
                Button(
                    onClick = {
                        onDismiss()
                        // todo default stqte without medications
                        // todo sos button
                        // todo MAybe pain short cut
                    },
                    colors = ButtonDefaults.primaryButtonColors()
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_play_arrow_24),
                        contentDescription = "Use alternate solution"
                    )
                }
            },
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = description,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onBackground
                )
                SpacerComposable()
                icon()
            }
        }
    }
}