package org.animations.demo

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun AnimateTextColorDemo() {
    var toggle by remember { mutableStateOf(false) }

    val color by animateColorAsState(
        targetValue = if (toggle) Color.Red else Color.Black,
        label = "color"
    )

    Scaffold {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            BasicText("Animate Color", color = {
                color
            }, modifier = Modifier.clickable{
                toggle = !toggle
            }, style = TextStyle(fontSize = 24.sp))
        }
    }
}