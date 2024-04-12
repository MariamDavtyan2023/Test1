package com.example.test1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test1.databinding.FragmentTestBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TestFragment : Fragment() {

    private lateinit var binding: FragmentTestBinding
    private val adapter = TestAdapter()
    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[TestViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()

    }

    private fun setupAdapter() {
        binding.recyclerViewProducts.adapter = adapter
        binding.recyclerViewProducts.layoutManager = LinearLayoutManager(requireContext())
        lifecycleScope.launch {
            viewModel.products.collect {
                adapter.updateData(it)
            }
        }
    }

}