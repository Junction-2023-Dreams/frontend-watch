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
    object Relax : Pages("relax")
    object RelaxBreathing : Pages("relax_breathing")
    object ExerciseBreath : Pages("exercise_breath")

    object AssessmentStart : Pages("assessment_start")
    object AssessmentPainLevel : Pages("assessment_pain_level")
    object AssessmentPainQuestionaire : Pages("assessment_pain_questionaire")
}
