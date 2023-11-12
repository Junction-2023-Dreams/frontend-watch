package com.junction.watchfrontend.presentation.composables.home

import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.wear.compose.material.Icon
import com.junction.watchfrontend.R
import com.junction.watchfrontend.presentation.composables.navigation.Pages
import com.junction.watchfrontend.presentation.composables.utils.ButtonComposable
import com.junction.watchfrontend.presentation.composables.utils.ColumnComposable
import com.junction.watchfrontend.presentation.composables.utils.DialogComposable
import com.junction.watchfrontend.presentation.composables.utils.DialogConfirmationComposable
import com.junction.watchfrontend.presentation.composables.utils.SpacerComposable

@Composable
fun PainComposable(
    activity: ComponentActivity,
    isDebug: Boolean,
    navController: NavHostController
) {
    var showSuggenstionDialog by remember { mutableStateOf(false) }
    var showPillConfirmation by remember { mutableStateOf(false) }

    ColumnComposable {
        ButtonComposable("Relax", {
            Icon(
                painter = painterResource(id = R.drawable.outline_self_improvement_24),
                contentDescription = "Check"
            )
        }) {
            navController.navigate(Pages.Relax.route)
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
            showSuggenstionDialog = true
        }

        DialogComposable(activity, showSuggenstionDialog, onDismiss = {
            Handler().postDelayed({
                showPillConfirmation = true
            }, 500)

            showSuggenstionDialog = false
        }, onAccept = {
            showPillConfirmation = false
            showSuggenstionDialog = false

            navController.navigate(Pages.RelaxBreathing.route)
        })

        DialogConfirmationComposable(showPillConfirmation, onDismiss = {
            showPillConfirmation = false
            navController.navigate(Pages.Home.route) {
                popUpTo(Pages.Home.route) {
                    inclusive = true
                }
            }
        })
    }
}