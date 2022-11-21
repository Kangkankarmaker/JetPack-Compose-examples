package kk.example.isscrolled

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kk.example.isscrolled.ui.theme.IsScrolledTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IsScrolledTheme {
                val lazyListState= rememberLazyListState()

                Scaffold(
                    content = {
                        Box(modifier = Modifier.fillMaxSize()){
                            List(lazyListState)
                            Text(
                                modifier = Modifier.align(Alignment.Center),
                                text = if (lazyListState.isScrolled) "Screlled" else "Nop",

                            )
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun List(lazyListState: LazyListState) {
    val items = remember {
        List(size = 25){it}
    }

    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        state = lazyListState,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ){
        items(
            items=items,
            key = {it}
        ){
            ItemHolder()
        }
    }

}

@Composable
fun ItemHolder() {
    Spacer(
        modifier = Modifier.fillMaxSize()
            .height(24.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.LightGray.copy(alpha = DefaultAlpha))
    )

}

val LazyListState.isScrolled:Boolean
get() = firstVisibleItemIndex>0 || firstVisibleItemScrollOffset >0