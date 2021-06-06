package com.capstone.foodcalories.data

import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.PropertyName

@IgnoreExtraProperties
data class FoodHistory(
    @PropertyName("id")
    var id: String? = null,
    @PropertyName("name")
    var name: String? = null,
    @PropertyName("calories")
    var calories: String? = null,
    @PropertyName("userId")
    val userId:String? = null,
    @PropertyName("date")
    var date :String? =null,
    var foodImage: Int? = null,
    var calorieTarget :String? =null
    )