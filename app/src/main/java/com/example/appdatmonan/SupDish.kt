package com.example.appdatmonan

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdatmonan.databinding.FragmentMainDishBinding
import com.example.appdatmonan.databinding.FragmentSupDishBinding

class SupDish : Fragment() {
    lateinit var binding: FragmentSupDishBinding
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
        binding = FragmentSupDishBinding.inflate(layoutInflater)
        val view:View = binding.root
        ListAdapter.SupList = mutableListOf()
        ListAdapter.SupList.add(ListAdapter.SupList.size, Food("Bắp cải trộn", R.drawable.bap))
        ListAdapter.SupList.add(ListAdapter.SupList.size, Food("Khoai tây nghiền", R.drawable.khoainghien))
        ListAdapter.SupList.add(ListAdapter.SupList.size, Food("Khoai tây chiên", R.drawable.khoai))
        ListAdapter.SupList.add(ListAdapter.SupList.size, Food("Nuggets", R.drawable.nugget))
        ListAdapter.SupList.add(ListAdapter.SupList.size, Food("Gà xiên que", R.drawable.gaxien))
        ListAdapter.SupList.add(ListAdapter.SupList.size, Food("Thanh cá", R.drawable.ca))
        ListAdapter.SupList.add(ListAdapter.SupList.size, Food("Gà popcorn", R.drawable.popcorn))
        ListAdapter.SupList.add(ListAdapter.SupList.size, Food("Xiên tenderods", R.drawable.tender))

        listView = view.findViewById(R.id.sup_recycler)
        adapter = ListAdapter(2, viewLifecycleOwner)
        listView.layoutManager = LinearLayoutManager(view.context)
        listView.adapter = adapter
        binding.btnNext.setOnClickListener() {
            MainActivity.mNavController.navigate(R.id.desert)
        }
        binding.btnBack.setOnClickListener() {
            MainActivity.mNavController.navigate(R.id.mainDish)
        }
        return view
    }

}