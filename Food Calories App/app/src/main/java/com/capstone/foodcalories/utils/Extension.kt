package com.capstone.foodcalories.utils

import android.app.Activity
import android.widget.Toast

object Extension {
    fun Activity.toast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}