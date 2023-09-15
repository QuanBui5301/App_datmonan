package com.example.appdatmonan

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.appdatmonan.MainActivity.Companion.viewmodel
import com.example.appdatmonan.databinding.FoodItemBinding

class ListAdapter(var foodtype : Int, val lifecycleOwner: LifecycleOwner) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    private lateinit var binding : FoodItemBinding
    private lateinit var context: Context
    companion object {
        var FoodList : MutableList<Food> = mutableListOf()
        var SupList : MutableList<Food> = mutableListOf()
        var DesertList : MutableList<Food> = mutableListOf()
        var DrinkList : MutableList<Food> = mutableListOf()
        var Other : MutableList<Food> = mutableListOf()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = FoodItemBinding.inflate(inflater, parent, false)
        context = parent.context
        return ViewHolder()
    }

    override fun getItemCount(): Int {
        when (foodtype) {
            1 -> return FoodList.size
            2 -> return SupList.size
            3 -> return DesertList.size
            4 -> return DrinkList.size
            else -> return Other.size
        }
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        when (foodtype) {
            1 -> return holder.bind(FoodList[position])
            2 -> return holder.bind(SupList[position])
            3 -> return holder.bind(DesertList[position])
            4 -> return holder.bind(DrinkList[position])
            else -> return holder.bind(Other[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Food) {
            binding.apply {
                name.text = item.name
                imgFood.setImageResource(item.image)
                if (item.name == mDish(foodtype)) {
                    checkbox.setChecked(true)
                }
                checkbox.setOnClickListener() {
                    if (checkbox.isChecked) {
                        when (foodtype) {
                            1 -> {
                                viewmodel.currentMain.value = item.name
                                viewmodel.currentMainImg.value = item.image
                            }
                            2 -> {
                                viewmodel.currentSup.value = item.name
                                viewmodel.currentSupImg.value = item.image
                            }
                            3 -> {
                                viewmodel.currentDesert.value = item.name
                                viewmodel.currentDesImg.value = item.image
                            }
                            4 -> {
                                viewmodel.currentDrink.value = item.name
                                viewmodel.currentDriImg.value = item.image
                            }
                            else -> Log.e("Error", "Not found foodtype!")
                        }
                    }
                }
            }
        }
    }
    fun mDish(foodtype:Int) : String {
        var name : String = ""

        when (foodtype) {
            1 -> {
                viewmodel.currentMain.observe(lifecycleOwner, Observer {
                    name = it.toString()
                })
            }
            2 -> {
                viewmodel.currentSup.observe(lifecycleOwner, Observer {
                    name = it.toString()
                })
            }
            3 -> {
                viewmodel.currentDesert.observe(lifecycleOwner, Observer {
                    name = it.toString()
                })
            }
            4 -> {
                viewmodel.currentDrink.observe(lifecycleOwner, Observer {
                    name = it.toString()
                })
            }
            else -> Log.e("Error", "Not found foodtype!")
        }
        return name
    }

}