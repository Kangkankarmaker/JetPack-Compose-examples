package k.example.paging.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.ExperimentalPagingApi
import k.example.paging.Screen.Home.HomeScreen
import k.example.paging.Screen.search.SearchScreen

@OptIn(ExperimentalPagingApi::class)
@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost(
        navController=navController,
        startDestination = Screen.Home.route
    ){
        composable(route = Screen.Home.route){
            HomeScreen(navController=navController)
        }

        composable(route = Screen.Search.route){
            SearchScreen(navController)
        }
    }
}