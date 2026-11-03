package com.example.workwithlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource

@Composable
fun ListScreen(
    items: List<Int>,
    onAddClick: () -> Unit,
    onItemClick: (Int) -> Unit
) {
    val columnsCount = integerResource(id = R.integer.columns_count)
    val itemSpacing = dimensionResource(id = R.dimen.item_spacing)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(columnsCount),
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(itemSpacing),
            verticalArrangement = Arrangement.spacedBy(itemSpacing),
        ) {
            items(items) { number ->
                ListItem(
                    number = number,
                    onClick = { onItemClick(number) }
                )
            }
        }
        Spacer(modifier = Modifier.height(itemSpacing))
        Button(
            onClick = onAddClick,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            Text(text = stringResource(id = R.string.add_button_text))
        }
    }
}