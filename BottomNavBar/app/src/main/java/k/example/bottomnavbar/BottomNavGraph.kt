package k.example.bottomnavbar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import k.example.bottomnavbar.screens.HomeScreen
import k.example.bottomnavbar.screens.ProfileScreen
import k.example.bottomnavbar.screens.SettingsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ){

        composable(
            route = BottomBarScreen.Home.route
        ){
            HomeScreen()
        }

        composable(
            route = BottomBarScreen.Profile.route
        ){
            ProfileScreen()
        }

        composable(
            route = BottomBarScreen.Settings.route
        ){
            SettingsScreen()
        }
    }
}