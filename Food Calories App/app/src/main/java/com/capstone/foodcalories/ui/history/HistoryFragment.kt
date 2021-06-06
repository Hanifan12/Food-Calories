package com.capstone.foodcalories.ui.history

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.foodcalories.data.Food
import com.capstone.foodcalories.data.FoodHistory
import com.capstone.foodcalories.databinding.FragmentHistoryBinding
import com.google.firebase.database.*
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.database.FirebaseDatabase

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.DataSnapshot

class HistoryFragment : Fragment() {

    private lateinit var historyViewModel: HistoryViewModel
    private var _binding: FragmentHistoryBinding? = null
    private lateinit var adapter: HistoryAdapter
    private lateinit var food: Food
    private lateinit var database: FirebaseDatabase
    private lateinit var myRef: DatabaseReference

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        historyViewModel =
            ViewModelProvider(this).get(HistoryViewModel::class.java)

        _binding = FragmentHistoryBinding.inflate(inflater, container, false)

        return binding.root

    }

    private fun getData() {
        val user = FirebaseAuth.getInstance().currentUser
        val userUid = user!!.uid

        val myRef = FirebaseDatabase.getInstance().getReference("FoodHistory").child(userUid)

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = ArrayList<FoodHistory>()

                for (data in snapshot.children) {
                    val model = data.getValue(FoodHistory::class.java)
                    list.add(model as FoodHistory)

                    if (model.name == "ice_cream") {
                        model.name = "Ice Cream"
                    }

                    if (model.name == "spaghetti") {
                        model.name = "Spaghetti"
                    }

                    if (model.name == "chicken_wings") {
                        model.name = "Chicken Wings"
                    }

                }

                if (list.size > 0) {
                    val rvHistory = _binding?.rvHistory
                    rvHistory?.layoutManager = LinearLayoutManager(context)
                    val adapter = HistoryAdapter(list)
                    rvHistory?.adapter = adapter

                    _binding?.noData?.visibility = View.INVISIBLE

                } else {
                    _binding?.noData?.visibility = View.VISIBLE
                    _binding?.fabDelete?.visibility = View.INVISIBLE
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("cancel", error.toString())
            }

        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()

        binding.fabDelete.setOnClickListener {
            val user = FirebaseAuth.getInstance().currentUser
            val userUid = user!!.uid
            val myRef = FirebaseDatabase.getInstance().getReference("FoodHistory").child(userUid)

            myRef.removeValue()
            onDestroyView()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}