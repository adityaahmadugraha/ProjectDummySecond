package com.aditya.projectdummysecond

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aditya.projectdummysecond.adapter.AdapterProducts
import com.aditya.projectdummysecond.data.ProductResponse
import com.aditya.projectdummysecond.databinding.ActivityMainBinding
import com.aditya.projectdummysecond.viewmodel.MainViewModel
import retrofit2.Call
import java.security.AllPermission

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: AdapterProducts
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAdapter = AdapterProducts()

        viewModel = ViewModelProvider(
            this@MainActivity, ViewModelProvider.NewInstanceFactory()
        )[MainViewModel::class.java]
        getData()

    }
    private fun getData() {
        viewModel.products.observe(this@MainActivity) { listProducts ->
            mAdapter.submitList(listProducts.products)
            binding.rvProdcts.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
                setHasFixedSize(true)
            }
        }
    }
}
