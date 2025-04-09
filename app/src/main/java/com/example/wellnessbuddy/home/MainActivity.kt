package com.example.wellnessbuddy.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.wellnessbuddy.R
import com.example.wellnessbuddy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.textTitle.text = when (destination.id) {
                R.id.homeFragment -> "Dashboard"
                R.id.bookingsFragment -> "Bookings"
                R.id.patientFragment -> "Patients"
                R.id.paymentFragment -> "Payments"
                R.id.analyticsFragment -> "Analytics"
                else -> "Title"
            }
        }
    }
}
