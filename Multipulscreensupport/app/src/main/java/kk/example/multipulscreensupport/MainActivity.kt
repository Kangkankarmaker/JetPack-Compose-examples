package kk.example.multipulscreensupport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import kk.example.boxwithconstraints.navigation.SetUpNavGraph
import kk.example.multipulscreensupport.ui.theme.MultipulScreenSupportTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultipulScreenSupportTheme {
                val window= rememberWindowSize()
                SetUpNavGraph(
                    windowSize = window,
                    navHostController = rememberNavController()
                )
            }
        }
    }
}

