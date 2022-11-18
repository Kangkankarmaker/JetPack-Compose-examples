package kk.example.mutablestateof.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(homeScreenViewModel: HomeScreenViewModel= viewModel() ) {

    val element = homeScreenViewModel.elements

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {

        Button(
            onClick = { homeScreenViewModel.addElement() }
        ) {
            Text(text = "Add the number")
        }

        element.forEach{
            Text(
                text ="number $it"

            )
        }
    }

}