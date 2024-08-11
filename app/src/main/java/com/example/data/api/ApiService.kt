package com.example.data.api

import com.example.data.model.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("plp")
    suspend fun fetchProducts(
        @Query("search-string") searchString: String,
        @Query("page-number") pageNumber: Int
    ): ProductResponse
}


