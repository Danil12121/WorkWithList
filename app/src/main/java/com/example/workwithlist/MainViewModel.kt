package com.example.workwithlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var itemCount by mutableIntStateOf(0)

    fun addItem() {
        itemCount++
    }
}