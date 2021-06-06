package com.capstone.foodcalories.model.local

import com.capstone.foodcalories.data.Food

object FoodData {
    fun generateFoodData():ArrayList<Food>{
        val foods = ArrayList<Food>()
        foods.add(
            Food(1,
                "ice_cream",
                "http://colorfulkitchentales.com/wp-content/uploads/2019/06/DSC_2248-e1573390105291.jpg",
                208
            )
        )

        foods.add(
            Food(2,
                "chicken_wings",
                "https://graphics8.nytimes.com/images/2016/02/09/dining/09COOKING_CHICKENWINGS2/09COOKING_CHICKENWINGS2-superJumbo.jpg",
                220
            )
        )

        foods.add(
            Food(3,
            "spaghetti",
            "https://www.fortatkinsonclub.org/wp-content/uploads/2019/08/Spaghetti_landscape-scaled.jpg",
            157)
        )

        foods.add(
            Food(4,
                "caesar_salad",
                "",
                44)
        )

        foods.add(
            Food(5,
                "club_sandwich",
                    "",
                221)
        )

        foods.add(
            Food(6,
                "cup_cakes",
                "",
                305)
        )

        foods.add(
            Food(7,
                "donuts",
                "",
                452)
        )

        foods.add(
            Food(8,
                "dumplings",
                "",
                112)
        )

        foods.add(
            Food(9,
                "french_fries",
                "",
                165)
        )

        foods.add(
            Food(10,
                "fried_rice",
                "",
                163)
        )

        foods.add(
            Food(11,
                "hamburger",
                "",
                294)
        )

        foods.add(
            Food(12,
                "omelette",
                "",
                154)
        )

        foods.add(
            Food(13,
                "pizza",
                "",
                266)
        )

        foods.add(
            Food(14,
                "spring_rolls",
                "",
                153)
        )

        foods.add(
            Food(15,
                "pancakes",
                "",
                227)
        )

        foods.add(
            Food(16,
                "steak",
                "",
                271)
        )

        foods.add(
            Food(17,
                "sushi",
                "",
                143)
        )

        foods.add(
            Food(18,
                "takoyaki",
                "",
                175)
        )

        foods.add(
            Food(19,
                "waffles",
                "",
                291)
        )

        foods.add(
            Food(20,
                "onion_rings",
                "",
                411)
        )
        return foods
    }
}