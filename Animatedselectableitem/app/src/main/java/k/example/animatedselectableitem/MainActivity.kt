package k.example.animatedselectableitem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import k.example.animatedselectableitem.ui.theme.AnimatedSelectableItemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedSelectableItemTheme {

                var selected by remember { mutableStateOf(false) }
                var selected2 by remember { mutableStateOf(false) }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(80.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SelectableItem(
                        selected = selected,
                        title = "Selected item",
                        onClick = {
                            selected=!selected
                        }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    SelectableItem(
                        selected = selected2,
                        title = "Selected item 2",
                        subTitle = "LoRa is a physical proprietary radio communication technique. It is based on spread spectrum modulation techniques derived from chirp spread spectrum technology. It was developed by Cycleo, a company of Grenoble, France, later acquired by Semtech.",
                        onClick = {
                            selected2=!selected2
                        }
                    )
                }
            }
        }
    }
}
