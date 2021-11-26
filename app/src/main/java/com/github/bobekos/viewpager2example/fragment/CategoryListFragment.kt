package com.github.bobekos.viewpager2example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.github.bobekos.viewpager2example.adapter.CategoryItemAdapter
import com.github.bobekos.viewpager2example.databinding.FragmentCategoryListBinding
import com.github.bobekos.viewpager2example.repo.CategoryRepo


class CategoryListFragment : Fragment() {

    private var binding: FragmentCategoryListBinding? = null

    companion object {
        private const val CATEGORY_ID = "category_id"

        fun getInstance(categoryID: String) = CategoryListFragment().apply {
            arguments = Bundle().apply {
                putString(CATEGORY_ID, categoryID)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryListBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CategoryItemAdapter {
            Toast.makeText(context, "Item ${it.name} clicked", Toast.LENGTH_SHORT).show()
        }
        binding?.root?.adapter = adapter

        val category = CategoryRepo.getItemsByCategory(
            requireArguments().getString(CATEGORY_ID, ""))
        category?.let {
            adapter.submitList(it.items)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}