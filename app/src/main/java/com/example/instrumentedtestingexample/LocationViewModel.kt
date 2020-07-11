package com.example.instrumentedtestingexample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData



class LocationViewModel(application: Application) : AndroidViewModel(application){
    private val _userLocation = MutableLiveData<String>("Not Available")
    val userLocation: LiveData<String> = _userLocation

    fun setLocation(location: LatLong){
            _userLocation.value = "${location.lat} ${location.long}"
    }

}