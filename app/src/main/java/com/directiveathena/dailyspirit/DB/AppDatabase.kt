package com.directiveathena.dailyspirit.DB

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters

@Database(
    entities=[DayContent::class],
    views = [],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun dbDao(): DbDAO
}


