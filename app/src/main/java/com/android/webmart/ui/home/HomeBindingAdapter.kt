package com.android.webmart.ui.home

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.webmart.data.model.Category
import com.android.webmart.data.model.Hotel
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

@BindingAdapter(value = ["hotelItems", "viewModel"], requireAll = true)
fun hotelItems(
    recyclerView: RecyclerView,
    list: List<Hotel>,
    viewModel: HomeViewModel
) {
    if (recyclerView.adapter == null) {
        recyclerView.adapter = HotelAdapter(viewModel)
    }

    (recyclerView.adapter as HotelAdapter).apply {
        submitList(list)
    }
}