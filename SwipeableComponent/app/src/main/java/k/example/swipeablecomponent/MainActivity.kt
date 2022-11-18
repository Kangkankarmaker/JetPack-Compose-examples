package k.example.swipeablecomponent

import android.graphics.fonts.Font
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import k.example.swipeablecomponent.ui.theme.SwipeableComponentTheme
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwipeableComponentTheme {

                val archive=SwipeAction(
                    onSwipe = {
                        Log.d("onSwipe","Swipe Archive")
                    },
                    icon = {
                        Icon(
                            modifier = Modifier.padding(16.dp),
                            painter = painterResource(
                                id = R.drawable.ic_baseline_archive_24
                            ),
                            tint = Color.White,
                            contentDescription = ""
                        )
                    }, background = Color.Green
                )

                val email=SwipeAction(
                    onSwipe = {
                        Log.d("onSwipe","Swipe email")
                    },
                    icon = {
                        Icon(
                            modifier = Modifier.padding(16.dp),
                            painter = painterResource(
                                id = R.drawable.ic_baseline_email_24
                            ),
                            tint = Color.White,
                            contentDescription = ""
                        )
                    }, background = Color.Blue
                )

                SwipeableActionsBox(

                    startActions = listOf(archive),
                    endActions  = listOf(email),
                    swipeThreshold = 50.dp
                ) {

                    Greeting()

                }

            }
        }
    }
}

@Composable
fun Greeting(name: String?="") {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.onSecondary)
            .padding(horizontal = 12.dp)
            .padding(vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(size = 50.dp))
                .background(MaterialTheme.colorScheme.primary)
                .size(50.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))

        Column() {
            Text(
                text = "Title",
               style = TextStyle(
                   fontSize = 20.sp,
                   fontWeight = FontWeight.Bold
               )

            )
            Text(
                text = "Title Title Title Title",
                style = TextStyle(
                    //fontSize = ,
                    fontWeight = FontWeight.Normal
                )
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SwipeableComponentTheme {
        Greeting("Android")
    }
}