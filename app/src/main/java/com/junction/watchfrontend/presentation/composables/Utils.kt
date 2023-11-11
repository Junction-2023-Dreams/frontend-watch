package com.junction.watchfrontend.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.junction.watchfrontend.presentation.theme.Constants
import com.junction.watchfrontend.presentation.theme.MyApplicationTheme

@Composable
fun ColumnComposable(content: @Composable ColumnScope.() -> Unit) {
    MyApplicationTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            content()
        }
    }
}

@Composable
fun SpacerComposable(height: Int = 8, width: Int = 8) =
    androidx.compose.foundation.layout.Spacer(
        modifier = Modifier
            .width(width.dp)
            .height(height.dp)
    )

@Composable
fun ButtonComposable(text: String = "Click me", icon: @Composable() (RowScope.() -> Unit)? = null, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(Constants.buttonHeight)
            .width(108.dp)
    ) {
        Row {
            if(icon != null) {
                icon()
                SpacerComposable()
            }
            Text(text)
        }
    }
}