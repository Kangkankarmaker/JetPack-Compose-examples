package kk.example.hyperlink

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import kk.example.hyperlink.ui.theme.HyperLinkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HyperLinkTheme {
                Box(modifier = Modifier.fillMaxSize()
                    .padding(50.dp)){
                    HyperLinkText(

                        fullText = "A privacy policy is a statement or legal document that discloses some or all of the ways a party gathers, uses, discloses, and manages a customer or client's data."
                    )

                }
            }
        }
    }
}

@Composable
fun HyperLinkText(
    modifier : Modifier=Modifier,
    fullText:String,
    linkText:List<String> = listOf("privacy policy","legal document"),
    linkTextColor: Color=Color.Blue,
    linkTextFontWeight: FontWeight= FontWeight.Bold,
    linkTextDecoration: TextDecoration=TextDecoration.Underline,
    hyperlinks : List<String> = listOf("https://google.com","https://facebook.com"),
    fontSize:TextUnit= TextUnit.Unspecified
) {

    val annotatedString= buildAnnotatedString {
        append(fullText)

        linkText.forEachIndexed { index, link ->
            val startIndex=fullText.indexOf(link)
            val endText=startIndex+link.length

            addStyle(
                style = SpanStyle(
                    color = linkTextColor,
                    fontSize=fontSize,
                    fontWeight = linkTextFontWeight,
                    textDecoration = linkTextDecoration
                ),
                start = startIndex,
                end= endText
            )

            addStringAnnotation(
                tag = "URL",
                annotation = hyperlinks[index],
                start = startIndex,
                end=endText
            )
        }

    }

    val uriHandler= LocalUriHandler.current

    ClickableText(
        modifier = modifier,
        text = annotatedString,
        onClick = {
            annotatedString
                .getStringAnnotations("URL",it,it)
                .firstOrNull()?.let { stringAnnotation->
                    uriHandler.openUri(stringAnnotation.item)
                }
        }
    )
}

