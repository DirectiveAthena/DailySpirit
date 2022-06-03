package com.directiveathena.dailyspirit

import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI.navigateUp
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.os.Bundle
import com.directiveathena.dailyspirit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val appBarConfiguration: AppBarConfiguration? = null
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(
            layoutInflater
        )
        setContentView(binding!!.root)
        setSupportActionBar(binding!!.toolbar)
        val navController = findNavController(this, R.id.nav_host_fragment_content_main)
        //        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

    }
    

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(this, R.id.nav_host_fragment_content_main)
        return (navigateUp(navController, appBarConfiguration!!)
                || super.onSupportNavigateUp())
    }
}