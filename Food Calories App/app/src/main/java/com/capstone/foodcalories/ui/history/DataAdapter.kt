package com.capstone.foodcalories.ui.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capstone.foodcalories.R
import com.capstone.foodcalories.databinding.HistoryRowBinding
import com.capstone.foodcalories.ui.db.DatabaseModel

class DataAdapter(var list : ArrayList<DatabaseModel>): RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    private lateinit var binding: HistoryRowBinding

    class ViewHolder(binding: HistoryRowBinding) : RecyclerView.ViewHolder(binding.root) {
        val foodName = binding.tvFoodName
        val foodCalorie = binding.calorie
        val calorieTarget = binding.tvCalorieTarget
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: HistoryRowBinding =
            HistoryRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.foodName.text = list[position].foodName
        holder.foodCalorie.text = list[position].foodName
        holder.calorieTarget.text = list[position].foodName
    }

    override fun getItemCount(): Int {
        return list.size
    }

}