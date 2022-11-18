package k.example.onboarding.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import k.example.onboarding.screen.Screen
import k.example.onboarding.screen.ui.HomeScreen
import k.example.onboarding.screen.ui.WelcomeScreen

@Composable
fun SetUpNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable(route = Screen.Welcome.route){
            WelcomeScreen(navController=navController)
        }

        composable(route = Screen.Home.route){
            HomeScreen()
        }
    }
}