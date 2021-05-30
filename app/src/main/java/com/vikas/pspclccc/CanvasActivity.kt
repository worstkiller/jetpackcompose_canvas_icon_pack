package com.vikas.pspclccc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.DefaultTintBlendMode
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

class CanvasActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainCanvas()
        }
    }
}

@Composable
fun mainCanvas() {
    val scope = rememberCoroutineScope()
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Blue,
        targetValue = Color.Red,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutLinearInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val alpha by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                1000, easing = FastOutLinearInEasing,
                delayMillis = 1000
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    Canvas(modifier = Modifier.fillMaxSize()) {
        repeat(20) {
            drawCircle(
                color = color,
                radius = 100f + it.times(it),
                center = Offset(x = this.center.x, y = this.center.y),
                style = Stroke(width = 10f, cap = StrokeCap.Butt),
                blendMode = BlendMode.Exclusion,
                alpha = alpha
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun showPreview() {
    mainCanvas()
}