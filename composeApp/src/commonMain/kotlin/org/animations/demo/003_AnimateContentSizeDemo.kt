package org.animations.demo

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimateContentSizeDemo() {

    var expanded by remember { mutableStateOf(false) }

    Scaffold { paddingValues ->
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .animateContentSize()
                        .width(300.dp)
                        .height(if (expanded) 500.dp else 100.dp)
                        .background(Color.Red)
                )

                Button(
                    onClick = {
                        expanded = !expanded
                    }
                ) {
                    Text("Change Size")
                }
            }
        }
    }
}