package com.vikas.jetpackcomposeiconpack.random

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.vikas.jetpackcomposeiconpack.ui.theme.PspclCCCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PspclCCCTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    var currentState by remember { mutableStateOf(BoxState.Collapsed) }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.size(400.dp)) {
                            BoxAnimation(state = currentState)
                        }
                        Button(onClick = {
                            currentState =
                                if (currentState == BoxState.Collapsed) BoxState.Expanded else BoxState.Collapsed
                        }) {
                            Text(text = "Change state")
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Greeting(name: String) {
    var changing by remember { mutableStateOf(true) }
    val alpha: Float by animateFloatAsState(if (changing) 1f else 0f)
    val editable: Dp by animateDpAsState(if (changing) 100.dp else 200.dp)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Column(
            modifier = Modifier
                .fillMaxHeight(.50f)
                .fillMaxWidth(.80f)
        ) {

            val color = remember { Animatable(Color.Gray) }
            LaunchedEffect(changing) {
                color.animateTo(if (changing) Color.Green else Color.Red)
            }
            Box(
                modifier = Modifier
                    .size(editable)
                    .background(Color.Red),
                contentAlignment = Alignment.Center

            ) {
                Text(text = "A screen", modifier = Modifier.graphicsLayer(alpha = alpha))
            }

            Box(
                Modifier
                    .fillMaxSize()
                    .background(color.value)
            )


        }

        Button(onClick = {
            changing = changing.not()
        }) {
            Text(text = "Shrink")
        }
    }

}

@Composable
fun BoxAnimation(state: BoxState) {
    val transitionData = getBoxAnimator(boxState = state)
    Box(
        modifier = Modifier
            .size(transitionData.size)
            .background(transitionData.color)
    ) {
        Text(text = "Box")
    }
}

@Composable
fun getBoxAnimator(boxState: BoxState): TransitionData {
    val transition = updateTransition(targetState = boxState, label = "")
    val color = transition.animateColor(transitionSpec = {
        when {
            BoxState.Expanded isTransitioningTo BoxState.Collapsed ->
                spring(stiffness = 50f)
            else ->
                tween(durationMillis = 500)
        }
    }) { state ->
        when (state) {
            BoxState.Collapsed -> {
                Color.Red
            }
            BoxState.Expanded -> {
                Color.Green
            }
        }
    }
    val size = transition.animateDp(transitionSpec = {
        when {
            BoxState.Expanded isTransitioningTo BoxState.Collapsed ->
                spring(stiffness = 100f, dampingRatio = .75f)
            else ->
                tween(durationMillis = 100)
        }
    }) { state ->
        when (state) {
            BoxState.Expanded -> {
                100.dp
            }
            BoxState.Collapsed -> {
                200.dp
            }
        }
    }
    return remember(transition) { TransitionData(color, size) }
}

class TransitionData(color: State<Color>, size: State<Dp>) {
    val color by color
    val size by size
}

enum class BoxState {
    Collapsed,
    Expanded
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    PspclCCCTheme {
        BoxAnimation(BoxState.Collapsed)
    }
}