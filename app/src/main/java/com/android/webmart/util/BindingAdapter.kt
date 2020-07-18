package com.android.webmart.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

@BindingAdapter("loadImageFromUrl")
fun loadImageFromUrl(imageView: ImageView, link: String) {
    Glide.with(imageView).load(link).into(imageView)
}