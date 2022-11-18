package k.example.textcustomization

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import k.example.textcustomization.ui.theme.TextCustomizationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextCustomizationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    SelectText()
                }
            }
        }
    }
}

@Composable
fun CustomText(){
    Text(
        text = stringResource(id = R.string.app_name),
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .padding(16.dp),
        color = Color.White,
        fontSize = 24.sp )
}

@Composable
fun CustomText2(){

    Text(
        buildAnnotatedString {
            withStyle(style = ParagraphStyle(textAlign = TextAlign.Center)){
                withStyle(style = SpanStyle(
                    color = MaterialTheme.colors.primary,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )){
                    append("A")
                }

                append("B")
                append("C")
                append("D")

            }
        }, modifier = Modifier.width(200.dp)

    )
}

@Composable
fun CustomText3(){
    Text(text = "Kangkan". repeat(20), maxLines = 2, overflow = TextOverflow.Ellipsis)
}

@Composable
fun SelectText(){
    SelectionContainer {
        Column{
            Text(text = "Hello")

            DisableSelection {
                Text(text = "Hello There")
            }
        }
        
    }
}

@Composable
fun SuperscriptSubscript (
    first: String,
    second:String,
    normalFontSize :TextUnit=MaterialTheme.typography.subtitle1.fontSize,
    fontWeight: FontWeight=FontWeight.Bold
){
    Text(buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = normalFontSize,
                fontWeight = fontWeight
            )
        ){
            append(first)
        }
        withStyle(
            style = SpanStyle(
                fontSize = normalFontSize,
                //baselineShift = BaselineShift.Superscript,
                baselineShift = BaselineShift.Subscript,
                fontWeight = fontWeight
            )
        ){
            append(second)
        }
    })

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextCustomizationTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            SuperscriptSubscript(first = "Kang", second = "kan")

        }
    }
}