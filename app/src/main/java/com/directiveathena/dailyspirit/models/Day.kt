// -------------------------------------------------------------------------------------------------
// - Imports -
// -------------------------------------------------------------------------------------------------
package com.directiveathena.dailyspirit.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

// -------------------------------------------------------------------------------------------------
// - Code -
// -------------------------------------------------------------------------------------------------
@Entity(
    indices = [
        Index(value=["date"], unique = true)    // Important as there should only be one mood per day
    ]
)
data class Day (
    @PrimaryKey val id: Int, // should become auto generated
    @ColumnInfo(name="date") val date: Date, // is converted to a long by the converter
    val mood: Int, // ranging from 0 to 4 (aka 5 values)
    val sticker: Int?, // id for extra sticker
    val note: String?,
    val image_path: String?, // don't store actual image, only path (external_path?)
)