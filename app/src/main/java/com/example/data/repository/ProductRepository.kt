package com.example.data.repository

import com.example.data.api.RetrofitClient
import com.example.data.model.ProductResponse

class ProductRepository {

    private val apiService = RetrofitClient.apiService

    suspend fun fetchProducts(searchString: String, pageNumber: Int): ProductResponse {
        return apiService.fetchProducts(searchString, pageNumber)
    }
}
