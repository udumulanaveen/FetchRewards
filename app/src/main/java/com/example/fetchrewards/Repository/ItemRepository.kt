package com.example.fetchrewards.Repository

import com.example.fetchrewards.DataModel.Item
import com.example.fetchrewards.Retrofit.RetrofitInstance

class ItemRepository {
    suspend fun getItems(): List<Item> {
        return RetrofitInstance.apiService.getItems()
            .filter { it.name != null && it.name.isNotBlank() }
            .sortedWith(compareBy({ it.listId }, { it.name }))
    }
}
