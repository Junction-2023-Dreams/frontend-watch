package com.junction.watchfrontend.presentation.composables.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text
import com.junction.watchfrontend.presentation.composables.utils.ColumnComposable
import com.junction.watchfrontend.presentation.composables.utils.SpacerComposable
import com.patrykandpatryk.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatryk.vico.compose.axis.horizontal.rememberTopAxis
import com.patrykandpatryk.vico.compose.axis.vertical.rememberEndAxis
import com.patrykandpatryk.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatryk.vico.compose.chart.Chart
import com.patrykandpatryk.vico.compose.chart.column.columnChart
import com.patrykandpatryk.vico.compose.chart.line.lineChart
import com.patrykandpatryk.vico.compose.legend.horizontalLegend
import com.patrykandpatryk.vico.compose.style.ChartStyle
import com.patrykandpatryk.vico.compose.style.LocalChartStyle
import com.patrykandpatryk.vico.compose.style.ProvideChartStyle
import com.patrykandpatryk.vico.compose.style.currentChartStyle
import com.patrykandpatryk.vico.core.chart.composed.plus
import com.patrykandpatryk.vico.core.component.Component
import com.patrykandpatryk.vico.core.component.text.TextComponent
import com.patrykandpatryk.vico.core.entry.ChartEntryModelProducer
import com.patrykandpatryk.vico.core.entry.composed.plus
import com.patrykandpatryk.vico.core.entry.entriesOf
import com.patrykandpatryk.vico.core.legend.LegendItem

data class DataPoint(val x: Float, val y: Float)

@Composable
fun ChartComposable() {
    ColumnComposable {
        SpacerComposable(12)
        Text("Analytics", style = MaterialTheme.typography.titleSmall)


        SpacerComposable(24, 0)
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("l")
            Text(
                " Pain",
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurface),
                textAlign = TextAlign.Start,
            )
            SpacerComposable(0, 16)
            Text(
                "- ",
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                "Relaxation",
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurface),
            )
        }

        val chartEntryModelProducer1 = ChartEntryModelProducer(entriesOf(4f, 12f, 8f, 16f))
        val chartEntryModelProducer2 = ChartEntryModelProducer(entriesOf(0f, 6f, 8f, 12f))
        val composedChartEntryModelProducer = chartEntryModelProducer1 + chartEntryModelProducer2

        val columnChart = columnChart()
        val lineChart = lineChart()

        ProvideChartStyle(
        ) {
            Chart(
                chart = remember(columnChart, lineChart) {
                    columnChart + lineChart
                },
                chartModelProducer = composedChartEntryModelProducer,
                startAxis = rememberStartAxis(),
                bottomAxis = rememberBottomAxis(),
                topAxis = rememberTopAxis(),
                endAxis = rememberEndAxis(),
            )
        }
    }
}