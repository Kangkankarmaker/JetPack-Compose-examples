package kk.example.multi_preview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kk.example.multi_preview.ui.theme.MultiPreviewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiPreviewTheme {
                
                Greeting()

            }
        }
    }
}

@Composable
fun Greeting() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyCard()
    }
}

@Composable
fun MyCard() {
    Box(
        modifier = Modifier
            .border(
                shape = RoundedCornerShape(size = 10.dp),
                color = Color.Blue,
                width = 2.dp
            )
    ){
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text ="Android Compose",
                style = TextStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize
                )
            )

            Text(
                text ="Developer mode = on",
                style = TextStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium,
                    fontSize = MaterialTheme.typography.labelMedium.fontSize
                )
            )
        }
    }
}


@Composable
@Preview(name = "Pixel 2", group = "Devices", device = Devices.PIXEL_4_XL, showSystemUi = true)
fun GreetingPreview() {
    Greeting()
}