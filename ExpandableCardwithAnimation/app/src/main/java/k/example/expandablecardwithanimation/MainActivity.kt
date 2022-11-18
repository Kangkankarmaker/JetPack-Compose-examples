package k.example.expandablecardwithanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import k.example.expandablecardwithanimation.ui.theme.ExpandableCardWithAnimationTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpandableCardWithAnimationTheme {
                // A surface container using the 'background' color from the theme

                Column(
                    modifier = Modifier.fillMaxSize()
                        .background(Color.Black)
                        .padding(30.dp)
                ) {
                    ExpandableCard("Title 1","Lorazepam, sold under the brand name Ativan among others, is a" +
                            " benzodiazepine medication. It is used to treat anxiety disorders, trouble sleeping, severe agitation," +
                            " active seizures including status")
                    ExpandableCard("Title 2","Lorazepam, sold under the brand name Ativan among others, is a" +
                            " benzodiazepine medication. It is used to treat anxiety disorders, trouble sleeping, severe agitation," +
                            " active seizures including status")
                }
            }
        }
    }
}



@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExpandableCardWithAnimationTheme {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color.Black)
                .padding(30.dp)
        ) {
            ExpandableCard("Title 1","Lorazepam, sold under the brand name Ativan among others, is a" +
                    " benzodiazepine medication. It is used to treat anxiety disorders, trouble sleeping, severe agitation," +
                    " active seizures including status")
            ExpandableCard("Title 2","Lorazepam, sold under the brand name Ativan among others, is a" +
                    " benzodiazepine medication. It is used to treat anxiety disorders, trouble sleeping, severe agitation," +
                    " active seizures including status")
        }
    }
}