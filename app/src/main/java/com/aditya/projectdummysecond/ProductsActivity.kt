package com.aditya.projectdummysecond

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aditya.projectdummysecond.databinding.ActivityProductsBinding
import com.bumptech.glide.Glide

class ProductsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val thumbnail = intent.getStringExtra("thumbnail").toString()


        val imgProducts = binding.imgProducts
        Glide.with(this)
            .load(thumbnail)
            .into(imgProducts)

        binding.btnProducts.setOnClickListener {
            val intent = Intent(this@ProductsActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}