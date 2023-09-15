package com.example.appdatmonan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdatmonan.databinding.FragmentDesertBinding
import com.example.appdatmonan.databinding.FragmentSupDishBinding

class Desert : Fragment() {
    lateinit var binding: FragmentDesertBinding
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
        binding = FragmentDesertBinding.inflate(layoutInflater)
        val view:View = binding.root
        ListAdapter.DesertList = mutableListOf()
        ListAdapter.DesertList.add(ListAdapter.DesertList.size, Food("Bánh trứng", R.drawable.banh))
        ListAdapter.DesertList.add(ListAdapter.DesertList.size, Food("Thanh bí ngô phô mai", R.drawable.bi))
        ListAdapter.DesertList.add(ListAdapter.DesertList.size, Food("Viên khoai môn", R.drawable.khoaimon))
        listView = view.findViewById(R.id.des_recycler)
        adapter = ListAdapter(3, viewLifecycleOwner)
        listView.layoutManager = LinearLayoutManager(view.context)
        listView.adapter = adapter
        binding.btnNext.setOnClickListener() {
            MainActivity.mNavController.navigate(R.id.drink)
        }
        binding.btnBack.setOnClickListener() {
            MainActivity.mNavController.navigate(R.id.supDish)
        }
        return view
    }
}