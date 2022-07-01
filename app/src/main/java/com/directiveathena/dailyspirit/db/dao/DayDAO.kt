// -------------------------------------------------------------------------------------------------
// - Imports -
// -------------------------------------------------------------------------------------------------
package com.directiveathena.dailyspirit.db.dao

import androidx.room.*
import com.directiveathena.dailyspirit.db.datatuples.DateMoodTuple
import com.directiveathena.dailyspirit.models.Day
import java.util.*

// -------------------------------------------------------------------------------------------------
// - Code -
// -------------------------------------------------------------------------------------------------
@Dao
interface DayDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // REPLACES the old day content if there was one
    suspend fun insertDays(vararg days: Day)

    @Update
    suspend fun updateDays(vararg days: Day)

    @Delete
    suspend fun delete(day: Day)

    @Query("SELECT * FROM Day")
    suspend fun getAll(): List<Day>

    @Query("SELECT date,mood FROM Day")
    suspend fun getAllMoods(): List<DateMoodTuple>

    @Query("SELECT * FROM Day where date BETWEEN :date_start AND :date_end")
    suspend fun getAllMoodsRange(date_start:Long, date_end:Long): List<Day>

    @Query("SELECT * FROM Day where date == :date")
    suspend fun getDayContent(date:Date): List<Day>
}