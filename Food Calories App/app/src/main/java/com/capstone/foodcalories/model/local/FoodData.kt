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
                208,
                "Ice Cream"
            )
        )

        foods.add(
            Food(2,
                "chicken_wings",
                R.drawable.wings,
                220,
                "Chicken Wings"

            )
        )

        foods.add(
            Food(3,
            "spaghetti",
            R.drawable.spaghetti,
            157,
                "Spaghetti"
            )
        )

        foods.add(
            Food(4,
                "caesar_salad",
                R.drawable.caesar_salad,
                44,
                "Caesar Salad"
            )
        )

        foods.add(
            Food(5,
                "club_sandwich",
                R.drawable.sandwich,
                221,
                "Sandwich"
            )
        )

        foods.add(
            Food(6,
                "cup_cakes",
                R.drawable.cup_cakes,
                305,
                "Cup Cakes"
            )
        )

        foods.add(
            Food(7,
                "donuts",
                R.drawable.donuts,
                452,
                "Donuts"
            )
        )

        foods.add(
            Food(8,
                "dumplings",
                R.drawable.dumplings,
                112,
                "Dumplings"
            )
        )

        foods.add(
            Food(9,
                "french_fries",
                R.drawable.french_fry,
                165,
            "French Fries"
            )
        )

        foods.add(
            Food(10,
                "fried_rice",
                R.drawable.fried_rice,
                163,
                "Fried Rice"
            )
        )

        foods.add(
            Food(11,
                "hamburger",
                R.drawable.hamburger,
                294,
                "Hamburger"
            )
        )

        foods.add(
            Food(12,
                "omelette",
                R.drawable.omelette,
                154,
                "Omelette"
            )
        )

        foods.add(
            Food(13,
                "pizza",
                R.drawable.pizza,
                266,
                "Pizza"
            )
        )

        foods.add(
            Food(14,
                "spring_rolls",
                R.drawable.spring_rolls,
                153,
                "Spring Rolls"
            )
        )

        foods.add(
            Food(15,
                "pancakes",
                R.drawable.pancakes,
                227,
                "Pancakes"
            )
        )

        foods.add(
            Food(16,
                "steak",
                R.drawable.steak,
                271,
                "Steak"
            )
        )

        foods.add(
            Food(17,
                "sushi",
                R.drawable.sushi,
                143,
                "Sushi"
            )
        )

        foods.add(
            Food(18,
                "takoyaki",
                R.drawable.takoyaki,
                175,
                "Takoyaki"
            )
        )

        foods.add(
            Food(19,
                "waffles",
                R.drawable.waffles,
                291,
                "Waffles"
            )
        )

        foods.add(
            Food(20,
                "onion_rings",
                R.drawable.onion_rings,
                411,
            "Onion Rings"
            )
        )
        return foods
    }
}