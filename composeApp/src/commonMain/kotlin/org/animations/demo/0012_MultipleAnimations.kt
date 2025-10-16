package org.animations.demo

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun MultipleAnimations() {
    //val alphaAnimation = remember { Animatable(0f) }
    val yAnimation = remember { Animatable(0f) }

    val colorAnimation = remember { androidx.compose.animation.Animatable(Color.Red) }

    LaunchedEffect(Unit) {
        // Running animations sequentially
//        alphaAnimation.animateTo(1f, animationSpec = tween(durationMillis = 1000))
//        yAnimation.animateTo(100f, animationSpec = tween(durationMillis = 1000))


        // Concurrent Animations
        launch {
            colorAnimation.animateTo(Color.Cyan, animationSpec = tween(durationMillis = 1000))
        }
        launch {
            yAnimation.animateTo(200f, animationSpec = tween(durationMillis = 1000))
        }
    }

    Scaffold {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            // Sequential Animation
//            Box(
//                modifier = Modifier
//                    .graphicsLayer {
//                        alpha = alphaAnimation.value
//                    }
//                    .offset(y = yAnimation.value.dp)
//                    .width(200.dp)
//                    .height(200.dp)
//                    .background(Color.Red)
//            )

            // Concurrent Animation
            Box(
                modifier = Modifier
                    .offset(y = yAnimation.value.dp)
                    .drawBehind {
                        drawRect(colorAnimation.value)
                    }
                    .width(200.dp)
                    .height(200.dp)
            )
        }
    }
}