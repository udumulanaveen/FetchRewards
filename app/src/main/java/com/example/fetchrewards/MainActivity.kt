package com.example.fetchrewards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fetchrewards.DataModel.Item
import com.example.fetchrewards.ViewModel.itemViewModel
import com.example.fetchrewards.ui.theme.FetchRewardsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FetchRewardsTheme {
                val itemViewModel = viewModel<itemViewModel>()
                val items by itemViewModel.items.collectAsState() // Observe items

                ItemListScreen(items)

            }
        }
    }
}

@Composable
fun ItemListScreen(items: List<Item>) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        // Display the list using LazyColumn
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            items(items) { item ->
                ItemRow(item = item)
            }
        }
    }
}

@Composable
fun ItemRow(item: Item) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(text = "List ID: ${item.listId}", style = MaterialTheme.typography.subtitle1)
        Text(text = item.name ?: "Unnamed", style = MaterialTheme.typography.body1)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FetchRewardsTheme {
        // Sample preview
        ItemListScreen(
            listOf(
                Item(1, 1, "Item 1"),
                Item(2, 1, "Item 2"),
                Item(3, 2, "Item 3")
            )
        )
    }
}