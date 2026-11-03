package com.example.workwithlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val myItems by viewModel.myItems.collectAsState()
            ListScreen(
                items = myItems.items,
                onAddClick = { viewModel.addItem() },
                onItemClick = { item -> viewModel.removeItem(item) }
            )
        }
    }
}