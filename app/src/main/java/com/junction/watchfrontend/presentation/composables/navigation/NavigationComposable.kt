package com.junction.watchfrontend.presentation.composables.navigation

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.junction.watchfrontend.presentation.composables.home.AchievementComposable
import com.junction.watchfrontend.presentation.composables.home.ChartComposable
import com.junction.watchfrontend.presentation.composables.home.FirstMeasurementComposable
import com.junction.watchfrontend.presentation.composables.home.HomeComposable
import com.junction.watchfrontend.presentation.composables.home.PainComposable
import com.junction.watchfrontend.presentation.composables.home.RelaxComposable
import com.junction.watchfrontend.presentation.composables.home.assessment.PainLevelComposable
import com.junction.watchfrontend.presentation.composables.home.assessment.PainQuestionaireComposable
import com.junction.watchfrontend.presentation.composables.home.assessment.PsychologicalAssessmentComposable
import com.junction.watchfrontend.presentation.composables.home.relax.BreathExerciseComposable

@Composable
fun NavigationComposable(activity: ComponentActivity) {
    val navController = rememberSwipeDismissableNavController()

    var sharedPreferences = activity.getSharedPreferences("prefs", ComponentActivity.MODE_PRIVATE);
    var hasFirstMeasurement = sharedPreferences.getBoolean("isPersonsDefaultStateSaved", false)

    var startDestination =
        if (hasFirstMeasurement) Pages.Home.route else Pages.FirstMeasurement.route

    var isDebug by remember { mutableStateOf(true) };

    SwipeDismissableNavHost(
        navController = navController,
        startDestination = if(!isDebug) startDestination else Pages.Achievements.route,

        ) {
        composable(Pages.FirstMeasurement.route) {
            FirstMeasurementComposable(activity, navController);
        }
        composable(Pages.Home.route) {
            HomeComposable(activity, isDebug, navController);
        }
        composable(Pages.Pain.route) {
            PainComposable(activity, isDebug, navController)
        }
        composable(Pages.Relax.route) {
            RelaxComposable(activity, isDebug, false, navController)
        }
        composable(Pages.RelaxBreathing.route) {
            RelaxComposable(activity, isDebug, true, navController)
        }
        composable(Pages.ExerciseBreath.route) {
            BreathExerciseComposable(
                activity,
                iterationCount = 1,
                titleFinished = {
                    Text("Success!")
                    Text("Your heart rate is now")
                    Row {
                        Text("85", color = MaterialTheme.colors.primary)
                        Text(" bpm")
                    }
                }
            ) {
                navController.navigate(Pages.AssessmentStart.route) {
                    popUpTo(Pages.Home.route) {
                        inclusive = true
                    }
                }
            }
        }

        composable(Pages.AssessmentStart.route) {
            PsychologicalAssessmentComposable(navController)
        }
        composable(Pages.AssessmentPainLevel.route) {
            PainLevelComposable(navController)
        }
        composable(Pages.AssessmentPainQuestionaire.route) {
            PainQuestionaireComposable(navController)
        }
        composable(Pages.Chart.route) {
            ChartComposable()
        }
        composable(Pages.Achievements.route) {
            AchievementComposable(activity)
        }
    }
}