// -------------------------------------------------------------------------------------------------
// - Imports -
// -------------------------------------------------------------------------------------------------
package com.directiveathena.dailyspirit.db

import androidx.annotation.WorkerThread
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.directiveathena.dailyspirit.db.content.Day
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
@TypeConverters(TimeConverters::class)
abstract class AppDatabase : RoomDatabase(){
    // ---------------------------------------------------------------------------------------------
    // - Data Access Objects -
    // ---------------------------------------------------------------------------------------------
    abstract fun dbDao(): DayDAO
}


