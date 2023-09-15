package com.example.appdatmonan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdatmonan.databinding.FragmentDesertBinding
import com.example.appdatmonan.databinding.FragmentDrinkBinding

class Drink : Fragment() {
    lateinit var binding: FragmentDrinkBinding
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
        binding = FragmentDrinkBinding.inflate(layoutInflater)
        val view:View = binding.root
        ListAdapter.DrinkList = mutableListOf()
        ListAdapter.DrinkList.add(ListAdapter.DrinkList.size, Food("Pepsi", R.drawable.pepsi))
        ListAdapter.DrinkList.add(ListAdapter.DrinkList.size, Food("Pepsi không calo", R.drawable.calo))
        ListAdapter.DrinkList.add(ListAdapter.DrinkList.size, Food("Pepsi vị chanh", R.drawable.chanh))
        ListAdapter.DrinkList.add(ListAdapter.DrinkList.size, Food("7Up", R.drawable.up))
        ListAdapter.DrinkList.add(ListAdapter.DrinkList.size, Food("Trà đào", R.drawable.dao))
        ListAdapter.DrinkList.add(ListAdapter.DrinkList.size, Food("Trà chanh Lipton", R.drawable.lipton))
        ListAdapter.DrinkList.add(ListAdapter.DrinkList.size, Food("Milo", R.drawable.milo))
        ListAdapter.DrinkList.add(ListAdapter.DrinkList.size, Food("Aquafina", R.drawable.aquafina))


        listView = view.findViewById(R.id.dri_recycler)
        adapter = ListAdapter(4, viewLifecycleOwner)
        listView.layoutManager = LinearLayoutManager(view.context)
        listView.adapter = adapter
        binding.btnNext.setOnClickListener() {
            MainActivity.mNavController.navigate(R.id.resultFragment)
        }
        binding.btnBack.setOnClickListener() {
            MainActivity.mNavController.navigate(R.id.desert)
        }
        return view
    }

}