package kk.example.passparcelable.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kk.example.passparcelable.Person
import kk.example.passparcelable.screen.DetailScreen
import kk.example.passparcelable.screen.HomeScreen
import kk.example.passparcelable.screen.Screen
import kk.example.passparcelable.screen.SharedViewModel

@Composable
fun SetUpNavGraph(navController: NavHostController) {

    val sharedViewModel:SharedViewModel= viewModel()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(route = Screen.Home.route){
            HomeScreen(navController=navController,sharedViewModel=sharedViewModel)
        }

        composable(route = Screen.Details.route){
           /* LaunchedEffect(key1 = it ){
                val result=navController.previousBackStackEntry?.savedStateHandle?.get<Person>("person")
                Log.d("clickResult","${result?.firstName}")
                Log.d("clickResult","${result?.lastName}")
            }*/
            DetailScreen(navController=navController,sharedViewModel=sharedViewModel)
        }
    }
}