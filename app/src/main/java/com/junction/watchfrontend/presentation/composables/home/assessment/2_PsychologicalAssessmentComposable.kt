package com.junction.watchfrontend.presentation.composables.home.assessment

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.InlineSlider
import androidx.wear.compose.material.InlineSliderDefaults
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TitleCard
import com.junction.watchfrontend.R
import com.junction.watchfrontend.presentation.composables.utils.ButtonComposable
import com.junction.watchfrontend.presentation.composables.utils.ColumnComposable
import com.junction.watchfrontend.presentation.composables.utils.SpacerComposable
import com.junction.watchfrontend.presentation.theme.Constants

@Composable
fun PsychologicalAssessmentComposable(activity: ComponentActivity, isDebug: Boolean, onFinish : () -> Unit) {

    var stage by remember { mutableStateOf(if (isDebug) 2 else 0) }
    var displayValue by remember { mutableStateOf(2) }

    var checkboxState by remember { mutableStateOf(false) }
    var checkboxState2 by remember { mutableStateOf(false) }
    var checkboxState3 by remember { mutableStateOf(false) }

    ColumnComposable {
        if (stage == 0) {
            Text(
                "Health Assessment", /*bold*/
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                "To improve your exercises."
            )

            SpacerComposable(12)

            Button(
                onClick = { stage = 1 },
                modifier = Modifier
                    .height(Constants.buttonHeight)
                    .width(100.dp)
            ) {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_play_arrow_24),
                        contentDescription = "Check"
                    )
                    SpacerComposable()
                    Text("Start")
                }
            }

        }
        if (stage == 1) {
            SpacerComposable(28)
            Text("Pain Level")
            SpacerComposable()
            // gradient green to red
            InlineSlider(
                modifier = Modifier.padding(8.dp),
                value = displayValue,
                colors = InlineSliderDefaults.colors(
                    selectedBarColor = when (displayValue) {
                        1 -> Color.Green // not shown
                        2 -> Color.Green
                        3 -> Color.Green.copy(0.7.toFloat())
                        4 -> Color.Yellow.copy(0.7.toFloat())
                        5 -> Color.Red
                        else -> Color.Green
                    },
                ),
                onValueChange = {
                    if(it <= 1) return@InlineSlider;
                    displayValue = it
                },
                valueProgression = 1..5,
                increaseIcon = { Icon(InlineSliderDefaults.Increase, "Increase") },
                decreaseIcon = { Icon(InlineSliderDefaults.Decrease, "Decrease") }
            )
            SpacerComposable(28)
            Button(
                onClick = { stage = 2 },
                modifier = Modifier
                    .height(Constants.buttonHeight)
                    .width(100.dp)
            ) {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_play_arrow_24),
                        contentDescription = "Next"
                    )
                    SpacerComposable()
                    Text("Next")
                }
            }
        } else if (stage == 2) {

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
                    ButtonComposable("Complete", ) {
                        onFinish()
                    }
                }
            }

        }
    }


}