package kk.example.nestednavigationbottombardemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import kk.example.nestednavigationbottombardemo.graphs.RootNavigationGraph
import kk.example.nestednavigationbottombardemo.ui.theme.NestedNavigationBottomBarDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NestedNavigationBottomBarDemoTheme {
                RootNavigationGraph(navController = rememberNavController())
            }
        }
    }
}