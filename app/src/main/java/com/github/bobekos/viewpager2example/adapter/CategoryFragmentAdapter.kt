package com.github.bobekos.viewpager2example.adapter

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.github.bobekos.viewpager2example.fragment.CategoryListFragment
import com.github.bobekos.viewpager2example.model.Category


class CategoryFragmentAdapter(items: List<Category>, activity: FragmentActivity) :
    FragmentStateAdapter(activity) {

    private val fragments = items.map {
        CategoryListFragment.getInstance(it.name)
    }

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int) = fragments[position]

}