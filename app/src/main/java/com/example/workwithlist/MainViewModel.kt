package com.example.workwithlist

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.collections.plus

data class MyItems(val items: List<Int> = emptyList(), val deleted: List<Int> = emptyList())
class MainViewModel : ViewModel() {

    private val _myItems = MutableStateFlow(MyItems())
    val myItems: StateFlow<MyItems> = _myItems.asStateFlow()
    fun addItem() {
        if (myItems.value.deleted.isNotEmpty()) {
            _myItems.update {
                it.copy(
                    items = myItems.value.items + myItems.value.deleted.first(),
                    deleted = myItems.value.deleted.drop(1)
                )
            }
        } else {
            _myItems.update { it.copy(items = myItems.value.items + myItems.value.items.size) }
        }
    }

    fun removeItem(item: Int) {
        _myItems.update {
            myItems.value.copy(
                items = myItems.value.items - item,
                deleted = myItems.value.deleted + item
            )
        }
    }
}