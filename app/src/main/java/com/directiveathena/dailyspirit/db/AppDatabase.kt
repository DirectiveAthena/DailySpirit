// -------------------------------------------------------------------------------------------------
// - Imports -
// -------------------------------------------------------------------------------------------------
package com.directiveathena.dailyspirit.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.directiveathena.dailyspirit.models.Day
import com.directiveathena.dailyspirit.db.converters.TimeConverters
import com.directiveathena.dailyspirit.db.dao.DayDAO

// -------------------------------------------------------------------------------------------------
// - Code -
// -------------------------------------------------------------------------------------------------
@Database(                          // Define the Room database
    entities=[Day::class],
    views = [],
    version = 3,                    // Version int for the database, only change this when the structure changes!
    exportSchema = false
)
// Type converters
@TypeConverters(TimeConverters::class)
abstract class AppDatabase : RoomDatabase(){
    // ---------------------------------------------------------------------------------------------
    // - Data Access Objects -
    // ---------------------------------------------------------------------------------------------
    abstract fun dbDao(): DayDAO

    companion object {
        private var instance : AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase {
            if (instance != null) return instance!!

            val newInstance = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "database-dailySpirit"
            )
            // Migrations between versions
            .addMigrations(MIGRATION_1_2)
            .addMigrations(MIGRATION_2_3)
            //Finally build the dammed thing
            .build()

            // set the newInstance to the "instance" var,
            // else we don't know if it's created in the new "getInstance" call
            instance = newInstance
            // return "newInstance", because "instance" is a private var
            return newInstance
        }

    }
}


