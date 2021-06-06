package com.capstone.foodcalories.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.capstone.foodcalories.data.FoodHistory
import com.capstone.foodcalories.databinding.HistoryRowBinding

class HistoryAdapter(private var list: ArrayList<FoodHistory>) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    private lateinit var binding: HistoryRowBinding
    private lateinit var historyFragment: HistoryFragment

    class ViewHolder(binding: HistoryRowBinding) : RecyclerView.ViewHolder(binding.root) {
        private val binding = HistoryRowBinding.bind(itemView)

        val foodName = binding.tvFoodName
        val foodCalorie = binding.tvCalorie
        val calorieTarget = binding.tvCalorieTarget
        val date = binding.date

        fun bind(food: FoodHistory) {
            Glide.with(itemView)
                .load(food.foodImage)
                .into(binding.foodImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: HistoryRowBinding =
            HistoryRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.foodName.text = list[position].name
        holder.foodCalorie.text = list[position].calories
        holder.calorieTarget.text = list[position].calorieTarget
        holder.date.text = list[position].date

        holder.bind(this.list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}