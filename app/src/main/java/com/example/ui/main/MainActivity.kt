package com.example.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ui.viewmodel.ProductViewModel
import com.example.busquedaproductos.R

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private lateinit var viewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        productAdapter = ProductAdapter()
        recyclerView.adapter = productAdapter

        viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        viewModel.products.observe(this) { products ->
            productAdapter.submitList(products)
        }

        viewModel.fetchProducts()
    }
}




