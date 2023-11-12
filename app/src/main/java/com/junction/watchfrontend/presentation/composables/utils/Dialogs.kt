package com.junction.watchfrontend.presentation.composables.utils

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonColors
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.dialog.Alert
import androidx.wear.compose.material.dialog.Confirmation
import androidx.wear.compose.material.dialog.Dialog
import com.junction.watchfrontend.R


@Composable
fun DialogConfirmationComposable(
    showDialog: Boolean = false,
    title: String = "Pill taken",
    description: String = "Health Effects are measured in the background",
    onDismiss: () -> Unit,
) {
    Dialog(
        showDialog = showDialog,
        onDismissRequest = {
            onDismiss()
        }
    ) {
        Confirmation(
            onTimeout = {
                onDismiss()
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Check",
                    modifier = Modifier.size(48.dp)
                )
            }
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    style = androidx.compose.material3.MaterialTheme.typography.titleSmall,
                )
                Text(
                    text = description,
                    textAlign = TextAlign.Center,
                    style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
                )
            }
        }
    }
}

@Composable
fun DialogComposable(
    activity: ComponentActivity,
    alertShowDialog: Boolean = false,
    onDismiss: () -> Unit,
    onAccept: () -> Unit,
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
                        onAccept()
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

@Composable
fun DialogComposableOneAction(
    activity: ComponentActivity,
    alertShowDialog: Boolean = false,
    onDismiss: () -> Unit,
    title: String = "Recommended\nPain Solution",
    description: String = "Breathing",
    buttonColor: ButtonColors = ButtonDefaults.primaryButtonColors(),
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
                SpacerComposable(width = 0)
            },
            positiveButton = {
                Row {

                    Button(
                        onClick = {
                            onDismiss()
                        },
                        colors = buttonColor
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_close_24),
                            contentDescription = "Use alternate solution"
                        )
                    }
                    SpacerComposable(width = 12)
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
            }
        }
    }
}