package kk.example.smallappbarm3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kk.example.smallappbarm3.ui.theme.SmallAppBarM3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmallAppBarM3Theme {
              
                Greeting()
                
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {

    val scrollBehavior=TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
             SmallTopAppBar(
                 title = {
                     Text(text = "Home")
                 },
                 navigationIcon = {
                     IconButton(onClick = {
                         //Toast.makeText(contex)
                     }) {
                         Icon(
                             imageVector = Icons.Default.Menu,
                             contentDescription = "Menu icon"
                         )
                     }
                 },
                 scrollBehavior = scrollBehavior

                 /*colors = TopAppBarDefaults.smallTopAppBarColors(
                     containerColor = MaterialTheme.colorScheme.primary
                 )*/
             )

            
        },
        content = {
            CustomList()
        }
    ) 
}

@Composable
fun CustomList() {
    val numbers = remember { mutableStateListOf(1,2,3,4,5,6,7,8,9,10) }

    LazyColumn{
        items(
            items=numbers,
            key = {it.hashCode()}
        ){

            Text(
                modifier = Modifier.fillMaxWidth()
                    .padding(all = 24.dp),
                text = "$it",

            )
        }
    }

}





















