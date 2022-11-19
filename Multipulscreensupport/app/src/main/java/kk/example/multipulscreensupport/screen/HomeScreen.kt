package kk.example.boxwithconstraints.screen

import androidx.compose.runtime.Composable

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kk.example.multipulscreensupport.WindowSize
import kk.example.multipulscreensupport.WindowType

@Composable
fun HomeScreen(
    windowSize: WindowSize,
    homeViewModel: HomeViewModel = viewModel()
) {
    val items = homeViewModel.items

    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items = items, key = { it.id }) {
            AdaptableItem(data = it, windowSize = windowSize)
        }
    }
}

@Composable
fun AdaptableItem(data: CustomData, windowSize: WindowSize) {
    val maxLines by remember(key1 = windowSize) {
        mutableStateOf(if (windowSize.width == WindowType.Compact) 4 else 10)
    }

    when (windowSize.height) {
        WindowType.Expanded -> {
            Column {
                ColumnContent(
                    data = data,
                    windowSize = windowSize,
                    maxLines = maxLines
                )
            }
        }
        else -> {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                RowContent(
                    data = data,
                    windowSize = windowSize,
                    maxLines = maxLines
                )
            }
        }
    }
}

@Composable
fun RowScope.RowContent(
    data: CustomData,
    windowSize: WindowSize,
    maxLines: Int
) {
    val showIcons by remember(key1 = windowSize) {
        mutableStateOf(windowSize.width == WindowType.Expanded)
    }

    AsyncImage(
        modifier = Modifier
            .weight(1f),
        model = ImageRequest.Builder(LocalContext.current)
            .data(data = data.image)
            .crossfade(enable = true)
            .build(),
        contentDescription = "Image",
        contentScale = ContentScale.Crop
    )

    Column(modifier = Modifier.weight(1f)) {
        Text(
            text = data.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontSize =
                when (windowSize.width) {
                    WindowType.Expanded -> MaterialTheme.typography.bodySmall.fontSize
                    WindowType.Medium -> MaterialTheme.typography.bodyMedium.fontSize
                    else -> MaterialTheme.typography.bodySmall.fontSize
                },
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            modifier = Modifier.alpha(alpha = DefaultAlpha),
            text = data.description,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontSize =
                when (windowSize.width) {
                    WindowType.Expanded -> MaterialTheme.typography.bodySmall.fontSize
                    WindowType.Medium -> MaterialTheme.typography.bodyMedium.fontSize
                    else -> MaterialTheme.typography.bodySmall.fontSize
                }
            )
        )
        if (showIcons) {
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                data.icons.forEach {
                    Icon(
                        modifier = Modifier.size(40.dp),
                        imageVector = it,
                        contentDescription = "Icon"
                    )
                }
            }
        }
    }
}

@Composable
fun ColumnContent(
    data: CustomData,
    windowSize: WindowSize,
    maxLines: Int
) {
    val showIcons by remember(key1 = windowSize) {
        mutableStateOf(windowSize.height == WindowType.Expanded)
    }

    AsyncImage(
        modifier = Modifier.fillMaxWidth().height(400.dp),
        model = ImageRequest.Builder(LocalContext.current)
            .data(data = data.image)
            .crossfade(enable = true)
            .build(),
        contentDescription = "Image",
        contentScale = ContentScale.Crop
    )

    Column {
        Text(
            text = data.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontSize =
                when (windowSize.height) {
                    WindowType.Expanded -> MaterialTheme.typography.bodyLarge.fontSize
                    else -> MaterialTheme.typography.bodySmall.fontSize
                },
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            modifier = Modifier.alpha(DefaultAlpha),
            text = data.description,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontSize =
                when (windowSize.height) {
                    WindowType.Expanded -> MaterialTheme.typography.bodyLarge.fontSize
                    else -> MaterialTheme.typography.bodySmall.fontSize
                }
            )
        )
        if (showIcons) {
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                data.icons.forEach {
                    Icon(
                        modifier = Modifier.size(40.dp),
                        imageVector = it,
                        contentDescription = "Icon"
                    )
                }
            }
        }
    }
}