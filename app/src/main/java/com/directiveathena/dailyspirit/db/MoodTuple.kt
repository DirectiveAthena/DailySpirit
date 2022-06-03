package com.directiveathena.dailyspirit.db

import androidx.room.ColumnInfo

data class MoodTuple (
    @ColumnInfo(name="date") val date:Long,
    @ColumnInfo(name="mood") val mood:Int
)