package k.example.lazycolume

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import k.example.lazycolume.model.Person
import k.example.lazycolume.ui.theme.Typography

@Composable
fun CustomerItem(person :Person){
    Row (
        modifier= Modifier
            .background(Color.LightGray)
            .fillMaxSize()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
        ){
        Text(
            text = "${person.age}",
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = person.firstName,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = person.lastName,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun ItemPreview(){
    CustomerItem(person = Person(1,"ka","ng",2))
}