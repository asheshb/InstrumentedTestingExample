package com.example.instrumentedtestingexample

import android.location.Address
import android.location.Geocoder
import android.location.Location
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import org.junit.Assert.assertEquals

@RunWith(AndroidJUnit4::class)
class LocationViewModelTest{
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private val location = LatLong(28.6139, 77.2090)

    @Test
    fun setLocation_ReturnsUserLocation(){
        val locationViewModel = LocationViewModel(ApplicationProvider.getApplicationContext())

        val observer = Observer<String> {}
        try {
            locationViewModel.userLocation.observeForever(observer)

            locationViewModel.setLocation(location)

            val value = locationViewModel.userLocation.value

            assertEquals(value, "${location.lat} ${location.long}")

        } finally {
             locationViewModel.userLocation.removeObserver(observer)
        }

    }
}