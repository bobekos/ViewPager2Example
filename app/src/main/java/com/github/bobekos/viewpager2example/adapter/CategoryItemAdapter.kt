package com.github.bobekos.viewpager2example.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.bobekos.viewpager2example.databinding.ItemCategoryBinding
import com.github.bobekos.viewpager2example.model.CategoryItem


class CategoryItemAdapter(private val onItemClick: (item: CategoryItem) -> Unit) :
    ListAdapter<CategoryItem, CategoryItemAdapter.CategoryItemViewHolder>(object :
        DiffUtil.ItemCallback<CategoryItem>() {
        override fun areItemsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
            return oldItem == newItem
        }
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder =
        CategoryItemViewHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            onItemClick
        )

    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) =
        holder.bind(getItem(position))

    class CategoryItemViewHolder(
        private val binding: ItemCategoryBinding,
        private val onItemClick: (item: CategoryItem) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CategoryItem) = with(binding) {
            title.text = item.name
            desc.text = item.desc
            root.setOnClickListener {
                onItemClick(item)
            }
        }
    }
}