package com.aditya.projectdummysecond

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aditya.projectdummysecond.adapter.AdapterProducts
import com.aditya.projectdummysecond.databinding.ActivityMainBinding
import com.aditya.projectdummysecond.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: AdapterProducts

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val viewModel = ViewModelProvider(
            this@MainActivity, ViewModelProvider.NewInstanceFactory()
        )[MainViewModel::class.java]

        viewModel.products.observe(this@MainActivity) { listProducts ->
            Log.d("response:::::::::::::::::::::", "onCreate: $listProducts")
            mAdapter.submitList(listProducts)
            binding.rvProdcts.adapter = mAdapter
            binding.rvProdcts.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvProdcts.setHasFixedSize(true)
        }
    }
}