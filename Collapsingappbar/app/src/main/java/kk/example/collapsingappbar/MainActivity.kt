package kk.example.collapsingappbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kk.example.collapsingappbar.ui.theme.CollapsingAppBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CollapsingAppBarTheme {
               Collapsing()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Collapsing() {

    val lazyListState = rememberLazyListState()

    Scaffold(
        content = {
            Box(modifier = Modifier.fillMaxSize()) {
                MainContent(lazyListState = lazyListState)
                TopBar(lazyListState=lazyListState)
            }
        }
    )
}

@Composable
fun TopBar(lazyListState: LazyListState) {
    SmallTopAppBar(
        modifier = Modifier
            .background(color = Color.Blue)
            .animateContentSize(animationSpec = tween(durationMillis = 300))
            .height(height = if (lazyListState.isScrolled) 0.dp else 56.dp),
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Blue
        ),
        title = {
            Text(
                text = "Title",
                modifier = Modifier.padding(top = 18.dp),
                style = TextStyle(
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    color = MaterialTheme.colorScheme.surface,
                    fontWeight = FontWeight.Bold
                )
            )
        },

    )
}

@Composable
fun MainContent(lazyListState: LazyListState) {
    val numbers = remember { List(size = 25) {it} }

    val padding by animateDpAsState(
        targetValue = if (lazyListState.isScrolled) 0.dp else 56.dp,
        animationSpec = tween(durationMillis = 300)
    )
    LazyColumn(
        modifier = Modifier.padding(top = padding),
        state = lazyListState
    ){
        items(
            items=numbers,
            key = {it}
        ){
            NumberHolder(numbers=it)
        }
    }
}

@Composable
fun NumberHolder(numbers: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = numbers.toString(),
            style = TextStyle(
                fontSize = MaterialTheme.typography.displayLarge.fontSize
            )
        )
    }
}


val LazyListState.isScrolled:Boolean
    get() = firstVisibleItemIndex>0 || firstVisibleItemScrollOffset >0