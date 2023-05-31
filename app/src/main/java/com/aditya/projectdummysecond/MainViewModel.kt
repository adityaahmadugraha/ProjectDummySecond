package com.aditya.projectdummysecond

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aditya.projectdummysecond.api.ApiConfig
import com.aditya.projectdummysecond.data.Products
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val _products = MutableLiveData<List<Products>>()
    val products: LiveData<List<Products>> = _products


    init {
        getProducts()
    }

    fun getProducts() {

        val client = ApiConfig.getApiService().getProducts()
        client.enqueue(object : retrofit2.Callback<List<Products>> {
            override fun onResponse(call: Call<List<Products>>, response: Response<List<Products>>) {
                if (response.isSuccessful) {

                    val responseBody = response.body()
                    if (responseBody != null) {
                        _products.value = responseBody
                    }
                }
            }

            override fun onFailure(call: Call<List<Products>>, t: Throwable) {
                Log.d("Respons::::::::", t.message.toString())
            }
        })
    }

}

private fun <T> Call<T>.enqueue(callback: Callback<List<Products>>) {


}
