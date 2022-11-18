package k.example.lazycolume

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import k.example.lazycolume.repositiry.PersonRepository
import k.example.lazycolume.ui.theme.LazyColumeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumeTheme {

                val personRepository=PersonRepository()
                val getAllData=PersonRepository().getAllData()

                LazyColumn(
                    contentPadding = PaddingValues(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ){
                    /*items(items = getAllData){person->
                        CustomerItem(person =person )
                    }*/
                    itemsIndexed(
                        items = getAllData,
                        /*key = {index,person->
                            person.id
                        }*/
                    ){index,person->
                        CustomerItem(person =person )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting() {

}

@Composable
fun Greeting2() {

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LazyColumeTheme {
        Greeting()
    }
}