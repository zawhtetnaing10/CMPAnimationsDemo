package org.animations.demo

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animate
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun AnimateBackgroundColorDemo() {

    val colors = listOf(Color.Red, Color.Black, Color.Blue, Color.Yellow)

    var selectedColor by remember { mutableStateOf(colors.first()) }

    // Animated color cannot be var. So it has to be hooked up to a mutable state color.
    val animatedColor by animateColorAsState(selectedColor, label = "color")

    Scaffold { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(paddingValues)
        ) {
            Box(modifier = Modifier.height(500.dp).fillMaxWidth().drawBehind{
                drawRect(animatedColor)
            }) {}

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    selectedColor = colors[(0..<colors.count()).random()]
                }
            ) {
                Text("Change Color")
            }
        }
    }
}