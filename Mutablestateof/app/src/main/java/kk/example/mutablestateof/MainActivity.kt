package kk.example.mutablestateof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import kk.example.mutablestateof.navigation.SetUpNavGraph
import kk.example.mutablestateof.screen.HomeScreen
import kk.example.mutablestateof.screen.HomeScreenViewModel
import kk.example.mutablestateof.ui.theme.MutableStateOfTheme

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MutableStateOfTheme {

                val navHost= rememberNavController()
                SetUpNavGraph(navHost)

            }
        }
    }
}

