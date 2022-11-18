package kk.example.mutablestateof.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kk.example.mutablestateof.screen.HomeScreen
import kk.example.mutablestateof.screen.HomeScreenViewModel

@Composable
fun SetUpNavGraph(navHostController: NavHostController) {
    val homeScreenViewModel:HomeScreenViewModel=  viewModel()
    NavHost(
        navController = navHostController ,
        startDestination = Screen.Home.route
    ){

        composable(route = Screen.Home.route){
            HomeScreen(homeScreenViewModel)
        }
    }
    
}