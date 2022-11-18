package kk.example.passparcelable.screen

import android.app.Person
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController,sharedViewModel: SharedViewModel) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                       val person=kk.example.passparcelable.Person(firstName = "kan", lastName = "gkan")

                sharedViewModel.addPerson(newPerson = person)
                navController.navigate(Screen.Details.route)

                        /*navController.currentBackStackEntry?.savedStateHandle?.set(
                            key = "person",
                            value = person
                )*/

            },
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Home",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

        )
    }
}