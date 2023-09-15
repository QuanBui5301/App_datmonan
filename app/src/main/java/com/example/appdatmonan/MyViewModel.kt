package com.example.appdatmonan

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    val currentMain = MutableLiveData<String>()
    val currentSup = MutableLiveData<String>()
    val currentDesert = MutableLiveData<String>()
    val currentDrink = MutableLiveData<String>()

    val currentMainImg = MutableLiveData<Int>()
    val currentSupImg = MutableLiveData<Int>()
    val currentDesImg = MutableLiveData<Int>()
    val currentDriImg = MutableLiveData<Int>()
}