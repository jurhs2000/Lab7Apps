package com.example.laboratorio5apps.models.DAOs

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.laboratorio5apps.models.entities.Poll
import com.example.laboratorio5apps.models.entities.Question

@Dao
interface PollDAO {

    @Insert
    fun insert(poll: Poll)

    @Query("SELECT * FROM poll_table WHERE id = :key")
    fun get(key: Long): Poll?

    @Query("SELECT * FROM poll_table ORDER BY id DESC")
    fun getAll(): LiveData<List<Poll>>

    @Query("DELETE FROM poll_table")
    fun deleteAll()
}
