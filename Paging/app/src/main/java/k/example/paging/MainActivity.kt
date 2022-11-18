package k.example.paging

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import dagger.hilt.android.AndroidEntryPoint
import k.example.paging.ui.theme.PagingTheme
import k.example.paging.navigation.SetUpNavGraph

@ExperimentalPagingApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PagingTheme {
                // A surface container using the 'background' color from the theme
                val navController= rememberNavController()
                SetUpNavGraph(navController = navController)
            }
        }
    }
}

