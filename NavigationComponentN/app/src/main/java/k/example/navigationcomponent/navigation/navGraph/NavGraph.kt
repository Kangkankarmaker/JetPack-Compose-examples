package k.example.navigationcomponent.navigation.navGraph

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import k.example.navigationcomponent.navigation.*
import k.example.navigationcomponent.screens.DetailScreen
import k.example.navigationcomponent.screens.HomeScreen
import k.example.navigationcomponent.screens.LogInScreen
import k.example.navigationcomponent.screens.SignUpScreen

@Composable
fun SetUpNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE,
        route = ROOT_ROUTE
    ){

        homeNavGraph(navController=navController)
        authNavGraph(navController = navController)

    }
}