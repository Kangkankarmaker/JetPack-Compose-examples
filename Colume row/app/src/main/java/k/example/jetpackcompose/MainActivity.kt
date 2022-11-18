package k.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import k.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

                    Column(modifier = Modifier.height(100.dp),
                        horizontalAlignment = Alignment.CenterHorizontally){
                        CustomColumnView(weight = 1f, color = MaterialTheme.colors.error)
                        CustomColumnView(weight = 3f, color = MaterialTheme.colors.secondary)

                    }

                    Row(modifier = Modifier.height(100.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CustomRowView(weight = 1f, color = MaterialTheme.colors.error)
                        CustomRowView(weight = 3f, color = MaterialTheme.colors.secondary)
                    }
                }
            }
        }
    }
}

@Composable
fun ColumnScope.CustomColumnView(weight: Float,color:Color){
    Surface(
        modifier = Modifier
            .width(150.dp)
            .weight(weight),
        color = color
    ){}
}
@Composable
fun RowScope.CustomRowView(weight: Float,color:Color){
    Surface(
        modifier = Modifier
            .height(150.dp)
            .weight(weight),
        color = color
    ){}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        Column(modifier = Modifier.height(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
            CustomColumnView(weight = 1f, color = MaterialTheme.colors.error)
            CustomColumnView(weight = 3f, color = MaterialTheme.colors.secondary)

        }

        Row(modifier = Modifier.height(100.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomRowView(weight = 1f, color = MaterialTheme.colors.error)
            CustomRowView(weight = 3f, color = MaterialTheme.colors.secondary)
        }

    }
}


