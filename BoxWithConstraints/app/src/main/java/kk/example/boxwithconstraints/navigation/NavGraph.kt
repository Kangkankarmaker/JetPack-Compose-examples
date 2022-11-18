package kk.example.boxwithconstraints.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kk.example.boxwithconstraints.screen.HomeScreen
import kk.example.boxwithconstraints.screen.Screen

@Composable
fun SetUpNavGraph(navHostController: NavHostController) {
    NavHost(
        navController =navHostController ,
        startDestination = Screen.Home.route
    ){
        composable(route = Screen.Home.route){
            HomeScreen()
        }
    }
}