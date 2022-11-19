package kk.example.boxwithconstraints.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kk.example.boxwithconstraints.screen.HomeScreen
import kk.example.boxwithconstraints.screen.Screen
import kk.example.multipulscreensupport.WindowSize

@Composable
fun SetUpNavGraph(windowSize: WindowSize,navHostController: NavHostController) {
    NavHost(
        navController =navHostController ,
        startDestination = Screen.Home.route
    ){
        composable(route = Screen.Home.route){
            HomeScreen(windowSize=windowSize)
        }
    }
}