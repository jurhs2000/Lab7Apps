package com.example.laboratorio5apps.models.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "poll_table")
data class Poll (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0L,
    @ColumnInfo(name = "create_date_milli")
    var createDateMilli: Long = System.currentTimeMillis()
)