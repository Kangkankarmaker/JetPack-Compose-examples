package k.example.coil_imageloadinglibrary

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import coil.transform.RoundedCornersTransformation
import k.example.coil_imageloadinglibrary.ui.theme.CoilImageLoadingLibraryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoilImageLoadingLibraryTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CoilImage()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CoilImageLoadingLibraryTheme {
        CoilImage()
    }
}


@OptIn(ExperimentalCoilApi::class)
@Composable
fun CoilImage() {
    Box(
        modifier = Modifier
            .height(150.dp)
            .width(150.dp),
        contentAlignment = Alignment.Center
    ){
        val painter = rememberImagePainter(
            data = "http://kangkan-karmaker.byethost18.com/images/my.png",
            builder = {
                placeholder(R.drawable.ic_launcher_background)
                error(androidx.core.R.drawable.notification_bg_low_pressed)
                crossfade(1000)
               /* transformations(
                    GrayscaleTransformation(),
                    CircleCropTransformation(),
                    BlurTransformation(LocalContext.current),
                    RoundedCornersTransformation(50f)
                )*/
            }
        )

        val painterState=painter.state
        Image(
            painter = painter,
            contentDescription = "logo Image",
            modifier = Modifier.clip(CircleShape)
        )
        if (painterState is ImagePainter.State.Loading){
            //CircularProgressIndicator()
            Text(text = "Loading")
        }
    }
}