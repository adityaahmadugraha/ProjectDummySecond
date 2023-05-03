package com.aditya.projectdummysecond.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aditya.projectdummysecond.data.Products
import com.aditya.projectdummysecond.databinding.ItemProductsBinding
import com.bumptech.glide.Glide

class AdapterProducts(

) : ListAdapter<Products, AdapterProducts.ViewHOlder>(DIF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHOlder {
        val binding =
            ItemProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHOlder(binding)

    }

    override fun onBindViewHolder(holder: ViewHOlder, @SuppressLint("RecyclerView") position: Int) {
        holder.bind(getItem(position))

    }

    inner class ViewHOlder(
        private val binding: ItemProductsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Products) {
            binding.txtProducts.text = data.description.toString()
            Glide.with(itemView.context)
                .load(data.thumbnail)
                .error(android.R.color.darker_gray)
                .into(binding.imgProducts)
            binding.txtTitle.text = data.title.toString()
            binding.cardView.setOnClickListener {

            }
        }
    }


    companion object {
        val DIF_CALLBACK: DiffUtil.ItemCallback<Products> =
            object : DiffUtil.ItemCallback<Products>() {
                override fun areItemsTheSame(oldItem: Products, newItem: Products): Boolean {
                    return oldItem.id == newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(oldItem: Products, newItem: Products): Boolean {
                    return oldItem == newItem
                }

            }
    }
}
