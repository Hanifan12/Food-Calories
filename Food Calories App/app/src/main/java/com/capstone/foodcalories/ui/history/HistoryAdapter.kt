package com.capstone.foodcalories.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capstone.foodcalories.data.FoodHistory
import com.capstone.foodcalories.databinding.HistoryRowBinding

class HistoryAdapter(private var list: ArrayList<FoodHistory>) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    private lateinit var binding: HistoryRowBinding

    class ViewHolder(binding: HistoryRowBinding) : RecyclerView.ViewHolder(binding.root) {
        val foodName = binding.tvFoodName
        val foodCalorie = binding.tvCalorie
        val date = binding.date
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: HistoryRowBinding =
            HistoryRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.foodName.text = list[position].name
        holder.foodCalorie.text = list[position].calories
        holder.date.text = list[position].date

    }

    override fun getItemCount(): Int {
        return list.size
    }
}