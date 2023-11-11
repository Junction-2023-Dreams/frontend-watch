package com.junction.watchfrontend.presentation.composables.navigation

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.junction.watchfrontend.presentation.composables.home.FirstMeasurementComposable
import com.junction.watchfrontend.presentation.composables.home.HomeComposable

@Composable
fun NavigationComposable(activity: ComponentActivity) {
    val navController = rememberSwipeDismissableNavController()

    var sharedPreferences = activity.getSharedPreferences("prefs", ComponentActivity.MODE_PRIVATE);
    var hasFirstMeasurement = sharedPreferences.getBoolean("isPersonsDefaultStateSaved", false)

    var startDestination =
        if (hasFirstMeasurement) Pages.Home.route else Pages.FirstMeasurement.route

    var isDebug by remember { mutableStateOf(false) };

    SwipeDismissableNavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Pages.FirstMeasurement.route) {
            FirstMeasurementComposable(activity);
        }
        composable(Pages.Home.route) {
            HomeComposable(activity, isDebug);
        }
        composable(Pages.Pain.route) {
            HomeComposable(activity, isDebug);
        }
    }
}