package com.junction.watchfrontend.presentation.composables.home.assessment

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.InlineSlider
import androidx.wear.compose.material.InlineSliderDefaults
import androidx.wear.compose.material.Text
import com.junction.watchfrontend.R
import com.junction.watchfrontend.presentation.composables.navigation.Pages
import com.junction.watchfrontend.presentation.composables.utils.ColumnComposable
import com.junction.watchfrontend.presentation.composables.utils.SpacerComposable
import com.junction.watchfrontend.presentation.theme.Constants

@Composable
fun PainLevelComposable(navController: NavController) {
    var displayValue by remember { mutableStateOf(2) }
    ColumnComposable {

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
                if (it <= 1) return@InlineSlider;
                displayValue = it
            },
            valueProgression = 1..5,
            increaseIcon = { Icon(InlineSliderDefaults.Increase, "Increase") },
            decreaseIcon = { Icon(InlineSliderDefaults.Decrease, "Decrease") }
        )
        SpacerComposable(28)
        Button(
            onClick = {
                navController.navigate(Pages.AssessmentPainQuestionaire.route)
            },
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
    }
}