package com.aditya.projectdummysecond

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aditya.projectdummysecond.adapter.AdapterProducts
import com.aditya.projectdummysecond.databinding.ActivityMainBinding
import com.aditya.projectdummysecond.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: AdapterProducts
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAdapter = AdapterProducts(
            onclik = { products ->
                Intent( this@MainActivity, ActivityDetail::class.java).also {
                    it.putExtra("id", products.id)
                    it.putExtra("title", products.title)
                    it.putExtra("description", products.description)
                    it.putExtra("price", products.price)
                    it.putExtra("discountPercentage", products.discountPercentage)
                    it.putExtra("rating", products.rating)
                    it.putExtra("stock", products.stock)
                    it.putExtra("brand", products.brand)
                    it.putExtra("category", products.category)
                    it.putExtra("thumbnail", products.thumbnail)
                    startActivity(it)
                }
            }

        )

        viewModel = ViewModelProvider(
            this@MainActivity, ViewModelProvider.NewInstanceFactory()
        )[MainViewModel::class.java]

        getData()
    }
    private fun getData() {
        viewModel.products.observe(this@MainActivity) { listProducts ->
            mAdapter.submitList(listProducts.products)
            binding.recyclerProduk.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
                setHasFixedSize(true)
            }
        }
    }
}
