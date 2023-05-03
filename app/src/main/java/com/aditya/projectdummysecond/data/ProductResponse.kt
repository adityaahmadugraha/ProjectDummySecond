package com.aditya.projectdummysecond.data

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @field:SerializedName("products")
    val products: List<Products>
)
