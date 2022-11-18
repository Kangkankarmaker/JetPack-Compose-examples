package k.example.navigationcomponent.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import k.example.navigationcomponent.navigation.Screen

@Composable
fun SignUpScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize(), 
        horizontalAlignment =Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "SignUp",
            color = Color.Blue,
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
            text = "Login",
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top=20.dp)
                .clickable {
                // navController.popBackStack()
                navController.navigate(Screen.LogIn.route){
                    popUpTo(Screen.LogIn.route){
                        inclusive=true
                    }
                }

            })
    }
}

@Preview
@Composable
fun SignUpPreview() {
    SignUpScreen(navController = rememberNavController())
}