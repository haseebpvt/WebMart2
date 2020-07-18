package com.android.webmart.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

@BindingAdapter("loadImageFromUrl")
fun loadImageFromUrl(imageView: ImageView, link: String) {
    Glide.with(imageView).load(link).into(imageView)
}

@BindingAdapter("customGridSpacing")
fun gridRecyclerViewSpacing(
    view: RecyclerView,
    space: Int
) {
    val spaceInPixel = convertDpToPixel(space)
    view.addItemDecoration(SpaceItemDecoration(3, spaceInPixel, true))
}