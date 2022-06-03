package com.directiveathena.dailyspirit.DB

import androidx.room.ColumnInfo

data class MoodTuple (
    @ColumnInfo(name="date") val date:Long,
    @ColumnInfo(name="mood") val mood:Int
)