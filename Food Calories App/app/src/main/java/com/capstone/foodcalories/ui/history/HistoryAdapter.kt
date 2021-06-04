package com.capstone.foodcalories.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.capstone.foodcalories.data.Food
import com.capstone.foodcalories.databinding.HistoryRowBinding

class HistoryAdapter(private val listFood: HistoryFragment) :
    RecyclerView.Adapter<HistoryAdapter.ListViewHolder>() {
    private val items = ArrayList<Food>()

    fun setItems(items: Food) {
        this.items.clear()
        this.items.addAll(listOf(items))
    }

    inner class ListViewHolder(private val binding: HistoryRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Food) {
            with(binding) {
                foodName.text = food.name
                calorie.text = food.calorie.toString()
                calorieTarget.text = food.calorieTarget.toString()

                //Glide.with(itemView)
                //    .load(food.image)
                //    .into(latest)


                if(food.calorieTarget != 0) {

                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HistoryAdapter.ListViewHolder {
        val binding: HistoryRowBinding =
            HistoryRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryAdapter.ListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}