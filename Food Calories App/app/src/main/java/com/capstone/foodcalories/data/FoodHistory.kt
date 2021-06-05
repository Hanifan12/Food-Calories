package com.capstone.foodcalories.data

import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.PropertyName


@IgnoreExtraProperties
data class FoodHistory(
    @PropertyName("name")
    val name: String? = null,
    @PropertyName("calories")
    val calories: String? = null,
    @PropertyName("userId")
    val userId:String? = null,
    @PropertyName("date")
    val date :String? =null
    ){

}