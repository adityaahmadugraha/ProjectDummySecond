package com.aditya.projectdummysecond.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aditya.projectdummysecond.api.ApiConfig
import com.aditya.projectdummysecond.data.ProductResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel : ViewModel() {
    private val _products = MutableLiveData<ProductResponse>()
    val products: LiveData<ProductResponse> = _products

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        getProducts()
    }

    private fun getProducts() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getProducts()
        client.enqueue(object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if (response.isSuccessful) {
                    _isLoading.value = false
                    val responseBody = response.body()
                    if (responseBody != null) {
                        _products.value = responseBody
                    }
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
               _isLoading.value = false
                Log.d("Respons::::::::", t.message.toString())
            }
        })
    }
}
