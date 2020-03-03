package com.example.laboratorio5apps.models.DAOs

/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.laboratorio5apps.models.entities.Question

@Dao
interface QuestionDAO {

    @Insert
    fun insert(question: Question)

    @Query("DELETE FROM question_table WHERE is_default = 0")
    fun clear()

    @Query("SELECT * FROM question_table WHERE id = :key")
    fun get(key: Long): Question?

    @Query("SELECT * FROM question_table ORDER BY id DESC")
    fun getAll(): LiveData<List<Question>>

    @Query("DELETE FROM question_table")
    fun deleteAll()

    @Query(value = "SELECT COUNT(id) FROM question_table")
    fun count(): Int
}
