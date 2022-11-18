package k.example.navigationcomponent.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import k.example.navigationcomponent.navigation.Screen

@Composable
fun DetailScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize(), 
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Detail",
            color = Color.Green,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable {
            // navController.popBackStack()
            navController.navigate(Screen.Home.route){
                popUpTo(Screen.Home.route){
                    inclusive=true
                }
            }

        })
    }
}