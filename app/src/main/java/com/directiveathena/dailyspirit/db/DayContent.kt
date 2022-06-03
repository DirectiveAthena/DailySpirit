package com.directiveathena.dailyspirit.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*


@Entity(indices = [Index(value=["date"], unique = true)])
data class DayContent (
    @PrimaryKey val id: Int, // should become auto generated
    @ColumnInfo(name="date") val date: Date, // always convert this to an actual date
    val mood: Int, // ranging from 0 to 4 (aka 5 values)
    val sticker: Int?, // id for extra sticker
    val note: String?,
    val image_path: String?, // don't store actual image, only path (external_path?)
)