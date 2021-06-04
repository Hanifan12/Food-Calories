package com.capstone.foodcalories.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.foodcalories.data.Food

class HistoryViewModel : ViewModel() {
    fun getFoodItem(): Food {
        lateinit var food: Food


        return food
    }

    fun setFoodItem(foodId: Int) {

    }
}