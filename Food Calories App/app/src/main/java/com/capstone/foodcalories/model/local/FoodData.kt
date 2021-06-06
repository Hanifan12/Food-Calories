package com.capstone.foodcalories.model.local

import com.capstone.foodcalories.R
import com.capstone.foodcalories.data.Food

object FoodData {
    fun generateFoodData():ArrayList<Food>{
        val foods = ArrayList<Food>()
        foods.add(
            Food(1,
                "ice_cream",
                R.drawable.ice_cream,
                208
            )
        )

        foods.add(
            Food(2,
                "chicken_wings",
                R.drawable.wings,
                220

            )
        )

        foods.add(
            Food(3,
            "spaghetti",
            R.drawable.spaghetti,
            157)
        )
        return foods
    }
}