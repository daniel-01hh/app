package com.example.data.model

data class ProductResponse(
    val status: Status,
    val plpResults: PlpResults
)

data class Status(
    val statusCode: Int
)

data class PlpResults(
    val records: List<Product>
)

