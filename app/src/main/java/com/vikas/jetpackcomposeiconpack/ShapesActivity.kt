package com.vikas.jetpackcomposeiconpack

import android.graphics.Paint
import android.graphics.Typeface
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ShapesActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            getAllIcons()
        }
    }
}

@Composable
fun getAllIcons() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            instagramIcon()
            facebookIcon()
            messengerIcon()
        }
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            googleIcon()
            getYoutubeIcon()
            getGooglePhotosIcon()
        }
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            googleAssistant()
            googleAds()
            getGoogleVoiceSearch()
        }
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            getStackOverflow()
            getSpotify()
            getTrello()
        }
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            getZoom()
            getJetpackCompose()
            getSpotify()
        }
    }
}

@Composable
fun instagramIcon() {
    val instaColors = listOf(Color.Yellow, Color.Red, Color.Magenta)
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        drawRoundRect(
            brush = Brush.linearGradient(colors = instaColors),
            cornerRadius = CornerRadius(60f, 60f),
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )
        drawCircle(
            brush = Brush.linearGradient(colors = instaColors),
            radius = 45f,
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )
        drawCircle(
            brush = Brush.linearGradient(colors = instaColors),
            radius = 13f,
            center = Offset(this.size.width * .80f, this.size.height * 0.20f),
        )
    }
}

@Composable
fun facebookIcon() {
    val assetManager = LocalContext.current.assets
    val paint = Paint().apply {
        textAlign = Paint.Align.CENTER
        textSize = 200f
        color = Color.White.toArgb()
        typeface = Typeface.createFromAsset(assetManager, "FACEBOLF.OTF")
    }
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        drawRoundRect(
            color = Color(0xFF1776d1),
            cornerRadius = CornerRadius(20f, 20f)
        )
        drawContext.canvas.nativeCanvas.drawText("f", center.x + 25, center.y + 100, paint)
    }
}

@Composable
fun messengerIcon() {
    val colors = listOf(Color(0xFF02b8f9), Color(0xFF0277fe))
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {

        val trianglePath = Path().let {
            it.moveTo(this.size.width * .20f, this.size.height * .77f)
            it.lineTo(this.size.width * .20f, this.size.height * 0.95f)
            it.lineTo(this.size.width * .37f, this.size.height * 0.86f)
            it.close()
            it
        }

        val electricPath = Path().let {
            it.moveTo(this.size.width * .20f, this.size.height * 0.60f)
            it.lineTo(this.size.width * .45f, this.size.height * 0.35f)
            it.lineTo(this.size.width * 0.56f, this.size.height * 0.46f)
            it.lineTo(this.size.width * 0.78f, this.size.height * 0.35f)
            it.lineTo(this.size.width * 0.54f, this.size.height * 0.60f)
            it.lineTo(this.size.width * 0.43f, this.size.height * 0.45f)
            it.close()
            it
        }

        drawOval(
            Brush.verticalGradient(colors = colors),
            size = Size(this.size.width, this.size.height * 0.95f)
        )

        drawPath(
            path = trianglePath,
            Brush.verticalGradient(colors = colors),
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )

        drawPath(path = electricPath, color = Color.White)

    }
}

@Composable
fun googleIcon() {

    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        val width = this.size.width
        val height = this.size.height

        val path = Path()
        path.moveTo(width / 2, height / 2)
        path.lineTo(width + 5, height * .05f)
        path.lineTo(width + 20, height * 0.45f)


        clipPath(path = path, clipOp = ClipOp.Difference) {
            drawCircle(
                color = Color.Transparent,
                radius = 100f,
                style = Stroke(40f, cap = StrokeCap.Round)
            )
            drawPath(path = path, color = Color.Transparent)
        }

        drawRect(
            color = Color(0xFF4384f3),
            size = Size(width * .55f, 20f),
            topLeft = Offset(width * .55f, height * .45f)
        )

        drawRect(
            color = Color(0xFF4384f3),
            size = Size(width * .45f, 20f),
            topLeft = Offset(width * .55f, height * .54f)
        )

        drawArc(
            color = Color(0xFF4384f3),
            startAngle = 0f,
            sweepAngle = 45f,
            useCenter = false,
            style = Stroke(width = 40f)
        )
        drawArc(
            color = Color(0xFF33a852),
            startAngle = 45f,
            sweepAngle = 135f,
            useCenter = false,
            style = Stroke(width = 40f)
        )
        drawArc(
            color = Color(0xFFfabd03),
            startAngle = 145f,
            sweepAngle = 80f,
            useCenter = false,
            style = Stroke(width = 40f)
        )

        drawArc(
            color = Color(0xFFeb4435),
            startAngle = 205f,
            sweepAngle = 120f,
            useCenter = false,
            style = Stroke(width = 40f)
        )
    }
}

@Composable
fun getYoutubeIcon() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {

        val path = Path().apply {
            moveTo(size.width * .43f, size.height * .18f)
            lineTo(size.width * .72f, size.height * .35f)
            lineTo(size.width * .43f, size.height * .53f)
            close()
        }
        drawRoundRect(
            color = Color.Red,
            cornerRadius = CornerRadius(40f, 40f),
            size = Size(size.width, size.height * .70f)
        )
        drawPath(color = Color.White, path = path)
    }
}

@Composable
private fun getGooglePhotosIcon() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        drawArc(
            color = Color(0xFFf04231),
            startAngle = -90f,
            sweepAngle = 180f,
            useCenter = true,
            size = Size(size.width * .50f, size.height * .50f),
            topLeft = Offset(size.width * .25f, 0f)
        )
        drawArc(
            color = Color(0xFF4385f7),
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = true,
            size = Size(size.width * .50f, size.height * .50f),
            topLeft = Offset(size.width * .50f, size.height * .25f)
        )
        drawArc(
            color = Color(0xFF30a952),
            startAngle = 0f,
            sweepAngle = -180f,
            useCenter = true,
            size = Size(size.width * .50f, size.height * .50f),
            topLeft = Offset(0f, size.height * .25f)
        )

        drawArc(
            color = Color(0xFFffbf00),
            startAngle = 270f,
            sweepAngle = -180f,
            useCenter = true,
            size = Size(size.width * .50f, size.height * .50f),
            topLeft = Offset(size.width * .25f, size.height * .50f)
        )


    }
}

@Composable
private fun googleAssistant() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {

        val paint = Paint().apply {
            color = Color.White.toArgb()
            setShadowLayer(20f, 0f, 0f, Color.DarkGray.copy(alpha = .20f).toArgb())
        }
        this.drawIntoCanvas {
            it.nativeCanvas.drawOval(this.size.width, this.size.height, 0f, 0f, paint)
        }
        drawCircle(
            color = Color(0xFF4385f7),
            radius = size.width * .20f,
            center = Offset(size.width * .33f, size.height * .35f)
        )
        drawCircle(
            color = Color(0xFFf04231),
            radius = size.width * .12f,
            center = Offset(size.width * .66f, size.height * .48f)
        )
        drawCircle(
            color = Color(0xFFffbf00),
            radius = size.width * .14f,
            center = Offset(size.width * .66f, size.height * .78f)
        )
        drawCircle(
            color = Color(0xFF30a952),
            radius = size.width * .08f,
            center = Offset(size.width * .84f, size.height * .32f)
        )
    }
}

@Composable
fun googleAds() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {

        rotate(30f) {
            drawRoundRect(
                color = Color(0xFFffbf00),
                cornerRadius = CornerRadius(40f, 40f),
                topLeft = Offset(26f, 5f),
                size = Size(size.width * .35f, size.height)
            )
        }
        rotate(-30f) {
            drawRoundRect(
                color = Color(0xFF4385f7),
                cornerRadius = CornerRadius(40f, 40f),
                topLeft = Offset(size.width.div(2), 0f),
                size = Size(size.width * .35f, size.height)
            )
        }
        drawCircle(color = Color(0xFF30a952), radius = 35f, center = Offset(30f, 145f))
    }
}

@Composable
fun getGoogleVoiceSearch() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {

        val paint = Paint().apply {
            color = Color.White.toArgb()
            setShadowLayer(20f, 0f, 0f, Color.DarkGray.copy(alpha = .20f).toArgb())
        }
        this.drawIntoCanvas {
            it.nativeCanvas.drawOval(this.size.width, this.size.height, 0f, 0f, paint)
        }

        drawRoundRect(
            color = Color(0xFF4385f7),
            cornerRadius = CornerRadius(40f, 40f),
            topLeft = Offset(size.width.times(.40f), size.height.times(.20f)),
            size = Size(size.width * .20f, size.height.times(.40f))
        )

        drawRect(
            color = Color(0xFF30a952),
            topLeft = Offset(size.width.times(.47f), size.height.times(.72f)),
            size = Size(size.width.times(.08f), size.height.times(.17f))
        )

        drawArc(
            color = Color(0xFFffbf00),
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = false,
            style = Stroke(width = size.width.times(.08f)),
            size = Size(size.width.times(.40f), size.height.times(.40f)),
            topLeft = Offset(size.width.times(.30f), size.height.times(.30f))
        )

        drawArc(
            color = Color(0xFFf04231),
            startAngle = 0f,
            sweepAngle = 130f,
            useCenter = false,
            style = Stroke(width = size.width.times(.08f)),
            size = Size(size.width.times(.40f), size.height.times(.40f)),
            topLeft = Offset(size.width.times(.30f), size.height.times(.30f))
        )

    }
}

@Composable
fun getStackOverflow() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        drawRect(
            color = Color(0xFFbcbbbb),
            topLeft = Offset(size.width * .10f, size.height * .63f),
            Size(size.width * .10f, size.height * .35f)
        )
        drawRect(
            color = Color(0xFFbcbbbb),
            topLeft = Offset(size.width * .10f, size.height * .89f),
            Size(size.width * .89f, size.height * .10f)
        )
        drawRect(
            color = Color(0xFFbcbbbb),
            topLeft = Offset(size.width * .89f, size.height * .63f),
            Size(size.width * .10f, size.height * .35f)
        )

        rotate(0f) {
            drawRect(
                color = Color(0xFFf48023),
                topLeft = Offset(size.width * .28f, size.height * .72f),
                Size(size.width * .54f, size.height * .10f)
            )
        }

        rotate(6f) {
            drawRect(
                color = Color(0xFFf48023),
                topLeft = Offset(size.width * .30f, size.height * .56f),
                Size(size.width * .54f, size.height * .10f)
            )
        }

        rotate(15f) {
            drawRect(
                color = Color(0xFFf48023),
                topLeft = Offset(size.width * .30f, size.height * .40f),
                Size(size.width * .54f, size.height * .10f)
            )
        }

        rotate(24f) {
            drawRect(
                color = Color(0xFFf48023),
                topLeft = Offset(size.width * .26f, size.height * .22f),
                Size(size.width * .54f, size.height * .10f)
            )
        }
        rotate(34f) {
            drawRect(
                color = Color(0xFFf48023),
                topLeft = Offset(size.width * .22f, size.height * .06f),
                Size(size.width * .54f, size.height * .10f)
            )
        }
    }
}

@Composable
fun getSpotify() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        val width = size.width
        val height = size.height
        val path = Path().apply {
            moveTo(width.times(.18f), height.times(.34f))
            cubicTo(
                width.times(.18f),
                height.times(.35f),
                width.times(.45f),
                height.times(.20f),
                width.times(.83f),
                height.times(.40f)
            )
            moveTo(
                width.times(.28f),
                height.times(.50f),
            )
            cubicTo(
                width.times(.28f),
                height.times(.50f),
                width.times(.45f),
                height.times(.43f),
                width.times(.73f),
                height.times(.55f)
            )
            moveTo(
                width.times(.33f),
                height.times(.67f),
            )
            cubicTo(
                width.times(.33f),
                height.times(.67f),
                width.times(.45f),
                height.times(.62f),
                width.times(.67f),
                height.times(.72f)
            )
        }
        drawCircle(color = Color(0xFF1ed760))
        drawPath(
            path = path,
            color = Color.Black,
            style = Stroke(width = width.times(.09f), cap = StrokeCap.Round)
        )
    }
}

@Composable
fun getTrello() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        drawRoundRect(color = Color(0xFF0269a9), cornerRadius = CornerRadius(20f, 20f))
        drawRoundRect(
            color = Color.White,
            cornerRadius = CornerRadius(10f, 10f),
            size = Size(width = size.width.times(.30f), size.height.times(.60f)),
            topLeft = Offset(size.width.times(.13f), size.height.times(.20f))
        )
        drawRoundRect(
            color = Color.White,
            cornerRadius = CornerRadius(10f, 10f),
            size = Size(width = size.width.times(.30f), size.height.times(.45f)),
            topLeft = Offset(size.width.times(.58f), size.height.times(.20f))
        )
    }
}

@Composable
fun getZoom() {
    val zoomColors = listOf(Color(0xFF56a2ff), Color(0xFF3d83fc))
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        val width = size.width
        val height = size.height
        val pathHeart = Path().apply {
            moveTo(width.times(.22f), height.times(.58f))
            lineTo(width.times(.22f), height.times(.37f))
            quadraticBezierTo(
                width.times(.22f),
                height.times(.34f),
                width.times(.25f),
                height.times(.34f)
            )
            lineTo(width.times(.54f), height.times(.34f))
            quadraticBezierTo(
                width.times(.62f),
                height.times(.34f),
                width.times(.62f),
                height.times(.41f)
            )
            lineTo(width.times(.62f), height.times(.62f))
            quadraticBezierTo(
                width.times(.62f),
                height.times(.65f),
                width.times(.58f),
                height.times(.65f)
            )
            lineTo(width.times(.30f), height.times(.65f))
            quadraticBezierTo(
                width.times(.22f),
                height.times(.65f),
                width.times(.22f),
                height.times(.58f)
            )
            moveTo(width.times(.65f), height.times(.44f))
            lineTo(width.times(.65f), height.times(.56f))
            lineTo(width.times(.75f), height.times(.65f))
            lineTo(width.times(.75f), height.times(.35f))
            lineTo(width.times(.65f), height.times(.44f))
            close()
        }
        drawRoundRect(
            brush = Brush.verticalGradient(zoomColors),
            cornerRadius = CornerRadius(60f, 60f)
        )
        drawPath(pathHeart, color = Color.White)
    }

}

@Composable
fun getJetpackCompose() {

    Canvas(modifier = Modifier.size(100.dp)) {

        val height = this.size.height
        val width = this.size.width
        drawArc(
            color = Color(0xFF58bd46),
            startAngle = 0f,
            useCenter = false,
            sweepAngle = -180f,
            size = Size(width = width.times(.60f), height = height.times(.55f)),
            topLeft = Offset(width.times(.25f), height.times(.30f))
        )
        drawCircle(
            color = Color.White,
            radius = width.times(.04f),
            center = Offset(width.times(.45f), height.times(.45f))
        )
        drawCircle(
            color = Color.White, radius = width.times(.04f),
            center = Offset(width.times(.64f), height.times(.45f)),
        )
        drawLine(
            color = Color(0xFF58bd46),
            start = Offset(width.times(.40f), height.times(.42f)),
            strokeWidth = 15f,
            cap = StrokeCap.Round,
            end = Offset(width.times(.29f), height.times(.29f))
        )
        drawLine(
            color = Color(0xFF58bd46),
            start = Offset(width.times(.68f), height.times(.40f)),
            strokeWidth = 15f,
            cap = StrokeCap.Round,
            end = Offset(width.times(.76f), height.times(.27f))
        )
    }

}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun showShapesPreview() {
    getAllIcons()
}