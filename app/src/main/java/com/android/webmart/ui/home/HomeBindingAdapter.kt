package com.android.webmart.ui.home

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.webmart.data.model.Category
import com.android.webmart.util.SpaceItemDecoration
import com.android.webmart.util.convertDpToPixel


@BindingAdapter("categoryItems")
fun categoryItems(recyclerView: RecyclerView, list: List<Category>) {
    list ?: return

    if (recyclerView.adapter == null) {
        recyclerView.adapter = CategoryAdapter()
    }

    (recyclerView.adapter as CategoryAdapter).apply {
        submitList(list)
    }
}

@BindingAdapter("customGridSpacing")
fun gridRecyclerViewSpacing(
    view: RecyclerView,
    space: Int
) {
    val spaceInPixel = convertDpToPixel(space)
    view.addItemDecoration(SpaceItemDecoration(3, spaceInPixel, true))
}