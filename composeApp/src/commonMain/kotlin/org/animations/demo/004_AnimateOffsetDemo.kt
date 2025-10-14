package org.animations.demo

import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun AnimateOffsetDemo() {
    var pixelToMove = with(LocalDensity.current) {
        100.dp.toPx().roundToInt()
    }

    var moved by remember { mutableStateOf(false) }

    val animateOffset by animateIntOffsetAsState(
        targetValue = if (moved) {
            IntOffset(pixelToMove, pixelToMove)
        } else {
            IntOffset.Zero
        },
        label = "offset"
    )

    Scaffold {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .offset {
                        animateOffset
                    }
                    .background(Color.Red).size(100.dp)
                    .clickable {
                        moved = !moved
                    }
            )
        }
    }
}