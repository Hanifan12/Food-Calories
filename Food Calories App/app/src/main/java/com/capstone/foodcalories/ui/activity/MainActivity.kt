package com.capstone.foodcalories.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.capstone.foodcalories.R
import com.capstone.foodcalories.databinding.ActivityMainBinding
import com.capstone.foodcalories.ui.home.HomeFragment
import com.capstone.foodcalories.ui.settings.SettingsActivity

class MainActivity : AppCompatActivity() {

    companion object{
        const val EXTRA =""
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val hasil = intent.getStringExtra(EXTRA)
        if(hasil == ""){
            Log.e("MainActivity","Data Kosong")
        }else{
            val frag = HomeFragment()
            val bundle = Bundle()
            bundle.putString("hasil",hasil)
            frag.arguments = bundle
            supportFragmentManager.beginTransaction()
                .add(R.id.nav_host_fragment_activity_main,frag)
                .commit()
        }

        val navView: BottomNavigationView = binding.navView


        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_add, R.id.navigation_history
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

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