package k.example.paging.Screen.Home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun HomeTopBar(
    onSearchClicked: () -> Unit
) {
    SmallTopAppBar(
        title = {
            Text(
                text = "Home",
                color = Color.Blue
            )
        },
        //colors = MaterialTheme.colorScheme.onSurface,
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            }
        }
    )
}

@Composable
@Preview
fun HomeTopBarPreview() {
    HomeTopBar {}
}