package com.matt.bitfit1

import android.widget.TextView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "foodInfo")

data class CurrentFood(
    @ColumnInfo (name = "foodName") val foodName: String,
    @ColumnInfo(name = "foodCalories") val foodCalories: String,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
)


