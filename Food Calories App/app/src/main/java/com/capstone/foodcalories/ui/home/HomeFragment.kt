package com.capstone.foodcalories.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.capstone.foodcalories.data.Food
import com.capstone.foodcalories.data.FoodHistory
import com.capstone.foodcalories.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var database: FirebaseDatabase
    private lateinit var myRef: DatabaseReference

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var link = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        database = FirebaseDatabase.getInstance()
        myRef = database.getReference("FoodHistory")
        myRef = database.reference

    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val hasil = arguments?.getString("hasil")
        if (hasil == null) {
            binding.latestFoodTitle.text = "Food"
        } else {
            binding.latestFoodTitle.text = "$hasil"

        }

        homeViewModel.dataItem.observe(viewLifecycleOwner, { news ->
            binding.articleTitle.text = news[0].title
            Glide.with(this)
                .load(news[0].image.large)
                .into(binding.articleImage)
            binding.articleFrom.text = "CNN Indonesia"
            link = news[0].link
        })

        binding.imageCard.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(link)
            startActivity(intent)
        }

        setHasOptionsMenu(true)

        val food = Food()
        binding.calorieTarget.text = food.calorieTarget.toString()

        return root
    }
}