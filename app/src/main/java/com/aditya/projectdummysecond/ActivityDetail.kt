package com.aditya.projectdummysecond

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.aditya.projectdummysecond.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide

class ActivityDetail : AppCompatActivity() {


    companion object {
        const val IMAGE_TAG = "foto"
        const val TITLE_TAG = "title"
        const val DESCRIPTION_TAG = "description"
    }

     private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foto = intent.getStringExtra(IMAGE_TAG)
        val nama = intent.getStringExtra(TITLE_TAG)
        val descripsi = intent.getStringExtra(DESCRIPTION_TAG)
        setViewInformasi(foto, nama, descripsi)

        binding.imgBackdetil.setOnClickListener(){
            val intent = Intent (this@ActivityDetail, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun setViewInformasi(foto: String?, title: String?, description: String?) {
        binding.apply {
            Log.d("Respone:::::::::::", "setViewInformasi: $foto")
            txtTitleDetail.text = title
            txtInformasi.text = description
            Glide.with(this@ActivityDetail)
                .load(foto)
                .error(android.R.color.darker_gray)
                .into(imgProductsDetail)
        }

    }
}