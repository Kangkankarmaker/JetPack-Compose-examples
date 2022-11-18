package k.example.gradientbutton

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import k.example.gradientbutton.ui.theme.Pink40
import k.example.gradientbutton.ui.theme.PurpleGrey40

@Composable
fun GradientButton(
    text: String,
    textColor: Color,
    gradient: Brush,
    onClick:()->Unit
){
    Button(
        colors = ButtonDefaults.buttonColors(
            Color.Transparent
        ),
        contentPadding = PaddingValues(5.dp),
        onClick = { onClick() }
    ) {
        Box(modifier = Modifier
            .background(gradient)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center){
            Text(text = text, color = textColor)
        }
    }
}

@Preview
@Composable
fun GradientPreview(){
    GradientButton(
        text = "Button",
        textColor = Color.White,
        gradient =Brush.horizontalGradient(
            colors = listOf(
                PurpleGrey40,Pink40
            )
        )
    ) {

    }
}