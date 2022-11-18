package k.example.expandablecardwithanimation

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import k.example.expandablecardwithanimation.ui.theme.ExpandableCardWithAnimationTheme
import k.example.expandablecardwithanimation.ui.theme.Shapes

@ExperimentalMaterialApi
@Composable
fun ExpandableCard(
    title: String,
    description: String
){

    var expandableState by remember { mutableStateOf(false) }
    val rotateState by animateFloatAsState(
        targetValue =if (expandableState)180f else 0f
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 1000,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = Shapes.medium,
        onClick = {
            expandableState=!expandableState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(6f),
                    text = title,
                    fontSize = MaterialTheme.typography.h4.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
                        .rotate(rotateState),
                    onClick = {
                        expandableState=!expandableState
                    }
                ) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Arrow")
                }
            }
            if (expandableState){
                Text(text = description)
            }
        }

    }
}

@Composable
@Preview
@ExperimentalMaterialApi
fun ExpandableCardPreview() {
    ExpandableCard("Title 1","Lorazepam, sold under the brand name Ativan among others, is a" +
            " benzodiazepine medication. It is used to treat anxiety disorders, trouble sleeping, severe agitation," +
            " active seizures including status")
}