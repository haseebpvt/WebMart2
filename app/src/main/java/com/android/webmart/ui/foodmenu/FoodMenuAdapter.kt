package com.android.webmart.ui.foodmenu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.webmart.BR
import com.android.webmart.R
import com.android.webmart.data.model.Food
import com.android.webmart.databinding.ItemFoodViewBinding

class FoodMenuAdapter(private val viewModel: FoodMenuViewModel) :
    ListAdapter<Food, FoodMenuViewHolder>(FoodDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodMenuViewHolder {
        return FoodMenuViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FoodMenuViewHolder, position: Int) {
        holder.bind(viewModel, getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_food_view
    }
}

class FoodMenuViewHolder(
    private val binding: ItemFoodViewBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: FoodMenuViewModel, food: Food) {
        binding.viewmodel = viewModel
        binding.setVariable(BR.food, food)
        binding.executePendingBindings()
    }
}

class FoodDiffUtil : DiffUtil.ItemCallback<Food>() {
    override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
        return oldItem.title == newItem.title &&
                oldItem.image == newItem.image &&
                oldItem.actualPrice == newItem.actualPrice &&
                oldItem.offerPrice == newItem.offerPrice
    }

    override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
        return oldItem == newItem
    }
}
