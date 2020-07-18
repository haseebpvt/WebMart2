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
import com.android.webmart.data.model.Hotel
import com.android.webmart.databinding.ItemHotelViewBinding

class HotelAdapter(private val viewModel: HomeViewModel) :
    ListAdapter<Hotel, HotelViewModel>(HotelDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewModel {
        return HotelViewModel(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HotelViewModel, position: Int) {
        holder.bind(viewModel, getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_hotel_view
    }
}

class HotelViewModel(
    private val binding: ItemHotelViewBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: HomeViewModel, hotel: Hotel) {
        binding.viewmodel = viewModel
        binding.setVariable(BR.hotel, hotel)
        binding.executePendingBindings()
    }
}

class HotelDiffUtil : DiffUtil.ItemCallback<Hotel>() {
    override fun areItemsTheSame(oldItem: Hotel, newItem: Hotel): Boolean {
        return oldItem.title == newItem.title &&
                oldItem.image == newItem.image &&
                oldItem.hotelId == newItem.hotelId &&
                oldItem.rating == newItem.rating
    }

    override fun areContentsTheSame(oldItem: Hotel, newItem: Hotel): Boolean {
        return oldItem == newItem
    }
}
