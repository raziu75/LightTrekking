package com.github.raziu75.lighttrekking.ui.composables.cards

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.raziu75.lighttrekking.model.CategoryItem
import com.github.raziu75.lighttrekking.vm.ItemViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FoodItemCard(onClick : () -> Unit, vm: ItemViewModel) {
    val itemState = vm.uiState.collectAsState()
    Card(
        modifier = Modifier
            .height(150.dp)
            .width(150.dp),
        elevation = 20.dp,
        shape = MaterialTheme.shapes.medium,
        backgroundColor = Color(0xFF03DAC5),
        onClick = { onClick() }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Nourriture",
                modifier = Modifier.align(Alignment.Center)
            )
            Text(
                text = "Poids total: ${itemState.value.categoryTotalWeight[CategoryItem.FOOD] ?: 0.0} kg",
                modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 8.dp)
            )
        }
    }
}