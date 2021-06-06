package com.capstone.foodcalories.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.capstone.foodcalories.data.Food
import com.capstone.foodcalories.data.FoodHistory
import com.capstone.foodcalories.databinding.FragmentHomeBinding
import com.capstone.foodcalories.model.local.FoodData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.DatabaseError

import com.google.firebase.database.DataSnapshot

import com.google.firebase.database.ValueEventListener


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var link = ""
    private var image =""
    private lateinit var list : ArrayList<FoodHistory>


//    private fun getUserData(){
//
//        val database = FirebaseDatabase.getInstance()
//        val myRef = database.getReference("FoodHistory")
//        val userId = FirebaseAuth.getInstance().currentUser!!.uid
//        myRef.child(userId).addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                list = snapshot.getValue(FoodHistory)
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                // Failed to read value
//                Log.w("firebase", "Failed to read value.", error.toException())
//            }
//        })
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        getUserData()
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
//        val foodData = FoodData.generateFoodData()
//        binding.latestFoodTitle.text = name
//        binding.latestFoodCalorie.text = calories
//        for (i in 1..foodData.lastIndex) {
//            if(name == foodData[i].name){
//                image = foodData[i].image
//            }
//        }
//        Glide.with(this)
//            .load(image)
//            .apply(RequestOptions().override(120,240))
//            .into(binding.latestFoodImage)


        homeViewModel.dataItem.observe(viewLifecycleOwner,{news ->
            binding.articleTitle.text = news[0].title
            Glide.with(this)
                .load(news[0].image.large)
                .into(binding.articleImage)
            binding.articleFrom.text="CNN Indonesia"
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