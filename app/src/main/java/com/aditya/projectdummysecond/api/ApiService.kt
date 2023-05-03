package com.aditya.projectdummysecond.api

import com.aditya.projectdummysecond.data.DataProducts
import com.aditya.projectdummysecond.data.Products
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiService {
    @GET("products")
    fun getProducts(): Call<List<Products>>

    @GET("products")
    fun getProducts(
        @QueryMap parameter: HashMap<String, String>
    ): Call<List<Products>>


}

