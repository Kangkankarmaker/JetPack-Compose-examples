package kk.example.boxwithconstraints.screen

sealed class Screen(val route:String){
    object Home : Screen("home")
}
