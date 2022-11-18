package k.example.textfields

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import k.example.textfields.ui.theme.TextFieldsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {


   Column(modifier = Modifier.fillMaxSize(),
   verticalArrangement = Arrangement.Center,
   horizontalAlignment = Alignment.CenterHorizontally ) {

       var text by remember { mutableStateOf("") }
       val maxChar=10

       OutlinedTextField(
           value =text,
           onValueChange = {newText->
               run {
                   if (newText.length<maxChar)// set count limit
                   text = newText
               }
       }, label = {
           Text(text = "Name")
       }, placeholder = { Text(text = "Type here..")},
           singleLine = true,
           leadingIcon = {
               IconButton(onClick = { /*TODO*/ }) {
                   Icon(imageVector = Icons.Filled.Email, contentDescription = "Email")
               }
           },

           trailingIcon = {
               IconButton(onClick = { /*TODO*/ }) {
                   Icon(imageVector = Icons.Filled.Check, contentDescription = "Check")
               }
           },

           keyboardOptions = KeyboardOptions(
               keyboardType = KeyboardType.Email,
               imeAction = ImeAction.Go
           ),
           keyboardActions = KeyboardActions (
               onSearch = {

               }
           )
       )
   }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextFieldsTheme {
        Greeting()
    }
}