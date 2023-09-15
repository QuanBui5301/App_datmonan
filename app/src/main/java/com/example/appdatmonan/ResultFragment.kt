package com.example.appdatmonan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentResultListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.appdatmonan.MainActivity.Companion.mNavController
import com.example.appdatmonan.MainActivity.Companion.viewmodel
import com.example.appdatmonan.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    lateinit var binding : FragmentResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater)
        val view = binding.root
        viewmodel.currentMain.observe(viewLifecycleOwner, Observer {
            binding.mainDish.text = it.toString()
        })
        viewmodel.currentSup.observe(viewLifecycleOwner, Observer {
            binding.supDish.text = it.toString()
        })
        viewmodel.currentDesert.observe(viewLifecycleOwner, Observer {
            binding.desDish.text = it.toString()
        })
        viewmodel.currentDrink.observe(viewLifecycleOwner, Observer {
            binding.driDish.text = it.toString()
        })
        viewmodel.currentMainImg.observe(viewLifecycleOwner, Observer {
            binding.mainImg.setImageResource(it.toString().toInt())
        })
        viewmodel.currentSupImg.observe(viewLifecycleOwner, Observer {
            binding.supImg.setImageResource(it.toString().toInt())
        })
        viewmodel.currentDesImg.observe(viewLifecycleOwner, Observer {
            binding.desImg.setImageResource(it.toString().toInt())
        })
        viewmodel.currentDriImg.observe(viewLifecycleOwner, Observer {
            binding.driImg.setImageResource(it.toString().toInt())
        })
        binding.btnCancel.setOnClickListener() {
            mNavController.navigate(R.id.mainDish)
        }
        return view
    }


}