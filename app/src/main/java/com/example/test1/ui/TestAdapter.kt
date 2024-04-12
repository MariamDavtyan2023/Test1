package com.example.test1.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test1.databinding.ProductItemBinding

class TestAdapter : RecyclerView.Adapter<TestAdapter.ProductsModelViewHolder>() {

    private val items = mutableListOf<ProductModel>()
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsModelViewHolder {
        return ProductsViewHolder(ProductItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ProductsModelViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(list: List<ProductModel>?){
        items.clear()
        list?.let {
            items.addAll(it)
        }
        notifyDataSetChanged()
    }

    abstract class ProductsModelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: ProductModel)
    }

    inner class ProductsViewHolder(private val binding: ProductItemBinding) : ProductsModelViewHolder(binding.root){
        override fun bind(item: ProductModel) {
            binding.textViewProduct.text = item.name
        }
    }

}