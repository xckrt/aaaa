package com.example.prakt2.ui.dashboard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prakt2.adapters.ProductAdapter
import com.example.prakt2.databinding.FragmentProductsBinding
import com.example.prakt2.models.Product

class ProductsFragment : Fragment() {

    private lateinit var binding: FragmentProductsBinding
    private lateinit var context:Context
    private lateinit var adapter: ProductAdapter
    private lateinit var products:List<Product>
    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        products = listOf(
            Product(1,"Вадим"),
            Product(2,"Артур"),
            Product(3,"Глеб"),
            Product(4,"Рома"),
            Product(5,"Андрей"),
            Product(6,"Айнур"),
            Product(7,"Петя"))

        binding = FragmentProductsBinding.inflate(inflater, container, false)
        context = this.requireContext()
        adapter = ProductAdapter.create(context)
        adapter.refreshProducts(products)

        binding.rvProducts.layoutManager = LinearLayoutManager(context)


        binding.rvProducts.adapter = adapter

        return binding.root
    }
}
