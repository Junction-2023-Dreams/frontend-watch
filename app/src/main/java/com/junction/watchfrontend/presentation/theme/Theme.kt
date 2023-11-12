package com.junction.watchfrontend.presentation.theme

import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

fun Color(hex: String) = Color(android.graphics.Color.parseColor(hex))

@Composable
fun MyApplicationTheme(
    content: @Composable () -> Unit
) {
    var colorScheme: ColorScheme = lightColorScheme(
        primary = Color("#006590"),
        onPrimary = Color("#ffffff"),
        primaryContainer = Color("#c8e6ff"),
        onPrimaryContainer = Color("#001e2f"),
        secondary = Color("#a63b10"),
        onSecondary = Color("#ffffff"),
        secondaryContainer = Color("#ffdbd0"),
        onSecondaryContainer = Color("#390c00"),
        error = Color("#ba1a1a"),
        onError = Color("#ffffff"),
        errorContainer = Color("#ffdad6"),
        onErrorContainer = Color("#410002"),
        background = Color("#fcfcff"),
        onBackground = Color("#191c1e"),
        onSurface = Color("#191c1e"),
        surface = Color("#fcfcff"),
        outline = Color("#71787e"),
        surfaceVariant = Color("#dde3ea"),
        onSurfaceVariant = Color("#41484d"),
    )

    if (true || isSystemInDarkTheme()) {
        colorScheme = darkColorScheme(
            primary = Color("#88ceff"),
            onPrimary = Color("#00344d"),
            primaryContainer = Color("#004c6e"),
            onPrimaryContainer = Color("#c8e6ff"),
            secondary = Color("#ffb59d"),
            onSecondary = Color("#5d1900"),
            secondaryContainer = Color("#832600"),
            onSecondaryContainer = Color("#ffdbd0"),
            error = Color("#ffb4ab"),
            onError = Color("#690005"),
            errorContainer = Color("#93000a"),
            onErrorContainer = Color("#ffdad6"),
            background = Color("#191c1e"),
            onBackground = Color("#e2e2e5"),
            onSurface = Color("#e2e2e5"),
            surface = Color("#191c1e"),
            outline = Color("#8b9198"),
            surfaceVariant = Color("#41484d"),
            onSurfaceVariant = Color("#c1c7ce"),
        )
    }

    androidx.compose.material3.MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}