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

        foods.add(
            Food(4,
                "caesar_salad",
                R.drawable.spaghetti,
                44)
        )

        foods.add(
            Food(5,
                "club_sandwich",
                R.drawable.spaghetti,
                221)
        )

        foods.add(
            Food(6,
                "cup_cakes",
                R.drawable.spaghetti,
                305)
        )

        foods.add(
            Food(7,
                "donuts",
                R.drawable.spaghetti,
                452)
        )

        foods.add(
            Food(8,
                "dumplings",
                R.drawable.spaghetti,
                112)
        )

        foods.add(
            Food(9,
                "french_fries",
                R.drawable.spaghetti,
                165)
        )

        foods.add(
            Food(10,
                "fried_rice",
                R.drawable.spaghetti,
                163)
        )

        foods.add(
            Food(11,
                "hamburger",
                R.drawable.spaghetti,
                294)
        )

        foods.add(
            Food(12,
                "omelette",
                R.drawable.spaghetti,
                154)
        )

        foods.add(
            Food(13,
                "pizza",
                R.drawable.spaghetti,
                266)
        )

        foods.add(
            Food(14,
                "spring_rolls",
                R.drawable.spaghetti,
                153)
        )

        foods.add(
            Food(15,
                "pancakes",
                R.drawable.spaghetti,
                227)
        )

        foods.add(
            Food(16,
                "steak",
                R.drawable.spaghetti,
                271)
        )

        foods.add(
            Food(17,
                "sushi",
                R.drawable.spaghetti,
                143)
        )

        foods.add(
            Food(18,
                "takoyaki",
                R.drawable.spaghetti,
                175)
        )

        foods.add(
            Food(19,
                "waffles",
                R.drawable.spaghetti,
                291)
        )

        foods.add(
            Food(20,
                "onion_rings",
                R.drawable.spaghetti,
                411)
        )
        return foods
    }
}