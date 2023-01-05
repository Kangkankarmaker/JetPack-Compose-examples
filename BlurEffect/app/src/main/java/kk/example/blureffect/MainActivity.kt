package kk.example.blureffect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role.Companion.Switch
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.stevdzasan.messagebar.ContentWithMessageBar
import com.stevdzasan.messagebar.MessageBarPosition
import com.stevdzasan.messagebar.rememberMessageBarState
import kk.example.blureffect.ui.theme.BlurEffectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlurEffectTheme {
               Greeting()
                
               // MaterialMessage()
            }
        }
    }

    
}

@Composable
fun Greeting() {

    var checked by remember { mutableStateOf(true) }
    val animatedBlur by animateDpAsState(targetValue = if (checked) 8.dp else 0.dp)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.blur( radius = animatedBlur),
            text ="Hello Compose",
            style = TextStyle(
                fontSize = MaterialTheme.typography.headlineLarge.fontSize
            )
        )

        Spacer(modifier = Modifier.padding(all = 24.dp))

        /*Switch(
            checked = checked,
            onCheckedChange = { checked = !checked }
        )*/
    }
}

@Composable
fun MaterialMessage() {
    val state = rememberMessageBarState()
    ContentWithMessageBar(
        messageBarState = state,
        position = MessageBarPosition.BOTTOM,
        //successIcon = ImageVector.vectorResource(id = R.drawable.ic_launcher_background)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                state.addSuccess(message = "Successfully Updated.")
            }) {
                Text(text = "Click me")
            }
            
            Spacer(modifier = Modifier.padding(all = 24.dp))

            Button(onClick = {
                state.addError(exception = Exception("Internet Unavailable."))
            }) {
                Text(text = "Click me")
            }
        }
    }
}


