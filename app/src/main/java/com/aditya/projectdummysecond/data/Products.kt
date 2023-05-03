package com.aditya.projectdummysecond.data

data class Products(
    val id: Int?,
    val title: String?,
    val description: String?,
    val price: Int?,
    val discountPercentage: Int?,
    val rating: Int?,
    val stock: Int?,
    val brand: String?,
    val category: String?,
    val thumbnail: String?,
    val images: Array<String>?
)
