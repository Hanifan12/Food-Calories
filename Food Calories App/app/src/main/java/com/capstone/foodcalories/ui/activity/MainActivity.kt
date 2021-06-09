package com.capstone.foodcalories.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.capstone.foodcalories.R
import com.capstone.foodcalories.data.FoodHistory
import com.capstone.foodcalories.databinding.ActivityMainBinding
import com.capstone.foodcalories.model.local.FoodData
import com.capstone.foodcalories.ui.settings.SettingsActivity
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.database.FirebaseDatabase
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_FOOD = "extra"
    }

    private lateinit var binding: ActivityMainBinding
    private var calories = ""
    private var image = 0

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("FoodHistory")
        val navView: BottomNavigationView = binding.navView
        val localData = FoodData.generateFoodData()

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_add, R.id.navigation_history
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        var makanan = intent.getStringExtra(EXTRA_FOOD)

        if(makanan == "extra" || makanan == null  || makanan =="""""" || makanan ==""){
            Log.e("MainActivity","Gagal Load Data makanan dan calories")
        }else{
            val data = FoodData.generateFoodData()
            for(i in 0..data.lastIndex){
                if(data[i].name == makanan){
                    calories = data[i].calorie.toString()
                    break
                }
            }
            val currentUser = FirebaseAuth.getInstance().currentUser!!.uid.trim()
            val current = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                LocalDateTime.now()
            } else {
                TODO("VERSION.SDK_INT < O")
            }
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
            val timeFormat = current.format(formatter).toString()
            for(i in 1..localData.lastIndex){
                if(makanan == localData[i].name){
                    makanan = localData[i].realName
                    image = localData[i].image
                }
            }
            val formData = FoodHistory(makanan,calories,image.toString(),timeFormat)
            val foodId = myRef.push().key
                myRef.child(currentUser).child(foodId!!).setValue(formData).addOnCompleteListener {
                    Toast.makeText(
                        this,
                        "Data $makanan Telah Ditambahkan",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        val settings: MenuItem? = menu?.findItem(R.id.btn_settings)
        settings?.setOnMenuItemClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            this.startActivity(intent)
            true
        }

        return super.onCreateOptionsMenu(menu)
    }
}