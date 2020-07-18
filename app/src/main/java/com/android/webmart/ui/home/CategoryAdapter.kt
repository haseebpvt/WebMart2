package com.android.webmart.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.webmart.BR
import com.android.webmart.R
import com.android.webmart.data.model.Category

class CategoryAdapter(
    private val eventListener: HomeEventListener
) : ListAdapter<Category, CategoryViewHolder>(CategoryDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                viewType,
                parent,
                false
            ),
            eventListener
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_home_category
    }
}

class CategoryViewHolder(
    private val binding: ViewDataBinding,
    private val eventListener: HomeEventListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(category: Category) {
        binding.setVariable(BR.category, category)
        binding.executePendingBindings()
    }
}

object CategoryDiffUtil : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.title == newItem.title &&
                oldItem.image == newItem.image
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }

}
