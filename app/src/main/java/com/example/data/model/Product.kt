package com.example.data.model

data class Product(
    val productId: Long,
    val productDisplayName: String,
    val listPrice: Double,
    val promoPrice: Double,
    val smImage: String,
    val variantsColor: List<Color>
)

data class Color(
    val colorName: String,
    val colorHex: String
)
