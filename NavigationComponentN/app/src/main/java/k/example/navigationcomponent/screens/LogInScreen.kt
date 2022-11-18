package k.example.navigationcomponent.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import k.example.navigationcomponent.navigation.HOME_ROUTE
import k.example.navigationcomponent.navigation.Screen

@Composable
fun LogInScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize(), 
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "LogIn",
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

        Text(
            text = "Go Back",
            modifier = Modifier
                .clickable {
                    navController.navigate(HOME_ROUTE){
                        popUpTo(HOME_ROUTE)
                    }
                }
                .padding(top = 160.dp)
        )
    }
}

@Preview
@Composable
fun LogInScreenPreview() {
    LogInScreen(navController = rememberNavController())
}