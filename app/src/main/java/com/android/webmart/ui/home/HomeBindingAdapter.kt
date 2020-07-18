package com.android.webmart.ui.home

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.webmart.data.model.Category
import com.android.webmart.util.SpaceItemDecoration
import com.android.webmart.util.convertDpToPixel


@BindingAdapter(value = ["categoryItems", "viewModel"], requireAll = true)
fun categoryItems(
    recyclerView: RecyclerView,
    list: List<Category>,
    viewModel: HomeViewModel
) {
    list ?: return

    if (recyclerView.adapter == null) {
        recyclerView.adapter = CategoryAdapter(viewModel)
    }

    (recyclerView.adapter as CategoryAdapter).apply {
        submitList(list)
    }
}