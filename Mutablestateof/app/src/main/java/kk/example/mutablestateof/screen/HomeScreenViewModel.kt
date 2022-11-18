package kk.example.mutablestateof.screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class HomeScreenViewModel :ViewModel(){
    private val _elements = mutableStateListOf<Int>()
    val elements:List<Int> = _elements

    fun addElement() {
        val randomNumber = Random.nextInt(from = 1, until = 100)
        _elements.add(randomNumber)
        Log.d(  "HomeViewModel",  "Added Number: ${_elements.last()}")
    }
}