// -------------------------------------------------------------------------------------------------
// - Imports -
// -------------------------------------------------------------------------------------------------
package com.directiveathena.dailyspirit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.directiveathena.dailyspirit.db.AppDatabase
import com.directiveathena.dailyspirit.databinding.ActivityMainBinding

// -------------------------------------------------------------------------------------------------
// - Code -
// -------------------------------------------------------------------------------------------------
class MainActivity : AppCompatActivity() {
    // ---------------------------------------------------------------------------------------------
    // - Class Variable definition -
    // ---------------------------------------------------------------------------------------------
    private var binding: ActivityMainBinding? = null
    lateinit var db: AppDatabase

    // ---------------------------------------------------------------------------------------------
    // - OnCreate -
    // ---------------------------------------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // initialize the database
        //      Done here to be as early as possible
        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java,"database-dailySpirit")
            .build()


        // Create binding for easy use later in the activity class
        binding = ActivityMainBinding.inflate(
            layoutInflater
        )
        setContentView(binding!!.root)
        setSupportActionBar(binding!!.toolbar)
    }

}