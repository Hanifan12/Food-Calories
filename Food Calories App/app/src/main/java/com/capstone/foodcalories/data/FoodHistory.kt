package com.capstone.foodcalories.data

import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.PropertyName

@IgnoreExtraProperties
data class FoodHistory(
    @PropertyName("name")
    var name: String? = null,
    @PropertyName("calories")
    var calories: String? = null,
    @PropertyName("image")
    var image: String? = null,
    @PropertyName("date")
    var date :String? =null

    )