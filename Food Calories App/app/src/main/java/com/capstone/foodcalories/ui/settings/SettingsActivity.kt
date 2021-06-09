package com.capstone.foodcalories.ui.settings

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import com.capstone.foodcalories.R
import android.content.SharedPreferences
import android.util.Log
import androidx.preference.Preference
import androidx.preference.PreferenceManager
import com.capstone.foodcalories.data.Food

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.settings)

    }

    class SettingsFragment : PreferenceFragmentCompat(),
        SharedPreferences.OnSharedPreferenceChangeListener,
        PreferenceManager.OnPreferenceTreeClickListener {
        private var mContext: Context? = null
        private lateinit var food: Food

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val sp = PreferenceManager.getDefaultSharedPreferences(requireContext())
            sp.registerOnSharedPreferenceChangeListener(this)

            preferenceManager.sharedPreferencesName = "calorieTarget"
        }

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
        }

        override fun onSharedPreferenceChanged(
            sharedPreferences: SharedPreferences?,
            key: String?
        ) {
            if (key.equals("calorieTarget")) {
                val pref: Preference? = this.findPreference(key!!)
                pref?.summary = sharedPreferences!!.getString(key, 0.toString())
                setCalorieTarget(pref?.summary as String)

            }
        }

        private fun setCalorieTarget(calorieTarget: String) {
            val food = Food(calorieTarget = 0)
            val ct = calorieTarget.toInt()
        }
    }
}