package com.wishto.roomdbmvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import com.wishto.roomdbmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    // private lateinit var binding: ActivityMainBinding
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        //   binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*    val navController = findNavController(R.id.nav_host_fragment_content_main)
            setupActionBarWithNavController(navController, appBarConfiguration)*/

        setupActionBarWithNavController(findNavController(R.id.fragment))
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}