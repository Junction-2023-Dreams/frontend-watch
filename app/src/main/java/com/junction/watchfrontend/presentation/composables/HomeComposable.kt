package com.junction.watchfrontend.presentation.composables

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.junction.watchfrontend.R
import com.junction.watchfrontend.presentation.theme.Constants
import com.junction.watchfrontend.presentation.theme.MyApplicationTheme


@Composable
fun homeComposable(activity: ComponentActivity) {

    var stage by remember { mutableStateOf(0) }

    MyApplicationTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (stage == 1) {
                androidx.wear.compose.material.Button(
                    onClick = {
                        stage = 1;
                    },
                    Modifier
                        .width(100.dp)
                        .height(Constants.buttonHeight)
                ) {
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.outline_self_improvement_24),
                            contentDescription = "Check"
                        )
                        Spacer(Modifier.width(3.dp))
                        Text("Relax")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        stage = 0;
                    },
                    Modifier
                        .width(100.dp)
                        .height(Constants.buttonHeight)
                ) {
                    Row(verticalAlignment =  Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center) {
                        // resize png icon to default size
                        Icon(
                            painter = painterResource(id = R.drawable.pill),
                            contentDescription = "Check",
                            modifier = Modifier.width(20.dp).height(20.dp)
                        )
                        Spacer(Modifier.width(3.dp))
                        Text("Ibuprofen", color = MaterialTheme.colors.onPrimary)
                    }
                    // todo substitute with medikament
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