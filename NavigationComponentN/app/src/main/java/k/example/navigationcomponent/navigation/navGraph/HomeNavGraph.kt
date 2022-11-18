package k.example.navigationcomponent.navigation.navGraph

import android.util.Log
import androidx.navigation.*
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import k.example.navigationcomponent.navigation.DETAILS_ARGUMENT_KEY
import k.example.navigationcomponent.navigation.DETAILS_ARGUMENT_KEY2
import k.example.navigationcomponent.navigation.HOME_ROUTE
import k.example.navigationcomponent.navigation.Screen
import k.example.navigationcomponent.screens.DetailScreen
import k.example.navigationcomponent.screens.HomeScreen
import k.example.navigationcomponent.screens.LogInScreen
import k.example.navigationcomponent.screens.SignUpScreen

fun NavGraphBuilder.homeNavGraph(
    navController:NavHostController
){
    navigation(
        startDestination = Screen.Home.route,
        route = HOME_ROUTE
    ){

        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(

                navArgument(DETAILS_ARGUMENT_KEY){
                    type= NavType.IntType
                    defaultValue=0
                },
                navArgument(DETAILS_ARGUMENT_KEY2){
                    type= NavType.StringType
                }
            )
        ){
            Log.d("Argu",it.arguments?.getInt(DETAILS_ARGUMENT_KEY).toString())
            Log.d("Argu2",it.arguments?.getString(DETAILS_ARGUMENT_KEY2).toString())
            DetailScreen(navController )
        }

    }

}