package com.github.bobekos.viewpager2example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.bobekos.viewpager2example.adapter.CategoryFragmentAdapter
import com.github.bobekos.viewpager2example.adapter.CategoryItemAdapter
import com.github.bobekos.viewpager2example.databinding.ActivityMainBinding
import com.github.bobekos.viewpager2example.model.Category
import com.github.bobekos.viewpager2example.model.CategoryItem
import com.github.bobekos.viewpager2example.repo.CategoryRepo
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = CategoryRepo.items

        val adapter = CategoryFragmentAdapter(items, this)
        binding.pager.adapter = adapter

        initTabLayout(items)
    }

    private fun initTabLayout(items: List<Category>) {
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = items[position].name
        }.attach()
    }
}