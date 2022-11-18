package k.example.navigationcomponent.navigation.navGraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import k.example.navigationcomponent.navigation.AUTHENTICATION_ROUTE
import k.example.navigationcomponent.navigation.Screen
import k.example.navigationcomponent.screens.LogInScreen
import k.example.navigationcomponent.screens.SignUpScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.LogIn.route,
        route = AUTHENTICATION_ROUTE
    ){

        composable(
            route = Screen.SignUp.route
        ){
            SignUpScreen(navController)
        }

        composable(
            route = Screen.LogIn.route
        ){
            LogInScreen(navController)
        }
    }

}