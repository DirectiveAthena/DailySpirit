// -------------------------------------------------------------------------------------------------
// - Imports -
// -------------------------------------------------------------------------------------------------
package com.directiveathena.dailyspirit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.directiveathena.dailyspirit.db.AppDatabase
import com.directiveathena.dailyspirit.databinding.ActivityMainBinding
import com.directiveathena.dailyspirit.db.MIGRATION_1_2
import com.directiveathena.dailyspirit.db.MIGRATION_2_3

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

        // initialize the database, to be as early as possible
        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java,"database-dailySpirit")
            // Migrations between versions
            .addMigrations(MIGRATION_1_2)
            .addMigrations(MIGRATION_2_3)
            //Finally build the dammed thing
            .build()


        // Create binding for easy use later in the activity class
        binding = ActivityMainBinding.inflate(
            layoutInflater
        )
        setContentView(binding!!.root)
        setSupportActionBar(binding!!.toolbar)
    }

}