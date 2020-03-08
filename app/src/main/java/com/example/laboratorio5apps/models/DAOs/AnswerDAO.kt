package com.example.laboratorio5apps.models.DAOs

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.laboratorio5apps.models.entities.Answer

@Dao
interface AnswerDAO {

    @Insert
    fun insert(answer: Answer)

    @Query("DELETE FROM answer_table WHERE question_id > 2")
    fun clear()

    @Query("SELECT * FROM answer_table WHERE id = :key")
    fun get(key: Long): Answer?

    @Query("SELECT * FROM answer_table")
    fun getAll(): LiveData<List<Answer>>

    @Query("DELETE FROM answer_table")
    fun deleteAll()
}
