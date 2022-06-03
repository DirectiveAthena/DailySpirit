package com.directiveathena.dailyspirit.db;

import androidx.room.TypeConverter;

import java.util.Date;

public class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let {Date(it)}
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

}
