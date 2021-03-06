// -------------------------------------------------------------------------------------------------
// - Imports -
// -------------------------------------------------------------------------------------------------
package com.directiveathena.dailyspirit.db.datatuples

import androidx.room.ColumnInfo

// -------------------------------------------------------------------------------------------------
// - Code -
// -------------------------------------------------------------------------------------------------
data class DateMoodTuple (
    @ColumnInfo(name="date") val date:Long,
    @ColumnInfo(name="mood") val mood:Int
)