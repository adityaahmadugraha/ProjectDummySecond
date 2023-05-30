package com.aditya.projectdummysecond.api

import com.aditya.projectdummysecond.data.ProductResponse
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("products")
    fun getProducts(): Call<ProductResponse>
}

