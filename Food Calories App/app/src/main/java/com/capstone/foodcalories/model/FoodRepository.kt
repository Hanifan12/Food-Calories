package com.capstone.foodcalories.model

import android.app.Application
import androidx.lifecycle.LiveData
import com.capstone.foodcalories.data.FoodHistory
import com.capstone.foodcalories.model.room.HistoryDao
import com.capstone.foodcalories.model.room.HistoryDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FoodRepository(application: Application) {
    private val mHistoryDao: HistoryDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()
    init {
        val db = HistoryDatabase.getInstance(application)
        mHistoryDao = db.historyDao()
    }
    fun getHistory(): LiveData<List<FoodHistory>> = mHistoryDao.getHistory()

    fun insert(foodHistory: FoodHistory) {
        executorService.execute { mHistoryDao.insertHistory(foodHistory) }
    }

    fun delete(foodHistory: FoodHistory) {
        executorService.execute { mHistoryDao.delete(foodHistory) }
    }

    fun update(foodHistory: FoodHistory) {
        executorService.execute { mHistoryDao.updateHistory(foodHistory) }
    }
}