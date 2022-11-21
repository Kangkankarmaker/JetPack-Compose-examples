package kk.example.countdowntext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import kk.example.countdowntext.ui.theme.CountdownTextTheme
import kk.example.countdowntext.ui.theme.KColor
import java.time.Duration

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountdownTextTheme {
                MainScreen(mainScreenViewModel = MainScreenViewModel())
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen(
    mainScreenViewModel: MainScreenViewModel
) {
    val seconds by mainScreenViewModel.seconds.collectAsState(initial = "00")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedContent(
            targetState = seconds,
            transitionSpec = {
                addAnimation().using(
                    SizeTransform(clip = true)
                )
            }
        ) { targetState ->
            Text(
                
                text = "$targetState",
                style = TextStyle(
                    fontSize = MaterialTheme.typography.displayLarge.fontSize,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun addAnimation(duration: Int=800):ContentTransform{
    return slideInVertically(animationSpec = tween(durationMillis = duration)){fullHeight ->fullHeight  }+ fadeIn(
        animationSpec = tween(durationMillis = duration)
    )with slideOutVertically(animationSpec = tween(durationMillis = duration)){fullHeight -> -fullHeight  } + fadeOut(
        animationSpec = tween(durationMillis = duration))

}

