package com.junction.watchfrontend.presentation.composables.navigation

/**
 * Represent all Screens (Composables) in the app.
 */
sealed class Pages(
    val route: String
) {
    object FirstMeasurement : Pages("first_measurement")
    object Home : Pages("home")
    object Pain : Pages("pain")
}
