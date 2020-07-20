package com.android.webmart.ui.foodmenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.webmart.data.model.Food
import com.android.webmart.databinding.ActivityFoodMenuBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FoodMenuActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: FoodMenuViewModel

    private lateinit var binding: ActivityFoodMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        viewModel.loadHotel("hotel1")
        viewModel.loadFood("hotel1")
    }
}

@BindingAdapter(value = ["foodItems", "viewModel"], requireAll = true)
fun foodItems(
    recyclerView: RecyclerView,
    list: List<Food>,
    viewModel: FoodMenuViewModel
) {
    if (recyclerView.adapter == null) {
        recyclerView.adapter = FoodMenuAdapter(viewModel)
    }

    (recyclerView.adapter as FoodMenuAdapter).apply {
        submitList(list)
    }
}