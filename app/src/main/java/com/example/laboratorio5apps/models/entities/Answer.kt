package com.example.laboratorio5apps.models.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "answer_table", foreignKeys = [
    ForeignKey(entity = Question::class, parentColumns = ["id"], childColumns = ["question_id"], onDelete = CASCADE),
    ForeignKey(entity = Poll::class, parentColumns = ["id"], childColumns = ["poll_id"], onDelete = CASCADE)
])
data class Answer (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0L,
    @ColumnInfo(name = "poll_id")
    var pollId: Long,
    @ColumnInfo(name = "question_id")
    var questionId: Long,
    @ColumnInfo(name = "answer_text")
    var answerText: String,
    @ColumnInfo(name = "answer_number")
    var answerNumber: Int,
    @ColumnInfo(name = "answer_rating")
    var answerRating: Double
)