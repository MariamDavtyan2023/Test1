package com.example.test1.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test1.databinding.ProductItemBinding

class TestAdapter : RecyclerView.Adapter<TestAdapter.BaseViewHolder>() {

    private val items = mutableListOf<String>()
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return TestViewHolder(ProductItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(list: List<String>?){
        items.clear()
        list?.let {
            items.addAll(it)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: String)
    }

    inner class TestViewHolder(private val binding: ProductItemBinding) : BaseViewHolder(binding.root){
        override fun bind(item: String) {
            binding.textViewProduct.text = item
        }
    }

}