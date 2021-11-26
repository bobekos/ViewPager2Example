package com.github.bobekos.viewpager2example.repo

import com.github.bobekos.viewpager2example.model.Category
import com.github.bobekos.viewpager2example.model.CategoryItem


object CategoryRepo {

    val items: List<Category> = listOf(
        Category("Pizza", listOf(
            CategoryItem(0, "Chicago Pizza", "some text..-"),
            CategoryItem(1, "New York-Style Pizza", "some text..-"),
            CategoryItem(2, "Sicilian Pizza", "some text..-"),
            CategoryItem(3, "Greek Pizza", "some text..-"),
            CategoryItem(4, "California Pizza", "some text..-"),
            CategoryItem(5, "Detroit Pizza", "some text..-"),
        )),
        Category("Burger", listOf(
            CategoryItem(0, "Beef Burgers", "some text..-"),
            CategoryItem(1, "Elk Burgers", "some text..-"),
            CategoryItem(2, "Portobello Mushroom Burgers", "some text..-"),
            CategoryItem(3, "Turkey Burgers", "some text..-"),
            CategoryItem(4, "Veggie Burgers", "some text..-"),
            CategoryItem(5, "Bison Burgers", "some text..-"),
        )),
        Category("Pasta", listOf(
            CategoryItem(0, "Lasagne", "some text..-"),
            CategoryItem(1, "Pizzoccherri", "some text..-"),
            CategoryItem(2, "Bigoli", "some text..-"),
            CategoryItem(3, "Tortellini", "some text..-"),
            CategoryItem(4, "Farfalle", "some text..-"),
        )),
    )

    fun getItemsByCategory(name: String) = items.find { it.name == name }
}