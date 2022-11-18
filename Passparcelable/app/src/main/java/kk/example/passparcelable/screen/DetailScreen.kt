package kk.example.passparcelable.screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun DetailScreen(navController: NavHostController,sharedViewModel: SharedViewModel) {

    val person =sharedViewModel.person
     LaunchedEffect(key1 = person ){

                Log.d("clickResult","${person?.firstName}")
                Log.d("clickResult","${person?.lastName}")
            }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable { },
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Detail",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

        )
    }
}

