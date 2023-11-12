package com.junction.watchfrontend.presentation.composables.home.assessment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TitleCard
import com.junction.watchfrontend.presentation.composables.navigation.Pages
import com.junction.watchfrontend.presentation.composables.utils.ButtonComposable
import com.junction.watchfrontend.presentation.composables.utils.DialogConfirmationComposable
import com.junction.watchfrontend.presentation.composables.utils.SpacerComposable

@Composable
fun PainQuestionaireComposable(navController: NavHostController) {
    var checkboxState by remember { mutableStateOf(false) }
    var checkboxState2 by remember { mutableStateOf(false) }
    var checkboxState3 by remember { mutableStateOf(false) }

    var showDialog by remember { mutableStateOf(false) }

    ScalingLazyColumn(
        modifier = Modifier
            .fillMaxSize()

    ) {
        item {
            Text("Do you feel")
        }

        item {
            SpacerComposable()
        }

        item {
            TitleCard(onClick = {
                checkboxState = !checkboxState
            }, title = {}, modifier = Modifier.height(50.dp)) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    SpacerComposable()
                    Text(text = "More relaxed")
                    Row(
                        Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Checkbox(checked = checkboxState, onCheckedChange = {
                            checkboxState = !checkboxState
                        })
                    }
                }
            }

        }

        item {
            TitleCard(onClick = {
                checkboxState2 = !checkboxState2
            }, title = {}, modifier = Modifier.height(50.dp)) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    SpacerComposable()
                    Text(text = "Changes in Stress")
                    Row(
                        Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Checkbox(checked = checkboxState2, onCheckedChange = {
                            checkboxState2 = !checkboxState2
                        })
                    }
                }
            }
        }

        item {
            TitleCard(onClick = {
                checkboxState3 = !checkboxState3
            }, title = {}, modifier = Modifier.height(50.dp)) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    SpacerComposable()
                    Text(text = "Positive thoughts")
                    Row(
                        Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Checkbox(checked = checkboxState3, onCheckedChange = {
                            checkboxState3 = !checkboxState3
                        })
                    }
                }
            }
        }

        item {
            SpacerComposable()
        }

        item {
            ButtonComposable("Complete") {
                showDialog = true
            }
        }
        item {
            DialogConfirmationComposable(
                showDialog,
                "Completed",
                "Psychological Health assessment analyzed"
            ) {
                navController.navigate(Pages.Home.route) {
                    popUpTo(Pages.Home.route) { inclusive = true }
                }
            }
        }
    }
}