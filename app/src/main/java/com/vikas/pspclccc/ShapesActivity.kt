package com.vikas.pspclccc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.vector.DefaultTintBlendMode
import androidx.compose.ui.tooling.preview.Preview

class ShapesActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            drawShapes()
        }
    }

}

@Composable
fun drawShapes() {

    Canvas(modifier = Modifier.fillMaxSize()) {

        drawCircle(
            color = Color.Black,
            radius = 300f,
            this.center,
            1f,
            style = Fill,
            null,
            blendMode = BlendMode.SrcIn
        )

        drawCircle(
            color = Color.Red,
            radius = 280f,
            this.center,
            1f,
            style = Fill,
            null,
            blendMode = BlendMode.Difference
        )

        drawCircle(
            color = Color.White,
            radius = 260f,
            this.center,
            1f,
            style = Fill,
            null,
            blendMode = BlendMode.Difference
        )

        val canvasWidth = size.width
        val canvasHeight = size.height

        drawLine(
            start = Offset(x = canvasWidth / 2, y = 500f),
            end = Offset(x = canvasWidth / 2, y = 800f),
            color = Color.Red,
            strokeWidth = 20F,
            blendMode = BlendMode.Color,
            cap = StrokeCap.Round
        )

        drawRoundRect(
            color = Color.Red,
            this.center,
            style = Fill,
            size = Size(100f, 200f),
            blendMode = BlendMode.Difference,
            cornerRadius = CornerRadius(6f, 6f)
        )
    }

}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun showShapesPreview() {
    drawShapes()
}