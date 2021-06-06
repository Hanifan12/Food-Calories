package com.capstone.foodcalories.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.foodcalories.api.RetrofitConfig
import com.capstone.foodcalories.model.remote.DataItem
import com.capstone.foodcalories.model.remote.Image
import com.capstone.foodcalories.model.remote.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _dataItem = MutableLiveData<List<DataItem>>()
    val dataItem: LiveData<List<DataItem>> = _dataItem

    private val _image = MutableLiveData<Image>()
    val image:LiveData<Image> = _image

    companion object{
        private const val TAG = "HomeViewModel"
        private const val type ="gaya-hidup"
    }

    init{
        getDataFromAPI()
    }

    private fun getDataFromAPI(){
        _isLoading.value = true
        val client = RetrofitConfig.create().getNewsCCNType(type)
        client.enqueue(object: Callback<NewsResponse>{
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                _isLoading.value = false
                if(response.isSuccessful){
                    _dataItem.value = response.body()?.data
                }else{
                    Log.e(TAG,"onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    private fun getCalories() {

    }
}
