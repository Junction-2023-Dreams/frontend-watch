package com.junction.watchfrontend.presentation.composables.home.assessment

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import com.junction.watchfrontend.R
import com.junction.watchfrontend.presentation.composables.navigation.Pages
import com.junction.watchfrontend.presentation.composables.utils.ColumnComposable
import com.junction.watchfrontend.presentation.composables.utils.SpacerComposable
import com.junction.watchfrontend.presentation.composables.utils.Constants

@Composable
fun PsychologicalAssessmentComposable(
    navController: NavHostController
) {


    ColumnComposable {
        Text(
            "Health Assessment", /*bold*/
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            "To improve your exercises."
        )

        SpacerComposable(12)

        Button(
            onClick = {
                navController.navigate(Pages.AssessmentPainLevel.route)
            },
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


}