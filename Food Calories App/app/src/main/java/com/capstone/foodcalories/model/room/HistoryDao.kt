package com.capstone.foodcalories.model.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.capstone.foodcalories.data.FoodHistory

@Dao
interface HistoryDao {

    @Query("SELECT * FROM db_foodhistory")
    fun getHistory(): LiveData<List<FoodHistory>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHistory(foods: FoodHistory)

    @Update
    fun updateHistory(food: FoodHistory)

    @Delete
    fun delete(food: FoodHistory)
}