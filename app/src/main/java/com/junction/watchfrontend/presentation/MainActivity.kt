package com.junction.watchfrontend.presentation

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.junction.watchfrontend.R
import com.junction.watchfrontend.presentation.composables.homeComposable
import com.junction.watchfrontend.presentation.composables.personDefaultStateEvaluationComposable

class MainActivity : ComponentActivity() {
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);

        super.onCreate(savedInstanceState)

        // sharedPreferences.edit().putBoolean("isPersonsDefaultStateSaved", false).apply()
        setContent {
            Surface(
                color = MaterialTheme.colors.background,
            ) {

                if (!sharedPreferences.getBoolean("isPersonsDefaultStateSaved", false)) {
                    personDefaultStateEvaluationComposable(activity = this)
                } else {
                    homeComposable(activity = this)
                }
            }
        }
    }
}

@Composable
fun Greeting(greetingName: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.primary,
        text = stringResource(R.string.hello_world, greetingName)
    )
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    homeComposable(activity = MainActivity())
}