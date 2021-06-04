package com.capstone.foodcalories.ui.history

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.foodcalories.R
import com.capstone.foodcalories.data.Food
import com.capstone.foodcalories.databinding.FragmentHistoryBinding
import com.capstone.foodcalories.ui.settings.SettingsActivity
//error di aku ga tau salah dimananya
//import kotlinx.android.synthetic.main.fragment_history.*
//import kotlinx.android.synthetic.main.fragment_history.view.*
//import kotlinx.coroutines.Dispatchers.Main

class HistoryFragment : Fragment() {

    private lateinit var historyViewModel: HistoryViewModel
    private var _binding: FragmentHistoryBinding? = null
    private lateinit var adapter: HistoryAdapter
    private lateinit var food: Food

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val food = Food()
        val calorieTarget = food.calorieTarget
        if(calorieTarget > 0) {
            binding.panel.visibility = View.VISIBLE
        } else {
            binding.panel.visibility = View.INVISIBLE
        }

        if (activity != null) {
//            val viewModel = ViewModelProvider(this,
//                ViewModelProvider.NewInstanceFactory())[HistoryViewModel::class.java]

            //nunggu item nya masuk dulu
            //val foodItem = viewModel.getFoodItem()
            val adapter = HistoryAdapter(this)
            //adapter.setItems(foodItem)

            with(binding.rvHistory) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}