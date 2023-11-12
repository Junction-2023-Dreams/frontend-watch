package com.junction.watchfrontend.presentation.composables.home

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.AutoCenteringParams
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TitleCard
import com.junction.watchfrontend.presentation.composables.utils.ColumnComposable
import com.junction.watchfrontend.presentation.composables.utils.SpacerComposable
import com.junction.watchfrontend.presentation.composables.utils.toast

@Composable
fun AchievementComposable(activity: ComponentActivity) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {

        ScalingLazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            item {

                Text(
                    "Achievements",
                    style = androidx.compose.material3.MaterialTheme.typography.titleMedium
                )
            }
            item{
                SpacerComposable()
            }
            item {
                Row {
                    Text(
                        " 23 ",
                        style = androidx.compose.material3.MaterialTheme.typography.titleSmall.copy(
                            color = MaterialTheme.colors.primary
                        )
                    )

                    Text(
                        "Points",
                        style = androidx.compose.material3.MaterialTheme.typography.titleSmall.copy(
                            color = MaterialTheme.colors.primary
                        )
                    )

                    Text(
                        " of 100 Points",
                        style = androidx.compose.material3.MaterialTheme.typography.titleSmall
                    )
                }
            }

            item {
                SpacerComposable()
            }

            item {
                LinearProgressIndicator(progress = 0.3f, modifier = Modifier.width(90.dp))
            }

            item {
                SpacerComposable(16)
            }
            item {

                TitleCard(
                    modifier = Modifier.width(200.dp),
                    onClick = {
                        toast(activity, "")
                    },
                    title = { Text("Breathe II") },
                    time = { Text("2 P", color = MaterialTheme.colors.primary) },

                    ) {
                    Text("Pain reliefed by 20 %")
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
                    title = { Text("Yoga") },
                    time = { Text("5 P", color = MaterialTheme.colors.primary) },
                ) {
                    Text("Sustainable training")
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
                    title = { Text("Meet I") },
                    time = { Text("15 P", color = MaterialTheme.colors.primary) },

                    ) {
                    Text("Exchange with Quitters")
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
                    title = { Text("Breath I") },
                    time = { Text("1 P", color = MaterialTheme.colors.primary) },
                ) {
                }
            }
        }
    }
}