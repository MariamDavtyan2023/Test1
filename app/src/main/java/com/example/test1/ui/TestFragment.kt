package com.example.test1.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test1.databinding.FragmentTestBinding
import com.example.test1.ui.base.BaseTestFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class TestFragment : BaseTestFragment() {

    private lateinit var binding: FragmentTestBinding
    private val adapter = TestAdapter()
    private val viewModel: TestViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getProducts()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupObserves()
    }

    private fun setupViews() {
        binding.recyclerViewProducts.apply {
            adapter = this@TestFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setupObserves() {
        lifecycleScope.launch {
            viewModel.productStateFlow.collectLatest {
                Log.d("TestFragment", it.size.toString())
                adapter.updateData(it)
            }
        }
    }

}