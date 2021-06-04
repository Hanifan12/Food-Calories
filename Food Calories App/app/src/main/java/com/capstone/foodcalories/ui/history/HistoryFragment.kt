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
import com.capstone.foodcalories.databinding.FragmentHistoryBinding
import com.capstone.foodcalories.ui.db.DatabaseModel
import com.google.firebase.database.*

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

        database = FirebaseDatabase.getInstance()
        myRef = database.getReference("Users")
        getData()

    }

    private fun getData() {
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = ArrayList<DatabaseModel>()
                for (data in snapshot.children) {
                    val model = data.getValue(DatabaseModel::class.java)
                    list.add(model as DatabaseModel)
                }

                if (list.size > 0) {
                    val adapter = DataAdapter(list)
                    binding.rvHistory.adapter = adapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("cancel", error.toString())
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)

        historyViewModel =
            ViewModelProvider(this).get(HistoryViewModel::class.java)

        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}