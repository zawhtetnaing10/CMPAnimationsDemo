package org.animations.demo

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun AnimateShadowsDemo() {

    var toggle by remember { mutableStateOf(false) }
    val elevation by animateDpAsState(
        targetValue = if (toggle) 32.dp else 0.dp,
        label = "elevation"
    )

    Scaffold {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .graphicsLayer {
                        this.shadowElevation = elevation.toPx()
                    }
                    .background(Color.Cyan)
                    .clickable{
                        toggle = !toggle
                    }
            )
        }
    }
}