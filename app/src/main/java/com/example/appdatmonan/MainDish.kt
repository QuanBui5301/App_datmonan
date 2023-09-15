package com.example.appdatmonan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListAdapter
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdatmonan.ListAdapter.Companion.FoodList
import com.example.appdatmonan.MainActivity.Companion.mNavController
import com.example.appdatmonan.databinding.FragmentMainDishBinding


class MainDish : Fragment() {
    lateinit var binding: FragmentMainDishBinding
    lateinit var listView : RecyclerView
    lateinit var adapter: com.example.appdatmonan.ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainDishBinding.inflate(layoutInflater)
        val view:View = binding.root
        FoodList = mutableListOf()
        FoodList.add(FoodList.size, Food("Gà Rán", R.drawable.garan))
        FoodList.add(FoodList.size, Food("Hot Wings", R.drawable.hotwings))
        FoodList.add(FoodList.size, Food("Gà Quay", R.drawable.gaquay))
        FoodList.add(FoodList.size, Food("Cơm Phi Lê Gà Giòn", R.drawable.phile))
        FoodList.add(FoodList.size, Food("Burger Tôm", R.drawable.tom))
        FoodList.add(FoodList.size, Food("Burger Zinger", R.drawable.zinger))
        FoodList.add(FoodList.size, Food("Burger Flava", R.drawable.flava))
        FoodList.add(FoodList.size, Food("Cơm Gà Rán", R.drawable.com))
        FoodList.add(FoodList.size, Food("Cơm Gà Xiên Que", R.drawable.gaque))
        FoodList.add(FoodList.size, Food("Mì Ý Gà Zinger", R.drawable.myyzinger))
        FoodList.add(FoodList.size, Food("Mỳ Ý Gà Viên", R.drawable.myy))
        FoodList.add(FoodList.size, Food("Cơm Phi Lê Gà Quay", R.drawable.comphile))
        listView = view.findViewById(R.id.main_recycler)
        adapter = ListAdapter(1, viewLifecycleOwner)
        listView.layoutManager = LinearLayoutManager(view.context)
        listView.adapter = adapter
        binding.btnNext.setOnClickListener() {
            mNavController.navigate(R.id.supDish)
        }
        return view
    }
}