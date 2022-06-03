package com.directiveathena.dailyspirit.DB

import androidx.room.*

@Dao
interface DbDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // REPLACES the old day content if there was one
    suspend fun insertDays(vararg days: DayContent)

    @Update
    suspend fun updateDays(vararg days: DayContent)

    @Delete
    suspend fun delete(day:DayContent)

    @Query("SELECT * FROM DayContent")
    suspend fun getAll(): List<DayContent>

    @Query("SELECT date,mood FROM DayContent")
    suspend fun getAllMoods(): List<MoodTuple>

    @Query("SELECT * FROM DayContent where date BETWEEN :date_start AND :date_end")
    suspend fun getAllMoodsRange(date_start:Long, date_end:Long): List<DayContent>

    @Query("SELECT * FROM DayContent where date == :date")
    suspend fun getDayContent(date:Long): List<DayContent>
}