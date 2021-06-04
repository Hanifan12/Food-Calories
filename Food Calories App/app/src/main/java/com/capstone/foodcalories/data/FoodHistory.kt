package com.capstone.foodcalories.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "db_foodhistory")
@kotlinx.parcelize.Parcelize
data class FoodHistory(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,
    @ColumnInfo(name = "name")
    var name: String = "",
    @ColumnInfo(name = "calories")
    var calories: Int = 0,
    @ColumnInfo(name = "tanggal")
    var tanggal :String =""
    ):Parcelable
