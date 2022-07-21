// -------------------------------------------------------------------------------------------------
// - Imports -
// -------------------------------------------------------------------------------------------------
package com.directiveathena.dailyspirit

import android.content.Context
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

        instance = this

        // Create binding for easy use later in the activity class
        binding = ActivityMainBinding.inflate(
            layoutInflater
        )
        setContentView(binding!!.root)
        setSupportActionBar(binding!!.toolbar)
    }

    companion object {
        private var instance: MainActivity? = null

        fun getContext():Context {
            return instance!!.applicationContext
        }
    }

}