package com.example.laboratorio5apps.models.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "poll_table",
    indices = arrayOf(Index(value = arrayOf("poll_id"), unique = true)))
data class Poll (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "poll_id")
    var id: Long = 0L,
    @ColumnInfo(name = "create_date_milli")
    var createDateMilli: Long = System.currentTimeMillis()
)