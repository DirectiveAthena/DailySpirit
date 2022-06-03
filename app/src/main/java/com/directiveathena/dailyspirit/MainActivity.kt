package com.directiveathena.dailyspirit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.directiveathena.dailyspirit.DB.AppDatabase
import com.directiveathena.dailyspirit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(
            layoutInflater
        )
        setContentView(binding!!.root)
        setSupportActionBar(binding!!.toolbar)

        // initialize the database
        createDatabase()

    }
    private fun createDatabase() {
        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java,"database-dailySpirit").build()
    }

}