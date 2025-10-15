package org.animations.demo

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun PlayAnAnimationOnStartOfAComposableDemo() {
    val alphaAnimation = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        alphaAnimation.animateTo(1f, animationSpec = tween(durationMillis = 3000))
    }

    Scaffold {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .graphicsLayer {
                        alpha = alphaAnimation.value
                    }
                    .width(200.dp)
                    .height(200.dp)
                    .background(Color.Red)
            )
        }
    }
}